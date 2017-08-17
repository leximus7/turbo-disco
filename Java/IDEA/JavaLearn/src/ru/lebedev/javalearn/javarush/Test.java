package ru.lebedev.javalearn.javarush;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        int v = 2;
        shift(v,5);
        System.out.println(v);

    }

    public static int shift(int value, int offset)
    {
        value += offset;
        return value;
    }


}
