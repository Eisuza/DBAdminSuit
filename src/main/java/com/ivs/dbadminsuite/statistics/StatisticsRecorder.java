package com.ivs.dbadminsuite.statistics;

import com.ivs.dbadminsuite.errorhandler.ErrorHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class StatisticsRecorder {
    private static final String fileName = "DBstatistics.txt";

    public void updateStatistics(String query, long executionTime, boolean success) {

        String queryCondition = success ? "Success" : "Error";
        String statisticsEntry = String.format("Query: %s, Execution Time: %d ms, Result: %s%n", query, executionTime, queryCondition);

        try {
            Path jarDir = getJarDir();
            String filePath = jarDir.resolve(fileName).toString();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(statisticsEntry);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка обновления статистики.", "Во время добавления информации произошла ошибка." + e.getMessage());
        }
    }

    private Path getJarDir() throws IOException {
        try {
            ProtectionDomain protectionDomain = getClass().getProtectionDomain();
            CodeSource codeSource = protectionDomain.getCodeSource();
            if (codeSource != null) {
                Path jarPath = Paths.get(codeSource.getLocation().toURI());
                if (jarPath.endsWith(".jar")) {
                    return jarPath.getParent();
                }
            }
        } catch (URISyntaxException e) {
            //e.printStackTrace();
            ErrorHandler.showError("Ошибка получения пути.", "Во время определения пути к файлу статистики произошла ошибка." + e.getMessage());
        }
        return Paths.get(System.getProperty("user.dir"));
    }
}




