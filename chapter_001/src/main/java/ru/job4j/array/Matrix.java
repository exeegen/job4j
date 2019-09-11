package ru.job4j.array;

import java.util.Arrays;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i+1)*(j+1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        int[][] arr = m.multiple(9);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
