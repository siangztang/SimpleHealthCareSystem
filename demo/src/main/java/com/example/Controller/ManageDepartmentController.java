package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.SwitchPage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageDepartmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> departmentTable;

    @FXML
    private TableColumn<?, ?> dptIDCol;

    @FXML
    private TableColumn<?, ?> dptNameCol;

    @FXML
    private Button manageDocBtn;

    @FXML
    private Button manageMedicineBtn;

    @FXML
    private Button managePatienttBtn;

    @FXML
    private TextField searchField;

    @FXML
    private Label unameLabel;

    @FXML
    void initialize() {

        manageDocBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, manageDocBtn);
        });

        manageMedicineBtn.setOnAction(event -> {
            SwitchPage.switchPage(event, manageMedicineBtn);
        });
    }

    public void initData(Admin admin){
        unameLabel.setText(admin.getUname());
    }
}
