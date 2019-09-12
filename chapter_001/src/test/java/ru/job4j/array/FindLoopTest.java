package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrays8Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{3, 6, 3, 8, 32, 54};
        int value = 8;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrays25ThenFalse() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{3, 6, 3, 8, 32, 54};
        int value = 25;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }


    @Test
    public void whenSort5() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{3, 4, 1, 2, 5};
        int[] result = find.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort3() {
        FindLoop find = new FindLoop();
        int[] input = new int[]{3, 4, 0};
        int[] result = find.sort(input);
        int[] expect = new int[]{0, 3, 4};
        assertThat(result, is(expect));
    }
}
