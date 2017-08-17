package ru.lebedev.javalearn.codewars.simplexer;

//     https://www.codewars.com/kata/simplexer/train/java

import java.util.Iterator;
import java.util.regex.*;

public class Simplexer
        implements Iterator<Token> {

    private String buffer = "";
    private int index = 0;

    private final static String[] types = new String[]{"whitespace", "boolean", "integer", "keyword",
                                                    "string", "operator", "identifier"};
    private final static String whitespace = "(?<whitespace>\\s+)";
    private final static String bool  = "(?<boolean>(true|false))";
    private final static String integer = "(?<integer>\\d+)";
    private final static String keyword = "(?<keyword>(if|else|for|while|return|func|break))";
    private final static String string  = "(?<string>\"[^\"]*\")";
    private final static String operator = "(?<operator>[+\\-*/%\\()=])";
    private final static String identifier  = "(?<identifier>[\\w$&&\\D][\\w$]*)";
    private final static String regex = "(" + whitespace + "|" + bool + "|" +
            integer + "|" + keyword + "|" + string + "|" + operator + "|" +
            identifier + ")";

    public Simplexer(String buffer) {
        this.buffer = buffer;
    }

    @Override
    public boolean hasNext() {
        if (buffer == null) { return false; }

        if (index < buffer.length()){
            return true;
        } else {
        return false;
        }
    }

    @Override
    public Token next() {

        Matcher m = Pattern.compile(regex).matcher(buffer);

        m.find(index);
        index = m.end();

        for (String type : types) {
            if (m.group(type) != null) {
                return new Token(m.group(type), type);
            }
        }

        throw new IllegalArgumentException(m.group());
    }

}
