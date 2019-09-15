package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax2To1Then2() {
        int result = Max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenMaxEquals() {
        int result = Max.max(10, 10);
        assertThat(result, is(10));
    }

    @Test
    public void maxForThree() {
        assertThat(Max.max(3, 7, 10), is(10));
    }

    @Test
    public void maxForThreeEqu() {
        assertThat(Max.max(12, 12, 12), is(12));
    }

    @Test
    public void maxForFour() {
        assertThat(Max.max(3, 6, 43, 5), is(43));
    }

    @Test
    public void maxForFourEqu() {
        assertThat(Max.max(5, 5, 5, 5), is(5));
    }

}