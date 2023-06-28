package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.Doctor;
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
import javafx.scene.input.KeyCode;

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
    private TableColumn<Doctor, String> docContactCol;

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
        SwitchPage switchpage = new SwitchPage();

        manageDptBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDptBtn);
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

        docNameField.setOnKeyPressed(event -> handleTextFieldKeyPress(event, docSpecializationField));
        docSpecializationField.setOnKeyPressed(event -> handleTextFieldKeyPress(event, docContactField));
        docContactField.setOnKeyPressed(event -> handleTextFieldKeyPress(event, docQualificationField));
        docQualificationField.setOnKeyPressed(event -> handleTextFieldKeyPress(event, docNameField));

        unFocusAll();

        docTable.getColumns().forEach(e -> e.setReorderable(false));
        docTable.setOnMouseClicked(event -> {
            Doctor doctor = docTable.getSelectionModel().getSelectedItem();
            if (doctor != null) {
                docNameField.setText(doctor.getDoctor_name());
                docContactField.setText(String.valueOf(doctor.getContact_info()));
                docQualificationField.setText(doctor.getQualification());
                docSpecializationField.setText(doctor.getDoctor_specialization());
            }
        });

        doctorShowListData();
        searchField();
    }

    private void handleTextFieldKeyPress(javafx.scene.input.KeyEvent event, javafx.scene.control.Control nextControl) {
        if (event.getCode() == KeyCode.TAB) {
            nextControl.requestFocus();
            event.consume();
        }
    }

    private CSVHandler csvhandler = new CSVHandler();
    private AlertMessage alert = new AlertMessage();
    private Doctor checkInput = new Doctor();

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

    public ObservableList<Doctor> refreshData(){
        ObservableList<Doctor> listData = csvhandler.readCSV(CSVPath.DOCTOR_PATH, Doctor.class, CustomComparator.createComparator(Doctor::getDoctor_id, 3), ParameterTypes.DOCTOR_PARAMETER_TYPES);
        return listData;
    }

    public void doctorShowListData(){

        docIDCol.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
        docNameCol.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));
        docQualificationCol.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        docSpecializationCol.setCellValueFactory(new PropertyValueFactory<>("doctor_specialization"));
        docContactCol.setCellValueFactory(new PropertyValueFactory<>("contact_info"));

        docTable.setItems(refreshData());
    }

    private void searchField(){
        FilteredList<Doctor> filteredData = new FilteredList<>(refreshData(), b -> true);
        if (searchField.getText() != null){
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

    private boolean checkEmpty(){
        if (docNameField.getText().isEmpty() || docContactField.getText().isEmpty() || docQualificationField.getText().isEmpty() || docSpecializationField.getText().isEmpty()) {
            // show error message
            alert.errorMessage("Please fill in all the fields");
            return true;
        }
        return false;
    }

    private boolean checkSelected(){
        if (docTable.getSelectionModel().getSelectedItem() == null) {
            // show error message
            alert.errorMessage("Please select a doctor");
            return true;
        }
        return false;
    }
    
    private void addBtnAction(){
        String doc_name = docNameField.getText();
        String doc_specialization = docSpecializationField.getText();
        String qualification = docQualificationField.getText();
        String contact_info = docContactField.getText();
        // check if any field is empty
        if (!checkEmpty()) {
            if (checkInput.validationDoctor(doc_name, doc_specialization, qualification, contact_info) == 1) {
                // check if doctor already exists
                for (Doctor doctor : refreshData()) {
                    if (doctor.getDoctor_name().equals(doc_name)) {
                        alert.errorMessage("Doctor already exists");
                        return;
                    }
                }

                // generate new doctor id
                String doc_id = "DOC" + String.format("%d", csvhandler.getMaxId(refreshData(), Doctor::getDoctor_id, "DOC") + 1);

                // create new doctor object
                Doctor newDoctor = new Doctor(doc_id, doc_name, doc_specialization, qualification, contact_info);

                // add new doctor to csv file
                csvhandler.writeCSV(CSVPath.DOCTOR_PATH, newDoctor);

                // show success message
                alert.successMessage("Doctor added successfully");

                // refresh data
                refreshData();
                    
                // refresh table
                doctorShowListData();

                // reset all fields
                resetBtnAction();

                // search field refresh
                searchField();

                // unfocus all
                unFocusAll();

            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }
    }

    private void updateBtnAction(){
        if (!checkSelected()){
            String docId = docTable.getSelectionModel().getSelectedItem().getDoctor_id();
            String doc_name = docNameField.getText();
            String doc_specialization = docSpecializationField.getText();
            String qualification = docQualificationField.getText();
            String contact_info = docContactField.getText();
            // check if any field is empty
            if (!checkEmpty()) {
                if (checkInput.validationDoctor(doc_name, doc_specialization, qualification, contact_info) == 1) {
                    // check if doctor already exists
                    for (Doctor doctor : refreshData()) {
                        if (doctor.getDoctor_name().equals(doc_name) && !doctor.getDoctor_id().equals(docId)) {
                            alert.errorMessage("Doctor already exists");
                            return;
                        }
                    }
                    // create new doctor object
                    Doctor newDoctor = new Doctor(docId, doc_name, doc_specialization, qualification, contact_info);

                    // update doctor
                    csvhandler.updateCSV(CSVPath.DOCTOR_PATH, 0, docId, newDoctor);

                    // show success message
                    alert.successMessage("Doctor updated successfully");

                    // refresh data
                    refreshData();
                    
                    // refresh table
                    doctorShowListData();

                    // reset all fields
                    resetBtnAction();

                    // search field refresh
                    searchField();

                    // unfocus all
                    unFocusAll();

                } else {
                    alert.errorMessage("Please enter valid input");
                }
            }
        }
    }

    private void deleteBtnAction(){
        // check if any doctor is selected
        if (!checkSelected()){
            // get the selected doctor id
            String docId = docTable.getSelectionModel().getSelectedItem().getDoctor_id();

            // delete doctor
            csvhandler.deleteCSV(CSVPath.DOCTOR_PATH, 0, docId);

            // show success message
            alert.successMessage("Doctor deleted successfully");

            // refresh data
            refreshData();
            
            // refresh table
            doctorShowListData();

            // reset all fields
            resetBtnAction();

            // search field refresh
            searchField();

            // unfocus all
            unFocusAll();

        }
    }

}
