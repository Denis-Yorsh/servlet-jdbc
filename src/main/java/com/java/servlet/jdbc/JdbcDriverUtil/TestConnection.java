package com.java.servlet.jdbc.JdbcDriverUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        Connection connection = GetConnection.getConnection();

        try {
            
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
