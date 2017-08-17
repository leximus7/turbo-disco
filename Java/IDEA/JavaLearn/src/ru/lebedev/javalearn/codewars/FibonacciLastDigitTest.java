package ru.lebedev.javalearn.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciLastDigitTest {

    @Test
    public void testFirst() {
        assertEquals(1, FibonacciLastDigit.getFibNumb(1));

    }

    @Test
    public void testTwo() {
        assertEquals(1, FibonacciLastDigit.getFibNumb(2));

    }

    @Test
    public void testFive() {
        assertEquals(5, FibonacciLastDigit.getFibNumb(5));

    }

    @Test
    public void example1(){
        assertEquals(FibonacciLastDigit.getFibNumb(193150), 5);
    }


    @Test
    public void example2(){
        assertEquals(FibonacciLastDigit.getFibNumb(300), 0);
    }

    @Test
    public void example3(){
        assertEquals(FibonacciLastDigit.getFibNumb(20001), 6);
    }

    @Test public void basicTests() {
        assertEquals("For n = 1", 1, FibonacciLastDigit.getFibNumb(1));
        assertEquals("For n = 21", 6, FibonacciLastDigit.getFibNumb(21));
        assertEquals("For n = 302", 1, FibonacciLastDigit.getFibNumb(302));
        assertEquals("For n = 4003", 7, FibonacciLastDigit.getFibNumb(4003));
        assertEquals("For n = 50004", 8, FibonacciLastDigit.getFibNumb(50004));
        assertEquals("For n = 600005", 5, FibonacciLastDigit.getFibNumb(600005));
        assertEquals("For n = 7000006", 3, FibonacciLastDigit.getFibNumb(7000006));
        assertEquals("For n = 80000007", 8, FibonacciLastDigit.getFibNumb(80000007));
        assertEquals("For n = 900000008", 1, FibonacciLastDigit.getFibNumb(900000008));
        assertEquals("For n = 1000000009", 9, FibonacciLastDigit.getFibNumb(1000000009));
    }

}