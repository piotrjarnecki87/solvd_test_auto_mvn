package com.solvd.course.hm.project.it.company.exceptions.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionLogger {

    private static final String LOG_FILE_PATH = "log.txt";
    public static void logException(Exception exception) {
        logExceptionToConsole(exception);
        logExceptionToFile(exception);
    }
    private static void logExceptionToConsole(Exception exception) {
        System.err.println("Exception caught: " + exception.getMessage());
        exception.printStackTrace(System.err);
    }

    public static void logExceptionToFile(Exception exception) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Exception caught: " + exception.getMessage());
            exception.printStackTrace(printWriter);

        } catch (IOException e) {
            System.err.println("IOException caught while logging exception: " + e.getMessage());
            e.printStackTrace(System.err);
        } catch (Exception e) {
            System.err.println("Exception caught while logging exception: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}