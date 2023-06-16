package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;


import com.example.Admin;
import com.example.Patient;
import com.example.SwitchPage;

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
    void initialize(){
        manageDptBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, manageDptBtn);
        });

        manageDocBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, manageDocBtn);
        });

        manageMedicineBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, manageMedicineBtn);
        });

    }


    void initData(Admin admin){
        unameLabel.setText(admin.getUname());
        patGenderBox.getItems().addAll("M", "F");
        resetBtn.setOnAction(event -> {
            resetBtnAction();
        });
        unFocusAll();
    }

    public void resetBtnAction(){
        patIDField.setText("");
        patNameField.setText("");
        patICField.setText("");
        patCotField.setText("");
        patDepartmentField.setValue("");
        patGenderBox.setValue("");
        searchField.setText("");
        unFocusAll();
        
    }

    public void unFocusAll(){
        manageDptBtn.setFocusTraversable(false);
        manageDocBtn.setFocusTraversable(false);
        manageMedicineBtn.setFocusTraversable(false);
        patListTable.setFocusTraversable(false);
        searchField.setFocusTraversable(false);
        patIDField.setFocusTraversable(false);
        patNameField.setFocusTraversable(false);
        patICField.setFocusTraversable(false);
        patCotField.setFocusTraversable(false);
        patDepartmentField.setFocusTraversable(false);
        patGenderBox.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
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
