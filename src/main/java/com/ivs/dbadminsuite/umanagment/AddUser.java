package com.ivs.dbadminsuite.umanagment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AddUser extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        openAddUser(primaryStage);
    }
    public void openAddUser(Stage parentStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ivs/dbadminsuite/adduser-view.fxml"));
        Parent root = loader.load();

        AddUserController controller = loader.getController();

        Scene scene = new Scene(root, 300, 100);
        Stage stage = new Stage();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Добавить пользователя");
        stage.setScene(scene);
        stage.show();
    }
}
