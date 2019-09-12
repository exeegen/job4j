package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = start; i <= finish; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            for (int j = i + 1; j < data.length; j++) {
                if (min > data[j]) {
                    min = data[j];
                }
            }
            int ind = indexOf(data, min, i, data.length);
            int b = data[i];
            data[i] = data[ind];
            data[ind] = b;
        }
        return data;
    }
}
