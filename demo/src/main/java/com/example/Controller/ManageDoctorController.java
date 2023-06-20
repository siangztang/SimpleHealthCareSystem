package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.Doctor;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageDoctorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<Doctor, Long> docContactCol;

    @FXML
    private TextField docContactField;

    @FXML
    private TableColumn<Doctor, String> docIDCol;

    @FXML
    private TableColumn<Doctor, String> docNameCol;

    @FXML
    private TextField docNameField;

    @FXML
    private TableColumn<Doctor, String> docQualificationCol;

    @FXML
    private TextField docQualificationField;

    @FXML
    private TableColumn<Doctor, String> docSpecializationCol;

    @FXML
    private TextField docSpecializationField;

    @FXML
    private TableView<Doctor> docTable;

    @FXML
    private Button manageDocBtn;

    @FXML
    private Button manageDptBtn;

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

        manageDptBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, manageDptBtn);
        });

        manageMedicineBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, manageMedicineBtn);
        });

        managePatientBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, managePatientBtn);
        });

        resetBtn.setOnAction(event -> {
            resetBtnAction();
        });

        unFocusAll();

        docTable.getColumns().forEach(e -> e.setReorderable(false));
        docTable.setOnMouseClicked(event -> {
            Doctor doctor = docTable.getSelectionModel().getSelectedItem();
            docNameField.setText(doctor.getDoctor_name());
            docContactField.setText(String.valueOf(doctor.getContact_info()));
            docQualificationField.setText(doctor.getQualification());
            docSpecializationField.setText(doctor.getDoctor_specialization());
        });

        doctorShowListData();
        searchField();
    }

    public void initData(Admin admin){
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){

        searchField.setText("");
        docNameField.setText("");
        docContactField.setText("");
        docQualificationField.setText("");
        docSpecializationField.setText("");
        docTable.getSelectionModel().clearSelection();        
    }

    public void unFocusAll(){
        manageDptBtn.setFocusTraversable(false);
        manageDocBtn.setFocusTraversable(false);
        manageMedicineBtn.setFocusTraversable(false);
        managePatientBtn.setFocusTraversable(false);
        docTable.setFocusTraversable(false);
        searchField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
        docNameField.setFocusTraversable(false);
        docContactField.setFocusTraversable(false);
        docQualificationField.setFocusTraversable(false);
        docSpecializationField.setFocusTraversable(false);
    }

    ObservableList<Doctor> listData = FXCollections.observableArrayList();

    public void doctorShowListData(){

        listData.add(new Doctor("D001", "Dr. A", "Cardiologist", "MBBS", 1234567890));
        listData.add(new Doctor("D002", "Dr. B", "Dermatologist", "MBBS", 1234567890));

        docIDCol.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
        docNameCol.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));
        docQualificationCol.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        docSpecializationCol.setCellValueFactory(new PropertyValueFactory<>("doctor_specialization"));
        docContactCol.setCellValueFactory(new PropertyValueFactory<>("contact_info"));

        docTable.setItems(listData);
    }

    private void searchField(){
        FilteredList<Doctor> filteredData = new FilteredList<>(listData, b -> true);
        searchField.setOnKeyReleased(e-> {
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(doctor -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (doctor.getDoctor_name().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (doctor.getDoctor_specialization().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (doctor.getQualification().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(doctor.getContact_info()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (doctor.getDoctor_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

            final SortedList<Doctor> doctor_list = new SortedList<>(filteredData);
            doctor_list.comparatorProperty().bind(docTable.comparatorProperty());
            docTable.setItems(doctor_list);
        });

    }

}
