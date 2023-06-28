package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.Patient;
import com.example.SwitchPage;
import com.example.TreatmentCourse;
import com.example.CSVRelatedClass.CSVHandler;
import com.example.CSVRelatedClass.CSVPath;
import com.example.CSVRelatedClass.CustomComparator;
import com.example.CSVRelatedClass.ParameterTypes;

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
    private Button backBtn;

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

        updateBtn.setOnAction(event -> {
            updateBtnAction();
        });

        deleteBtn.setOnAction(event -> {
            deleteBtnAction();
        });

        unFocusAll();

        backBtn.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\PatientHistory.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                PatientHistoryController controller = loader.getController();
                controller.initData(admin, patient_info);
                Node node = (Node) event.getSource();
                Stage currentStage = (Stage) node.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        treatmentCourseTable.getColumns().forEach(e -> e.setReorderable(false));

        treatmentCourseTable.setOnMouseClicked(event -> {
            TreatmentCourse selectedTreatmentCourse = treatmentCourseTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1) {
                if (selectedTreatmentCourse != null) {
                    // Do something with the selected patient data
                    System.out.println("Selected treatment course ID: " + selectedTreatmentCourse.getTreatment_course_id());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

    }
    
    private Admin admin;
    private Patient patient_info;
    private CSVHandler csvhandler = new CSVHandler();
    private AlertMessage alert = new AlertMessage();
    private TreatmentCourse checkInput = new TreatmentCourse();

    public void initData(Admin admin, Patient patient_info, String history_id){
        this.admin = admin;
        this.patient_info = patient_info;
        patInfoID.setText(patient_info.getPatient_id());
        patInfoName.setText(patient_info.getName());
        patInfoAge.setText(String.valueOf(patient_info.getAge()));
        patInfoGender.setText(Character.toString(patient_info.getGender()));
        patInfoDepartment.setText(patient_info.getDepartment());
        patInfoContactInfo.setText(patient_info.getContact_info());
        patInfoHisID.setText(history_id);
        unameLabel.setText(admin.getUname());
        TreatmentCourseShowListData();
    }

    public void resetBtnAction(){
        treatmentCourseStartDateField.setValue(null);
        treatmentCourseEndDateField.setValue(null);
        treatmentCourseTable.getSelectionModel().clearSelection();
        treatmentCourseTable.setItems(refreshData());
        TreatmentCourseShowListData();
    }

    public void unFocusAll(){
        managePatientBtn.setFocusTraversable(false);
        backBtn.setFocusTraversable(false);
        treatmentCourseTable.setFocusTraversable(false);
        treatmentCourseStartDateField.setFocusTraversable(false);
        treatmentCourseEndDateField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
    }

    private ObservableList<TreatmentCourse> refreshData(){
        String history_id = patInfoHisID.getText();
        ObservableList<TreatmentCourse> listData = csvhandler.readCSV(CSVPath.TREATMENTCOURSE_PATH, TreatmentCourse.class, "history_id", history_id, CustomComparator.createComparator(TreatmentCourse::getTreatment_course_id, 2), ParameterTypes. TREATMENT_COURSE_PARAMETER_TYPES);
        return listData;
    }

    private ObservableList<TreatmentCourse> refreshAllData(){
        ObservableList<TreatmentCourse> listData = csvhandler.readCSV(CSVPath.TREATMENTCOURSE_PATH, TreatmentCourse.class, CustomComparator.createComparator(TreatmentCourse::getTreatment_course_id, 2), ParameterTypes. TREATMENT_COURSE_PARAMETER_TYPES);
        return listData;
    }

    private void TreatmentCourseShowListData(){

        treatmentCourseIDCol.setCellValueFactory(new PropertyValueFactory<>("treatment_course_id"));
        treatmentCourseStartDateCol.setCellValueFactory(new PropertyValueFactory<>("start_date"));
        treatmentCourseEndDateCol.setCellValueFactory(new PropertyValueFactory<>("end_date"));

        treatmentCourseTable.setItems(refreshData());
    }

    private boolean checkEmpty(){
        if (treatmentCourseStartDateField.getValue() == null || treatmentCourseEndDateField.getValue() == null) {
            // show error message
            alert.errorMessage("Please fill in all fields");
            return true;
        }
        return false;
    }

    private boolean checkSelected(){
        if (treatmentCourseTable.getSelectionModel().getSelectedItem() == null) {
            // show error message
            alert.errorMessage("Please select a treatment course");
            return true;
        }
        return false;
    }
    
    private void addBtnAction(){
        String startDate = treatmentCourseStartDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String endDate = treatmentCourseEndDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (!checkEmpty()){
            if(checkInput.validateTreatmentCourse(startDate, endDate) == 1){

                //generate treatment course id
                String treatment_course_id = "TC" + String.format("%d", csvhandler.getMaxId(refreshAllData(), TreatmentCourse::getTreatment_course_id, "TC") + 1);

                //creata a new treatment course object
                TreatmentCourse newTreatmentCourse = new TreatmentCourse(treatment_course_id, patInfoHisID.getText(), startDate, endDate);

                //add new treatment course to csv file
                csvhandler.writeCSV(CSVPath.TREATMENTCOURSE_PATH, newTreatmentCourse);

                //show success message
                alert.successMessage("Treatment course added successfully");

                //refresh data
                refreshData();

                //refresh table
                TreatmentCourseShowListData();

                // reset fields
                resetBtnAction();
            } else {
                // show error message
                alert.errorMessage("Invalid date input");
            }
        }
    }

    private void updateBtnAction(){
        if (!checkSelected()){
            // get selected treatment course
            String treatment_course_id = treatmentCourseTable.getSelectionModel().getSelectedItem().getTreatment_course_id();
            String start_date = treatmentCourseStartDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String end_date = treatmentCourseEndDateField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (!checkEmpty()){
                if (checkInput.validateTreatmentCourse(start_date, end_date) == 1){
                        
                    //create a new treatment course object
                    TreatmentCourse updatedTreatmentCourse = new TreatmentCourse(treatment_course_id, patInfoHisID.getText(), start_date, end_date);

                    //update treatment course in csv file
                    csvhandler.updateCSV(CSVPath.TREATMENTCOURSE_PATH, 0, treatment_course_id, updatedTreatmentCourse);

                    //show success message
                    alert.successMessage("Treatment course updated successfully");

                    //refresh data
                    refreshData();

                    //refresh table
                    TreatmentCourseShowListData();

                    // reset fields
                    resetBtnAction();

                } else {
                    // show error message
                    alert.errorMessage("Invalid date input");
                }
            }
        }
    }

    private void deleteBtnAction(){
        if (!checkSelected()){
            // get selected treatment course
            String treatment_course_id = treatmentCourseTable.getSelectionModel().getSelectedItem().getTreatment_course_id();

            //delete treatment course in csv file
            csvhandler.deleteCSV(CSVPath.TREATMENTCOURSE_PATH, 0, treatment_course_id);

            //show success message
            alert.successMessage("Treatment course deleted successfully");

            //refresh data
            refreshData();

            //refresh table
            TreatmentCourseShowListData();

            // reset fields
            resetBtnAction();
        }
    }
}
