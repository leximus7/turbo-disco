package ru.lebedev.javalearn.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test
    public void testSomething() {
        for(int i = 0; i<10; i++){
            double a = Math.random();
            double b = Math.random();

            assertEquals(a + " * " + b, a*b, Multiply.multiply(a,b), 1.0e-14);        }

        // assertEquals("expected", "actual");
    }
}
