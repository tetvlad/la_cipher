package com.javarush.caesar.exception;

public class CaesarException extends Exception {
    // Проверяемые исключения
    public CaesarException(String message) {
        super(message);
    }

    // Непроверяемые исключения
    public CaesarException(String message, Throwable cause) {
        super(message, cause);
    }
}
