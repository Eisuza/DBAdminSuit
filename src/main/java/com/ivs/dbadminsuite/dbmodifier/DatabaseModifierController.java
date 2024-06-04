package com.ivs.dbadminsuite.dbmodifier;

import com.ivs.dbadminsuite.db.DatabaseConnector;
import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseModifierController {
    private static final String MODIFY_REGEX = "\\b(CREATE|ALTER|DROP|TRUNCATE)\\b.*";

    @FXML
    private TextArea queryTextArea;

    @FXML
    private void executeQuery() {
        String query = queryTextArea.getText();
        if (!isValidQuery(query)) {
            ErrorHandler.showError("Запрос введен с ошибками", "Пожалуйста, введите верный запрос.");
            return;
        }

        try {
            DatabaseConnector connector = new DatabaseConnector();
            connector.connect();
            connector.executeUpdate(query);
            connector.disconnect();
            showNotification("Операция выполнена успешно.");
        } catch (SQLException e) {
            ErrorHandler.showError("Ошибка SQL", "Возникла ошибка во время выполнения запроса: " + e.getMessage());
        }
    }

    private void showNotification(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Успешно");
        alert.setHeaderText(null);
        Image icon = new Image(Objects.requireNonNull(ErrorHandler.class.getResourceAsStream("/icon.png")));
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(icon);
        alert.setContentText(message);
        alert.showAndWait();
    }

   private boolean isValidQuery(String query) {
       Pattern modifyPattern = Pattern.compile(MODIFY_REGEX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
       Matcher modifyMatcher = modifyPattern.matcher(query);
       return modifyMatcher.matches();
   }
}
