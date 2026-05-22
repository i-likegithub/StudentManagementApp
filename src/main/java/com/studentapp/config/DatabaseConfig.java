package com.studentapp.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConfig {

    private static final Dotenv dotenv = Dotenv.load();

    public static final String DB_URL =
            dotenv.get("DB_URL");
}