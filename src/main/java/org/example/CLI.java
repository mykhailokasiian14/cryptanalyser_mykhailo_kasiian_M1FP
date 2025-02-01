package org.example;

import java.util.Scanner;

 class CLI {
     void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привіт мій друже! Що на цей раз будемо робити?\n" +
                "Доводжу до відома, цей код працює лише з англійським алфавітом");

        String command = promptCommand(scanner);
        String filePath = promptFilePath(scanner);
        int key = promptKey(scanner);

        Runner runner = new Runner();
        try {
            runner.run(new String[]{command, filePath, String.valueOf(key)});
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    private String promptCommand(Scanner scanner) {
        System.out.println("Введіть команду (ENCRYPT або DECRYPT):");
        String command = scanner.nextLine().toUpperCase();

        while (!command.equals("ENCRYPT") && !command.equals("DECRYPT")) {
            System.out.println("Невідома команда! Спробуйте ще раз:");
            command = scanner.nextLine().toUpperCase();
        }
        return command;
    }

    private String promptFilePath(Scanner scanner) {
        System.out.println("Введіть шлях до файлу:");
        return scanner.nextLine();
    }

    private int promptKey(Scanner scanner) {
        System.out.println("Введіть ключ (ціле число):");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ключ повинен бути цілим числом. Спробуйте ще раз:");
            }
        }
    }
}