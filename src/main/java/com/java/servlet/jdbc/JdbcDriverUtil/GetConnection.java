package com.java.servlet.jdbc.JdbcDriverUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

    private static final Logger log = LoggerFactory.getLogger(GetConnection.class);
    private static final String url = "jdbc:mysql://localhost:3306/human_jdbc";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() {

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        if (connection != null) {
            System.out.println("Connected to the MySQL server successfully.");
        } else {
            System.out.println("Failed to make connection!");
        }
        log.info("Connection is ON, User = {}", user);

        return connection;
    }
}
