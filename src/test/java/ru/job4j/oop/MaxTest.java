package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMaxFromTwoThenFive() {
        Max calc = new Max();
        int result = calc.max(1, 5);
        int expected = 5;
        assertEquals(expected, result);
    }

    @Test
    public void whenMaxFromThreeThen() {
        Max calc = new Max();
        int result = calc.max(6, 3, 2);
        int expected = 6;
        assertEquals(expected, result);
    }

    @Test
    public void whenMaxFromFourThen() {
        Max calc = new Max();
        int result = calc.max(6, 3, 2, 7);
        int expected = 7;
        assertEquals(expected, result);
    }
}