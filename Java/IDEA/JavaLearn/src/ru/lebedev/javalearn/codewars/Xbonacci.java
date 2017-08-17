package ru.lebedev.javalearn.codewars;

//   https://www.codewars.com/kata/tribonacci-sequence/train/java

import java.util.Arrays;
import java.util.stream.Stream;

public class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        double[] result = Arrays.copyOf(s, n);

        for(int i = 3; i < n; i++){
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
        return result;
    }


    public double[] xbonacci(double[] signature, int n) {
        int size = signature.length;
        double[] result = Arrays.copyOf(signature, n);

        for(int i = size; i < n; i++){
            result[i] = result[i-1];
            for(int j = 1; j < size; j++) {
                result[i] += result[i-j-1];
            }
        }
        return result;
    }
}
