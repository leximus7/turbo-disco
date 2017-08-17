package ru.lebedev.javalearn.codewars;
// https://www.codewars.com/kata/find-fibonacci-last-digit/train/java

import java.util.stream.*;

public class FibonacciLastDigit {
        public static int getFibNumb(int n) {
            int a = 1, b = 0;
            int i = 1;
            int c = 0;
            int sum;

            while (i < n) {
                 c = a;
                 //a = (a + b) % 10;
                sum = a+b;
                a = (sum < 10) ? sum : (sum - 10);
                 b = c;
                 i++;
            }

            return a;

//            return Stream.iterate(new int[] {0, 1}, x -> new int[] {x[1], (x[0] + x[1]) % 10})
//                    .skip(n)
//                    .findFirst()
//                    .get()[0];
        }
}
