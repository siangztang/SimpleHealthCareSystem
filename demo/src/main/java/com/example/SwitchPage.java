package com.example;

import java.io.FileInputStream;
import java.io.IOException;

import com.example.Controller.LoginController;
import com.example.Controller.ManageDepartmentController;
import com.example.Controller.ManageDoctorController;
import com.example.Controller.ManageMedicineController;
import com.example.Controller.PatientListController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class SwitchPage {

    private static Admin admin = LoginController.getAdmin();
    
    public static void switchPage(ActionEvent event, Button btnId) {
        
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();
        if (buttonId.equals("manageDptBtn")){
            
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\ManageDepartment.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                ManageDepartmentController controller = loader.getController();
                controller.initData(admin);
                stage.show();
                Stage currentStage = (Stage) btnId.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (buttonId.equals("manageDocBtn")){

            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\ManageDoctor.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                ManageDoctorController controller = loader.getController();
                controller.initData(admin);
                stage.show();
                Stage currentStage = (Stage) btnId.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (buttonId.equals("manageMedicineBtn")){

            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\ManageMedicine.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                ManageMedicineController controller = loader.getController();
                controller.initData(admin);
                stage.show();
                Stage currentStage = (Stage) btnId.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        } else if (buttonId.equals("managePatientBtn")){
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream("demo\\src\\main\\resources\\com\\example\\PatientList.fxml"));
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                PatientListController controller = loader.getController();
                controller.initData(admin);
                stage.show();
                Stage currentStage = (Stage) btnId.getScene().getWindow();
                currentStage.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }
        
    }
}
