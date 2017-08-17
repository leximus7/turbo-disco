package ru.lebedev.javalearn.codewars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class XbonacciTest {
    private Xbonacci variabonacci;

    @Before
    public void setUp() {
        variabonacci = new Xbonacci();
    }

    @Test
    public void testFirst(){
        assertArrayEquals(new double[]{1}, variabonacci.tribonacci(new double[]{1,1,1}, 1), 1e-10);
    }

    @Test
    public void basicTribonacciTests() {
        assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, variabonacci.tribonacci(new double []{1,1,1},10), 1e-10);
        assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, variabonacci.tribonacci(new double []{0,0,1},10), 1e-10);
        assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, variabonacci.tribonacci(new double []{0,1,1},10), 1e-10);
    }

    @Test
    public void basicXbonacciTests() {
        assertArrayEquals(new double []{0,1,1,2,3,5,8,13,21,34}, variabonacci.xbonacci(new double []{0,1},10), 1e-10);
        assertArrayEquals(new double []{1,1,2,3,5,8,13,21,34,55}, variabonacci.xbonacci(new double []{1,1},10), 1e-10);
        assertArrayEquals(new double []{0,0,0,0,1,1,2,4,8,16}, variabonacci.xbonacci(new double []{0,0,0,0,1},10), 1e-10);
        assertArrayEquals(new double []{1,0,0,0,0,0,1,2,3,6}, variabonacci.xbonacci(new double []{1,0,0,0,0,0,1},10), 1e-10);
    }

}