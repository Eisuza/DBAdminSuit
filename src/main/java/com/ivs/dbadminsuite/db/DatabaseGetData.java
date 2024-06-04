package com.ivs.dbadminsuite.db;

import com.ivs.dbadminsuite.umanagment.UserPrivileges;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseGetData {

    public List<UserPrivileges> getUserPrivilegesList() throws SQLException {
        List<UserPrivileges> userPrivilegesList = new ArrayList<>();
        DatabaseConnector connector = new DatabaseConnector();
        connector.connect();
        ResultSet  resultSet = connector.executeQuery("SELECT user, host, account_locked, select_priv,insert_priv, update_priv, delete_priv, create_priv, drop_priv," +
                        " grant_priv, references_priv, alter_priv, create_tmp_table_priv, lock_tables_priv, execute_priv, create_view_priv, show_view_priv, " +
                        "create_routine_priv, alter_routine_priv, event_priv, trigger_priv FROM mysql.user");
        while (resultSet.next()) {
            String user = resultSet.getString("user");
            String host = resultSet.getString("host");
            Boolean accountLocked = resultSet.getBoolean("account_locked");
            Boolean selectPriv = resultSet.getBoolean("select_priv");
            Boolean insertPriv = resultSet.getBoolean("insert_priv");
            Boolean updatePriv = resultSet.getBoolean("update_priv");
            Boolean deletePriv = resultSet.getBoolean("delete_priv");
            Boolean createPriv = resultSet.getBoolean("create_priv");
            Boolean dropPriv = resultSet.getBoolean("drop_priv");
            Boolean grantPriv = resultSet.getBoolean("grant_priv");
            Boolean referencesPriv = resultSet.getBoolean("references_priv");
            Boolean alterPriv = resultSet.getBoolean("alter_priv");
            Boolean createTmpTablePriv = resultSet.getBoolean("create_tmp_table_priv");
            Boolean lockTablesPriv = resultSet.getBoolean("lock_tables_priv");
            Boolean executePriv = resultSet.getBoolean("execute_priv");
            Boolean createViewPriv = resultSet.getBoolean("create_view_priv");
            Boolean showViewPriv = resultSet.getBoolean("show_view_priv");
            Boolean createRoutinePriv = resultSet.getBoolean("create_routine_priv");
            Boolean alterRoutinePriv = resultSet.getBoolean("alter_routine_priv");
            Boolean eventPriv = resultSet.getBoolean("event_priv");
            Boolean triggerPriv = resultSet.getBoolean("trigger_priv");
            UserPrivileges userPrivileges = new UserPrivileges(user, host, accountLocked, selectPriv, insertPriv, updatePriv,
                    deletePriv, createPriv, dropPriv, grantPriv, referencesPriv, alterPriv, createTmpTablePriv,
                    lockTablesPriv,  executePriv, createViewPriv, showViewPriv, createRoutinePriv, alterRoutinePriv,
                    eventPriv, triggerPriv);
            userPrivilegesList.add(userPrivileges);
        }
        return userPrivilegesList;
    }
}
