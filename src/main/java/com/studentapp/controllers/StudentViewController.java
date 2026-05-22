package com.studentapp.controllers;

import com.studentapp.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentViewController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField courseField;

    @FXML
    private TextField emailField;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> courseColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    private final ObservableList<Student> studentList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        courseColumn.setCellValueFactory(
                new PropertyValueFactory<>("course")
        );

        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );

        loadStudents();
    }

    public void handleAddStudent() {

        StudentController.addStudent(
                nameField.getText(),
                courseField.getText(),
                emailField.getText()
        );

        loadStudents();

        nameField.clear();
        courseField.clear();
        emailField.clear();
    }

    public void handleDeleteStudent() {

        Student selected =
                studentTable.getSelectionModel()
                        .getSelectedItem();

        if(selected != null) {

            StudentController.deleteStudent(
                    selected.getId()
            );

            loadStudents();
        }
    }

    private void loadStudents() {

        studentList.clear();

        studentList.addAll(
                StudentController.getStudents()
        );

        studentTable.setItems(studentList);
    }
}