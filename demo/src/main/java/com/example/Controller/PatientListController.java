package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.time.LocalDate;

import java.time.Period;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.Department;
import com.example.Patient;
import com.example.SwitchPage;
import com.example.CSVRelatedClass.CSVHandler;
import com.example.CSVRelatedClass.CSVPath;
import com.example.CSVRelatedClass.CustomComparator;
import com.example.CSVRelatedClass.ParameterTypes;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PatientListController {

    @FXML
    private StackPane pages;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button manageDocBtn;

    @FXML
    private Button manageDptBtn;

    @FXML
    private Button manageMedicineBtn;

    @FXML
    private TableColumn<Patient, String> patAgeCol;

    @FXML
    private TextField patCotField;

    @FXML
    private TableColumn<Patient, String> patCotInfoCol;

    @FXML
    private TableColumn<Patient, String> patDepartmentCol;

    @FXML
    private ComboBox<String> patDepartmentField;

    @FXML
    private ComboBox<String> patGenderBox;

    @FXML
    private TableColumn<Patient, String> patGenderCol;

    @FXML
    private TableColumn<Patient, String> patICCol;

    @FXML
    private TextField patICField;

    @FXML
    private TableColumn<Patient, String> patIDCol;

    @FXML
    private TableView<Patient> patListTable;

    @FXML
    private TableColumn<Patient, String> patNameCol;

    @FXML
    private TextField patNameField;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField searchField;

    @FXML
    private Label unameLabel;

    @FXML
    private Button updateBtn;

    @FXML
    void initialize(){
        SwitchPage switchpage = new SwitchPage();

        manageDptBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDptBtn);
        });

        manageDocBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDocBtn);
        });

        manageMedicineBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageMedicineBtn);
        });

        patGenderBox.getItems().addAll("M", "F");
        
        ObservableList<Department> depListData = csvhandler.readCSV(CSVPath.DEPARTMENT_PATH, Department.class, CustomComparator.createComparator(Department::getId, 1), ParameterTypes.DEPARTMENT_PARAMETER_TYPES);

        for (Department department : depListData) {
            patDepartmentField.getItems().add(department.getName());
        }

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

        logOutBtn.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream("demo/src/main/resources/com/example/Login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                Node node = (Node) event.getSource();
                Stage currentStage = (Stage) node.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        patNameField.addEventFilter(KeyEvent.KEY_PRESSED, event -> handleTextFieldKeyPress(event, patICField));
        patICField.addEventFilter(KeyEvent.KEY_PRESSED, event -> handleTextFieldKeyPress(event, patGenderBox));
        patGenderBox.addEventFilter(KeyEvent.KEY_PRESSED, event -> handleTextFieldKeyPress(event, patCotField));
        patCotField.addEventFilter(KeyEvent.KEY_PRESSED, event -> handleTextFieldKeyPress(event, patDepartmentField));
        patDepartmentField.addEventFilter(KeyEvent.KEY_PRESSED, event -> handleTextFieldKeyPress(event, patNameField));

        unFocusAll();
        patListTable.getColumns().forEach(e -> e.setReorderable(false));
        patListTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Patient selectedPatient = patListTable.getSelectionModel().getSelectedItem();
                if (selectedPatient != null) {
                    patNameField.setText(selectedPatient.getName());
                    patICField.setText(String.valueOf(selectedPatient.getIc()));
                    patCotField.setText(String.valueOf(selectedPatient.getContact_info()));
                    patDepartmentField.setValue(selectedPatient.getDepartment());
                    patGenderBox.setValue(String.valueOf(selectedPatient.getGender()));

                }
            } else if (event.getClickCount() == 2) {
                Patient selectedPatient = patListTable.getSelectionModel().getSelectedItem();
                if (selectedPatient != null) {
                    // Do something with the selected patient data
                    System.out.println("Selected patient ID: " + selectedPatient.getPatient_id());
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        Parent root = loader.load(new FileInputStream("demo/src/main/resources/com/example/PatientHistory.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                        PatientHistoryController controller = loader.getController();
                        controller.initData(admin, selectedPatient);
                        Node node = (Node) event.getSource();
                        Stage currentStage = (Stage) node.getScene().getWindow();
                        currentStage.close();
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        patientShowListData();
        searchFilter();
    }

    private void handleTextFieldKeyPress(javafx.scene.input.KeyEvent event, javafx.scene.control.Control nextControl) {
        if (event.getCode() == KeyCode.TAB) {
            nextControl.requestFocus();
            event.consume();
        }
    }

    private Admin admin;
    CSVHandler csvhandler = new CSVHandler();
    private AlertMessage alert = new AlertMessage();
    private Patient checkInput = new Patient();

    public void initData(Admin admin){
        this.admin = admin;
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){
        patNameField.setText("");
        patICField.setText("");
        patCotField.setText("");
        patDepartmentField.setValue("");
        patGenderBox.setValue("");
        searchField.setText("");
        patListTable.getSelectionModel().clearSelection();
        patListTable.setItems(refreshData());
        patientShowListData();      
    }

    public void unFocusAll(){
        manageDptBtn.setFocusTraversable(false);
        manageDocBtn.setFocusTraversable(false);
        manageMedicineBtn.setFocusTraversable(false);
        patListTable.setFocusTraversable(false);
        searchField.setFocusTraversable(false);
        patNameField.setFocusTraversable(false);
        patICField.setFocusTraversable(false);
        patCotField.setFocusTraversable(false);
        patDepartmentField.setFocusTraversable(false);
        patGenderBox.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
        logOutBtn.setFocusTraversable(false);
    }

    private ObservableList<Patient> refreshData(){
        ObservableList<Patient> listData = csvhandler.readCSV(CSVPath.PATIENT_PATH, Patient.class, CustomComparator.createComparator(Patient::getPatient_id, 3), ParameterTypes.PATIENT_PARAMETER_TYPES);
        return listData;
    }

    public void patientShowListData(){

        patIDCol.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
        patNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        patICCol.setCellValueFactory(new PropertyValueFactory<>("ic"));
        patAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        patGenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        patCotInfoCol.setCellValueFactory(new PropertyValueFactory<>("contact_info"));
        patDepartmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        
        patListTable.setItems(refreshData());

    }

    private void searchFilter(){
        FilteredList<Patient> filteredData = new FilteredList<>(refreshData(), e -> true);

        if (searchField.getText() != null){
            searchField.setOnKeyReleased(e->{
        
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(Patient -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String toLowerCaseNewValue = newValue.toLowerCase();
                    String gender = String.valueOf(Patient.getGender()).toLowerCase();
                        if(Patient.getPatient_id().toLowerCase().contains(toLowerCaseNewValue)){
                            return true;
                        }else if(Patient.getName().toLowerCase().contains(toLowerCaseNewValue)){
                            return true;
                        }else if(String.valueOf(Patient.getIc()).contains(toLowerCaseNewValue)){
                            return true;
                        }else if(String.valueOf(Patient.getAge()).contains(toLowerCaseNewValue)){
                            return true;
                        }else if(gender.equals(toLowerCaseNewValue)){
                            return true;
                        }else if(String.valueOf(Patient.getContact_info()).contains(toLowerCaseNewValue)){
                            return true;
                        }else if(Patient.getDepartment().toLowerCase().contains(toLowerCaseNewValue)){
                            return true;
                        }

                return false;

                });
            });
                final SortedList<Patient> patient_list = new SortedList<>(filteredData);
                patient_list.comparatorProperty().bind(patListTable.comparatorProperty());
                patListTable.setItems(patient_list);
            });
        }
    }

    private boolean checkEmpty(){
        if (patNameField.getText().isEmpty() || patICField.getText().isEmpty() || patCotField.getText().isEmpty() || patDepartmentField.getValue() == null || patGenderBox.getValue() == null) {
            // show error message
            alert.errorMessage("Please fill in all the fields");
            return true;
        }
        return false;
    }

    private boolean checkSelected(){
        if (patListTable.getSelectionModel().getSelectedItem() == null) {
            // show error message
            alert.errorMessage("Please select a patient");
            return true;
        }
        return false;
    }

    public String checkAndConvertToString(String value) {
        // System.out.println(value);
        try {
            new BigInteger(value);
            System.out.println(value);
            return value;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void addBtnAction(){

        String patName = patNameField.getText();
        String patIC = patICField.getText();
        String checkICResult = checkAndConvertToString(patIC);
        if (checkICResult == null) {
            alert.errorMessage("Invalid input: " + patIC + " is not an integer");
            return;
        }
        int patAge = ageCal(patIC);
        String patCot = patCotField.getText();
        String checkCotResult = checkAndConvertToString(patCot);
        if (checkCotResult == null) {
            alert.errorMessage("Invalid input: " + patCot + " is not an integer");
            return;
        }
        String patDepartment = patDepartmentField.getValue();
        String patGenderStr = patGenderBox.getValue();
        char patGender = patGenderStr.charAt(0);

        if (!checkEmpty()){
            if (checkInput.validationPatient(patName, patIC, patGender, patCot, patDepartment) == 1) {
                
                // check if patient already exist
                for (Patient patient : refreshData()){
                    if (patient.getName().equals(patName)){
                        alert.errorMessage("Patient already exists");
                        return;
                    }
                }

                // generate patient id
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                // int timestampInt = (int) (timestamp.getTime() / 1000);

                String patID = "PAT" + (timestamp.getTime()/1000);

                // creata patient object
                Patient patient = new Patient(patID, patName, patIC, patAge, patGender, patCot, patDepartment);

                // add new patient to csv file
                csvhandler.writeCSV(CSVPath.PATIENT_PATH, patient);

                // show success message
                alert.successMessage("Patient has been added successfully");

                // refresh data
                refreshData();

                // refresh table
                patientShowListData();

                // search filter reset
                searchFilter();

                // unfocus all
                unFocusAll();

                // reset all input field
                resetBtnAction();

            } else {
                // show error message
                alert.errorMessage("Please enter a valid input");
            }
        }
    }

    private void updateBtnAction(){
        if (!checkSelected()){
            // get selected patient
            String patID = patListTable.getSelectionModel().getSelectedItem().getPatient_id();
            String patName = patNameField.getText();
            String patIC = patICField.getText();
            int patAge = ageCal(patIC);
            String patCot = patCotField.getText();
            String patDepartment = patDepartmentField.getValue();
            String patGenderStr = patGenderBox.getValue();
            char patGender = patGenderStr.charAt(0);

            if (!checkEmpty()){
                if (checkInput.validationPatient(patName, patIC, patGender, patCot, patDepartment) == 1) {

                    // check if patient already exist
                    for (Patient patient : refreshData()){
                        if (patient.getName().equals(patName) && !patient.getPatient_id().equals(patID)){
                            alert.errorMessage("Patient already exists");
                            return;
                        }
                    }

                    // create patient object
                    Patient updatedPatient = new Patient(patID, patName, patIC, patAge, patGender, patCot, patDepartment);

                    // update patient to csv file
                    csvhandler.updateCSV(CSVPath.PATIENT_PATH, 0, patID, updatedPatient);

                    // show success message
                    alert.successMessage("Patient has been updated successfully");

                    // refresh data
                    refreshData();

                    // refresh table
                    patientShowListData();

                    // search filter reset
                    searchFilter();

                    // unfocus all
                    unFocusAll();

                    // reset all input field
                    resetBtnAction();

                } else {
                    // show error message
                    alert.errorMessage("Please enter a valid input");
                }
            }
        }
    }

    private void deleteBtnAction(){
        if (!checkSelected()){
            // get selected patient
            String patID = patListTable.getSelectionModel().getSelectedItem().getPatient_id();

            // delete patient from csv file
            csvhandler.deleteCSV(CSVPath.PATIENT_PATH, 0, patID);

            // show success message
            alert.successMessage("Patient has been deleted successfully");

            // refresh data
            refreshData();

            // refresh table
            patientShowListData();

            // search filter reset
            searchFilter();

            // unfocus all
            unFocusAll();

            // reset all input field
            resetBtnAction();
        }
    }

    private int ageCal(String patIC){
        // Extract the birth date from the IC number
        String birthYearPrefixStr = patIC.substring(0, 2);
        int birthYearPrefix;
        
        if (birthYearPrefixStr.startsWith("0")) {
            birthYearPrefix = Integer.parseInt(birthYearPrefixStr.substring(1, 2));
        } else {
            birthYearPrefix = Integer.parseInt(birthYearPrefixStr);
        }

        // int birthYearPrefix = Integer.parseInt(patIC.substring(0, 2));
        int birthYear;
        if (birthYearPrefix >= 0 && birthYearPrefix <= 29) {
            birthYear = 2000 + birthYearPrefix;
        } else {    
            birthYear = 1900 + birthYearPrefix;
        }


        int birthMonth = Integer.parseInt(patIC.substring(2, 4));
        int birthDay = Integer.parseInt(patIC.substring(4, 6));

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the age
        LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
        Period age = Period.between(birthDate, currentDate);
        int patAge = age.getYears() + 1;

        return patAge;
    }

     

}