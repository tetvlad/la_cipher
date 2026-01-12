package com.javarush.caesar.core;

public class CaesarAlphabet {

    public static final String RUSSIAN_UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String RUSSIAN_LOWER = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static char encryptChar(char c, int shift) {
        if (RUSSIAN_UPPER.indexOf(c) >= 0) {
            int index = RUSSIAN_UPPER.indexOf(c);
            return RUSSIAN_UPPER.charAt((index + shift) % RUSSIAN_UPPER.length());
        }
        if (RUSSIAN_LOWER.indexOf(c) >= 0) {
            int index = RUSSIAN_LOWER.indexOf(c);
            return RUSSIAN_LOWER.charAt((index + shift) % RUSSIAN_LOWER.length());
        }
        return c;
    }

    public static char decryptChar(char c, int shift) {
        if (RUSSIAN_UPPER.indexOf(c) >= 0) {
            int index = RUSSIAN_UPPER.indexOf(c);
            return RUSSIAN_UPPER.charAt((index - shift + RUSSIAN_UPPER.length()) % RUSSIAN_UPPER.length());
        }
        if (RUSSIAN_LOWER.indexOf(c) >= 0) {
            int index = RUSSIAN_LOWER.indexOf(c);
            return RUSSIAN_LOWER.charAt((index - shift + RUSSIAN_LOWER.length()) % RUSSIAN_LOWER.length());
        }
        return c;
    }

    public static boolean isSupportedChar(char c) {
        return (RUSSIAN_UPPER.indexOf(c) >= 0) ||
                (RUSSIAN_LOWER.indexOf(c) >= 0) ||
                Character.isWhitespace(c) ||
                ",.?!-:;()".indexOf(c) >= 0;
    }
    private CaesarAlphabet() {
    }
}