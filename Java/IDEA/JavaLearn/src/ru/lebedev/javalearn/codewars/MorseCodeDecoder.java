package ru.lebedev.javalearn.codewars;

//  https://www.codewars.com/kata/decode-the-morse-code/train/java

import java.util.Scanner;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {

        StringBuilder result = new StringBuilder();

        for(String word : morseCode.trim().split("   ")){
            for(String letter : word.split(" ")){
                result.append(MorseCode.get(letter));
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
