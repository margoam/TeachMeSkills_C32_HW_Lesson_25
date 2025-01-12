package com.teachmeskills.hw.lesson_25.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final Path INFO_LOG_PATH = Paths.get("C:\\Users\\mozhe\\IdeaProjects\\TeachMeSkills_C32_HW_Lesson_25\\tms.lesson_25\\src\\main\\resources\\logs.txt");

    public static void log(String message) {
        String formattedDate = SIMPLE_DATE_FORMAT.format(new Date());
        String logMessage = "[INFO] " + formattedDate + " -> " + message;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INFO_LOG_PATH.toFile(), true))) {
            writer.write(logMessage);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Failed to write to log file (" + INFO_LOG_PATH + "): " + e.getMessage());
        }
    }
}
