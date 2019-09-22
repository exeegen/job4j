package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input){
        this.input = input;
    }

    @Override
    public String ask(String question){
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, List<Integer> range){
        while (true){
            try{
                return this.input.ask(question, range);
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
