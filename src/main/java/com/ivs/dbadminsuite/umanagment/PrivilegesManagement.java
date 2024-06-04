package com.ivs.dbadminsuite.umanagment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PrivilegesManagement extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        openPrevilegesManagement(primaryStage);
    }
    public void openPrevilegesManagement(Stage parentStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ivs/dbadminsuite/privilegesmanagement-view.fxml"));
        Parent root = loader.load();

        PrivilegesManagementController controller = loader.getController();

        Scene scene = new Scene(root, 1000, 700);
        Stage stage = new Stage();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Управлять пользователями базы данных.");
        stage.setScene(scene);
        stage.show();
    }
}
