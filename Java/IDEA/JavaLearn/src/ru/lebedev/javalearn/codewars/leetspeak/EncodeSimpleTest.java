package ru.lebedev.javalearn.codewars.leetspeak;

import static org.junit.Assert.*;
import org.junit.Test;

public class EncodeSimpleTest {

    Leetspeak myEncoder = new Leetspeak();

    @Test
    public void simpleTest(){
        assertTrue("empty string", myEncoder.encode("").equals(""));
        assertTrue("abcdef string", myEncoder.encode("abcdef").equals("4bcd3f"));
    }

    @Test
    public void simpleTest2(){
        assertTrue("LemOn string", myEncoder.encode("LemOn").equals("13/^^\\0n"));
    }
}