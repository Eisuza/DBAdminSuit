package com.ivs.dbadminsuite.config;

import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppConfig {
    private static final String CONFIG_FILE_NAME = "config.json";

    public static String getDbUrl() {
        JSONObject config = loadConfigFromFile();
        return config.getString("db_url");
    }

    public static String getDbUsername() {
        JSONObject config = loadConfigFromFile();
        return config.getString("db_username");
    }

    public static String getDbPassword() {
        JSONObject config = loadConfigFromFile();
        return config.getString("db_password");
    }

    public static void setDbUrl(String url) {
        JSONObject config = loadConfigFromFile();
        config.put("db_url", url);
        saveConfigToFile(config);
    }

    public static void setDbUsername(String login) {
        JSONObject config = loadConfigFromFile();
        config.put("db_username", login);
        saveConfigToFile(config);
    }

    public static void setDbPassword(String password) {
        JSONObject config = loadConfigFromFile();
        config.put("db_password", password);
        saveConfigToFile(config);
    }

    private static JSONObject loadConfigFromFile() {
        try {
            Path configFilePath = Paths.get(System.getProperty("user.dir")).resolve(CONFIG_FILE_NAME);
            if (Files.exists(configFilePath)) {
                String content = new String(Files.readAllBytes(configFilePath));
                return new JSONObject(content);
            } else {
                return new JSONObject();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки настроек.", "Во время загрузки настроек базы данных произошла ошибка: " + e.getMessage());
            return new JSONObject(); // В случае ошибки, возвращаем пустой JSON объект
        }
    }

    private static void saveConfigToFile(JSONObject config) {
        try {
            Path configFilePath = Paths.get(System.getProperty("user.dir")).resolve(CONFIG_FILE_NAME);
            FileWriter file = new FileWriter(configFilePath.toFile());
            file.write(config.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка сохранения настроек.", "Во время сохранения настроек базы данных произошла ошибка." + e.getMessage());
        }
    }
}