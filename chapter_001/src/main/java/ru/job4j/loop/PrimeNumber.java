package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = finish-1;
        for (int i = 2; i <= finish; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count--;
                    break;
                }
            }

        }
        return count;
    }
}
