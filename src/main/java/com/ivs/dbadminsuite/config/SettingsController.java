package com.ivs.dbadminsuite.config;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class SettingsController {
    @FXML
    private TextField urlTextField;

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button editButton;

    @FXML
    private Button saveButton;

    @FXML
    private void initialize() {
        urlTextField.setText(AppConfig.getDbUrl());
        loginTextField.setText(AppConfig.getDbUsername());
        passwordTextField.setText(AppConfig.getDbPassword());
    }

    @FXML
    private void editSettings() {
        urlTextField.setEditable(true);
        loginTextField.setEditable(true);
        passwordTextField.setEditable(true);
        editButton.setVisible(false);
        saveButton.setVisible(true);
    }

    @FXML
    private void saveSettings() {

        AppConfig.setDbUrl(urlTextField.getText());
        AppConfig.setDbUsername(loginTextField.getText());
        AppConfig.setDbPassword(passwordTextField.getText());

        urlTextField.setEditable(false);
        loginTextField.setEditable(false);
        passwordTextField.setEditable(false);
        editButton.setVisible(true);
        saveButton.setVisible(false);
    }
}
