package com.javarush.caesar.service;

import com.javarush.caesar.exception.CaesarException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileService {

    private static final String ENCODING = StandardCharsets.UTF_8.name();

    public String readFile(String filePath) throws CaesarException {
        //1) преобразовать путь в Path
        Path path = Paths.get(filePath);


        //2) проверить существование файла
        //3) проверить права на чтение
        //4) проверить содержимое
        //5) обработать IOException

        if (!Files.exists(path)) {
            throw new CaesarException("Файл не найден: " + filePath);
        }
        if (!Files.isReadable(path)) {
            throw new CaesarException("Отсутствуют права на запись: " + filePath);
        }

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
            return content.toString();
        } catch (IOException e) {
            throw new CaesarException("Ошибка чтения файла: " + filePath, e);
        }
    }

    public void writeFile(String content, String filePath) throws CaesarException {
        //1) преобразовать путь
        //2) создать родительские директории (* опционально)
        //3) записать содержимое с правильными опциями
        //4) обработать IOException

         Path path = Paths.get(filePath);
        Path parentDir = path.getParent();

        try {
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new CaesarException("Ошибка во время записи файла: " + filePath, e);
        }
    }

    public boolean fileExists (String filePath) {
         //Проверка существования файла
        return Files.exists(Paths.get(filePath));
    }

}