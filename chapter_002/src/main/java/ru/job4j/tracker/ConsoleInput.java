package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String str) {
        System.out.println(str);
        return scanner.nextLine();
    }

    public int ask(String question, List<Integer> range){
        int key = Integer.valueOf(this.ask(question));
        if(range.contains(key)){
            return key;
        }
        else throw new MenuOutException("Введите пункт меню в диапазоне 0 - " + (range.size()-1) + " : ");
    }
}
