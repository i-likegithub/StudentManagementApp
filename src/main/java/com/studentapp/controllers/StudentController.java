package com.studentapp.controllers;

import com.studentapp.database.DBConnection;
import com.studentapp.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    public static void addStudent(
            String name,
            String course,
            String email
    ) {

        String sql = """
                INSERT INTO students(name, course, email)
                VALUES(?,?,?)
                """;

        try (
                Connection conn = DBConnection.connect();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, name);
            stmt.setString(2, course);
            stmt.setString(3, email);

            stmt.executeUpdate();

            System.out.println("Student added.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (
                Connection conn = DBConnection.connect();
                PreparedStatement stmt =
                        conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while(rs.next()) {

                students.add(
                        new Student(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("course"),
                                rs.getString("email")
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (
                Connection conn = DBConnection.connect();
                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Student deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}