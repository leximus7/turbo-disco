package ru.lebedev.javalearn.codewars;

public class MorseCode {
    public static String get(String code) {

        if (code.equals(".-")) {
            return "A";
        } else if (code.equals("-...")) {
            return "B";
        } else return "R";

    }
}
