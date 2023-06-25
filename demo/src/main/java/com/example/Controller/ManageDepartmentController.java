package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.Department;
import com.example.SwitchPage;
import com.example.CSVRelatedClass.CSVHandler;
import com.example.CSVRelatedClass.CSVPath;
import com.example.CSVRelatedClass.CustomComparator;
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

        updateBtn.setOnAction(event -> {
            updateBtnAction();
        });

        deleteBtn.setOnAction(event -> {
            deleteBtnAction();
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

    private CSVHandler csvhandler = new CSVHandler();
    private AlertMessage alert = new AlertMessage();
    private Department checkInput = new Department();
    
    
    public void initData(Admin admin){
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){ 
        searchField.setText("");
        dptNameField.setText("");
        departmentTable.getSelectionModel().clearSelection();
        departmentTable.setItems(refreshData());
        departmentShowListData();     
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

    public ObservableList<Department> refreshData(){
        ObservableList<Department> listData = csvhandler.readCSV(CSVPath.DEPARTMENT_PATH, Department.class, CustomComparator.createComparator(Department::getId), ParameterTypes.DEPARTMENT_PARAMETER_TYPES);
        return listData;
    }
    
    public void departmentShowListData(){
        dptIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        dptNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        departmentTable.setItems(refreshData());

    }

    private void searchFilter(){
        FilteredList<Department> filteredData = new FilteredList<>(refreshData(), e -> true);
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

    private boolean checkEmpty(){
        if (dptNameField.getText().isEmpty()) {
            // show error message
            alert.errorMessage("Please fill in all the fields");
            return true;
        }
        return false;
    }

    private boolean checkSelected(){
        if (departmentTable.getSelectionModel().getSelectedItem() == null) {
            // show error message
            alert.errorMessage("Please select a department");
            return true;
        }
        return false;
    }
    
    private void addBtnAction(){

        String dptName = dptNameField.getText();

        // check if all fields are filled
        if (!checkEmpty()){
            if (checkInput.validationDepartment(dptName) == 1) {

                // check if department already exists
                for (Department deparment : refreshData()){
                    if (deparment.getName().equals(dptName)){
                        alert.errorMessage("Department already exists");
                        return;
                    }
                }

                // generate new department id
                String dpt_id = "D" + String.format("%d", csvhandler.getMaxId(refreshData(), Department::getId, "D") + 1);
                
                // creata a new department object
                Department newDepartment = new Department(dpt_id, dptName);

                // add new department to csv file
                csvhandler.writeCSV(CSVPath.DEPARTMENT_PATH, newDepartment);

                // show success message
                alert.successMessage("Department added successfully");

                // refresh data
                refreshData();

                // refresh table
                departmentShowListData();

                // reset all fields
                resetBtnAction();

            } else {

                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }
    }

    private void updateBtnAction(){

        if (!checkSelected()){
            String dptId = departmentTable.getSelectionModel().getSelectedItem().getId();
            String dptName = dptNameField.getText();
            // check if the input is empty
            if (!checkEmpty()) {
                if (checkInput.validationDepartment(dptName) == 1 && dptId != null) {
                // check if the department already exists
                for (Department deparment : refreshData()){
                    if (deparment.getName().equals(dptName)){
                        alert.errorMessage("Department already exists");
                        return;
                    }
                }
                // creata a new department object
                Department updatedDepartment = new Department(dptId, dptName);

                // update the department
                csvhandler.updateCSV(CSVPath.DEPARTMENT_PATH, "id", dptId, updatedDepartment);

                // show success message
                alert.successMessage("Department updated successfully");

                // refresh data
                refreshData();

                // refresh table
                departmentShowListData();

                // reset all fields
                resetBtnAction();

            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
            }
        }
    }

    private void deleteBtnAction(){
        // check if a department is selected
        if (!checkSelected()){
            // get the selected department id
            String selectedDepartment = departmentTable.getSelectionModel().getSelectedItem().getId();
            
            // delete the department
            csvhandler.deleteCSV(CSVPath.DEPARTMENT_PATH, "id", selectedDepartment);

            // show success message
            alert.successMessage("Department deleted successfully");

            // refresh data
            refreshData();

            // refresh table
            departmentShowListData();

            // reset all fields
            resetBtnAction();
        }
    }

}
