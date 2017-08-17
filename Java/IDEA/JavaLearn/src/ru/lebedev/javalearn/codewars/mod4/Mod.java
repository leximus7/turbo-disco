package ru.lebedev.javalearn.codewars.mod4;

//      https://www.codewars.com/kata/mod4-regex/train/java

import java.util.regex.Pattern;

public class Mod {
    public static Pattern mod4 = Pattern.compile("\\[[+\\-]?((\\d*(([02468][048])|([13579][26])))|[048])\\]");
}
