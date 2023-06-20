package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.Patient;
import com.example.PatientHistory;
import com.example.SwitchPage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

        managePatientBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, managePatientBtn);
        });

        resetBtn.setOnAction(event -> {
            resetBtnAction();
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
                    patHisSpecialCommentsField.setText(selectedPatientHistory.getSpeacial_comments());
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
        patInfoContactInfo.setText(Long.toString(patient_info.getContact_info()));
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

    public void patientHistoryShowListData(){

        ObservableList<PatientHistory> listData = FXCollections.observableArrayList();
        listData.add(new PatientHistory("P0001", 1, "Dr. A", "None", "Walking", "Good", "None", "H0001"));
        listData.add(new PatientHistory("P0002", 2, "Dr. B", "None", "Walking", "Good", "None", "H0002")); 
        
        patHisWardCol.setCellValueFactory(new PropertyValueFactory<>("ward_no"));
        patHisDirectedByCol.setCellValueFactory(new PropertyValueFactory<>("directed_by"));
        patHisMajorComplicationsCol.setCellValueFactory(new PropertyValueFactory<>("major_complications"));
        patHisMovementMeansCol.setCellValueFactory(new PropertyValueFactory<>("movement_means"));
        patHisResultsCol.setCellValueFactory(new PropertyValueFactory<>("results"));
        patHisSpecialCommentsCol.setCellValueFactory(new PropertyValueFactory<>("speacial_comments"));
        patHisHIDCol.setCellValueFactory(new PropertyValueFactory<>("history_id"));

        patHisTable.setItems(listData);

    }

}
