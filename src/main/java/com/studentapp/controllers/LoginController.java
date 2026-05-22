package com.studentapp.controllers;

import com.studentapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    public TextField usernameField;
    public PasswordField passwordField;

    public void handleLogin(ActionEvent event) {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("admin") && password.equals("admin")) {

            try {

                FXMLLoader loader = new FXMLLoader(
                        Main.class.getResource("/views/dashboard.fxml")
                );

                Stage stage = (Stage) usernameField.getScene().getWindow();

                stage.setScene(new Scene(loader.load()));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Invalid Login");
        }
    }
}