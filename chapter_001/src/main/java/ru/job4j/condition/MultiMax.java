package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int m = first > second ? first : second;
        m = m > third ? m : third;
        return m;
    }
}
