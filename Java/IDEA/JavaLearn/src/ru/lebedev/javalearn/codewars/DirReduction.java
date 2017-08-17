package ru.lebedev.javalearn.codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

        int size = list.size();
        int i = 0;
        while(i < (size -1) ){
            i = reduct(list, i);
            size = list.size();
        }
        return list.toArray(new String[size]);
    }

    private static int reduct(ArrayList<String> list, int i) {
        if (checkReduction(list.get(i), list.get(i+1))){
            list.remove(i);
            list.remove(i);
            if (i == 0) {
                return i;
            } else return --i;
        } else
        return ++i;
    }


    private static boolean checkReduction(String s1, String s2) {
        if (s1 == "NORTH" && s2 == "SOUTH")      return true;
        else if (s1 == "SOUTH" && s2 == "NORTH") return true;
        else if (s1 == "WEST" && s2 == "EAST")   return true;
        else if (s1 == "EAST" && s2 == "WEST")   return true;
        else return false;
    }

}
