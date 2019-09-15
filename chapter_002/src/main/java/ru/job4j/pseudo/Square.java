package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        return new StringBuilder()
                .append("+++++++")
                .append(System.lineSeparator())
                .append("+     +")
                .append(System.lineSeparator())
                .append("+     +")
                .append(System.lineSeparator())
                .append("+++++++")
                .toString();
    }
}
