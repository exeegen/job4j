package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void max1(){
        assertThat(SqMax.max(9, 6, 3, 1), is(9));
    }

    @Test
    public void max2(){
        assertThat(SqMax.max(9, 15, 3, 1), is(15));
    }

    @Test
    public void max3(){
        assertThat(SqMax.max(9, 6, 31, 1), is(31));
    }

    @Test
    public void max4(){
        assertThat(SqMax.max(9, 6, 3, 11), is(11));
    }

    @Test
    public void maxEquls(){
        assertThat(SqMax.max(5, 5, 5, 5), is(5));
    }
}
