package com.javarush.caesar;

import com.javarush.caesar.core.CaesarAlphabet;
import com.javarush.caesar.core.CaesarProcessor;
import com.javarush.caesar.exception.CaesarException;
import com.javarush.caesar.model.ProcessingResult;

import java.util.Scanner;

public class CaesarApp {

    private final CaesarProcessor processor;
    private final Scanner scanner;

    public CaesarApp() {
        this.processor = new CaesarProcessor();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        CaesarApp app = new CaesarApp();
        app.run();
    }

    public void run() {
        printWelcomeMessage();

        while (true) {
            showMainMenu();
            String choice = scanner.nextLine();

            switch (choice.trim()) {
                case "1":
                    processEncryptFile();
                    break;
                case "2":
                    processDecryptFile();
                    break;
                case "3":
                    showCaesarInfo();
                    break;
                case "0":
                    System.out.println("\nДо свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("ШИФР ЦЕЗАРЯ v.1.0");
        System.out.println("Профессиональный шифратор-дешифратор");
        System.out.println("Сдвиг по умолчанию: 3");
        System.out.println("=".repeat(50));
    }

    private void showMainMenu() {
        System.out.println("\nГЛАВНОЕ МЕНЮ: ");
        System.out.println("1. Зашифровать файл (текст → Цезарь)");
        System.out.println("2. Дешифровать файл (Цезарь → текст)");
        System.out.println("3. Справка по шифру Цезаря");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private void processEncryptFile() {
        System.out.print("Введите сдвиг (Enter=по умолчанию 3): ");
        String shiftInput = scanner.nextLine().trim();
        int shift = 3; // значение по умолчанию

        if (!shiftInput.isEmpty()) {
            try {
                shift = Integer.parseInt(shiftInput);
            } catch (NumberFormatException e) {
                System.out.println("Неверный сдвиг, используется 3");
            }
        }

        System.out.println("\nШифрование файла (сдвиг=" + shift + "):");
        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();

            ProcessingResult result = processor.encryptFile(inputFile, outputFile, shift);
            displaySuccessResult(result, inputFile, outputFile);
        } catch (CaesarException e) {
            displayError(e.getMessage());
        }
    }

    private void processDecryptFile() {
        System.out.print("Введите сдвиг (Enter=по умолчанию 3): ");
        String shiftInput = scanner.nextLine().trim();
        int shift = 3; // значение по умолчанию

        if (!shiftInput.isEmpty()) {
            try {
                shift = Integer.parseInt(shiftInput);
            } catch (NumberFormatException e) {
                System.out.println("Неверный сдвиг, используется 3");
            }
        }

        System.out.println("\nДешифрование файла (сдвиг=" + shift + "):");
        try {
            String inputFile = getInputFilePath();
            String outputFile = getOutputFilePath();

            ProcessingResult result = processor.decryptFile(inputFile, outputFile, shift);
            displaySuccessResult(result, inputFile, outputFile);
        } catch (CaesarException e) {
            displayError(e.getMessage());
        }
    }

    private String getInputFilePath() {
        System.out.print("Введите путь к файлу: ");
        return scanner.nextLine().trim();
    }

    private String getOutputFilePath() {
        System.out.print("Введите путь для создания файла: ");
        return scanner.nextLine().trim();
    }

    private void displaySuccessResult(ProcessingResult result, String inputFile, String outputFile) {
        System.out.println("\n✓ " + result.getMessage());
        System.out.println("Путь исходного файла: " + inputFile);
        System.out.println("Результат шифрования записан: " + outputFile);

        System.out.println("\nРезультат работы преобразования:");
        System.out.println("Данные на входе:  " + result.getInputPreview());
        System.out.println("Данные на выходе: " + result.getOutputPreview());
        System.out.println();
    }

    private void displayError(String message) {
        System.out.println("\n Ошибка: " + message + "\n");
    }

    private void showCaesarInfo() {
        System.out.println("\nШИФР ЦЕЗАРЯ");
        System.out.println("────────────────");
        System.out.println("• Сдвиг по умолчанию: 3 (можно изменить в меню)");
        System.out.println("• Русский алфавит: 33 буквы");
        System.out.println("• Пример: 'ДЖАВАРАШ' → 'ИЛГЕСБКУ' (сдвиг=5)");
        System.out.println("• Пробелы и знаки препинания сохраняются");

        System.out.println("\nДля возврата в меню нажмите ввод ...");
        scanner.nextLine();
    }
}