package com.ivs.dbadminsuite.umanagment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UpdateUser extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        openUpdateUser(primaryStage);
    }
    public void openUpdateUser(Stage parentStage) throws IOException {
        // Загрузка FXML-файла
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ivs/dbadminsuite/updateuser-view.fxml"));
        Parent root = loader.load();

        // Получение контроллера из загрузчика
        UpdateUserController controller = loader.getController();

        Scene scene = new Scene(root, 400, 100);
        Stage stage = new Stage();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Редактировать данные пользователя");
        stage.setScene(scene);
        stage.show();
    }
}
