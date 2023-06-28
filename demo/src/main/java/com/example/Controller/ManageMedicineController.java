package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.example.Admin;
import com.example.AlertMessage;
import com.example.Medicine;
import com.example.SwitchPage;
import com.example.CSVRelatedClass.CSVHandler;
import com.example.CSVRelatedClass.CSVPath;
import com.example.CSVRelatedClass.CustomComparator;
import com.example.CSVRelatedClass.ParameterTypes;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ManageMedicineController {

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
    private Button managePatientBtn;

    @FXML
    private TableColumn<Medicine, Integer> medicineAmountCol;

    @FXML
    private TextField medicineAmountField;

    @FXML
    private TableColumn<Medicine, String> medicineDescriptionCol;

    @FXML
    private TextArea medicineDescriptionField;

    @FXML
    private TableColumn<Medicine, String> medicineIDCol;

    @FXML
    private TableColumn<Medicine, String> medicineNameCol;

    @FXML
    private TextField medicineNameField;

    @FXML
    private TableView<Medicine> medicineTable;

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

        SwitchPage switchpage = new SwitchPage();

        manageDptBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDptBtn);
        });

        manageDocBtn.setOnAction(event -> {
            switchpage.switchPage(event, manageDocBtn);
        });

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

        medicineNameField.addEventFilter(KeyEvent.KEY_PRESSED, this::handleTextFieldKeyPress);
        medicineDescriptionField.addEventFilter(KeyEvent.KEY_PRESSED, this::handleTextAreaKeyPress);
        medicineAmountField.addEventFilter(KeyEvent.KEY_PRESSED, this::handleTextFieldKeyPress);

        unFocusAll();

        medicineTable.getColumns().forEach(e -> e.setReorderable(false));
        medicineTable.setOnMouseClicked(event -> {
            Medicine selectedMedicine = medicineTable.getSelectionModel().getSelectedItem();
            if (selectedMedicine != null) {
                medicineNameField.setText(selectedMedicine.getMedicine_name());
                medicineAmountField.setText(String.valueOf(selectedMedicine.getMedicine_amount()));
                medicineDescriptionField.setText(selectedMedicine.getMedicine_description());
            }
        });
        medicineShowListData();
        searchFilter();
    }

    private void handleTextFieldKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            event.consume();
            jumpToNextField();
        }
    }

    private void handleTextAreaKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            event.consume();
            jumpToNextField();
        }
    }

    private void jumpToNextField() {
        if (medicineNameField.isFocused()) {
            medicineDescriptionField.requestFocus();
        } else if (medicineDescriptionField.isFocused()) {
            medicineAmountField.requestFocus();
        } else if (medicineAmountField.isFocused()) {
            medicineNameField.requestFocus();
        }
    }

    private CSVHandler csvhandler = new CSVHandler();
    private AlertMessage alert = new AlertMessage();
    private Medicine checkInput = new Medicine();


    public void initData(Admin admin){
        unameLabel.setText(admin.getUname());
    }

    public void resetBtnAction(){

        searchField.setText("");
        medicineNameField.setText("");
        medicineAmountField.setText("");
        medicineDescriptionField.setText("");
        medicineTable.getSelectionModel().clearSelection();
        medicineTable.setItems(refreshData());
        medicineShowListData();
    }

    public void unFocusAll(){
        manageDptBtn.setFocusTraversable(false);
        manageDocBtn.setFocusTraversable(false);
        manageMedicineBtn.setFocusTraversable(false);
        managePatientBtn.setFocusTraversable(false);
        medicineTable.setFocusTraversable(false);
        searchField.setFocusTraversable(false);
        medicineNameField.setFocusTraversable(false);
        medicineAmountField.setFocusTraversable(false);
        medicineDescriptionField.setFocusTraversable(false);
        addBtn.setFocusTraversable(false);
        updateBtn.setFocusTraversable(false);
        deleteBtn.setFocusTraversable(false);
        resetBtn.setFocusTraversable(false);
    }

    public ObservableList<Medicine> refreshData(){
        ObservableList<Medicine> listData = csvhandler.readCSV(CSVPath.MEDICINE_PATH, Medicine.class, CustomComparator.createComparator(Medicine::getMedicine_id, 1), ParameterTypes.MEDICINE_PARAMETER_TYPES);
        return listData;
    }

    public void medicineShowListData() {
        medicineIDCol.setCellValueFactory(new PropertyValueFactory<>("medicine_id"));
        medicineNameCol.setCellValueFactory(new PropertyValueFactory<>("medicine_name"));
        medicineAmountCol.setCellValueFactory(new PropertyValueFactory<>("medicine_amount"));
        medicineDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("medicine_description"));

        medicineTable.setItems(refreshData());

    }

    private void searchFilter(){
        FilteredList<Medicine> filteredData = new FilteredList<>(refreshData(), b -> true);

        if (searchField.getText() != null){
            searchField.setOnKeyReleased(e->{
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate((Predicate<? super Medicine>) medicine->{
                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if(medicine.getMedicine_id().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }else if(medicine.getMedicine_name().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }else if(medicine.getMedicine_description().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }else if(String.valueOf(medicine.getMedicine_amount()).contains(lowerCaseFilter)){
                        return true;
                    }
                    return false;
                });
            });
                final SortedList<Medicine> medicine_list = new SortedList<>(filteredData);
                medicine_list.comparatorProperty().bind(medicineTable.comparatorProperty());
                medicineTable.setItems(medicine_list);  

            });
        }
    }

    private boolean checkEmpty(){
        if (medicineNameField.getText().isEmpty()) {
            // show error message
            alert.errorMessage("Please fill in all the fields");
            return true;
        }
        return false;
    }

    private boolean checkSelected(){
        if (medicineTable.getSelectionModel().getSelectedItem() == null) {
            // show error message
            alert.errorMessage("Please select a medicine");
            return true;
        }
        return false;
    }


    private void addBtnAction(){
        //check if all fields are filled    
        if (!checkEmpty()) {
            String medicine_name = medicineNameField.getText();
            String medicine_description = medicineDescriptionField.getText();
            int medicine_amount = -1;
            try {
                medicine_amount = Integer.parseInt(medicineAmountField.getText());
            } catch (NumberFormatException e) {
                alert.errorMessage("Please enter a valid integer for medicine amount");
                return;
            }
        
            if (checkInput.validationMedicine(medicine_name, medicine_description, medicine_amount) == 1){
                //check if medicine already exist
                for (Medicine medicine : refreshData()){
                    if (medicine.getMedicine_name().equals(medicine_name)){
                        alert.errorMessage("Medicine already exists");
                        return;
                    }
                }

                //generate medicine id
                String medicine_id = "M" + String.format("%d", csvhandler.getMaxId(refreshData(), Medicine::getMedicine_id, "M") + 1);

                //create new medicine object
                Medicine newMedicine = new Medicine(medicine_id, medicine_name, medicine_description, medicine_amount);

                //add new medicine to csv file
                csvhandler.writeCSV(CSVPath.MEDICINE_PATH, newMedicine);

                // show success message
                alert.successMessage("Medicine added successfully!");
                
                //refresh data
                refreshData();

                //refresh table
                medicineShowListData();
                
                // reset input field
                resetBtnAction();

                // search filter refresh
                searchFilter();

                // unfocus all
                unFocusAll();
                                
            } else {
                // show error message
                alert.errorMessage("Please enter a valid input!");
            }
        }
    }
    private void updateBtnAction(){

        if (!checkSelected()){
            String medicineID = medicineTable.getSelectionModel().getSelectedItem().getMedicine_id();
            String medicineName = medicineNameField.getText();
            String medicineDescription = medicineDescriptionField.getText();
            int medicineAmount = -1;

            try {
                medicineAmount = Integer.parseInt(medicineAmountField.getText());
            } catch (NumberFormatException e) {
                alert.errorMessage("Please enter a valid integer for medicine amount");
                return;
            }

            // check if the input is empty
            if (!checkEmpty()) {
                if (checkInput.validationMedicine(medicineName,medicineDescription,medicineAmount) == 1 && medicineName != null) {
                // check if the medicine already exists
                for (Medicine medicine : refreshData()){
                    if (medicine.getMedicine_name().equals(medicineName) && !medicine.getMedicine_id().equals(medicineID)){
                        alert.errorMessage("Medicine already exists");
                        return;
                    }
                }
                // creata a new department object
                Medicine updatedMedicine = new Medicine(medicineID, medicineName, medicineDescription, medicineAmount);

                // update the department in the csv file
                csvhandler.updateCSV(CSVPath.MEDICINE_PATH, 0, medicineID, updatedMedicine);


                // show success message
                alert.successMessage("Medicine updated successfully");

                // refresh data
                refreshData();

                // refresh table
                medicineShowListData();

                // reset all fields
                resetBtnAction();

                // search filter refresh
                searchFilter();

                // unfocus all
                unFocusAll();

                } else {
                // show error message
                alert.errorMessage("Please enter valid input");
                }
            }
        }
    }

    private void deleteBtnAction(){
        // check if a department is selected
        if (!checkSelected()){
            // get the selected department id
            String selectedMedicine = medicineTable.getSelectionModel().getSelectedItem().getMedicine_id();
            
            // delete the department
            csvhandler.deleteCSV(CSVPath.MEDICINE_PATH, 0, selectedMedicine);

            // show success message
            alert.successMessage("Medicine deleted successfully");

            // refresh data
            refreshData();

            // refresh table
            medicineShowListData();

            // reset all fields
            resetBtnAction();

            // search filter refresh
            searchFilter();

            // unfocus all
            unFocusAll();
        }
    }

}
