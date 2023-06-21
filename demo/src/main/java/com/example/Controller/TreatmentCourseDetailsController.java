package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.BioBloodAnalysis;
import com.example.BloodAnalysis;
import com.example.Diagnosis;
import com.example.Patient;
import com.example.Procedure;
import com.example.RWAnalysis;
import com.example.SwitchPage;
import com.example.UrineAnalysis;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class TreatmentCourseDetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RWAnalysisAddBtn;

    @FXML
    private Button RWAnalysisDeleteBtn;

    @FXML
    private Button RWAnalysisResetBtn;

    @FXML
    private Button RWAnalysisUpdateBtn;

    @FXML
    private Button bioBloodAnalysisAddBtn;

    @FXML
    private Button bioBloodAnalysisDeleteBtn;

    @FXML
    private Button bioBloodAnalysisResetBtn;

    @FXML
    private Button bioBloodAnalysisUpdateBtn;

    @FXML
    private Button bloodAnalysisAddBtn;

    @FXML
    private Button bloodAnalysisDeleteBtn;

    @FXML
    private Button bloodAnalysisResetBtn;

    @FXML
    private Button bloodAnalysisUpdateBtn;

    @FXML
    private Button diagnosisAddBtn;

    @FXML
    private Button diagnosisDeleteBtn;

    @FXML
    private Button diagnosisResetBtn;

    @FXML
    private Button diagnosisUpdateBtn;

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
    private TextField patInfoHisID;

    @FXML
    private TextField patInfoID;

    @FXML
    private TextField patInfoName;

    @FXML
    private Button procedureAddBtn;

    @FXML
    private Button procedureDeleteBtn;

    @FXML
    private Button procedureResetBtn;

    @FXML
    private Button procedureUpdateBtn;

    @FXML
    private Tab treatCourseDetAnalysisTab;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisALTCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisALTField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisASTCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisASTField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisAkalinePhospataseCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisAkalinePhospataseField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisBiluribinCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisBiluribinField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisCholesterolCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisCholesterolField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisCreatenineCol;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisDateCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisCreatenineField;

    @FXML
    private DatePicker treatCourseDetBioBloodAnalysisDateField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisDirectBiluribinCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisDirectBiluribinField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisHDLCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisHDLField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisIDCol;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisLDLCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisLDLField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisSugarCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisSugarField;

    @FXML
    private Tab treatCourseDetBioBloodAnalysisTab;

    @FXML
    private TableView<BioBloodAnalysis> treatCourseDetBioBloodAnalysisTable;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisTriglyceridesCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisTriglyceridesField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisUrearCol;

    @FXML
    private TableColumn<BloodAnalysis, String> treatCourseDetBloodAnalysisColorCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisColorField;

    @FXML
    private TableColumn<BloodAnalysis, String> treatCourseDetBloodAnalysisDateCol;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisDateCol;

    @FXML
    private DatePicker treatCourseDetBloodAnalysisDateDateField;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisESRCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisESRField;

    @FXML
    private TableColumn<BloodAnalysis, Double> treatCourseDetBloodAnalysisHaematocritCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisHaematocritField;

    @FXML
    private TableColumn<BloodAnalysis, Double> treatCourseDetBloodAnalysisHaemoglobinCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisHaemoglobinField;

    @FXML
    private TableColumn<BloodAnalysis, String> treatCourseDetBloodAnalysisIDCol;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisLymphocytesCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisLymphocytesField;

    @FXML
    private TableColumn<BloodAnalysis, Double> treatCourseDetBloodAnalysisMeanCorpuscularHaemoglobinCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisMeanCorpuscularHaemoglobinField;

    @FXML
    private TableColumn<BloodAnalysis, Double> treatCourseDetBloodAnalysisMeanCorpuscularVolumeCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisMeanCorpuscularVolumeField;

    @FXML
    private TableColumn<BloodAnalysis, Boolean> treatCourseDetBloodAnalysisParasitesCol;

    @FXML
    private ComboBox<String> treatCourseDetBloodAnalysisParasitesField;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisPlateletsCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisPlateletsField;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisRedCellsCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisRedCellsField;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisStabNeuthrophilCol;

    @FXML
    private Tab treatCourseDetBloodAnalysisTab;

    @FXML
    private TableView<BloodAnalysis> treatCourseDetBloodAnalysisTable;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisWhiteCellsCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisWhiteCellsField;

    @FXML
    private TableColumn<Diagnosis, String> treatCourseDetDiagnosisDiagDateCol;

    @FXML
    private DatePicker treatCourseDetDiagnosisDiagDateField;

    @FXML
    private TableColumn<Diagnosis, String> treatCourseDetDiagnosisDocNameCol;

    @FXML
    private ComboBox<String> treatCourseDetDiagnosisDocNameField;

    @FXML
    private TableColumn<Diagnosis, String> treatCourseDetDiagnosisNameCol;

    @FXML
    private TextField treatCourseDetDiagnosisNameField;

    @FXML
    private Tab treatCourseDetDiagnosisTab;

    @FXML
    private TableView<Diagnosis> treatCourseDetDiagnosisTable;

    @FXML
    private TableColumn<Diagnosis, String> treatCourseDetDiagnosisTreatPlanCol;

    @FXML
    private TextField treatCourseDetDiagnosisTreatPlanField;

    @FXML
    private TableColumn<Procedure, String> treatCourseDetProcedureDateCol;

    @FXML
    private DatePicker treatCourseDetProcedureDateField;

    @FXML
    private Button treatCourseDetProcedureMedicineAddBtn;

    @FXML
    private ComboBox<?> treatCourseDetProcedureMedicineChoice;

    @FXML
    private TextArea treatCourseDetProcedureMedicineList;

    @FXML
    private Tab treatCourseDetProcedureTab;

    @FXML
    private TableView<Procedure> treatCourseDetProcedureTable;

    @FXML
    private Button treatCourseDetProcedureTimeBtn;

    @FXML
    private TableColumn<Procedure, String> treatCourseDetProcedureTimeCol;

    @FXML
    private TextField treatCourseDetProcedureTimeField;

    @FXML
    private TableColumn<Procedure, String> treatCourseDetProcedureTypeCol;

    @FXML
    private TextField treatCourseDetProcedureTypeField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisAidsDateCol;

    @FXML
    private DatePicker treatCourseDetRWAnalysisAidsDateField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisAidsResultCol;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisDateCol;

    @FXML
    private TextField treatCourseDetRWAnalysisAidsResultField;

    @FXML
    private DatePicker treatCourseDetRWAnalysisDateField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisHepatitisDateCol;

    @FXML
    private DatePicker treatCourseDetRWAnalysisHepatitisDateField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisHepatitisResultCol;

    @FXML
    private TextField treatCourseDetRWAnalysisHepatitisResultField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisIDCol;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisRWResultCol;

    @FXML
    private TextField treatCourseDetRWAnalysisRWResultField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisSyphilisDateCol;

    @FXML
    private DatePicker treatCourseDetRWAnalysisSyphilisDateField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisSyphilisResultCol;

    @FXML
    private TextField treatCourseDetRWAnalysisSyphilisResultField;

    @FXML
    private Tab treatCourseDetRWAnalysisTab;

    @FXML
    private TableView<RWAnalysis> treatCourseDetRWAnalysisTable;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisColorCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisColorField;

    @FXML
    private DatePicker treatCourseDetUrineAnalysisDateField;

    @FXML
    private TableColumn<UrineAnalysis, Double> treatCourseDetUrineAnalysisDensityCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisDensityField;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisGlucoseCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisGlucoseField;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisIDCol;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisKetonesCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisKetonesField;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisLeukocytesCol;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisNitritesCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisNitritesField;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisProteinCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisProteinField;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisReactionCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisReactionField;

    @FXML
    private Tab treatCourseDetUrineAnalysisTab;

    @FXML
    private TableView<UrineAnalysis> treatCourseDetUrineAnalysisTable;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisTransparencyCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisTransparencyField;

    @FXML
    private StackPane treatment_course_details_page;

    @FXML
    private Label unamelabel;

    @FXML
    private Button urineAnalysisAddBtn;

    @FXML
    private Button urineAnalysisDeleteBtn;

    @FXML
    private Button urineAnalysisResetBtn;

    @FXML
    private Button urineAnalysisUpdateBtn;

    @FXML
    void initialize() {
        managePatientBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, managePatientBtn);
        });

        treatCourseDetProcedureTimeBtn.setOnAction(event -> {
            showTimePopup();
        });

        diagnosisResetBtn.setOnAction(event -> {
            diagnosisResetBtnAction();
        });

        procedureResetBtn.setOnAction(event -> {
            procedureResetBtnAction();
        });

        urineAnalysisResetBtn.setOnAction(event -> {
            urineAnalysisResetBtnAction();
        });

        RWAnalysisResetBtn.setOnAction(event -> {
            RWAnalysisResetBtnAction();
        });

        bioBloodAnalysisResetBtn.setOnAction(event -> {
            bioBloodAnalysisResetBtnAction();
        });

        bloodAnalysisResetBtn.setOnAction(event -> {
            bloodAnalysisResetBtnAction();
        });

        unFocusAll();

        treatCourseDetDiagnosisTable.getColumns().forEach(e -> e.setReorderable(false));

        treatCourseDetDiagnosisTable.setOnMouseClicked(event -> {
            Diagnosis selectedDiagnosis = treatCourseDetDiagnosisTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1){
                if (selectedDiagnosis != null){
                    System.out.println("Selected diagnosis ID: " + selectedDiagnosis.getDiagnosis_id());
                    treatCourseDetDiagnosisNameField.setText(selectedDiagnosis.getDiagnosis_name());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate diagnosis_date = LocalDate.parse(selectedDiagnosis.getDiagnosis_date(), formatter);
                    treatCourseDetDiagnosisDiagDateField.setValue(diagnosis_date);
                    treatCourseDetDiagnosisDocNameField.setValue(selectedDiagnosis.getDoctor_name());
                    treatCourseDetDiagnosisTreatPlanField.setText(selectedDiagnosis.getTreatment_plan());                    
                }
            }
            
        });
        DiagnosisShowListData();

        treatCourseDetProcedureTable.getColumns().forEach(e -> e.setReorderable(false));

        treatCourseDetProcedureTable.setOnMouseClicked(event -> {
            Procedure selectedProcedure = treatCourseDetProcedureTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1){
                if (selectedProcedure != null){
                    System.out.println("Selected procedure ID: " + selectedProcedure.getProcedure_id());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate procedure_date = LocalDate.parse(selectedProcedure.getProcedure_date(), formatter);
                    treatCourseDetProcedureDateField.setValue(procedure_date);
                    treatCourseDetProcedureTimeField.setText(selectedProcedure.getProcedure_time());
                    treatCourseDetProcedureTypeField.setText(selectedProcedure.getType());
                    String[] medicineList = selectedProcedure.getMedicine_list();
                    String medicineListText = String.join(", ", medicineList);
                    treatCourseDetProcedureMedicineList.setText(medicineListText);
                }
            } else if (event.getClickCount() == 2){
                try {
                    System.out.println("Selected procedure ID: " + selectedProcedure.getProcedure_id());
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\ProcedureDetails.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    ProcedureDetailsController controller = loader.getController();
                    String[] medicineList = selectedProcedure.getMedicine_list();
                    controller.initData(admin, patient_info, history_id, treatment_course_id, selectedProcedure.getProcedure_id(), medicineList);
                    Node node = (Node) event.getSource();
                    Stage currentStage = (Stage) node.getScene().getWindow();
                    currentStage.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ProcedureShowListData();

        treatCourseDetUrineAnalysisTable.getColumns().forEach(e -> e.setReorderable(false));
        treatCourseDetUrineAnalysisTable.setOnMouseClicked(event -> {
            UrineAnalysis selectedUrineAnalysis = treatCourseDetUrineAnalysisTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1){
                if (selectedUrineAnalysis != null){
                    System.out.println("Selected urine analysis ID: " + selectedUrineAnalysis.getAnalysis_id());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate urine_analysis_date = LocalDate.parse(selectedUrineAnalysis.getAnalysis_date(), formatter);
                    treatCourseDetUrineAnalysisDateField.setValue(urine_analysis_date);
                    treatCourseDetUrineAnalysisColorField.setText(selectedUrineAnalysis.getColor());
                    treatCourseDetUrineAnalysisReactionField.setText(selectedUrineAnalysis.getReaction());
                    treatCourseDetUrineAnalysisTransparencyField.setText(selectedUrineAnalysis.getTransparency());
                    treatCourseDetUrineAnalysisDensityField.setText(String.valueOf(selectedUrineAnalysis.getDensity()));
                    treatCourseDetUrineAnalysisProteinField.setText(selectedUrineAnalysis.getProtein());
                    treatCourseDetUrineAnalysisGlucoseField.setText(selectedUrineAnalysis.getGlucose());
                    treatCourseDetUrineAnalysisKetonesField.setText(selectedUrineAnalysis.getKetones());
                    treatCourseDetUrineAnalysisNitritesField.setText(selectedUrineAnalysis.getNitrites());
                }
            }
        });
        UrineAnalysisShowListData();

        treatCourseDetRWAnalysisTable.getColumns().forEach(e -> e.setReorderable(false));
        treatCourseDetRWAnalysisTable.setOnMouseClicked(event -> {
            RWAnalysis selectedRWAnalysis = treatCourseDetRWAnalysisTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1){
                if (selectedRWAnalysis != null){
                    System.out.println("Selected RW analysis ID: " + selectedRWAnalysis.getAnalysis_id());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate rw_analysis_date = LocalDate.parse(selectedRWAnalysis.getAnalysis_date(), formatter);
                    LocalDate aids_date = LocalDate.parse(selectedRWAnalysis.getAnalysis_date(), formatter);
                    LocalDate syphilis_date = LocalDate.parse(selectedRWAnalysis.getAdis_date(), formatter);
                    LocalDate hepatitis_date = LocalDate.parse(selectedRWAnalysis.getHepatitis_date(), formatter);

                    treatCourseDetRWAnalysisDateField.setValue(rw_analysis_date);
                    treatCourseDetRWAnalysisRWResultField.setText(selectedRWAnalysis.getRw_result());
                    treatCourseDetRWAnalysisAidsDateField.setValue(aids_date);
                    treatCourseDetRWAnalysisAidsResultField.setText(selectedRWAnalysis.getAids_result());
                    treatCourseDetRWAnalysisSyphilisDateField.setValue(syphilis_date);
                    treatCourseDetRWAnalysisSyphilisResultField.setText(selectedRWAnalysis.getSyphilis_result());
                    treatCourseDetRWAnalysisHepatitisDateField.setValue(hepatitis_date);
                    treatCourseDetRWAnalysisHepatitisResultField.setText(selectedRWAnalysis.getHepatitis_result());
                }
            }
        });
        RWAnalysisShowListData();

        treatCourseDetBioBloodAnalysisTable.getColumns().forEach(e -> e.setReorderable(false));
        treatCourseDetBioBloodAnalysisTable.setOnMouseClicked(event -> {
            BioBloodAnalysis selectedBioBloodAnalysis = treatCourseDetBioBloodAnalysisTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1){
                if (selectedBioBloodAnalysis != null){
                    System.out.println("Selected bio blood analysis ID: " + selectedBioBloodAnalysis.getAnalysis_id());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate bio_blood_analysis_date = LocalDate.parse(selectedBioBloodAnalysis.getAnalysis_date(), formatter);

                    treatCourseDetBioBloodAnalysisDateField.setValue(bio_blood_analysis_date);
                    treatCourseDetBioBloodAnalysisCreatenineField.setText(String.valueOf(selectedBioBloodAnalysis.getCreatenine()));
                    // treatCourseDetBioBloodAnalysisSugarField
                    // treatCourseDetBioBloodAnalysisBiluribinField
                    // treatCourseDetBioBloodAnalysisDirectBiluribinField
                }
            }
        });
        BioBloodAnalysisShowListData();

        treatCourseDetBloodAnalysisTable.getColumns().forEach(e -> e.setReorderable(false));
        treatCourseDetBloodAnalysisTable.setOnMouseClicked(event -> {
            BloodAnalysis selectedBloodAnalysis = treatCourseDetBloodAnalysisTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1){
                if (selectedBloodAnalysis != null){
                    System.out.println("Selected blood analysis ID: " + selectedBloodAnalysis.getAnalysis_id());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate blood_analysis_date = LocalDate.parse(selectedBloodAnalysis.getAnalysis_date(), formatter);

                    treatCourseDetBloodAnalysisDateDateField.setValue(blood_analysis_date);
                    
                }
            }
        });
        BloodAnalysisShowListData();


    }

    private Admin admin;
    private Patient patient_info;
    private String history_id;
    private String treatment_course_id;

    public void initData(Admin admin, Patient patient_info, String history_id, String treatment_course_id){
        this.admin = admin;
        this.patient_info = patient_info;
        this.history_id = history_id;
        this.treatment_course_id = treatment_course_id;
        patInfoID.setText(patient_info.getPatient_id());
        patInfoName.setText(patient_info.getName());
        patInfoAge.setText(String.valueOf(patient_info.getAge()));
        patInfoGender.setText(Character.toString(patient_info.getGender()));
        patInfoDepartment.setText(patient_info.getDepartment());
        patInfoContact.setText(Long.toString(patient_info.getContact_info()));
        patInfoHisID.setText(history_id);
        patInfoCourseID.setText(treatment_course_id);
        unamelabel.setText(admin.getUname());
    }

    public void diagnosisResetBtnAction(){

    }

    public void procedureResetBtnAction(){

    }

    public void urineAnalysisResetBtnAction(){

    }

    public void RWAnalysisResetBtnAction(){

    }

    public void bioBloodAnalysisResetBtnAction(){

    }

    public void bloodAnalysisResetBtnAction(){

    }

    public void unFocusAll(){

    }

    public void DiagnosisShowListData(){
        ObservableList<Diagnosis> diagnosisListData = FXCollections.observableArrayList();

        diagnosisListData.add(new Diagnosis("1", "2", "20/7/2023", "4", "5", "6"));
        diagnosisListData.add(new Diagnosis("1", "2", "20/7/2023", "4", "5", "6"));

        treatCourseDetDiagnosisNameCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis_id"));
        treatCourseDetDiagnosisDiagDateCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis_date"));
        treatCourseDetDiagnosisDocNameCol.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));
        treatCourseDetDiagnosisTreatPlanCol.setCellValueFactory(new PropertyValueFactory<>("treatment_plan"));

        treatCourseDetDiagnosisTable.setItems(diagnosisListData);

    }

    public void ProcedureShowListData(){
        ObservableList<Procedure> procedureListData = FXCollections.observableArrayList();

        procedureListData.add(new Procedure("1", "Surgery", "20/7/2023", "11:25", "1", new String[]{"Aspirin", "Ibuprofen"}));
        procedureListData.add(new Procedure("2", "Radiology", "20/7/2023", "11:25", "2", new String[]{"X-ray", "CT scan"}));

        treatCourseDetProcedureDateCol.setCellValueFactory(new PropertyValueFactory<>("procedure_date"));
        treatCourseDetProcedureTimeCol.setCellValueFactory(new PropertyValueFactory<>("procedure_time"));
        treatCourseDetProcedureTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        treatCourseDetProcedureTable.setItems(procedureListData);

    }

    public void UrineAnalysisShowListData(){
        ObservableList<UrineAnalysis> urineAnalysisListData = FXCollections.observableArrayList();

        urineAnalysisListData.add(new UrineAnalysis("1", "20/7/2023", "Clear", "Good", "1.025", 1.23, "Negative", "Negative", "Negative", "Negative", "Negative"));
        urineAnalysisListData.add(new UrineAnalysis("2", "20/7/2023", "Clear", "Good", "1.025", 1.23, "Negative", "Negative", "Negative", "Negative", "Negative"));

        treatCourseDetUrineAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetUrineAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetUrineAnalysisColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        treatCourseDetUrineAnalysisReactionCol.setCellValueFactory(new PropertyValueFactory<>("reaction"));
        treatCourseDetUrineAnalysisTransparencyCol.setCellValueFactory(new PropertyValueFactory<>("transparency"));
        treatCourseDetUrineAnalysisDensityCol.setCellValueFactory(new PropertyValueFactory<>("density"));
        treatCourseDetUrineAnalysisProteinCol.setCellValueFactory(new PropertyValueFactory<>("protein"));
        treatCourseDetUrineAnalysisGlucoseCol.setCellValueFactory(new PropertyValueFactory<>("glucose"));
        treatCourseDetUrineAnalysisKetonesCol.setCellValueFactory(new PropertyValueFactory<>("ketones"));
        treatCourseDetUrineAnalysisNitritesCol.setCellValueFactory(new PropertyValueFactory<>("nitrites"));
        treatCourseDetUrineAnalysisLeukocytesCol.setCellValueFactory(new PropertyValueFactory<>("leukocytes"));

        treatCourseDetUrineAnalysisTable.setItems(urineAnalysisListData);

    }

    public void RWAnalysisShowListData(){
        ObservableList<RWAnalysis> RWAnalysisListData = FXCollections.observableArrayList();

        RWAnalysisListData.add(new RWAnalysis("1", "20/7/2023", "Positive", "20/7/2023", "Positive", "20/7/2023", "Positive", "20/7/2023", "Positive"));
        RWAnalysisListData.add(new RWAnalysis("2", "20/7/2023", "Positive", "20/7/2023", "Positive", "20/7/2023", "Positive", "20/7/2023", "Positive"));

        treatCourseDetRWAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetRWAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetRWAnalysisRWResultCol.setCellValueFactory(new PropertyValueFactory<>("rw_result"));
        treatCourseDetRWAnalysisAidsDateCol.setCellValueFactory(new PropertyValueFactory<>("adis_date"));
        treatCourseDetRWAnalysisAidsResultCol.setCellValueFactory(new PropertyValueFactory<>("aids_result"));
        treatCourseDetRWAnalysisSyphilisDateCol.setCellValueFactory(new PropertyValueFactory<>("syphilis_date"));
        treatCourseDetRWAnalysisSyphilisResultCol.setCellValueFactory(new PropertyValueFactory<>("syphilis_result"));
        treatCourseDetRWAnalysisHepatitisDateCol.setCellValueFactory(new PropertyValueFactory<>("hepatitis_date"));
        treatCourseDetRWAnalysisHepatitisResultCol.setCellValueFactory(new PropertyValueFactory<>("hepatitis_result"));

        treatCourseDetRWAnalysisTable.setItems(RWAnalysisListData);
        
    }

    public void BioBloodAnalysisShowListData(){
        ObservableList<BioBloodAnalysis> bioBloodAnalysisListData = FXCollections.observableArrayList();

        bioBloodAnalysisListData.add(new BioBloodAnalysis("1", "20/7/2023", 1.123, 1.512, 1.321, 2.21, 2.32, 1.56, 1.11, 1.22, 3.12, 11.2, 13.23, 12.22));
        bioBloodAnalysisListData.add(new BioBloodAnalysis("2", "20/7/2023", 1.123, 1.512, 1.321, 2.21, 2.32, 1.56, 1.11, 1.22, 3.12, 11.2, 13.23, 12.22));

        treatCourseDetBioBloodAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetBioBloodAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetBioBloodAnalysisUrearCol.setCellValueFactory(new PropertyValueFactory<>("urea"));
        treatCourseDetBioBloodAnalysisCreatenineCol.setCellValueFactory(new PropertyValueFactory<>("createnine"));
        treatCourseDetBioBloodAnalysisSugarCol.setCellValueFactory(new PropertyValueFactory<>("sigar"));
        treatCourseDetBioBloodAnalysisBiluribinCol.setCellValueFactory(new PropertyValueFactory<>("biluribin"));
        treatCourseDetBioBloodAnalysisDirectBiluribinCol.setCellValueFactory(new PropertyValueFactory<>("direct_biluribin"));
        treatCourseDetBioBloodAnalysisASTCol.setCellValueFactory(new PropertyValueFactory<>("AST"));
        treatCourseDetBioBloodAnalysisALTCol.setCellValueFactory(new PropertyValueFactory<>("ALT"));
        treatCourseDetBioBloodAnalysisCholesterolCol.setCellValueFactory(new PropertyValueFactory<>("cholesterol"));
        treatCourseDetBioBloodAnalysisTriglyceridesCol.setCellValueFactory(new PropertyValueFactory<>("triglycerides"));
        treatCourseDetBioBloodAnalysisHDLCol.setCellValueFactory(new PropertyValueFactory<>("HDL"));
        treatCourseDetBioBloodAnalysisLDLCol.setCellValueFactory(new PropertyValueFactory<>("LDL"));
        treatCourseDetBioBloodAnalysisAkalinePhospataseCol.setCellValueFactory(new PropertyValueFactory<>("alkaline_phosphatase"));

        treatCourseDetBioBloodAnalysisTable.setItems(bioBloodAnalysisListData);

    }

    public void BloodAnalysisShowListData(){
        ObservableList<BloodAnalysis> bloodAnalysisListData = FXCollections.observableArrayList();

        bloodAnalysisListData.add(new BloodAnalysis("1", "20/7/2023", 1, 1.512, "Red", true, 2, 1, 1, 1, 3, 11.2, 13.23, 12.22));
        bloodAnalysisListData.add(new BloodAnalysis("2", "20/7/2023", 1, 1.512, "Red", true, 2, 1, 1, 1, 3, 11.2, 13.23, 12.22));

        treatCourseDetBloodAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetBloodAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetBloodAnalysisRedCellsCol.setCellValueFactory(new PropertyValueFactory<>("red_cells"));
        treatCourseDetBloodAnalysisHaemoglobinCol.setCellValueFactory(new PropertyValueFactory<>("haemoglobin"));
        treatCourseDetBloodAnalysisColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        treatCourseDetBloodAnalysisParasitesCol.setCellValueFactory(new PropertyValueFactory<>("parasites"));
        treatCourseDetBloodAnalysisWhiteCellsCol.setCellValueFactory(new PropertyValueFactory<>("white_cells"));
        treatCourseDetBloodAnalysisLymphocytesCol.setCellValueFactory(new PropertyValueFactory<>("lymphocytes"));
        treatCourseDetBloodAnalysisESRCol.setCellValueFactory(new PropertyValueFactory<>("ESR"));
        treatCourseDetBloodAnalysisPlateletsCol.setCellValueFactory(new PropertyValueFactory<>("platelets"));
        treatCourseDetBloodAnalysisMeanCorpuscularVolumeCol.setCellValueFactory(new PropertyValueFactory<>("mean_corpuscular_volumn"));
        treatCourseDetBloodAnalysisMeanCorpuscularHaemoglobinCol.setCellValueFactory(new PropertyValueFactory<>("mean_corpuscular_haemoglobin"));
        treatCourseDetBloodAnalysisHaematocritCol.setCellValueFactory(new PropertyValueFactory<>("hematocrit"));

        treatCourseDetBloodAnalysisTable.setItems(bloodAnalysisListData);

    }

    private Popup timePopup;

    private void showTimePopup() {
        if (timePopup == null) {
            timePopup = new Popup();
            timePopup.setAutoHide(true);

            ListView<LocalTime> timeList = new ListView<>();
            timeList.setPrefSize(100, 100);

            List<LocalTime> times = new ArrayList<>();
            times.add(LocalTime.of(0, 0));
            times.add(LocalTime.of(1, 0));
            times.add(LocalTime.of(2, 0));
            times.add(LocalTime.of(3, 0));
            times.add(LocalTime.of(4, 0));
            times.add(LocalTime.of(5, 0));
            times.add(LocalTime.of(6, 0));
            times.add(LocalTime.of(7, 0));
            times.add(LocalTime.of(8, 0));
            times.add(LocalTime.of(9, 0));
            times.add(LocalTime.of(10, 0));
            times.add(LocalTime.of(11, 0));
            times.add(LocalTime.of(12, 0));
            times.add(LocalTime.of(13, 0));
            times.add(LocalTime.of(14, 0));
            times.add(LocalTime.of(15, 0));
            times.add(LocalTime.of(16, 0));
            times.add(LocalTime.of(17, 0));
            times.add(LocalTime.of(18, 0));
            times.add(LocalTime.of(19, 0));
            times.add(LocalTime.of(20, 0));
            times.add(LocalTime.of(21, 0));
            times.add(LocalTime.of(22, 0));
            times.add(LocalTime.of(23, 0));

            timeList.getItems().addAll(times);
            timeList.setOnMouseClicked(event -> {
                LocalTime selectedTime = timeList.getSelectionModel().getSelectedItem();
                setTime(selectedTime);
                timePopup.hide();
            });

            timePopup.getContent().add(timeList);
        }

        double x = treatCourseDetProcedureTimeField.localToScreen(treatCourseDetProcedureTimeField.getBoundsInLocal()).getMinX();
        double y = treatCourseDetProcedureTimeField.localToScreen(treatCourseDetProcedureTimeField.getBoundsInLocal()).getMaxY();
        timePopup.show(treatCourseDetProcedureTimeField.getScene().getWindow(), x, y);

    }

    private void setTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeString = time.format(formatter);
        treatCourseDetProcedureTimeField.setText(timeString);
    }
}

    
