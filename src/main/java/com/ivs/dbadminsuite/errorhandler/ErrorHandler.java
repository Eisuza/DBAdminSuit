package com.ivs.dbadminsuite.errorhandler;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

// Методы для обработки ошибок
public class ErrorHandler {
    public void handleException(Exception e) {
        e.printStackTrace();
    }
    public static void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        Image icon = new Image(Objects.requireNonNull(ErrorHandler.class.getResourceAsStream("/icon.png")));
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(icon);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
