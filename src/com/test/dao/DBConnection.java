package com.test.dao;

import com.test.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnection {

    static Connection getConnectionDataBase() {
        Connection connection = null;

        try {
            // load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");

            // get hold of the driver manager
            connection = DriverManager.getConnection(
                    Constants.getDatabaseConnection(),
                    Constants.getUsername(),
                    Constants.getUserPassword());
            System.out.println("Database successfully opened.");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed, check output console");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connection made to DB!");
        }
        return connection;

    }

}
