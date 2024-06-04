package com.ivs.dbadminsuite.dbvisualizer;

import com.ivs.dbadminsuite.db.DatabaseConnector;
import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseVisualizerController {

    @FXML
    private TableView<TableData> attributesTable;

    @FXML
    private TableColumn<TableData, String> tableColumn;

    @FXML
    private TableColumn<TableData, String> attributesColumn;

    @FXML
    private TableView<ForeignKeyData> foreignKeysTable;

    @FXML
    private TableColumn<ForeignKeyData, String> foreignKeyTableColumn;

    @FXML
    private TableColumn<ForeignKeyData, String> foreignKeyColumn;

    public void initialize() {
        try {
            DatabaseConnector connector = new DatabaseConnector();
            Connection connection = connector.connect();
            Statement statement = connection.createStatement();

            ResultSet tablesResultSet = statement.executeQuery("SHOW TABLES");
            Map<String, List<String>> tableAttributesMap = new LinkedHashMap<>();
            Map<String, List<String>> tableForeignKeysMap = new LinkedHashMap<>();

            // Получаем названия всех таблиц и сохраняем их в Map
            while (tablesResultSet.next()) {
                String tableName = tablesResultSet.getString(1);
                tableAttributesMap.put(tableName, new ArrayList<>());
                tableForeignKeysMap.put(tableName, new ArrayList<>());
            }

            // Получаем атрибуты и внешние ключи для каждой таблицы
            for (String tableName : tableAttributesMap.keySet()) {
                // Получаем список атрибутов таблицы
                ResultSet columnsResultSet = statement.executeQuery("SHOW COLUMNS FROM " + tableName);
                while (columnsResultSet.next()) {
                    String columnName = columnsResultSet.getString("Field");
                    tableAttributesMap.get(tableName).add(columnName);
                }

                // Получаем список внешних ключей таблицы
                ResultSet foreignKeysResultSet = statement.executeQuery("SHOW CREATE TABLE " + tableName);
                if (foreignKeysResultSet.next()) {
                    String createTableStatement = foreignKeysResultSet.getString("Create Table");
                    addForeignKeyItems(tableName, createTableStatement, tableForeignKeysMap);
                }
            }

            connector.disconnect();

            // Заполнение данных для таблиц
            ObservableList<TableData> attributesData = FXCollections.observableArrayList();
            for (String tableName : tableAttributesMap.keySet()) {
                attributesData.add(new TableData(tableName, String.join("\n", tableAttributesMap.get(tableName))));
            }

            ObservableList<ForeignKeyData> foreignKeysData = FXCollections.observableArrayList();
            for (String tableName : tableForeignKeysMap.keySet()) {
                for (String foreignKey : tableForeignKeysMap.get(tableName)) {
                    foreignKeysData.add(new ForeignKeyData(tableName, foreignKey));
                }
            }

            // Привязка данных к таблицам
            tableColumn.setCellValueFactory(cellData -> cellData.getValue().tableNameProperty());
            attributesColumn.setCellValueFactory(cellData -> cellData.getValue().attributesProperty());
            attributesTable.setItems(attributesData);

            foreignKeyTableColumn.setCellValueFactory(cellData -> cellData.getValue().tableNameProperty());
            foreignKeyColumn.setCellValueFactory(cellData -> cellData.getValue().foreignKeyProperty());
            foreignKeysTable.setItems(foreignKeysData);

        } catch (SQLException e) {
            //e.printStackTrace();
            ErrorHandler.showError("SQL Error", "An error occurred while visualizing database: " + e.getMessage());
        }
    }

    private void addForeignKeyItems(String tableName, String createTableStatement, Map<String, List<String>> tableForeignKeysMap) {
        // Ищем в createTableStatement выражения, которые описывают внешние ключи
        Pattern pattern = Pattern.compile("FOREIGN KEY \\(`(\\w+)`\\) REFERENCES `(\\w+)` \\(`(\\w+)`\\)");
        Matcher matcher = pattern.matcher(createTableStatement);

        // Перебираем все найденные вхождения
        while (matcher.find()) {
            String columnName = matcher.group(1);
            String referencedTable = matcher.group(2);
            String referencedColumn = matcher.group(3);

            // Добавляем информацию о внешнем ключе в Map
            String foreignKeyInfo = referencedTable + "." + referencedColumn;
            tableForeignKeysMap.get(tableName).add(foreignKeyInfo);
        }
    }
}

