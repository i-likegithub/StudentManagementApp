package com.studentapp.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    course TEXT NOT NULL,
                    email TEXT NOT NULL
                )
                """;

        try (
                Connection conn = DBConnection.connect();
                Statement stmt = conn.createStatement()
        ) {

            stmt.execute(sql);

            System.out.println("Database initialized.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}