package com.javarush.caesar.model;

public class ProcessingResult {

    private final boolean success;  // Успешное выполнение операции
    private final String message;   // Сообщение для пользователя
    private final String inputPreview;  // Что на входе
    private final String outputPreview; // Что на выходе

    public ProcessingResult(boolean success, String message, String inputPreview, String outputPreview) {
        this.success = success;
        this.message = message;
        this.inputPreview = inputPreview;
        this.outputPreview = outputPreview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingResult that = (ProcessingResult) o;
        return success == that.success &&
                java.util.Objects.equals(message, that.message) &&
                java.util.Objects.equals(inputPreview, that.inputPreview) &&
                java.util.Objects.equals(outputPreview, that.outputPreview);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(success, message, inputPreview, outputPreview);
    }

    @Override
    public String toString() {
        return "ProcessingResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", inputPreview='" + inputPreview + '\'' +
                ", outputPreview='" + outputPreview + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getInputPreview() {
        return inputPreview;
    }

    public String getOutputPreview() {
        return outputPreview;
    }
}
