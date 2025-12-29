package com.javarush.caesar.exception;
// Непроверяемые исключения
public class CaesarRunTimeException extends RuntimeException {
    public CaesarRunTimeException(String message) {
        super(message);
    }
}
