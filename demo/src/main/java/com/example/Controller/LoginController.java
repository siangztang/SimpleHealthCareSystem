package com.example.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.Admin;
import com.example.AlertMessage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField UsernameField;

    @FXML
    private Button lognbtn;

    @FXML
    void initialize() {
        UsernameField.setFocusTraversable(false);
        PasswordField.setFocusTraversable(false);
        lognbtn.setFocusTraversable(false);
        lognbtn.setOnAction(event -> {
            login();
        });

        UsernameField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.TAB) {
                PasswordField.requestFocus();
            }
        });

        PasswordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.TAB) {
                login();
                lognbtn.requestFocus();
            }
        });
    }

    private AlertMessage alert = new AlertMessage();
    private static Admin admin;
    public void login() {
        String uname = UsernameField.getText().trim();
        String password = PasswordField.getText().trim();
        
        if (admin == null){
            admin = new Admin(uname, password);
        }
        

        switch (admin.isValidLogin()) {
            case 0:
                alert.errorMessage("Invalid Username or Password");
                break;
            case 1:
                alert.successMessage("Login Successful");
                try {
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\PatientList.fxml"));
                    
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    PatientListController controller = loader.getController();
                    controller.initData(admin);
                    stage.show();
                    Stage currentStage = (Stage) lognbtn.getScene().getWindow();
                    currentStage.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
