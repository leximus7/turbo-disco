package ru.lebedev.javalearn.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSumThreeFive {
    @Test
    public void testTen(){
        assertEquals(23, new SumThreeFive().solution(10));
    }
}
