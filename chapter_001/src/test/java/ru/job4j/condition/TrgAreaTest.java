package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrgAreaTest {

    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 4);
    Point p3 = new Point(4, 0);
    Point p4 = new Point(0, 16);

    TrgArea trg1 = new TrgArea(p1, p2, p3);
    TrgArea trg2 = new TrgArea(p1, p2, p4);

    @Test
    public void existTrue() {
        double out = trg1.area();
        Assert.assertEquals(out, 8, 1e-6);
    }

    @Test
    public void existFalse() {
        double out = trg2.area();
        assertThat(out, is(-1.0));
    }
}
