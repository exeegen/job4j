package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int k = array[i];
            array[i] = array[j];
            array[j] = k;
        }
        return array;
    }
}
