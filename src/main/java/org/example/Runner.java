package org.example;

import java.io.IOException;

public class Runner {
    public void run(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Формат: command filePath [key]");
        }

        String command = args[0].toUpperCase();
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        FileService fileService = new FileService();
        CaesarCipher caesarCipher = new CaesarCipher();

        String inputText = fileService.readFile(filePath);
        String outputText;
        String outputFilePath;


        switch (command) {
            case "ENCRYPT":
                outputText = caesarCipher.encryptText(inputText, key);
                outputFilePath = filePath.replace(".txt", "[ENCRYPTED].txt");
                break;

            case "DECRYPT":
                outputText = caesarCipher.decryptText(inputText, key);
                outputFilePath = filePath.replace(".txt", "[DECRYPTED].txt");
                break;

            default:
                throw new IllegalArgumentException("Невідома команда: " + command);
        }

        fileService.writeFile(outputFilePath, outputText);
        System.out.println("Результат записано у файл: " + outputFilePath);
    }
}
