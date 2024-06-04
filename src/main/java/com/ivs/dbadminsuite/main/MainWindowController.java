package com.ivs.dbadminsuite.main;

import com.ivs.dbadminsuite.config.Settings;
import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import com.ivs.dbadminsuite.qexecutor.QueryExecutor;
import com.ivs.dbadminsuite.dbmodifier.DatabaseModifier;
import com.ivs.dbadminsuite.dbvisualizer.DatabaseVisualizer;
import com.ivs.dbadminsuite.umanagment.PrivilegesManagement;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;

public class MainWindowController {
    @FXML
    private void executeQuery() {
        QueryExecutor queryExecutor = new QueryExecutor();
        Stage stage = new Stage();
        try {
            queryExecutor.openQueryExecutor(stage);
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }

    @FXML
    private void modifyDB() {
        DatabaseModifier databaseModifier = new DatabaseModifier();
        Stage stage = new Stage();
        try {
            databaseModifier.openQueryExecutor(stage);
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }

    @FXML
    private void openConnections() {
        DatabaseVisualizer databaseVisualizer = new DatabaseVisualizer();
        Stage stage = new Stage();
        try {
            databaseVisualizer.openDatabaseVisualizer(stage);
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }

    }

    @FXML
    private void openSettings() {
        Settings settings = new Settings();
        Stage stage = new Stage();
        try {
            settings.openSettings(stage);
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }

    @FXML
    private void manageUserList() {
        PrivilegesManagement privilegesManagement = new PrivilegesManagement();
        Stage stage = new Stage();
        try {
            privilegesManagement.openPrevilegesManagement(stage);
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }
}
