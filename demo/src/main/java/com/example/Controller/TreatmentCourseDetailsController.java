package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.BioBloodAnalysis;
import com.example.BloodAnalysis;
import com.example.Diagnosis;
import com.example.Doctor;
import com.example.Patient;
import com.example.Procedure;
import com.example.RWAnalysis;
import com.example.SwitchPage;
import com.example.UrineAnalysis;
import com.example.CSVRelatedClass.CSVHandler;
import com.example.CSVRelatedClass.CSVPath;
import com.example.CSVRelatedClass.CustomComparator;
import com.example.CSVRelatedClass.ParameterTypes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class TreatmentCourseDetailsController {

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
    private TableColumn<BioBloodAnalysis, Integer> treatCourseDetBioBloodAnalysisALTCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisALTField;

    @FXML
    private TableColumn<BioBloodAnalysis, Integer> treatCourseDetBioBloodAnalysisASTCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisASTField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisBiluribinCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisBiluribinField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisCreatenineCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisCreatenineField;

    @FXML
    private TableColumn<BioBloodAnalysis, String> treatCourseDetBioBloodAnalysisDateCol;

    @FXML
    private DatePicker treatCourseDetBioBloodAnalysisDateField;

    @FXML
    private TableColumn<BioBloodAnalysis, Double> treatCourseDetBioBloodAnalysisDirectBiluribinCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisDirectBiluribinField;

    @FXML
    private TableColumn<BioBloodAnalysis, String> treatCourseDetBioBloodAnalysisIDCol;

    @FXML
    private TableColumn<BioBloodAnalysis, Integer> treatCourseDetBioBloodAnalysisSugarCol;

    @FXML
    private TextField treatCourseDetBioBloodAnalysisSugarField;

    @FXML
    private Tab treatCourseDetBioBloodAnalysisTab;

    @FXML
    private TableView<BioBloodAnalysis> treatCourseDetBioBloodAnalysisTable;

    @FXML
    private TableColumn<BioBloodAnalysis, Integer> treatCourseDetBioBloodAnalysisUreaCol;
    
    @FXML
    private TableColumn<BloodAnalysis, String> treatCourseDetBloodAnalysisColorCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisColorField;

    @FXML
    private TableColumn<BloodAnalysis, String> treatCourseDetBloodAnalysisDateCol;

    @FXML
    private DatePicker treatCourseDetBloodAnalysisDateDateField;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisESRCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisESRField;

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
    private TableColumn<BloodAnalysis, String> treatCourseDetBloodAnalysisParasitesCol;

    @FXML
    private ComboBox<String> treatCourseDetBloodAnalysisParasitesField;

    @FXML
    private TableColumn<BloodAnalysis, Double> treatCourseDetBloodAnalysisRedCellsCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisRedCellsField;

    @FXML
    private TableColumn<BloodAnalysis, Integer> treatCourseDetBloodAnalysisStabNeuthrophilCol;

    @FXML
    private TextField treatCourseDetBloodAnalysisStabNeuthrophilField;

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
    private TableColumn<Diagnosis, String> treatCourseDetDiagnosisIDCol;

    @FXML
    private TextField treatCourseDetDiagnosisNameField;

    @FXML
    private Tab treatCourseDetDiagnosisTab;

    @FXML
    private TableView<Diagnosis> treatCourseDetDiagnosisTable;

    @FXML
    private TableColumn<Procedure, String> treatCourseDetProcedureDateCol;

    @FXML
    private TableColumn<Procedure, String> treatCourseDetProcedureIDCol;

    @FXML
    private DatePicker treatCourseDetProcedureDateField;

    @FXML
    private Button treatCourseDetProcedureMedicineAddBtn;

    @FXML
    private ComboBox<String> treatCourseDetProcedureMedicineChoice;

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
    private ComboBox<String> treatCourseDetRWAnalysisAidsResultField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisDateCol;

    @FXML
    private DatePicker treatCourseDetRWAnalysisDateField;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisIDCol;

    @FXML
    private TableColumn<RWAnalysis, String> treatCourseDetRWAnalysisRWResultCol;

    @FXML
    private ComboBox<String> treatCourseDetRWAnalysisRWResultField;

    @FXML
    private Tab treatCourseDetRWAnalysisTab;

    @FXML
    private TableView<RWAnalysis> treatCourseDetRWAnalysisTable;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisColorCol;

    @FXML
    private ComboBox<String> treatCourseDetUrineAnalysisColorField;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisDateCol;

    @FXML
    private DatePicker treatCourseDetUrineAnalysisDateField;

    @FXML
    private TableColumn<UrineAnalysis, Double> treatCourseDetUrineAnalysisDensityCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisDensityField;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisIDCol;

    @FXML
    private TableColumn<UrineAnalysis, Double> treatCourseDetUrineAnalysisReactionCol;

    @FXML
    private TextField treatCourseDetUrineAnalysisReactionField;

    @FXML
    private Tab treatCourseDetUrineAnalysisTab;

    @FXML
    private TableView<UrineAnalysis> treatCourseDetUrineAnalysisTable;

    @FXML
    private TableColumn<UrineAnalysis, String> treatCourseDetUrineAnalysisTransparencyCol;

    @FXML
    private ComboBox<String> treatCourseDetUrineAnalysisTransparencyField;

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

    private String[] medicineList;

    @FXML
    void initialize() {
        SwitchPage switchpage = new SwitchPage();
        treatCourseDetRWAnalysisRWResultField.getItems().addAll("Positive", "Negative");
        treatCourseDetBloodAnalysisParasitesField.getItems().addAll("Positive", "Negative");
        treatCourseDetRWAnalysisAidsResultField.getItems().addAll("Positive", "False-Positive", "Negative");
        treatCourseDetUrineAnalysisTransparencyField.getItems().addAll("Clear", "Slightly Cloudy", "Cloudy");
        treatCourseDetUrineAnalysisColorField.getItems().addAll("Pale Yellow", "Yellow", "Dark Yellow", "Brown", "Red", "Orange", "Black");
        treatCourseDetProcedureMedicineChoice.getItems().addAll("Medicine 1", "Medicine 2", "Medicine 3", "Medicine 4", "Medicine 5");

        ObservableList<Doctor> doctorListData = csvhandler.readCSV(CSVPath.DOCTOR_PATH, Doctor.class, CustomComparator.createComparator(Doctor::getDoctor_id), ParameterTypes.DOCTOR_PARAMETER_TYPES);

        for (Doctor doctor : doctorListData) {
            treatCourseDetDiagnosisDocNameField.getItems().add(doctor.getDoctor_name());
        }

        managePatientBtn.setOnAction(event -> {
            switchpage.switchPage(event, managePatientBtn);
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

        RWAnalysisResetBtn.setOnAction(event -> {
            RWAnalysisResetBtnAction();
        });

        bloodAnalysisResetBtn.setOnAction(event -> {
            bloodAnalysisResetBtnAction();
        });

        treatCourseDetProcedureMedicineAddBtn.setOnAction(event -> {
            addMedicine();
        });

        diagnosisAddBtn.setOnAction(event -> {
            addDiagnosisBtnAction();
        });

        procedureAddBtn.setOnAction(event -> {
            addProcedureBtnAction();
        });

        bloodAnalysisAddBtn.setOnAction(event -> {
            addBloodAnalysisBtnAction();
        });

        RWAnalysisAddBtn.setOnAction(event -> {
            addRWAnalysisBtnAction();
        });

        bioBloodAnalysisAddBtn.setOnAction(event -> {
            addBioBloodAnalysisBtnAction();
        });

        urineAnalysisAddBtn.setOnAction(event -> {
            addUrineAnalysisBtnAction();
        });

        diagnosisUpdateBtn.setOnAction(event -> {
            updateDiagnosisBtnAction();
        });

        procedureUpdateBtn.setOnAction(event -> {
            updateProcedureBtnAction();
        });

        bloodAnalysisUpdateBtn.setOnAction(event -> {
            updateBloodAnalysisBtnAction();
        });

        RWAnalysisUpdateBtn.setOnAction(event -> {
            // updateRWAnalysisBtnAction();
        });

        bioBloodAnalysisUpdateBtn.setOnAction(event -> {
            // updateBioBloodAnalysisBtnAction();
        });

        urineAnalysisUpdateBtn.setOnAction(event -> {
            // updateUrineAnalysisBtnAction();
        });

        diagnosisDeleteBtn.setOnAction(event -> {
            deleteDiagnosisBtnAction();
        });

        procedureDeleteBtn.setOnAction(event -> {
            deleteProcedureBtnAction();
        });

        bloodAnalysisDeleteBtn.setOnAction(event -> {
            // deleteBloodAnalysisBtnAction();
        });

        RWAnalysisDeleteBtn.setOnAction(event -> {
            // deleteRWAnalysisBtnAction();
        });

        bioBloodAnalysisDeleteBtn.setOnAction(event -> {
            // deleteBioBloodAnalysisBtnAction();
        });

        urineAnalysisDeleteBtn.setOnAction(event -> {
            // deleteUrineAnalysisBtnAction();
        });        

        unFocusAll();

        treatCourseDetDiagnosisTable.getColumns().forEach(e -> e.setReorderable(false));

        treatCourseDetDiagnosisTable.setOnMouseClicked(event -> {
            Diagnosis selectedDiagnosis = treatCourseDetDiagnosisTable.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 1){
                if (selectedDiagnosis != null){
                    System.out.println("Selected diagnosis ID: " + selectedDiagnosis.getDiagnosis_id());
                    treatCourseDetDiagnosisNameField.setText(selectedDiagnosis.getDiagnosis_name());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate diagnosis_date = LocalDate.parse(selectedDiagnosis.getDiagnosis_date(), formatter);
                    treatCourseDetDiagnosisDiagDateField.setValue(diagnosis_date);
                    treatCourseDetDiagnosisDocNameField.setValue(selectedDiagnosis.getDoctor_name());
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
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate procedure_date = LocalDate.parse(selectedProcedure.getProcedure_date(), formatter);
                    treatCourseDetProcedureDateField.setValue(procedure_date);
                    treatCourseDetProcedureTimeField.setText(selectedProcedure.getProcedure_time());
                    treatCourseDetProcedureTypeField.setText(selectedProcedure.getType());
                    String[] medicineList = selectedProcedure.getMedicine_list().split("; ");
                    this.medicineList = medicineList;
                    String medicineListText = String.join("; ", medicineList);
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
                    stage.setResizable(false);
                    stage.show();
                    ProcedureDetailsController controller = loader.getController();
                    String[] medicineList = selectedProcedure.getMedicine_list().split("; ");
                    this.medicineList = medicineList;
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
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate urine_analysis_date = LocalDate.parse(selectedUrineAnalysis.getAnalysis_date(), formatter);
                    treatCourseDetUrineAnalysisDateField.setValue(urine_analysis_date);
                    treatCourseDetUrineAnalysisColorField.setValue(selectedUrineAnalysis.getColor());
                    treatCourseDetUrineAnalysisReactionField.setText(String.valueOf(selectedUrineAnalysis.getReaction()));
                    treatCourseDetUrineAnalysisTransparencyField.setValue(selectedUrineAnalysis.getTransparency());
                    treatCourseDetUrineAnalysisDensityField.setText(String.valueOf(selectedUrineAnalysis.getDensity()));
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

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate rw_analysis_date = LocalDate.parse(selectedRWAnalysis.getAnalysis_date(), formatter);
                    LocalDate aids_date = LocalDate.parse(selectedRWAnalysis.getAids_date(), formatter);

                    treatCourseDetRWAnalysisDateField.setValue(rw_analysis_date);
                    treatCourseDetRWAnalysisRWResultField.setValue(String.valueOf(selectedRWAnalysis.getRw_result()));
                    treatCourseDetRWAnalysisAidsDateField.setValue(aids_date);
                    treatCourseDetRWAnalysisAidsResultField.setValue(String.valueOf(selectedRWAnalysis.getAids_result()));
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

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate bio_blood_analysis_date = LocalDate.parse(selectedBioBloodAnalysis.getAnalysis_date(), formatter);

                    treatCourseDetBioBloodAnalysisDateField.setValue(bio_blood_analysis_date);
                    treatCourseDetBioBloodAnalysisCreatenineField.setText(String.valueOf(selectedBioBloodAnalysis.getCreatenine()));
                    treatCourseDetBioBloodAnalysisSugarField.setText(String.valueOf(selectedBioBloodAnalysis.getSugar()));
                    treatCourseDetBioBloodAnalysisBiluribinField.setText(String.valueOf(selectedBioBloodAnalysis.getBiluribin()));
                    treatCourseDetBioBloodAnalysisDirectBiluribinField.setText(String.valueOf(selectedBioBloodAnalysis.getDirect_biluribin()));
                    treatCourseDetBioBloodAnalysisASTField.setText(String.valueOf(selectedBioBloodAnalysis.getAST()));
                    treatCourseDetBioBloodAnalysisALTField.setText(String.valueOf(selectedBioBloodAnalysis.getALT()));

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

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate blood_analysis_date = LocalDate.parse(selectedBloodAnalysis.getAnalysis_date(), formatter);

                    treatCourseDetBloodAnalysisDateDateField.setValue(blood_analysis_date);
                    treatCourseDetBloodAnalysisRedCellsField.setText(String.valueOf(selectedBloodAnalysis.getRed_cells()));
                    treatCourseDetBloodAnalysisHaemoglobinField.setText(String.valueOf(selectedBloodAnalysis.getHaemoglobin()));
                    treatCourseDetBloodAnalysisColorField.setText(String.valueOf(selectedBloodAnalysis.getColor()));
                    treatCourseDetBloodAnalysisParasitesField.setValue(String.valueOf(selectedBloodAnalysis.getParasites()));
                    treatCourseDetBloodAnalysisWhiteCellsField.setText(String.valueOf(selectedBloodAnalysis.getWhite_cells()));
                    treatCourseDetBloodAnalysisStabNeuthrophilField.setText(String.valueOf(selectedBloodAnalysis.getStab_neuthrophil()));
                    treatCourseDetBloodAnalysisLymphocytesField.setText(String.valueOf(selectedBloodAnalysis.getLymphocytes()));
                    treatCourseDetBloodAnalysisESRField.setText(String.valueOf(selectedBloodAnalysis.getESR()));
                    
                }
            }
        });
        BloodAnalysisShowListData();

    }

    private Admin admin;
    private Patient patient_info;
    private String history_id;
    private String treatment_course_id;
    private Popup timePopup;

    private CSVHandler csvhandler = new CSVHandler();
    private AlertMessage alert = new AlertMessage();
    private Procedure procedureCheckInput = new Procedure();
    private Diagnosis diagnosisCheckInput = new Diagnosis();

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
        patInfoContact.setText(patient_info.getContact_info());
        patInfoHisID.setText(history_id);
        patInfoCourseID.setText(treatment_course_id);
        unamelabel.setText(admin.getUname());
    }

    public void diagnosisResetBtnAction(){
        treatCourseDetDiagnosisNameField.setText("");
        treatCourseDetDiagnosisDiagDateField.setValue(null);
        treatCourseDetDiagnosisDocNameField.setValue(""); //unsure if correct
        treatCourseDetDiagnosisTable.getSelectionModel().clearSelection(); 
        treatCourseDetDiagnosisTable.setItems(diagnosisRefreshData());
        DiagnosisShowListData();
    }

    public void procedureResetBtnAction(){
        treatCourseDetProcedureDateField.setValue(null);
        treatCourseDetProcedureTimeField.setText("");
        treatCourseDetProcedureTypeField.setText("");
        treatCourseDetProcedureMedicineList.setText("");
        treatCourseDetProcedureMedicineChoice.setValue(null);
        treatCourseDetProcedureTable.getSelectionModel().clearSelection(); 
        treatCourseDetProcedureTable.setItems(procedureRefreshData());
        ProcedureShowListData();
    }
    
    public void bloodAnalysisResetBtnAction(){
        treatCourseDetBloodAnalysisDateDateField.setValue(null);
        treatCourseDetBloodAnalysisRedCellsField.setText(String.valueOf(""));
        treatCourseDetBloodAnalysisHaemoglobinField.setText(String.valueOf(""));
        treatCourseDetBloodAnalysisColorField.setText(String.valueOf(""));
        treatCourseDetBloodAnalysisParasitesField.setValue(String.valueOf(""));
        treatCourseDetBloodAnalysisWhiteCellsField.setText(String.valueOf(""));
        treatCourseDetBloodAnalysisLymphocytesField.setText(String.valueOf(""));
        treatCourseDetBloodAnalysisESRField.setText(String.valueOf(""));
        treatCourseDetBloodAnalysisTable.getSelectionModel().clearSelection(); 

    }

    public void RWAnalysisResetBtnAction(){
        treatCourseDetRWAnalysisDateField.setValue(null);
        treatCourseDetRWAnalysisRWResultField.setValue(null);
        treatCourseDetRWAnalysisAidsDateField.setValue(null);
        treatCourseDetRWAnalysisAidsResultField.setValue(null);
        treatCourseDetRWAnalysisTable.getSelectionModel().clearSelection(); 

    }

    public void bioBloodAnalysisResetBtnAction(){
        treatCourseDetBioBloodAnalysisDateField.setValue(null);
        treatCourseDetBioBloodAnalysisCreatenineField.setText(String.valueOf(""));
        treatCourseDetBioBloodAnalysisSugarField.setText(String.valueOf(""));
        treatCourseDetBioBloodAnalysisBiluribinField.setText(String.valueOf(""));
        treatCourseDetBioBloodAnalysisDirectBiluribinField.setText(String.valueOf(""));
        treatCourseDetBioBloodAnalysisASTField.setText(String.valueOf(""));
        treatCourseDetBioBloodAnalysisALTField.setText(String.valueOf(""));
        treatCourseDetBioBloodAnalysisTable.getSelectionModel().clearSelection(); 
    }

    public void urineAnalysisResetBtnAction(){
        treatCourseDetUrineAnalysisDateField.setValue(null);
        treatCourseDetUrineAnalysisColorField.setValue("");
        treatCourseDetUrineAnalysisReactionField.setText("");
        treatCourseDetUrineAnalysisTransparencyField.setValue("");
        treatCourseDetUrineAnalysisDensityField.setText("");
        treatCourseDetUrineAnalysisTable.getSelectionModel().clearSelection(); 
        
    }

    public void unFocusAll(){
        managePatientBtn.setFocusTraversable(false);
        treatCourseDetDiagnosisTable.setFocusTraversable(false);
        treatCourseDetProcedureTable.setFocusTraversable(false);

        treatCourseDetBloodAnalysisTable.setFocusTraversable(false);
        treatCourseDetBloodAnalysisDateDateField.setFocusTraversable(false);
        treatCourseDetBloodAnalysisRedCellsField.setFocusTraversable(false);
        treatCourseDetBloodAnalysisHaemoglobinField.setFocusTraversable(false);
        treatCourseDetBloodAnalysisColorField.setFocusTraversable(false);
        treatCourseDetBloodAnalysisParasitesField.setFocusTraversable(false);
        treatCourseDetBloodAnalysisWhiteCellsField.setFocusTraversable(false);
        treatCourseDetBloodAnalysisLymphocytesField.setFocusTraversable(false);
        treatCourseDetBloodAnalysisESRField.setFocusTraversable(false);

        treatCourseDetRWAnalysisTable.setFocusTraversable(false);
        treatCourseDetRWAnalysisDateField.setFocusTraversable(false);
        treatCourseDetRWAnalysisRWResultField.setFocusTraversable(false);
        treatCourseDetRWAnalysisAidsDateField.setFocusTraversable(false);
        treatCourseDetRWAnalysisAidsResultField.setFocusTraversable(false);

        treatCourseDetBioBloodAnalysisTable.setFocusTraversable(false);
        treatCourseDetBioBloodAnalysisDateField.setFocusTraversable(false);
        treatCourseDetBioBloodAnalysisCreatenineField.setFocusTraversable(false);
        treatCourseDetBioBloodAnalysisSugarField.setFocusTraversable(false);
        treatCourseDetBioBloodAnalysisBiluribinField.setFocusTraversable(false);
        treatCourseDetBioBloodAnalysisDirectBiluribinField.setFocusTraversable(false);
        treatCourseDetBioBloodAnalysisASTField.setFocusTraversable(false);
        treatCourseDetBioBloodAnalysisALTField.setFocusTraversable(false);

        treatCourseDetUrineAnalysisTable.setFocusTraversable(false);
        treatCourseDetUrineAnalysisDateField.setFocusTraversable(false);
        treatCourseDetUrineAnalysisColorField.setFocusTraversable(false);
        treatCourseDetUrineAnalysisReactionField.setFocusTraversable(false);
        treatCourseDetUrineAnalysisTransparencyField.setFocusTraversable(false);
        treatCourseDetUrineAnalysisDensityField.setFocusTraversable(false); 

    }

    public ObservableList<Diagnosis> diagnosisRefreshData(){
        ObservableList<Diagnosis> listData = csvhandler.readCSV(CSVPath.DIAGNOSIS_PATH, Diagnosis.class, CustomComparator.createComparator(Diagnosis::getDiagnosis_id), ParameterTypes.DIAGNOSIS_PARAMETER_TYPES);
        return listData;
    }

    public void DiagnosisShowListData(){

        treatCourseDetDiagnosisIDCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis_id"));
        treatCourseDetDiagnosisNameCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis_name"));
        treatCourseDetDiagnosisDiagDateCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis_date"));
        treatCourseDetDiagnosisDocNameCol.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));

        treatCourseDetDiagnosisTable.setItems(diagnosisRefreshData());

    }

    private boolean diagnosisCheckEmpty(){
        if (treatCourseDetDiagnosisNameField.getText().isEmpty() || treatCourseDetDiagnosisDiagDateField.getValue() == null || treatCourseDetDiagnosisDocNameField.getValue().isEmpty()) {
            // show error message
            alert.errorMessage("Please fill in all the fields");
            return true;
        }
        return false;
    }

    private boolean diagnosisCheckSelected(){
        if (treatCourseDetDiagnosisTable.getSelectionModel().getSelectedItem() == null) {
            // show error message
            alert.errorMessage("Please select a diagnosis");
            return true;
        }
        return false;
    }

    private void addDiagnosisBtnAction(){

        String diagnosis_name = treatCourseDetDiagnosisNameField.getText();
        String diagnosis_date = treatCourseDetDiagnosisDiagDateField.getValue().toString();
        String doctor_name = treatCourseDetDiagnosisDocNameField.getValue();

        // check if any field is empty
        if (!diagnosisCheckEmpty()) {
            if (diagnosisCheckInput.validationDiagnosis(diagnosis_name, diagnosis_date, doctor_name) == 1) {
                // generate new diagnosis id
                String diag_id = "D" + String.format("%d", diagnosisRefreshData().size() + 1);

                // create new diagnosis object
                Diagnosis newDiagnosis = new Diagnosis(diag_id, diagnosis_name, diagnosis_date, doctor_name, treatment_course_id);

                // add new diagnosis to csv file
                csvhandler.writeCSV(CSVPath.DIAGNOSIS_PATH, newDiagnosis);

                // show success message
                alert.successMessage("Diagnosis added successfully");

                // refresh data
                diagnosisRefreshData();

                // refresh table
                DiagnosisShowListData();

                // reset all fields
                diagnosisResetBtnAction();

            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }

    }

    private void updateDiagnosisBtnAction(){

        if (!diagnosisCheckSelected()){
            // get selected diagnosis
            String diagnosisId = treatCourseDetDiagnosisTable.getSelectionModel().getSelectedItem().getDiagnosis_id();
            String diagnosis_name = treatCourseDetDiagnosisNameField.getText();
            String diagnosis_date = treatCourseDetDiagnosisDiagDateField.getValue().toString();
            String doctor_name = treatCourseDetDiagnosisDocNameField.getValue();
            if (!diagnosisCheckEmpty()){
                if (diagnosisCheckInput.validationDiagnosis(diagnosis_name, diagnosis_date, doctor_name) == 1) {
                    

                    // create new diagnosis object
                    Diagnosis newDiagnosis = new Diagnosis(diagnosisId, diagnosis_name, diagnosis_date, doctor_name, treatment_course_id);

                    // update selected diagnosis in csv file
                    csvhandler.updateCSV(CSVPath.DIAGNOSIS_PATH, "diagnosis_id", diagnosisId, newDiagnosis);

                    // show success message
                    alert.successMessage("Diagnosis updated successfully");

                    // refresh data
                    diagnosisRefreshData();

                    // refresh table
                    DiagnosisShowListData();

                    // reset all fields
                    diagnosisResetBtnAction();

                } else {
                    // show error message
                    alert.errorMessage("Please enter valid input");
                }
            }
        }
    }

    private void deleteDiagnosisBtnAction(){
        if (!diagnosisCheckSelected()){
            // get selected diagnosis
            String diagnosisId = treatCourseDetDiagnosisTable.getSelectionModel().getSelectedItem().getDiagnosis_id();

            // delete selected diagnosis in csv file
            csvhandler.deleteCSV(CSVPath.DIAGNOSIS_PATH, "diagnosis_id", diagnosisId);

            // show success message
            alert.successMessage("Diagnosis deleted successfully");

            // refresh data
            diagnosisRefreshData();

            // refresh table
            DiagnosisShowListData();
            
            // reset all fields
            diagnosisResetBtnAction();

            
        }
    }

    public ObservableList<Procedure> procedureRefreshData(){
        ObservableList<Procedure> listData = csvhandler.readCSV(CSVPath.PROCEDURE_PATH, Procedure.class, CustomComparator.createComparator(Procedure::getProcedure_id), ParameterTypes.PROCEDURE_PARAMETER_TYPES);
        return listData;
    }

    public void ProcedureShowListData(){

        treatCourseDetProcedureIDCol.setCellValueFactory(new PropertyValueFactory<>("procedure_id"));
        treatCourseDetProcedureDateCol.setCellValueFactory(new PropertyValueFactory<>("procedure_date"));
        treatCourseDetProcedureTimeCol.setCellValueFactory(new PropertyValueFactory<>("procedure_time"));
        treatCourseDetProcedureTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        treatCourseDetProcedureTable.setItems(procedureRefreshData());

    }

    private boolean procedureCheckEmpty(){
        if (treatCourseDetProcedureTypeField.getText().isEmpty() || treatCourseDetProcedureDateField == null || treatCourseDetProcedureTimeField.getText().isEmpty() || treatCourseDetProcedureMedicineList.getText().equals("")) {
            // show error message
            alert.errorMessage("Please fill in all the fields");
            return true;
        }
        return false;
    }

    private boolean procedureCheckSelected(){
        if (treatCourseDetProcedureTable.getSelectionModel().getSelectedItem() == null) {
            // show error message
            alert.errorMessage("Please select a procedure");
            return true;
        }
        return false;
    }

    private void addProcedureBtnAction(){
        String procedureType = treatCourseDetProcedureTypeField.getText();
        String procedureDate = treatCourseDetProcedureDateField.getValue().toString();
        String procedureTime = treatCourseDetProcedureTimeField.getText();
        String procedureMedicine = treatCourseDetProcedureMedicineList.getText();

        // check if any field is empty
        if (!procedureCheckEmpty()){
            if (procedureCheckInput.validationProcedure(procedureType, procedureDate, procedureTime, procedureMedicine) == 1) {
                
                // generate new procedure id
                String procedureId = "P" + String.format("%d", csvhandler.getMaxId(procedureRefreshData(), Procedure::getProcedure_id, "P") + 1);
                
                // create new procedure object
                Procedure newProcedure = new Procedure(procedureId, procedureType, procedureDate, procedureTime, treatment_course_id, procedureMedicine);

                // add new procedure to csv file
                csvhandler.writeCSV(CSVPath.PROCEDURE_PATH, newProcedure);

                // show success message
                alert.successMessage("Procedure added successfully");

                // refresh data
                procedureRefreshData();

                // refresh table
                ProcedureShowListData();

                // reset all fields
                procedureResetBtnAction();

            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }
    }

    private void updateProcedureBtnAction(){
        if (!procedureCheckSelected()){
            // get selected procedure
            String procedureId = treatCourseDetProcedureTable.getSelectionModel().getSelectedItem().getProcedure_id();
            String procedureType = treatCourseDetProcedureTypeField.getText();
            String procedureDate = treatCourseDetProcedureDateField.getValue().toString();
            String procedureTime = treatCourseDetProcedureTimeField.getText();
            String procedureMedicine = treatCourseDetProcedureMedicineList.getText();

            // check if any field is empty
            if (!procedureCheckEmpty()){
                if (procedureCheckInput.validationProcedure(procedureType, procedureDate, procedureTime, procedureMedicine) == 1) {
                    
                    // create new procedure object
                    Procedure newProcedure = new Procedure(procedureId, procedureType, procedureDate, procedureTime, treatment_course_id, procedureMedicine);

                    // update selected procedure in csv file
                    csvhandler.updateCSV(CSVPath.PROCEDURE_PATH, "procedure_id", procedureId, newProcedure);

                    // show success message
                    alert.successMessage("Procedure updated successfully");

                    // refresh data
                    procedureRefreshData();

                    // refresh table
                    ProcedureShowListData();

                    // reset all fields
                    procedureResetBtnAction();

                } else {
                    // show error message
                    alert.errorMessage("Please enter valid input");
                }
            }
        }
    }

    private void deleteProcedureBtnAction(){
        if (!procedureCheckSelected()){
            // get selected procedure
            String procedureId = treatCourseDetProcedureTable.getSelectionModel().getSelectedItem().getProcedure_id();

            // delete selected procedure in csv file
            csvhandler.deleteCSV(CSVPath.PROCEDURE_PATH, "procedure_id", procedureId);

            // show success message
            alert.successMessage("Procedure deleted successfully");

            // refresh data
            procedureRefreshData();

            // refresh table
            ProcedureShowListData();
            
            // reset all fields
            procedureResetBtnAction();
        }
    }



    public void UrineAnalysisShowListData(){
        ObservableList<UrineAnalysis> urineAnalysisListData = FXCollections.observableArrayList();

        urineAnalysisListData.add(new UrineAnalysis("UA0001", "20/7/2023", "TC001", "Red", 5, "Clear", 1.023));
        urineAnalysisListData.add(new UrineAnalysis("UA0002", "20/7/2023", "TC002", "Red", 4.8, "Clear", 1.023));

        treatCourseDetUrineAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetUrineAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetUrineAnalysisColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        treatCourseDetUrineAnalysisReactionCol.setCellValueFactory(new PropertyValueFactory<>("reaction"));
        treatCourseDetUrineAnalysisTransparencyCol.setCellValueFactory(new PropertyValueFactory<>("transparency"));
        treatCourseDetUrineAnalysisDensityCol.setCellValueFactory(new PropertyValueFactory<>("density"));

        treatCourseDetUrineAnalysisTable.setItems(urineAnalysisListData);

    }

    public void RWAnalysisShowListData(){
        ObservableList<RWAnalysis> RWAnalysisListData = FXCollections.observableArrayList();

        RWAnalysisListData.add(new RWAnalysis("RW0001", "20/7/2023", "TC001", "Positive", "20/7/2023", "Positive"));
        RWAnalysisListData.add(new RWAnalysis("RW0002", "20/7/2023", "TC002", "Positive", "20/7/2023", "Positive"));

        treatCourseDetRWAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetRWAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetRWAnalysisRWResultCol.setCellValueFactory(new PropertyValueFactory<>("rw_result"));
        treatCourseDetRWAnalysisAidsDateCol.setCellValueFactory(new PropertyValueFactory<>("aids_date"));
        treatCourseDetRWAnalysisAidsResultCol.setCellValueFactory(new PropertyValueFactory<>("aids_result"));

        treatCourseDetRWAnalysisTable.setItems(RWAnalysisListData);
        
    }

    public void BioBloodAnalysisShowListData(){
        ObservableList<BioBloodAnalysis> bioBloodAnalysisListData = FXCollections.observableArrayList();

        bioBloodAnalysisListData.add(new BioBloodAnalysis("BB0001", "TC001", "20/7/2023", 1.512, 1, 2.21, 2.32, 1, 1));
        bioBloodAnalysisListData.add(new BioBloodAnalysis("BB0002", "TC002", "20/7/2023", 1.512, 1, 2.21, 2.32, 1, 1));

        treatCourseDetBioBloodAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetBioBloodAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetBioBloodAnalysisCreatenineCol.setCellValueFactory(new PropertyValueFactory<>("createnine"));
        treatCourseDetBioBloodAnalysisSugarCol.setCellValueFactory(new PropertyValueFactory<>("sugar"));
        treatCourseDetBioBloodAnalysisBiluribinCol.setCellValueFactory(new PropertyValueFactory<>("biluribin"));
        treatCourseDetBioBloodAnalysisDirectBiluribinCol.setCellValueFactory(new PropertyValueFactory<>("direct_biluribin"));
        treatCourseDetBioBloodAnalysisASTCol.setCellValueFactory(new PropertyValueFactory<>("AST"));
        treatCourseDetBioBloodAnalysisALTCol.setCellValueFactory(new PropertyValueFactory<>("ALT"));

        treatCourseDetBioBloodAnalysisTable.setItems(bioBloodAnalysisListData);

    }

    public ObservableList<BloodAnalysis> bloodAnalysisRefreshData(){
    ObservableList<BloodAnalysis> listData = csvhandler.readCSV(CSVPath.BLOODANALYSIS_PATH, BloodAnalysis.class, CustomComparator.createComparator(BloodAnalysis::getAnalysis_id), ParameterTypes.BLOOD_ANALYSIS_PARAMETER_TYPES);
    return listData;
    }

    public void BloodAnalysisShowListData(){

        //bloodAnalysisListData.add(new BloodAnalysis("BA0001", "20/7/2023", "TC001", 4.5, 13.5, "Red", "Positive", 5000, 0, 20, 20));
        //bloodAnalysisListData.add(new BloodAnalysis("BA0002", "20/7/2023", "TC002", 1.23, 1.512, "Red", "true", 2, 1, 1, 1));

        treatCourseDetBloodAnalysisIDCol.setCellValueFactory(new PropertyValueFactory<>("analysis_id"));
        treatCourseDetBloodAnalysisDateCol.setCellValueFactory(new PropertyValueFactory<>("analysis_date"));
        treatCourseDetBloodAnalysisRedCellsCol.setCellValueFactory(new PropertyValueFactory<>("red_cells"));
        treatCourseDetBloodAnalysisHaemoglobinCol.setCellValueFactory(new PropertyValueFactory<>("haemoglobin"));
        treatCourseDetBloodAnalysisColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        treatCourseDetBloodAnalysisParasitesCol.setCellValueFactory(new PropertyValueFactory<>("parasites"));
        treatCourseDetBloodAnalysisWhiteCellsCol.setCellValueFactory(new PropertyValueFactory<>("white_cells"));
        treatCourseDetBloodAnalysisStabNeuthrophilCol.setCellValueFactory(new PropertyValueFactory<>("stab_neuthrophil"));
        treatCourseDetBloodAnalysisLymphocytesCol.setCellValueFactory(new PropertyValueFactory<>("lymphocytes"));
        treatCourseDetBloodAnalysisESRCol.setCellValueFactory(new PropertyValueFactory<>("ESR"));

        treatCourseDetBloodAnalysisTable.setItems(bloodAnalysisRefreshData());

    }

    private boolean bloodAnalysisCheckEmpty(){
    if (treatCourseDetBloodAnalysisDateDateField == null || treatCourseDetBloodAnalysisRedCellsField.getText().isEmpty() || treatCourseDetBloodAnalysisHaemoglobinField.getText().isEmpty() || treatCourseDetBloodAnalysisColorField.getText().isEmpty() || treatCourseDetBloodAnalysisParasitesField == null || treatCourseDetBloodAnalysisWhiteCellsField.getText().isEmpty() || treatCourseDetBloodAnalysisLymphocytesField.getText().isEmpty() || treatCourseDetBloodAnalysisESRField.getText().isEmpty()) {
        // show error message
        alert.errorMessage("Please fill in all the fields");
        return true;
    }
    return false;
    }
    private boolean bloodAnalysisCheckSelected(){
    if (treatCourseDetBloodAnalysisTable.getSelectionModel().getSelectedItem() == null) {
        // show error message
        alert.errorMessage("Please select a blood analysis");
        return true;
    }
    return false;
    }

        private void addBloodAnalysisBtnAction(){

            if(!bloodAnalysisCheckEmpty()) {

            String analysis_date = treatCourseDetBloodAnalysisDateDateField.getValue().toString();
            double red_cells = Double.parseDouble(treatCourseDetBloodAnalysisRedCellsField.getText());
            double haemoglobin = Double.parseDouble(treatCourseDetBloodAnalysisHaemoglobinField.getText());
            String color = treatCourseDetBloodAnalysisColorField.getText();
            String parasites = treatCourseDetBloodAnalysisParasitesField.getValue().toString();
            int white_cells = Integer.parseInt(treatCourseDetBloodAnalysisWhiteCellsField.getText());
            int stab_neuthrophil = Integer.parseInt(treatCourseDetBloodAnalysisStabNeuthrophilField.getText());
            int lymphocytes = Integer.parseInt(treatCourseDetBloodAnalysisLymphocytesField.getText());
            int ESR = Integer.parseInt(treatCourseDetBloodAnalysisESRField.getText());
            
            if (BloodAnalysis.validationBloodAnalysis(analysis_date, red_cells, haemoglobin, color, parasites, white_cells, stab_neuthrophil, lymphocytes, ESR) == 1) {

                //generate new blood anaylsis id
                String analysis_id = "BA" + String.format("%d", (bloodAnalysisRefreshData().size() + 1));

                //create new analysis object
                BloodAnalysis newBloodAnalysis = new BloodAnalysis(analysis_id, analysis_date, treatment_course_id, red_cells, haemoglobin, color, parasites, white_cells, stab_neuthrophil, lymphocytes, ESR);

                //add new analysis to csv
                csvhandler.writeCSV(CSVPath.BLOODANALYSIS_PATH, newBloodAnalysis);

                // show success message
                alert.successMessage("Blood Analysis added successfully");

                //refresh data
                bloodAnalysisRefreshData();

                // reset all fields
                bloodAnalysisResetBtnAction();


            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }
    }

    //i cant seem to add contstuctor on bloodanalysis
    private BloodAnalysis bloodAnalysisCheckInput = new BloodAnalysis();
    private void updateBloodAnalysisBtnAction(){

        if (!bloodAnalysisCheckSelected()){
            // get selected diagnosis
            String analysis_id = treatCourseDetDiagnosisTable.getSelectionModel().getSelectedItem().getDiagnosis_id();
            String analysis_date = treatCourseDetBloodAnalysisDateDateField.getValue().toString();
            double red_cells = Double.parseDouble(treatCourseDetBloodAnalysisRedCellsField.getText());
            double haemoglobin = Double.parseDouble(treatCourseDetBloodAnalysisHaemoglobinField.getText());
            String color = treatCourseDetBloodAnalysisColorField.getText();
            String parasites = treatCourseDetBloodAnalysisParasitesField.getValue().toString();
            int white_cells = Integer.parseInt(treatCourseDetBloodAnalysisWhiteCellsField.getText());
            int stab_neuthrophil = Integer.parseInt(treatCourseDetBloodAnalysisStabNeuthrophilField.getText());
            int lymphocytes = Integer.parseInt(treatCourseDetBloodAnalysisLymphocytesField.getText());
            int ESR = Integer.parseInt(treatCourseDetBloodAnalysisESRField.getText());
            if (!bloodAnalysisCheckInput()){
                if (bloodAnalysisCheckInput.validationBloodAnalysis(analysis_date, red_cells, haemoglobin, color, parasites, white_cells, stab_neuthrophil, lymphocytes, ESR) == 1) {
                    

                    // create new diagnosis object
                    BloodAnalysis newBloodAnalysis = new BloodAnalysis(analysis_id, analysis_date, parasites, red_cells, haemoglobin, color, parasites, white_cells, stab_neuthrophil, lymphocytes, ESR);

                    // update selected diagnosis in csv file
                    csvhandler.updateCSV(CSVPath.BLOODANALYSIS_PATH, "analysis_id", analysis_id, newBloodAnalysis);

                    // show success message
                    alert.successMessage("Blood Analysis updated successfully");

                    // refresh data
                    bloodAnalysisRefreshData();

                    // refresh table
                    BloodAnalysisShowListData();

                    // reset all fields
                    bloodAnalysisResetBtnAction();

                } else {
                    // show error message
                    alert.errorMessage("Please enter valid input");
                }
            }
        }
    }

    private void addMedicine(){
        if (treatCourseDetProcedureMedicineChoice.getValue() == null) {
            alert.errorMessage("No medicine selected");
            return;
        } else if (treatCourseDetProcedureMedicineList.getText().equals("")) {
            medicineList = new String[]{treatCourseDetProcedureMedicineChoice.getValue()};
        } else {
            String medicineName = treatCourseDetProcedureMedicineChoice.getValue();
            
            boolean isDuplicate = false;
            for(String medical : medicineList){
                if(medical.equals(medicineName)){
                    // show error
                    alert.errorMessage("Medicine already added");
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){
                medicineList = Arrays.copyOf(medicineList, medicineList.length + 1);
                medicineList[medicineList.length - 1] = medicineName;
                alert.successMessage("Medicine added");
            }
        }

        String medicineListText = String.join("; ", medicineList);
        treatCourseDetProcedureMedicineList.setText(medicineListText);
    }

    private void showTimePopup() {
        if (timePopup == null) {
            timePopup = new Popup();
            timePopup.setAutoHide(true);

            ListView<LocalTime> timeList = new ListView<>();
            timeList.setPrefSize(170, 100);

            List<LocalTime> times = new ArrayList<>();
            for (int hour = 0; hour < 24; hour++) {
                for (int minute = 0; minute < 60; minute++) {
                    times.add(LocalTime.of(hour, minute));
                }
            }
            ObservableList<LocalTime> observableTimes = FXCollections.observableList(times);
            FilteredList<LocalTime> filteredTimes = new FilteredList<>(observableTimes);

            // Create the search field
            TextField searchField = new TextField();
            searchField.setPromptText("Search...");

            // Bind the search field to the filtered list
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredTimes.setPredicate(time -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase().replace(":", "");
                    return time.toString().toLowerCase().replace(":", "").contains(lowerCaseFilter);
                });
            });

            // Set the items of the ListView to the filtered list
            timeList.setItems(filteredTimes);

            // Set the result converter for the dialog
            timeList.setOnMouseClicked(event -> {
                LocalTime selectedTime = timeList.getSelectionModel().getSelectedItem();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                String timeString = selectedTime.format(formatter);
                treatCourseDetProcedureTimeField.setText(timeString);
                timePopup.hide();
            });

            // Create the layout for the dialog
            VBox vbox = new VBox(searchField, timeList);
            vbox.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1px;");

            // Show the dialog
            timePopup.getContent().add(vbox);
        }

        double x = treatCourseDetProcedureTimeField.localToScreen(treatCourseDetProcedureTimeField.getBoundsInLocal()).getMinX();
        double y = treatCourseDetProcedureTimeField.localToScreen(treatCourseDetProcedureTimeField.getBoundsInLocal()).getMaxY();
        timePopup.show(treatCourseDetProcedureTimeField.getScene().getWindow(), x, y);
        
    }

    private void addRWAnalysisBtnAction(){
        if(treatCourseDetRWAnalysisDateField.getValue() == null ||treatCourseDetRWAnalysisRWResultField.getValue() == null || treatCourseDetRWAnalysisAidsResultField.getValue() == null || treatCourseDetRWAnalysisAidsDateField.getValue() == null){
            alert.errorMessage("Please fill all the fields");
        }else{
            String analysis_date = treatCourseDetRWAnalysisDateField.getValue().toString();
            String rw_result = treatCourseDetRWAnalysisRWResultField.getValue().toString();
            String aids_result = treatCourseDetRWAnalysisAidsResultField.getValue().toString();
            String aids_date = treatCourseDetRWAnalysisAidsDateField.getValue().toString();
            
            if (RWAnalysis.validationRWAnalysis(analysis_date, rw_result, aids_result, aids_date) == 1) {
                // reset all fields
                RWAnalysisResetBtnAction();
                // show success message
                alert.successMessage("RW Analysis added successfully");

            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }
            
    }

    private void addBioBloodAnalysisBtnAction(){
        if (treatCourseDetBioBloodAnalysisDateField == null||treatCourseDetBioBloodAnalysisCreatenineField.getText().isEmpty()  || treatCourseDetBioBloodAnalysisSugarField.getText().isEmpty() ||treatCourseDetBioBloodAnalysisBiluribinField.getText().isEmpty() || treatCourseDetBioBloodAnalysisDirectBiluribinField.getText().isEmpty() || treatCourseDetBioBloodAnalysisASTField.getText().isEmpty() || treatCourseDetBioBloodAnalysisALTField.getText().isEmpty()) {
            alert.errorMessage("Please fill all the fields");
        }else{
            String analysis_date = treatCourseDetBioBloodAnalysisDateField.getValue().toString();
            double createnine = Double.parseDouble(treatCourseDetBioBloodAnalysisCreatenineField.getText());
            int sugar = Integer.parseInt(treatCourseDetBioBloodAnalysisSugarField.getText());
            double biluribin = Double.parseDouble(treatCourseDetBioBloodAnalysisBiluribinField.getText());
            double direct_biluribin = Double.parseDouble(treatCourseDetBioBloodAnalysisDirectBiluribinField.getText());
            int AST = Integer.parseInt(treatCourseDetBioBloodAnalysisASTField.getText());
            int ALT = Integer.parseInt(treatCourseDetBioBloodAnalysisALTField.getText());
            
            if (BioBloodAnalysis.validationBioBloodAnalysis(analysis_date, createnine, sugar, biluribin, direct_biluribin, AST, ALT) == 1) {
                // reset all fields
                bioBloodAnalysisResetBtnAction();
                // show success message
                alert.successMessage("Bio Blood Analysis added successfully");
            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }
    }
    
    private void addUrineAnalysisBtnAction(){
        if(treatCourseDetUrineAnalysisDateField.getValue() == null || treatCourseDetUrineAnalysisColorField.getValue()== null || treatCourseDetUrineAnalysisReactionField == null || treatCourseDetUrineAnalysisTransparencyField.getValue()== null || treatCourseDetUrineAnalysisDensityField == null ){
            alert.errorMessage("Please fill all the fields");
        }else{
            String analysis_date = treatCourseDetUrineAnalysisDateField.getValue().toString();
            String color = treatCourseDetUrineAnalysisColorField.getValue().toString();
            Double reaction = Double.parseDouble(treatCourseDetUrineAnalysisReactionField.getText());
            String transparency = treatCourseDetUrineAnalysisTransparencyField.getValue().toString();
            Double density = Double.parseDouble(treatCourseDetUrineAnalysisDensityField.getText());
            
            if (UrineAnalysis.validationUrineAnalysis(analysis_date, color, reaction, transparency, density) == 1) {
                // reset all fields
                urineAnalysisResetBtnAction();
                // show success message
                alert.successMessage("Urine Analysis added successfully");
            } else {
                // show error message
                alert.errorMessage("Please enter valid input");
            }
        }

    }

}

    
