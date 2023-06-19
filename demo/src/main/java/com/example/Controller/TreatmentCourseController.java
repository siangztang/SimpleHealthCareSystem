package com.example.Controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.SwitchPage;
import com.example.TreatmentCourse;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

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
    private TableColumn<TreatmentCourse, Date> treatmentCourseEndDateCol;

    @FXML
    private DatePicker treatmentCourseEndDateField;

    @FXML
    private TableColumn<TreatmentCourse, String> treatmentCourseIDCol;

    @FXML
    private TableColumn<TreatmentCourse, String> treatmentCourseNameCol;

    @FXML
    private TextField treatmentCourseNameField;

    @FXML
    private TableColumn<TreatmentCourse, Date> treatmentCourseStartDateCol;

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

        treatmentCourseTable.getColumns().forEach(e -> e.setReorderable(false));
        unFocusAll();

    }

    public void initData(Admin admin, String pat_id, String history_id){
        patInfoID.setText(pat_id);
        patInfoHisID.setText(history_id);
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){
        treatmentCourseNameField.setText("");
        treatmentCourseStartDateField.setValue(null);
        treatmentCourseEndDateField.setValue(null);
    }

    public void unFocusAll(){
        managePatientBtn.setFocusTraversable(false);
        treatmentCourseTable.setFocusTraversable(false);
        treatmentCourseNameField.setFocusTraversable(false);
        treatmentCourseStartDateField.setFocusTraversable(false);
        treatmentCourseEndDateField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
    }

}
