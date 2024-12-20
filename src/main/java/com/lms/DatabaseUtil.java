package com.lms;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private static final String PROPERTIES_FILE = "/db.properties";

    public static Connection getConnection() throws SQLException {
        try (InputStream input = DatabaseUtil.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new SQLException("Failed to load database properties.", e);
        }
    }
}
