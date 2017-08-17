package ru.lebedev.javalearn.codewars;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Decoder {
    public int[] uncompress(final String music) {
        return Arrays.stream(music.split(","))
                .flatMapToInt(Decoder::mapToStream)
                .toArray();
    }

    private static IntStream mapToStream (String s) {
        s = s.trim();
        int[] numbers = Arrays.stream(s.split("(?<=\\d)[-*/]"))
                .filter(x -> (x.length() > 0))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (Pattern.matches("-?\\d+\\*\\d+", s)) {
            return IntStream.generate(() -> numbers[0])
                    .limit(numbers[1]);
        }  else if (Pattern.matches("-?\\d+--?\\d+(/\\d+)?", s)) {
            int interval = ((numbers.length == 3) ? numbers[2] : 1) * Integer.signum(numbers[1] - numbers[0]);
            return IntStream.iterate(numbers[0], x -> x + interval)
                    .limit((numbers[1] - numbers[0]) / interval + 1);
        } else if (Pattern.matches("\\d+", s)) {
            return IntStream.of(numbers[0]);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
