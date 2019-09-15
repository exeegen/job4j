package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput {
    Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    public String ask(String str) {
        System.out.println(str);
        return scanner.nextLine();
    }
}
