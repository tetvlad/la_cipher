package com.javarush.caesar.core;

import com.javarush.caesar.exception.CaesarException;
import com.javarush.caesar.model.ProcessingResult;
import com.javarush.caesar.service.FileService;

public class CaesarProcessor {
    private final CaesarCoder coder;
    private final FileService fileService;

    public CaesarProcessor() {
        this.coder = new CaesarCoder();
        this.fileService = new FileService();
    }

    public ProcessingResult encryptFile(String inputPath, String outputPath, int shift) throws CaesarException {
        String content = fileService.readFile(inputPath);
        ProcessingResult result = coder.encryptText(content, shift);
        fileService.writeFile(result.getOutputPreview(), outputPath);
        return result;
    }

    public ProcessingResult decryptFile(String inputPath, String outputPath, int shift) throws CaesarException {
        String content = fileService.readFile(inputPath);
        ProcessingResult result = coder.decryptText(content, shift);
        fileService.writeFile(result.getOutputPreview(), outputPath);
        return result;
    }
}