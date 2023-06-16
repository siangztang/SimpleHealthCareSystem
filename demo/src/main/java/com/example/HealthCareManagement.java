package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class HealthCareManagement extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Health Care Management System");
        stage.centerOnScreen();
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }

}