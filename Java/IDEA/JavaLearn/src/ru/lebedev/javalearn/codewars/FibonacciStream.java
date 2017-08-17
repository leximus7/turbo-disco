package ru.lebedev.javalearn.codewars;

//   https://www.codewars.com/kata/fibonacci-streaming/train/java

import javafx.util.Pair;

import java.util.stream.*;

public class FibonacciStream {
    public static IntStream generateFibonacciSequence() {

        return Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .mapToInt(x -> x[1]);
    }
}