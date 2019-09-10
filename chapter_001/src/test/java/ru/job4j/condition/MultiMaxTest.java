package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {

    private MultiMax check = new MultiMax();

    @Test
    public void whenSecondMax() {
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax(){
        int result = check.max(32, 12, 3);
        assertThat(result, is(32));
    }

    @Test
    public void whenTherdMax(){
        int result = check.max(3, 4, 7);
        assertThat(result, is(7));
    }

    @Test
    public void whenAllEquals(){
        int resulut = check.max(21, 21, 21);
        assertThat(resulut, is(21));
    }

}
