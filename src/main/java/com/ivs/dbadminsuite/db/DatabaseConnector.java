package com.ivs.dbadminsuite.db;

import com.ivs.dbadminsuite.config.AppConfig;
import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import com.ivs.dbadminsuite.statistics.StatisticsRecorder;

import java.sql.*;

public class DatabaseConnector {

    private  String URL = AppConfig.getDbUrl();
    private  String USERNAME = AppConfig.getDbUsername();
    private String PASSWORD = AppConfig.getDbPassword();
    private Connection connection;

    public Connection connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    public ResultSet executeQuery(String query) throws SQLException {
        StatisticsRecorder statisticsRecorder = new StatisticsRecorder();
        long startTime = System.currentTimeMillis();
        ResultSet resultSet = null;
        boolean success = false;
        try {
            if (connection == null || connection.isClosed()) {
                throw new IllegalStateException("Соединение не установлено.");
            }
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            success = true;
        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка выполнения запроса.", "Во время выполнения запроса произошла ошибка." + e.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            statisticsRecorder.updateStatistics(query, executionTime, success);
        }
        return resultSet;
    }

    public int executeUpdate(String query) throws SQLException {
        StatisticsRecorder statisticsRecorder = new StatisticsRecorder();
        long startTime = System.currentTimeMillis();
        int rowsAffected = 0;
        boolean success = false;
        try {
            if (connection == null || connection.isClosed()) {
                throw new IllegalStateException("Соединение не установлено.");
            }
            try (Statement statement = connection.createStatement()) {
                rowsAffected = statement.executeUpdate(query);
                success = true;
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка выполнения запроса.", "Во время выполнения запроса произошла ошибка." + e.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            statisticsRecorder.updateStatistics(query, executionTime, success);
        }
        return rowsAffected;
    }
}
