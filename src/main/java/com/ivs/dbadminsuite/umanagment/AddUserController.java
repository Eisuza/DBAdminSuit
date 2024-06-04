package com.ivs.dbadminsuite.umanagment;

import com.ivs.dbadminsuite.db.DatabaseSetData;
import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Objects;

public class AddUserController {
    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void addUser() throws SQLException {
        String login = loginTextField.getText();
        String password = passwordField.getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        Image icon = new Image(Objects.requireNonNull(ErrorHandler.class.getResourceAsStream("/icon.png")));
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(icon);
        DatabaseSetData databaseSetData = new DatabaseSetData();
        if (!databaseSetData.isUserExist(login)) {
             boolean success = databaseSetData.addUser(login, password);
            if (success) {
                alert.setTitle("Успешно");
                alert.setContentText("Пользователь успешно добавлен в базу данных");
            } else {
                alert.setTitle("Ошибка");
                alert.setContentText("Во время добавления произошла ошибка.");
            }
        } else {
            alert.setTitle("Внимание");
            alert.setContentText("Пользователь с таким логином уже существует.");
        }

        alert.showAndWait();
    }
}
