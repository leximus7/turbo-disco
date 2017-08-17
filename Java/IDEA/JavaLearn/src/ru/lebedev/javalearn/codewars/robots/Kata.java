package ru.lebedev.javalearn.codewars.robots;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata
{
    public static String[] countRobots(String[] a)
    {
        int auto = 0, mech = 0;
        String body = "[\\|};&#\\[\\]/><\\()\\*]{2}";
        Pattern p = Pattern.compile("\\p{Alpha}" + body + "0" + body + "0" + body + "\\p{Alpha}");

        for (String item : a) {
             if( item.toLowerCase().contains("automatik") ) {
                 Matcher m = p.matcher(item);
                 while (m.find()) {
                     auto++;
                 }
            } else if ( item.toLowerCase().contains("mechanik") ) {
                 Matcher m = p.matcher(item);
                 while (m.find()) {
                     mech++;
                 }
             }
        }
        return new String[]{auto + " robots functioning automatik", mech + " robots dancing mechanik"};
    }
}
