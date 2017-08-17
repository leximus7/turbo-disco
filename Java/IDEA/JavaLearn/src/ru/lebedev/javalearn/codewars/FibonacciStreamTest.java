package ru.lebedev.javalearn.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciStreamTest {
    @Test
    public void testFirstTwenty() {
        assertArrayEquals("The first 20 elements are incorrect",
                new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765},
                FibonacciStream.generateFibonacciSequence().limit(20).toArray()
                );
    }

}