package org.example;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        CLI cli = new CLI();
        if (args.length > 0) {
            try {
                runner.run(args);
            } catch (Exception e) {
                System.out.println("Warning: " + e.getMessage());
            }
        } else {
            cli.start();
        }
    }

}