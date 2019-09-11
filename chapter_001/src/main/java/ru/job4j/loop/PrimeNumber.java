package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        CheckPrimeNumber check = new CheckPrimeNumber();
        int count = 0;
        for (int i = 2; i <= finish; i++) {
            if(check.check(i))
                count++;
        }
        return count;
    }
}
