package ru.job4j.inheritance;

public class Animal {
    public Animal(){
        // вызов конструктора Object автоматически
        System.out.println(Animal.class.getSimpleName());
    }
}
