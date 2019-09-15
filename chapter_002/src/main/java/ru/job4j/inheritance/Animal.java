package ru.job4j.inheritance;

public class Animal {

    String name;

    public Animal(){
        // вызов конструктора Object автоматически
        System.out.println(Animal.class.getSimpleName());
    }

    public Animal(String name){
        this.name = name;
    }
}
