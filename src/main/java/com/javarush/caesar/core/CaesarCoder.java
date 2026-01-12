package com.javarush.caesar.core;

import com.javarush.caesar.exception.CaesarException;
import com.javarush.caesar.model.ProcessingResult;
import com.javarush.caesar.service.ValidationService;

public class CaesarCoder {

    private final ValidationService validationService;

    public CaesarCoder() {
        this.validationService = new ValidationService();
    }

    public ProcessingResult encryptText(String text, int shift) throws CaesarException {
        validationService.validateTextForEncryption(text);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char encryptedChar = CaesarAlphabet.encryptChar(text.charAt(i), shift);
            result.append(encryptedChar);
        }

        String encrypted = result.toString();
        return new ProcessingResult(true, "Текст зашифрован",
                getPreview(text), getPreview(encrypted));
    }

    public ProcessingResult decryptText(String encryptedText, int shift) throws CaesarException {
        validationService.validateTextForDecryption(encryptedText);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char decryptedChar = CaesarAlphabet.decryptChar(encryptedText.charAt(i), shift);
            result.append(decryptedChar);
        }

        String decrypted = result.toString();
        return new ProcessingResult(true, "Текст дешифрован",
                getPreview(encryptedText), getPreview(decrypted));
    }

    public String getPreview(String text) {
        if (text == null) return "";
        if (text.length() <= 100) {
            return text;
        }
        return text.substring(0, 97) + "...";
    }
}