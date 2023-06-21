package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.example.Admin;
import com.example.Medicine;
import com.example.SwitchPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageMedicineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button manageDocBtn;

    @FXML
    private Button manageDptBtn;

    @FXML
    private Button manageMedicineBtn;

    @FXML
    private Button managePatientBtn;

    @FXML
    private TableColumn<Medicine, Integer> medicineAmountCol;

    @FXML
    private TextField medicineAmountField;

    @FXML
    private TableColumn<Medicine, String> medicineDescriptionCol;

    @FXML
    private TextArea medicineDescriptionField;

    @FXML
    private TableColumn<Medicine, String> medicineIDCol;

    @FXML
    private TableColumn<Medicine, String> medicineNameCol;

    @FXML
    private TextField medicineNameField;

    @FXML
    private TableView<Medicine> medicineTable;

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
        manageDptBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDptBtn);
        });

        manageDocBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDocBtn);
        });

        managePatientBtn.setOnAction(event -> {
            switchpage.switchPage(event, managePatientBtn);
        });

        resetBtn.setOnAction(event -> {
            resetBtnAction();
        });

        unFocusAll();
        medicineTable.getColumns().forEach(e -> e.setReorderable(false));
        medicineTable.setOnMouseClicked(event -> {
            Medicine selectedMedicine = medicineTable.getSelectionModel().getSelectedItem();
            if (selectedMedicine != null) {
                medicineNameField.setText(selectedMedicine.getMedicine_name());
                medicineAmountField.setText(String.valueOf(selectedMedicine.getMedicine_amount()));
                medicineDescriptionField.setText(selectedMedicine.getMedicine_description());
            }
        });
        medicineShowListData();
        searchFilter();
    }

    public void initData(Admin admin){
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){

        searchField.setText("");
        medicineNameField.setText("");
        medicineAmountField.setText("");
        medicineDescriptionField.setText("");
        medicineTable.getSelectionModel().clearSelection();        
    }

    public void unFocusAll(){
        manageDptBtn.setFocusTraversable(false);
        manageDocBtn.setFocusTraversable(false);
        manageMedicineBtn.setFocusTraversable(false);
        managePatientBtn.setFocusTraversable(false);
        medicineTable.setFocusTraversable(false);
        searchField.setFocusTraversable(false);
        medicineNameField.setFocusTraversable(false);
        medicineAmountField.setFocusTraversable(false);
        medicineDescriptionField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
    }

    ObservableList<Medicine> listData = FXCollections.observableArrayList();

    public void medicineShowListData() {

        listData.add(new Medicine("M001", "Paracetamol", "500mg For fever", 100));
        listData.add(new Medicine("M002", "Panadol", "500mg For fever", 100));

        medicineIDCol.setCellValueFactory(new PropertyValueFactory<>("medicine_id"));
        medicineNameCol.setCellValueFactory(new PropertyValueFactory<>("medicine_name"));
        medicineAmountCol.setCellValueFactory(new PropertyValueFactory<>("medicine_amount"));
        medicineDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("medicine_description"));

        medicineTable.setItems(listData);

    }

    private void searchFilter(){
        FilteredList<Medicine> filteredData = new FilteredList<>(listData, b -> true);
        searchField.setOnKeyReleased(e->{
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Medicine>) medicine->{
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(medicine.getMedicine_id().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(medicine.getMedicine_name().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(medicine.getMedicine_description().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(String.valueOf(medicine.getMedicine_amount()).contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });
        });
            final SortedList<Medicine> medicine_list = new SortedList<>(filteredData);
            medicine_list.comparatorProperty().bind(medicineTable.comparatorProperty());
            medicineTable.setItems(medicine_list);  

        });
    }

}
