package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.Medicine;
import com.example.Patient;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProcedureDetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button managePatientBtn;

    @FXML
    private TextField patInfoAge;

    @FXML
    private TextField patInfoContact;

    @FXML
    private TextField patInfoCourseID;

    @FXML
    private TextField patInfoDepartment;

    @FXML
    private TextField patInfoGender;

    @FXML
    private TextField patInfoHistory;

    @FXML
    private TextField patInfoID;

    @FXML
    private TextField patInfoName;

    @FXML
    private TextField patInfoProcedureID;

    @FXML
    private TableColumn<Medicine, String> prodDetMedNameCol;

    @FXML
    private TableView<Medicine> prodDetTable;

    @FXML
    private StackPane treatment_course_page;

    @FXML
    private Label unameLabel;

    @FXML
    private Button backBtn;

    @FXML
    void initialize() {
        SwitchPage switchpage = new SwitchPage();
        managePatientBtn.setOnAction(event -> {
            switchpage.switchPage(event, managePatientBtn);
        });

        backBtn.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream("demo/src/main/resources/com/example/TreatmentCourseDetails.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                TreatmentCourseDetailsController controller = loader.getController();
                controller.initData(admin, patient_info, history_id, treatment_course_id);
                Node node = (Node) event.getSource();
                Stage currentStage = (Stage) node.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        unFocusAll();
    }

    private String[] medicine_list;
    private Admin admin;
    private Patient patient_info;
    private String history_id;
    private String treatment_course_id;

    public void initData(Admin admin, Patient patient_info, String history_id, String treatment_course_id, String procedure_id, String[] medicine_list) {
        this.medicine_list = medicine_list;
        this.admin = admin;
        this.patient_info = patient_info;
        this.history_id = history_id;
        this.treatment_course_id = treatment_course_id;
        patInfoID.setText(patient_info.getPatient_id());
        patInfoName.setText(patient_info.getName());
        patInfoAge.setText(String.valueOf(patient_info.getAge()));
        patInfoGender.setText(String.valueOf(patient_info.getGender()));
        patInfoContact.setText(String.valueOf(patient_info.getContact_info()));
        patInfoDepartment.setText(patient_info.getDepartment());
        patInfoHistory.setText(history_id);
        patInfoCourseID.setText(treatment_course_id);
        patInfoProcedureID.setText(procedure_id);

        ProcedureDetailsShowListData();
        
    }

    public void unFocusAll(){
        managePatientBtn.setFocusTraversable(false);
        prodDetTable.setFocusTraversable(false);
        backBtn.setFocusTraversable(false);
    }

    public void ProcedureDetailsShowListData(){
        ObservableList<Medicine> listData = FXCollections.observableArrayList();
        
        for (String medicine : this.medicine_list) {
            listData.add(new Medicine(medicine));
            System.out.println(medicine);
        }

        prodDetMedNameCol.setCellValueFactory(new PropertyValueFactory<>("medicine_name"));

        prodDetTable.setItems(listData);

    }

}
