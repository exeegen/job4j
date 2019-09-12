package ru.job4j.sort;

import java.util.Arrays;

/**
 * sorting arrays merging.
 */
public class Merge {
    /**
     * very important method...
     *
     * @param left
     * @param right
     * @return
     */
    public int[] merge(int[] left, int[] right) {

        int[] rsl = new int[left.length + right.length];

        if (left.length == 0 && right.length == 0) {
            return rsl;
        }
        if (left.length == 0) {
            return Arrays.copyOf(right, right.length);
        }
        if (right.length == 0) {
            return Arrays.copyOf(left, left.length);
        }


        int indL = 0, indR = 0;
        while (indL < left.length && indR < right.length) {
            if (left[indL] < right[indR]) {
                rsl[indL + indR] = left[indL];
                indL++;
            } else {
                rsl[indL + indR] = right[indR];
                indR++;
            }
        }
        while (indL < left.length) {
            rsl[indL + indR] = left[indL];
            indL++;
        }
        while (indR < right.length) {
            rsl[indL + indR] = right[indR];
            indR++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
