package ru.job4j.tracker;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, List<Integer> range){
        while (true){
            try{
                return super.ask(question, range);
            }
            catch (MenuOutException e){
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("Введите корректное значение");
            }
        }
    }
}
