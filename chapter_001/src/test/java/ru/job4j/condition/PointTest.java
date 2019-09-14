package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import java.nio.channels.Pipe;

public class PointTest {

    @Test
    public void distance1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        double expected = 2;
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 1e-6);
    }

    @Test
    public void distance2() {
        Point p1 = new Point(6, -8);
        Point p2 = new Point(5, 6);
        double expected = 14.035668;
        double out = p1.distance(p2);
        Assert.assertEquals(expected, out, 1e-6);
    }
}
