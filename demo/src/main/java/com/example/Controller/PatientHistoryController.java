package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.Patient;
import com.example.PatientHistory;
import com.example.SwitchPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PatientHistoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button managePatientBtn;

    @FXML
    private TableColumn<PatientHistory, String> patHisDirectedByCol;

    @FXML
    private TextField patHisDirectedByField;

    @FXML
    private TableColumn<PatientHistory, String> patHisHIDCol;

    @FXML
    private TableColumn<PatientHistory, String> patHisMajorComplicationsCol;

    @FXML
    private TextField patHisMajorComplicationsField;

    @FXML
    private TableColumn<PatientHistory, String> patHisMovementMeansCol;

    @FXML
    private TextField patHisMovementMeansField;

    @FXML
    private TableColumn<PatientHistory, String> patHisResultsCol;

    @FXML
    private TextField patHisResultsField;

    @FXML
    private TableColumn<PatientHistory, String> patHisSpecialCommentsCol;

    @FXML
    private TextArea patHisSpecialCommentsField;

    @FXML
    private TableColumn<PatientHistory, Integer> patHisWardCol;

    @FXML
    private TextField patHisWardField;

    @FXML
    private TextField patInfoAge;

    @FXML
    private TextField patInfoContactInfo;

    @FXML
    private TextField patInfoDep;

    @FXML
    private TextField patInfoGender;

    @FXML
    private TextField patInfoID;

    @FXML
    private TextField patInfoName;

    @FXML
    private TableView<PatientHistory> patHisTable;

    @FXML
    private StackPane patient_history_page;

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

        patHisTable.getColumns().forEach(e -> e.setReorderable(false));
        patHisTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                PatientHistory selectedPatientHistory = patHisTable.getSelectionModel().getSelectedItem();
                if (selectedPatientHistory != null) {
                    // Do something with the selected patient data
                    System.out.println("Selected patient history ID: " + selectedPatientHistory.getHistory_id());
                    patHisDirectedByField.setText(selectedPatientHistory.getDirected_by());
                    patHisMajorComplicationsField.setText(selectedPatientHistory.getMajor_complications());
                    patHisMovementMeansField.setText(selectedPatientHistory.getMovement_means());
                    patHisResultsField.setText(selectedPatientHistory.getResults());
                    patHisSpecialCommentsField.setText(selectedPatientHistory.getSpecial_comments());
                    patHisWardField.setText(String.valueOf(selectedPatientHistory.getWard_no()));

                }   
            } else if (event.getClickCount() == 2) {
                PatientHistory selectedPatientHistory = patHisTable.getSelectionModel().getSelectedItem();
                if (selectedPatientHistory != null) {
                    // Do something with the selected patient data
                    System.out.println("Selected patient history ID: " + selectedPatientHistory.getHistory_id());
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\TreatmentCourse.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                        TreatmentCourseController controller = loader.getController();
                        controller.initData(admin, patient_info, selectedPatientHistory.getHistory_id());
                        Node node = (Node) event.getSource();
                        Stage currentStage = (Stage) node.getScene().getWindow();
                        currentStage.close();
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        patientHistoryShowListData();
        searchFilter();
    }

    private Admin admin;
    private Patient patient_info;

    public void initData(Admin admin, Patient patient_info){
        this.admin = admin;
        this.patient_info = patient_info;
        patInfoID.setText(patient_info.getPatient_id());
        patInfoName.setText(patient_info.getName());
        patInfoAge.setText(String.valueOf(patient_info.getAge()));
        patInfoGender.setText(Character.toString(patient_info.getGender()));
        patInfoDep.setText(patient_info.getDepartment());
        patInfoContactInfo.setText(patient_info.getContact_info());
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){
        patHisDirectedByField.setText("");
        patHisMajorComplicationsField.setText("");
        patHisMovementMeansField.setText("");
        patHisResultsField.setText("");
        patHisSpecialCommentsField.setText("");
        patHisWardField.setText("");
        patHisTable.getSelectionModel().clearSelection();
    }

    public void unFocusAll(){
        managePatientBtn.setFocusTraversable(false);
        patHisTable.setFocusTraversable(false);
        searchField.setFocusTraversable(false);
        patHisDirectedByField.setFocusTraversable(false);
        patHisMajorComplicationsField.setFocusTraversable(false);
        patHisMovementMeansField.setFocusTraversable(false);
        patHisResultsField.setFocusTraversable(false);
        patHisSpecialCommentsField.setFocusTraversable(false);
        patHisWardField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
    }

    ObservableList<PatientHistory> listData = FXCollections.observableArrayList();

    public void patientHistoryShowListData(){

        listData.add(new PatientHistory("H0001","P0001", 1, "Dr. A", "None", "Walking", "Good", "None"));
        listData.add(new PatientHistory("H0002","P0002", 2, "Dr. B", "None", "Walking", "Good", "None" )); 
        
        patHisHIDCol.setCellValueFactory(new PropertyValueFactory<>("history_id"));
        patHisWardCol.setCellValueFactory(new PropertyValueFactory<>("ward_no"));
        patHisDirectedByCol.setCellValueFactory(new PropertyValueFactory<>("directed_by"));
        patHisMajorComplicationsCol.setCellValueFactory(new PropertyValueFactory<>("major_complications"));
        patHisMovementMeansCol.setCellValueFactory(new PropertyValueFactory<>("movement_means"));
        patHisResultsCol.setCellValueFactory(new PropertyValueFactory<>("results"));
        patHisSpecialCommentsCol.setCellValueFactory(new PropertyValueFactory<>("special_comments"));
        
        patHisTable.setItems(listData);

    }

    private void searchFilter(){
        FilteredList<PatientHistory> filteredData = new FilteredList<>(listData, b -> true);
        searchField.setOnKeyReleased(e ->{
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super PatientHistory>) patientHistory -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (patientHistory.getDirected_by().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (patientHistory.getMajor_complications().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (patientHistory.getMovement_means().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (patientHistory.getResults().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (patientHistory.getSpecial_comments().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(patientHistory.getWard_no()).contains(lowerCaseFilter)) {
                    return true;
                } else if (patientHistory.getHistory_id().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

            return false;
            
            });
        });
            final SortedList<PatientHistory> patient_history_list = new SortedList<>(filteredData);
            patient_history_list.comparatorProperty().bind(patHisTable.comparatorProperty());
            patHisTable.setItems(patient_history_list);
        });
    }

    private AlertMessage alert = new AlertMessage();
    private PatientHistory checkInput = new PatientHistory();

    private void addBtnAction() {
        // get all user input

        if (patHisWardField.getText().isEmpty() || patHisDirectedByField.getText().isEmpty() || patHisMajorComplicationsField.getText().isEmpty() || patHisMovementMeansField.getText().isEmpty() || patHisResultsField.getText().isEmpty() || patHisSpecialCommentsField.getText().isEmpty()) {
            alert.errorMessage("Please fill all the fields");
        } else {
            String patient_id = patient_info.getPatient_id();
            int ward_no = -1;
            try {
                ward_no = Integer.parseInt(patHisWardField.getText());
            } catch (NumberFormatException e) {
                alert.errorMessage("Please enter a valid integer for ward number");
                return;
            }

            String directed_by = patHisDirectedByField.getText();
            String major_complications = patHisMajorComplicationsField.getText();
            String movement_means = patHisMovementMeansField.getText();
            String results = patHisResultsField.getText();
            String special_comments = patHisSpecialCommentsField.getText();

            if (checkInput.validationPatientHistory(patient_id, ward_no, directed_by, major_complications, movement_means, results, special_comments) == 1) {
                
                // reset all input field
                resetBtnAction();

                // show success message
                alert.successMessage("Patient History Added Successfully");
            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }

    }

}
