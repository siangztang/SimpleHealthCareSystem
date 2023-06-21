package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.Patient;
import com.example.SwitchPage;
import com.example.TreatmentCourse;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreatmentCourseController {

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
    private TextField patInfoAge;

    @FXML
    private TextField patInfoContactInfo;

    @FXML
    private TextField patInfoDepartment;

    @FXML
    private TextField patInfoGender;

    @FXML
    private TextField patInfoHisID;

    @FXML
    private TextField patInfoID;

    @FXML
    private TextField patInfoName;

    @FXML
    private Button resetBtn;

    @FXML
    private TableColumn<TreatmentCourse, String> treatmentCourseEndDateCol;

    @FXML
    private DatePicker treatmentCourseEndDateField;

    @FXML
    private TableColumn<TreatmentCourse, String> treatmentCourseIDCol;

    @FXML
    private TableColumn<TreatmentCourse, String> treatmentCourseStartDateCol;

    @FXML
    private DatePicker treatmentCourseStartDateField;

    @FXML
    private TableView<TreatmentCourse> treatmentCourseTable;

    @FXML
    private StackPane treatment_course_page;

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

        treatmentCourseTable.getColumns().forEach(e -> e.setReorderable(false));

        treatmentCourseTable.setOnMouseClicked(event -> {
            TreatmentCourse selectedTreatmentCourse = treatmentCourseTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1) {
                if (selectedTreatmentCourse != null) {
                    // Do something with the selected patient data
                    System.out.println("Selected treatment course ID: " + selectedTreatmentCourse.getTreatment_course_id());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate startDate = LocalDate.parse(selectedTreatmentCourse.getStart_date(), formatter);
                    LocalDate enDate = LocalDate.parse(selectedTreatmentCourse.getEnd_date(), formatter);
                    treatmentCourseStartDateField.setValue(startDate);
                    treatmentCourseEndDateField.setValue(enDate);
                }   
            } else if (event.getClickCount() == 2) {
                if (selectedTreatmentCourse != null) {
                    // Do something with the selected patient data
                    System.out.println("Selected treatment course ID: " + selectedTreatmentCourse.getTreatment_course_id());
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\TreatmentCourseDetails.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                        TreatmentCourseDetailsController controller = loader.getController();
                        controller.initData(admin, patient_info, selectedTreatmentCourse.getHistory_id(), selectedTreatmentCourse.getTreatment_course_id());
                        Node node = (Node) event.getSource();
                        Stage currentStage = (Stage) node.getScene().getWindow();
                        currentStage.close();
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        TreatmentCourseShowListData();

    }
    
    private Admin admin;
    private Patient patient_info;

    public void initData(Admin admin, Patient patient_info, String history_id){
        this.admin = admin;
        this.patient_info = patient_info;
        patInfoID.setText(patient_info.getPatient_id());
        patInfoName.setText(patient_info.getName());
        patInfoAge.setText(String.valueOf(patient_info.getAge()));
        patInfoGender.setText(Character.toString(patient_info.getGender()));
        patInfoDepartment.setText(patient_info.getDepartment());
        patInfoContactInfo.setText(Long.toString(patient_info.getContact_info()));
        patInfoHisID.setText(history_id);
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){
        treatmentCourseStartDateField.setValue(null);
        treatmentCourseEndDateField.setValue(null);
    }

    public void unFocusAll(){
        managePatientBtn.setFocusTraversable(false);
        treatmentCourseTable.setFocusTraversable(false);
        treatmentCourseStartDateField.setFocusTraversable(false);
        treatmentCourseEndDateField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
    }

    public void TreatmentCourseShowListData(){
        ObservableList<TreatmentCourse> listData = FXCollections.observableArrayList();

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
        String dateString = dateFormat.format(currentDate);

        listData.add(new TreatmentCourse("H001", "TC001", dateString, dateString));

        treatmentCourseIDCol.setCellValueFactory(new PropertyValueFactory<>("treatment_course_id"));
        treatmentCourseStartDateCol.setCellValueFactory(new PropertyValueFactory<>("start_date"));
        treatmentCourseEndDateCol.setCellValueFactory(new PropertyValueFactory<>("end_date"));

        treatmentCourseTable.setItems(listData);

    }

    

}
