package com.ivs.dbadminsuite.main;

import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainWindow extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ivs/dbadminsuite/mainwindow-view.fxml"));
            Parent root = loader.load();

            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
            primaryStage.getIcons().add(icon);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Панель управления.");
            primaryStage.show();
        } catch (Exception e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

