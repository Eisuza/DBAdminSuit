package com.ivs.dbadminsuite.db;

import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import com.ivs.dbadminsuite.statistics.StatisticsRecorder;
import com.ivs.dbadminsuite.umanagment.UserPrivileges;
import java.sql.*;

public class DatabaseSetData {

    public int editPrivileges(UserPrivileges userPrivileges) {
        boolean success = false;
        int rowsAffected = 0;
        String query = "UPDATE mysql.user SET host = ?, account_locked = ?, select_priv = ?,insert_priv = ?, update_priv = ?, delete_priv = ?, create_priv = ?, drop_priv = ?," +
                " grant_priv = ?, references_priv = ?, alter_priv = ?, create_tmp_table_priv = ?, lock_tables_priv = ?, execute_priv = ?, create_view_priv = ?, show_view_priv = ?, " +
                "create_routine_priv = ?, alter_routine_priv = ?, event_priv = ?, trigger_priv = ? WHERE user = ?";
        String host = userPrivileges.getHost();
        Boolean accountLocked = userPrivileges.isAccountLocked();
        Boolean selectPriv = userPrivileges.isSelectPriv();
        Boolean insertPriv = userPrivileges.isInsertPriv();
        Boolean updatePriv = userPrivileges.isUpdatePriv();
        Boolean deletePriv = userPrivileges.isDeletePriv();
        Boolean createPriv = userPrivileges.isCreatePriv();
        Boolean dropPriv = userPrivileges.isDropPriv();
        Boolean grantPriv = userPrivileges.isGrantPriv();
        Boolean referencesPriv = userPrivileges.isReferencesPriv();
        Boolean alterPriv = userPrivileges.isAlterPriv();
        Boolean createTmpTablePriv = userPrivileges.isCreateTmpTablePriv();
        Boolean lockTablesPriv = userPrivileges.isLockTablesPriv();
        Boolean executePriv = userPrivileges.isExecutePriv();
        Boolean createViewPriv = userPrivileges.isCreateViewPriv();
        Boolean showViewPriv = userPrivileges.isShowViewPriv();
        Boolean createRoutinePriv = userPrivileges.isCreateRoutinePriv();
        Boolean alterRoutinePriv = userPrivileges.isAlterRoutinePriv();
        Boolean eventPriv = userPrivileges.isEventPriv();
        Boolean triggerPriv = userPrivileges.isTriggerPriv();
        String user = userPrivileges.getUser();
        String aquery = "UPDATE mysql.user SET host = '" + host + "', account_locked = '" + accountLocked + "', select_priv = " + selectPriv + ", insert_priv = " + insertPriv + ", update_priv = " + updatePriv + ", delete_priv = " + deletePriv + ", create_priv = " + createPriv + ", drop_priv = " + dropPriv + "," +
                " grant_priv = " + grantPriv + ", references_priv = " + referencesPriv + ", alter_priv = " + alterPriv + ", create_tmp_table_priv = " + createTmpTablePriv + ", lock_tables_priv = " + lockTablesPriv + ", execute_priv = " + executePriv + ", create_view_priv = " + createViewPriv + ", show_view_priv = " + showViewPriv + ", " +
                "create_routine_priv = " + createRoutinePriv + ", alter_routine_priv = " + alterRoutinePriv + ", event_priv = " + eventPriv + ", trigger_priv = " + triggerPriv + " WHERE user = '" + user + "'";
        StatisticsRecorder statisticsRecorder = new StatisticsRecorder();
        long startTime = System.currentTimeMillis();
        try {
            DatabaseConnector connector = new DatabaseConnector();
            Connection connection = connector.connect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, host);
            statement.setString(2, accountLocked ? "Y" : "N");
            statement.setString(3, selectPriv ? "Y" : "N");
            statement.setString(4, insertPriv ? "Y" : "N");
            statement.setString(5, updatePriv ? "Y" : "N");
            statement.setString(6, deletePriv ? "Y" : "N");
            statement.setString(7, createPriv ? "Y" : "N");
            statement.setString(8, dropPriv ? "Y" : "N");
            statement.setString(9, grantPriv ? "Y" : "N");
            statement.setString(10, referencesPriv ? "Y" : "N");
            statement.setString(11, alterPriv ? "Y" : "N");
            statement.setString(12, createTmpTablePriv ? "Y" : "N");
            statement.setString(13, lockTablesPriv ? "Y" : "N");
            statement.setString(14, executePriv ? "Y" : "N");
            statement.setString(15, createViewPriv ? "Y" : "N");
            statement.setString(16, showViewPriv ? "Y" : "N");
            statement.setString(17, createRoutinePriv ? "Y" : "N");
            statement.setString(18, alterRoutinePriv ? "Y" : "N");
            statement.setString(19, eventPriv ? "Y" : "N");
            statement.setString(20, triggerPriv ? "Y" : "N");
            statement.setString(21, user);
            rowsAffected = statement.executeUpdate();
            success = true;
        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка SQL", "Возникла ошибка во время выполнения запроса: " + e.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            statisticsRecorder.updateStatistics(aquery, executionTime, success);
        }
        return rowsAffected;
    }

    public boolean addUser(String login, String password) {
        StatisticsRecorder statisticsRecorder = new StatisticsRecorder();
        long startTime = System.currentTimeMillis();
        boolean success = false;
        String query = "CREATE USER '" + login + "'@'localhost' IDENTIFIED BY '" + password + "'";
        try {
            DatabaseConnector connector = new DatabaseConnector();
            Connection connection = connector.connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            success = true;
        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка SQL", "Возникла ошибка во время выполнения запроса: " + e.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            statisticsRecorder.updateStatistics(query, executionTime, success);
        }
        return success;
    }

    public boolean updateUser(String login, String password) {
        StatisticsRecorder statisticsRecorder = new StatisticsRecorder();
        long startTime = System.currentTimeMillis();
        boolean success = false;
        String query = "ALTER USER ?@'localhost' IDENTIFIED BY ?";
        try {
            DatabaseConnector connector = new DatabaseConnector();
            Connection connection = connector.connect();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
            success = true;
        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка SQL", "Возникла ошибка во время выполнения запроса: " + e.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            query = "ALTER USER "+login +"@'localhost' IDENTIFIED BY "+password;
            statisticsRecorder.updateStatistics(query, executionTime, success); // Обновление статистики
        }
        return success;
    }

    public boolean deleteUser(String login) {
        StatisticsRecorder statisticsRecorder = new StatisticsRecorder();
        long startTime = System.currentTimeMillis();
        boolean success = false;
        String query = "DROP USER '" + login + "'@'localhost'";
        try {
            DatabaseConnector connector = new DatabaseConnector();
            Connection connection = connector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
            success = true;
        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка SQL", "Возникла ошибка во время выполнения запроса: " + e.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            statisticsRecorder.updateStatistics(query, executionTime, success); // Обновление статистики
        }
        return success;
    }


    public boolean isUserExist(String login) throws SQLException {
        StatisticsRecorder statisticsRecorder = new StatisticsRecorder();
        long startTime = System.currentTimeMillis();
        boolean success = false;
        boolean isExist = false;
        String query = "SELECT COUNT(*) AS count FROM mysql.user WHERE user = ?";
        try {
            DatabaseConnector connector = new DatabaseConnector();
            Connection connection = connector.connect();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                isExist = (count > 0);
            }
            success = true;
        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка SQL", "Возникла ошибка во время выполнения запроса: " + e.getMessage());
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            query = "SELECT COUNT(*) AS count FROM user WHERE login = " + login;
            statisticsRecorder.updateStatistics(query, executionTime, success); // Обновление статистики
        }
        return isExist;
    }
}
