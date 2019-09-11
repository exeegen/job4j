package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;
        while (amount > 0) {
            amount = (int) (amount * percent / 100 + amount - salary*12);
            year++;
        }
        return year;
    }

    public static void main(String[] args) {
        Mortgage m = new Mortgage();
        System.out.println(m.year(100, 70, 50));
    }
}
