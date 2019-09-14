package ru.job4j.inheritance;

public class Tiger extends Predator{
    public Tiger(){
        super();
        System.out.println(Tiger.class.getSimpleName());
    }

    public static void main(String[] args) {
        new Tiger();
    }
}
