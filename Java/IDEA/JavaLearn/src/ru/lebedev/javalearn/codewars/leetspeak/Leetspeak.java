package ru.lebedev.javalearn.codewars.leetspeak;

import java.util.regex.*;

public class Leetspeak extends Encoder {

    public String encode(String source){

        if (source == null) return "";

        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("[aelmouAELMOU]").matcher(source);

        while ( m.find() ) {
            m.appendReplacement(sb, Matcher.quoteReplacement(encodeLetter(m.group().toLowerCase() )));
        }

        m.appendTail(sb);

        return sb.toString();
    }

    private String encodeLetter(String s) {
        if (s.equals("a")) return "4";
        if (s.equals("e")) return "3";
        if (s.equals("l")) return "1";
        if (s.equals("m")) return "/^^\\";
        if (s.equals("o")) return "0";
        if (s.equals("u")) return "(_)";
        throw  new IllegalArgumentException();
    }

}

abstract class Encoder{
    public abstract String encode(String source);
}
