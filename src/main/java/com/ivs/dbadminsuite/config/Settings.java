package com.ivs.dbadminsuite.config;

import com.ivs.dbadminsuite.dbmodifier.DatabaseModifierController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Settings extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        openSettings(primaryStage);
    }

    public void openSettings(Stage parentStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ivs/dbadminsuite/settings-view.fxml"));
        Parent root = loader.load();

        SettingsController controller = loader.getController();

        Scene scene = new Scene(root, 400, 300);
        Stage stage = new Stage();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Настройки подключения к базе данных.");
        stage.setScene(scene);
        stage.show();
    }
}
