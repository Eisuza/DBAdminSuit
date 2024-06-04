package com.ivs.dbadminsuite.qexecutor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class QueryExecutor extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        openQueryExecutor(primaryStage);
    }
    public void openQueryExecutor(Stage parentStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ivs/dbadminsuite/queryexecutor-view.fxml"));
        Parent root = loader.load();

        QueryExecutorController controller = loader.getController();

        Scene scene = new Scene(root, 400, 300);
        Stage stage = new Stage();
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Выполнить произвольный запрос.");
        stage.setScene(scene);
        stage.show();
    }

}
