package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenDistanceThen2Pont82() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 2);
        double result = a.distance(b);
        double expected = 2.82;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenDistance3dThen3Point46() {
        Point a = new Point(0, 0, 1);
        Point b = new Point(2, 2, 3);
        double result = a.distance3d(b);
        double expected = 3.46;
        assertEquals(expected, result, 0.01);
    }
}