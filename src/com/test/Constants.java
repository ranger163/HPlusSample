package com.test;

public class Constants {

    private static String localhost = "jdbc:mysql://localhost:";
    private static String port = "3306/";
    private static String databaseName = "hplus?";
    private static String configuration = "autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static String databaseConnection = localhost + port + databaseName + configuration;

    private static String username = "root";
    private static String userPassword = "Andy@163";

    public static String getLocalhost() {
        return localhost;
    }

    public static void setLocalhost(String localhost) {
        Constants.localhost = localhost;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        Constants.port = port;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static void setDatabaseName(String databaseName) {
        Constants.databaseName = databaseName;
    }

    public static String getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(String configuration) {
        Constants.configuration = configuration;
    }

    public static String getDatabaseConnection() {
        return databaseConnection;
    }

    public static void setDatabaseConnection(String databaseConnection) {
        Constants.databaseConnection = databaseConnection;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Constants.username = username;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static void setUserPassword(String userPassword) {
        Constants.userPassword = userPassword;
    }
}
