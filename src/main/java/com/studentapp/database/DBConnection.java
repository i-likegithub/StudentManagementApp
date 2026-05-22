package com.studentapp.database;

import com.studentapp.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection connect() {

        try {

            return DriverManager.getConnection(
                    DatabaseConfig.DB_URL
            );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}