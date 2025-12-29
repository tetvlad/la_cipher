package com.javarush.caesar.service;

import com.javarush.caesar.core.CaesarAlphabet;
import com.javarush.caesar.exception.CaesarException;

import java.util.Locale;

public class ValidationService {

    public void validateTextForEncryption(String text) throws CaesarException {
        if (text == null || text.trim().isEmpty()) {
            throw new CaesarException("Текст для шифрования не может быть пустым");
        }

        String upperText = text.toUpperCase(Locale.ROOT);
        for (int i = 0; i < upperText.length(); i++) {
            char c = upperText.charAt(i);
            if (!Character.isWhitespace(c) && !CaesarAlphabet.isSupportedChar(c)) {
                throw new CaesarException(String.format("Неподдерживаемый символ '%c' в позиции %d", c, (i + 1)));
            }
        }
    }
    public void validateTextForDecryption(String text) throws CaesarException {
        validateTextForEncryption(text);
    }
}