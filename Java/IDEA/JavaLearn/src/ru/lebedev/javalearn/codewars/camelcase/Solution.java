package ru.lebedev.javalearn.codewars.camelcase;

import java.lang.StringBuilder;
import java.util.regex.*;

class Solution{

    static String toCamelCase (String s) {
        StringBuffer sb = new StringBuffer();

        Matcher m = Pattern.compile("[_-](\\w)").matcher(s);

        while ( m.find() ) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }

        return m.appendTail(sb).toString();
    }


    static String toCamelCase_old(String s){
        StringBuilder sb = new StringBuilder(s);

        Pattern p = Pattern.compile("[^\\p{Alpha}]\\p{Alpha}");
        Matcher m = p.matcher(s);

        int replaced = 0;

        while (m.find()) {
            int start = m.start() - replaced;
            sb.replace(start, start + 2, sb.substring(start + 1, start + 2).toUpperCase());
            replaced++;
        }

        return sb.toString();
    }
}
