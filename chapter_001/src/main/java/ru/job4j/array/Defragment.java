package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        for (int index = 0, j = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell == null) {
                j = index;
                while (j < array.length) {
                    if (array[++j] != null) {
                        array[index] = array[j];
                        array[j] = null;
                        break;
                    }

                }
            }
            System.out.print(array[index] + " ");
            if (j == array.length-1) break;
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}
