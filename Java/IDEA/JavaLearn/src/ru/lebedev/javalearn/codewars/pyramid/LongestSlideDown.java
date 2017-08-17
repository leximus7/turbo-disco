package ru.lebedev.javalearn.codewars.pyramid;

import java.util.Arrays;
import java.util.stream.Stream;

public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {

        int[][] sum = new int[pyramid.length][];

        for (int i = 0; i < pyramid.length; i++) {
            sum[i] = Arrays.copyOf(pyramid[i], pyramid[i].length);
        }

        for (int i = 1; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                if (j == 0) {
                    sum[i][j] += sum[i-1][j];
                } else if (j == sum[i].length - 1) {
                    sum[i][j] += sum[i-1][j-1];
                } else if (sum[i-1][j] > sum[i-1][j-1]){
                    sum[i][j] += sum[i-1][j];
                } else {
                    sum[i][j] += sum[i-1][j-1];
                }
            }
        }

        return Arrays.stream(sum[sum.length - 1])
                .max()
                .getAsInt();

    }
}
