package com.studentapp.controllers;

import com.studentapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {

    public void openStudents(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    Main.class.getResource(
                            "/views/students.fxml"
                    )
            );

            Stage stage = new Stage();

            stage.setScene(
                    new Scene(loader.load())
            );

            stage.setTitle("Students");

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}