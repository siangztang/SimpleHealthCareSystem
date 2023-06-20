package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.example.Admin;
import com.example.Patient;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
        patGenderBox.getItems().addAll("M", "F");
        resetBtn.setOnAction(event -> {
            resetBtnAction();
        });
        unFocusAll();
        patListTable.getColumns().forEach(e -> e.setReorderable(false));
        patListTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Patient selectedPatient = patListTable.getSelectionModel().getSelectedItem();
                if (selectedPatient != null) {
                    patNameField.setText(selectedPatient.getName());
                    patICField.setText(String.valueOf(selectedPatient.getIc()));
                    patCotField.setText(String.valueOf(selectedPatient.getContact_info()));
                    patDepartmentField.setValue(selectedPatient.getDepartment());
                    patGenderBox.setValue(String.valueOf(selectedPatient.getGender()));

                }
            } else if (event.getClickCount() == 2) {
                Patient selectedPatient = patListTable.getSelectionModel().getSelectedItem();
                if (selectedPatient != null) {
                    // Do something with the selected patient data
                    System.out.println("Selected patient ID: " + selectedPatient.getPatient_id());
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\PatientHistory.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                        PatientHistoryController controller = loader.getController();
                        controller.initData(admin, selectedPatient);
                        Node node = (Node) event.getSource();
                        Stage currentStage = (Stage) node.getScene().getWindow();
                        currentStage.close();
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        patientShowListData();
        searchField();
    }

    private Admin admin;


    public void initData(Admin admin){
        this.admin = admin;
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){
        patNameField.setText("");
        patICField.setText("");
        patCotField.setText("");
        patDepartmentField.setValue("");
        patGenderBox.setValue("");
        searchField.setText("");
        patListTable.getSelectionModel().clearSelection();        
    }

    public void unFocusAll(){
        manageDptBtn.setFocusTraversable(false);
        manageDocBtn.setFocusTraversable(false);
        manageMedicineBtn.setFocusTraversable(false);
        patListTable.setFocusTraversable(false);
        searchField.setFocusTraversable(false);
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

    ObservableList<Patient> listData = FXCollections.observableArrayList();

    public void patientShowListData(){

        
        listData.add(new Patient("P0001", "John", 12345612234L, 20, 'M', 12345L, "Emergency"));
        listData.add(new Patient("P0002", "Mary", 12345612234L, 20, 'F', 12345L, "Emergency"));

        patIDCol.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
        patNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        patICCol.setCellValueFactory(new PropertyValueFactory<>("ic"));
        patAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        patGenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        patCotInfoCol.setCellValueFactory(new PropertyValueFactory<>("contact_info"));
        patDepartmentCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        
        patListTable.setItems(listData);

    }

    private void searchField(){
        FilteredList<Patient> filteredData = new FilteredList<>(listData, e -> true);
        searchField.setOnKeyReleased(e->{
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Patient >) pat -> {
                if (newValue == null) {
                    return true;
                }
                
                String toLowerCaseNewValue = newValue.toLowerCase();
                if(pat.getPatient_id().toLowerCase().contains(toLowerCaseNewValue)){
                    return true;
                }else if(pat.getName().toLowerCase().contains(toLowerCaseNewValue)){
                    return true;
                }else if(String.valueOf(pat.getIc()).contains(toLowerCaseNewValue)){
                    return true;
                }else if(String.valueOf(pat.getAge()).contains(toLowerCaseNewValue)){
                    return true;
                }else if(String.valueOf(pat.getGender()).contains(toLowerCaseNewValue)){
                    return true;
                }else if(String.valueOf(pat.getContact_info()).contains(toLowerCaseNewValue)){
                    return true;
                }else if(pat.getDepartment().toLowerCase().contains(toLowerCaseNewValue)){
                    return true;
                }

            return false;

            });
        });
            final SortedList<Patient> patients_list = new SortedList<>(filteredData);
            patients_list.comparatorProperty().bind(patListTable.comparatorProperty());
            patListTable.setItems(patients_list);

        });

        
    }

     

}