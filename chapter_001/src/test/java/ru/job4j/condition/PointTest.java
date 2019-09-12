package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance1() {
        int x1 = 0, x2 = 2, y1 = 0, y2 = 0;
        double expected = 2;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 1e-6);
    }

    @Test
    public void distance2() {
        int x1 = 6, x2 = 5, y1 = -8, y2 = 6;
        double expected = 14.035668;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 1e-6);
    }
}
