package ru.job4j.inheritance;

public class Tiger extends Predator{
    public Tiger(String name){
        super(name);
        System.out.println(Tiger.class.getSimpleName());
    }

    public static void main(String[] args) {
        new Tiger("Tigra");
    }
}
