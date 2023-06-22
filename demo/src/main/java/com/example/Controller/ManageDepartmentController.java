package com.example.Controller;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.Department;
import com.example.SwitchPage;
import com.example.CSVRelatedClass.CSVHandler;
import com.example.CSVRelatedClass.CSVPath;
import com.example.CSVRelatedClass.ParameterTypes;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageDepartmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableView<Department> departmentTable;

    @FXML
    private TableColumn<Department, String> dptIDCol;

    @FXML
    private TableColumn<Department, String> dptNameCol;

    @FXML
    private TextField dptNameField;

    @FXML
    private Button manageDocBtn;

    @FXML
    private Button manageMedicineBtn;

    @FXML
    private Button managePatientBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField searchField;

    @FXML
    private Label unameLabel;

    @FXML
    private Button updateBtn;

    @FXML
    void initialize() {
        SwitchPage switchpage = new SwitchPage();
        manageDocBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDocBtn);
        });

        manageMedicineBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageMedicineBtn);
        });

        managePatientBtn.setOnAction(event -> {
            switchpage.switchPage(event, managePatientBtn);
        });

        resetBtn.setOnAction(event -> {
            resetBtnAction();
        });

        addBtn.setOnAction(event -> {
            addBtnAction();
        });

        unFocusAll();
        departmentTable.getColumns().forEach(e -> e.setReorderable(false));
        departmentTable.setOnMouseClicked(event -> {
            Department selectedDepartment = departmentTable.getSelectionModel().getSelectedItem();
            if (selectedDepartment != null) {
                dptNameField.setText(selectedDepartment.getName());
            }
        });
        departmentShowListData();
        searchFilter();
    }

    public void initData(Admin admin){
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){ 
        searchField.setText("");
        dptNameField.setText("");
        departmentTable.getSelectionModel().clearSelection();     
    }

    public void unFocusAll(){
        searchField.setFocusTraversable(false);
        manageDocBtn.setFocusTraversable(false);
        manageMedicineBtn.setFocusTraversable(false);
        managePatientBtn.setFocusTraversable(false);
        departmentTable.setFocusTraversable(false);
        dptNameField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
    }

    CSVHandler csvhandler = new CSVHandler();
    String filePath = CSVPath.DEPARTMENT_PATH;
    Class<?>[] parameterTypes = ParameterTypes.DEPARTMENT_PARAMETER_TYPES;
    Comparator<Department> comparator = Comparator.comparing(Department::getId);
    ObservableList<Department> listData = csvhandler.readCSV(filePath, Department.class, comparator, parameterTypes);
    

    public void departmentShowListData(){
        // ObservableList<Department> listData = csvhandler.readCSV(filePath, Department.class, comparator, parameterTypes);
        dptIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dptNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        departmentTable.setItems(listData);

    }

    private void searchFilter(){
        // ObservableList<Department> listData = csvhandler.readCSV(filePath, Department.class, comparator, parameterTypes);
        FilteredList<Department> filteredData = new FilteredList<>(listData, e -> true);
        searchField.setOnKeyReleased(e->{
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Department -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Department.getId().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (Department.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

            return false;

            });
        });
            final SortedList<Department> department_list = new SortedList<>(filteredData);
            department_list.comparatorProperty().bind(departmentTable.comparatorProperty());
            departmentTable.setItems(department_list);
        });

    }

    private AlertMessage alert = new AlertMessage();

    private void addBtnAction(){

        if (dptNameField.getText().isEmpty()) {
            // show error message
            alert.errorMessage("Please fill in all the fields");
        } else {
            String dptName = dptNameField.getText();
            

            if (dptName.matches("^[a-zA-z]+([\\s][a-zA-Z]+)*$") && dptName.length() > 5) {
                
                for (Department deparment : listData){
                    if (deparment.getName().equals(dptName)){
                        alert.errorMessage("Department already exists");
                        return;
                    }
                }
                Department newDepartment = new Department("D002", dptName);
                csvhandler.writeCSV(filePath, newDepartment);
                alert.successMessage("Department added successfully");
                ObservableList<Department> listData = csvhandler.readCSV(filePath, Department.class, comparator, parameterTypes);
                this.listData = listData;
                // reset all fields
                resetBtnAction();

                // refresh table
                departmentShowListData();

            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }
    }
}
