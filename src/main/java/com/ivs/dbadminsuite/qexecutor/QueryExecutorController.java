package com.ivs.dbadminsuite.qexecutor;

import com.ivs.dbadminsuite.db.DatabaseConnector;
import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryExecutorController {
    private static final String SELECT_REGEX = "(?s)\\bSELECT\\b.*";
    private static final String MODIFY_REGEX = "(?s)\\bINSERT\\b|\\bUPDATE\\b|\\bDELETE\\b.*";

    @FXML
    private TextArea queryTextArea;

    @FXML
    private TableView<Object[]> resultTableView;

    @FXML
    private void executeQuery() {
        String query = queryTextArea.getText();
        if (!isValidQuery(query)) {
            ErrorHandler.showError("Запрос введен с ошибками", "Пожалуйста, введите верный запрос.");
        } else {
            try {
                DatabaseConnector connector = new DatabaseConnector();
                connector.connect();
                if (isSelectQuery(query)) {
                    ResultSet resultSet = connector.executeQuery(query);
                    populateTableView(resultSet);
                } else {
                    int rowsAffected = connector.executeUpdate(query);
                    System.out.println("Запрос затронул " + rowsAffected + " строк(и)");
                    if (rowsAffected > 0) {
                        showNotification("Операция выполнена успешно.\nЗапрос затронул " + rowsAffected + " строк(и)");
                    } else {
                        showNotification("Операция выполнена успешно.\nНи одной строки не затронуто.");
                    }
                }
                connector.disconnect();
            } catch (SQLException e) {
                ErrorHandler.showError("Ошибка SQL", "Возникла ошибка во время выполнения запроса: " + e.getMessage());
            }
        }
    }

    private void showNotification(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Успешно");
        Image icon = new Image(Objects.requireNonNull(ErrorHandler.class.getResourceAsStream("/icon.png")));
        ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(icon);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean isSelectQuery(String query) {
        return query.trim().toLowerCase().startsWith("select");
    }

    private boolean isValidQuery(String query) {
        // Проверяем, является ли запрос запросом на выборку данных
        Pattern selectPattern = Pattern.compile(SELECT_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher selectMatcher = selectPattern.matcher(query);

        // Проверяем, является ли запрос запросом на модификацию данных
        Pattern modifyPattern = Pattern.compile(MODIFY_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher modifyMatcher = modifyPattern.matcher(query);

        // Запрос должен быть либо запросом на выборку данных, либо запросом на модификацию данных
        return selectMatcher.matches() || modifyMatcher.matches();
    }

    private void populateTableView(ResultSet resultSet) throws SQLException {
        resultTableView.getColumns().clear();
        if (resultSet == null) {
            return;
        }

        // Создаем список столбцов таблицы на основе метаданных результирующего набора
        List<TableColumn<Object[], Object>> columns = new ArrayList<>();
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            int columnIndex = i;
            TableColumn<Object[], Object> column = new TableColumn<>(resultSet.getMetaData().getColumnName(i));
            column.setCellValueFactory(cellData -> {
                Object[] rowData = cellData.getValue();
                return new SimpleObjectProperty<>(rowData[columnIndex - 1]);
            });
            columns.add(column);
        }

        // Добавляем столбцы в таблицу
        resultTableView.getColumns().addAll(columns);

        // Заполняем таблицу данными из результирующего набора
        ObservableList<Object[]> data = FXCollections.observableArrayList();
        while (resultSet.next()) {
            Object[] rowData = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 1; i <= rowData.length; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            data.add(rowData);
        }
        resultTableView.setItems(data);
    }

    public void printResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet == null) {
            System.out.println("ResultSet пуст.");
            return;
        }

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}
