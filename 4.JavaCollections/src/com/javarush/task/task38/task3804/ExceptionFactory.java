package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Object exceptionType) {
        if (exceptionType == null) return new IllegalArgumentException();

        StringBuilder message = null;
        if (exceptionType instanceof ExceptionApplicationMessage ||
                exceptionType instanceof ExceptionDBMessage ||
                exceptionType instanceof ExceptionUserMessage) {
            message = new StringBuilder(exceptionType.toString().replaceAll("_", " ").toLowerCase());
            StringBuilder sb = message.replace(0, 1, message.substring(0, 1).toUpperCase());
        }
        if (exceptionType instanceof ExceptionApplicationMessage) {
            return new Exception(message.toString());
        } else if (exceptionType instanceof ExceptionDBMessage) {
            return new RuntimeException(message.toString());
        } else if (exceptionType instanceof ExceptionUserMessage) {
            return new Error(message.toString());
        } else return new IllegalArgumentException();
    }
}
