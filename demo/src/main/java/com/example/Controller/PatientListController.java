package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class PatientListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button manageDocBtn;

    @FXML
    private Button manageDptBtn;

    @FXML
    private TableColumn<Patient, String> patAgeCol;

    @FXML
    private TextField patCotField;

    @FXML
    private TableColumn<Patient, String> patCotInfoCol;

    @FXML
    private TableColumn<Patient, String> patDepartmentCol;

    @FXML
    private ComboBox<?> patDepartmentField;

    @FXML
    private ComboBox<?> patGenderBox;

    @FXML
    private TableColumn<Patient, String> patGenderCol;

    @FXML
    private TableColumn<Patient, String> patICCol;

    @FXML
    private TextField patICField;

    @FXML
    private TableColumn<Patient, String> patIDCol;

    @FXML
    private TextField patIDField;

    @FXML
    private TableView<Patient> patListTable;

    @FXML
    private TableColumn<Patient, String> patNameCol;

    @FXML
    private TextField patNameField;

    @FXML
    private StackPane patient_list_page;

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
        
    }

    void initData(Admin admin){
        unameLabel.setText(admin.getUname());
    }

    // private ObservableList<Patient> patientList;

    public void patientShowListData(){
        // patientList = 
        patIDCol.setCellValueFactory(new PropertyValueFactory<>("patID"));
        patNameCol.setCellValueFactory(new PropertyValueFactory<>("patName"));
        patICCol.setCellValueFactory(new PropertyValueFactory<>("patIC"));
        patAgeCol.setCellValueFactory(new PropertyValueFactory<>("patAge"));
        patGenderCol.setCellValueFactory(new PropertyValueFactory<>("patGender"));
        patCotInfoCol.setCellValueFactory(new PropertyValueFactory<>("patCotInfo"));
        patDepartmentCol.setCellValueFactory(new PropertyValueFactory<>("patDepartment"));
        
        // patListTable.setItems(patientList);

    }

     

}
