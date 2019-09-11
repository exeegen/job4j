package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        boolean b = data[0];
        for (int i = 1; i < data.length; i++) {
            if (!b == data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
