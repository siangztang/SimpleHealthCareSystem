package com.example.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane patient_history_page;

    @FXML
    private StackPane patient_list_page;

    @FXML
    private StackPane treatment_course_details_page;

    @FXML
    private StackPane treatment_course_page;

    @FXML
    private Label unamelabel1;

    @FXML
    private Label unamelabel2;

    @FXML
    private Label unamelabel3;

    @FXML
    private Label unamelabel4;

    @FXML
    void initialize() {

    }

    void initData(Admin admin){
        unamelabel1.setText(admin.getUname());
        unamelabel2.setText(admin.getUname());
        unamelabel3.setText(admin.getUname());
        unamelabel4.setText(admin.getUname());
    }

}
