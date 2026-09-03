package com.art5019.art5019s_injustice.helper;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class TextHelper {
    public static final HashMap<Integer, String> romanNumerals = new
            HashMap<>(Map.ofEntries(entry(1,"I"),entry(2,"II"),entry(3,"III"),entry(4,"IV")
            ,entry(5,"V"),entry(6,"VI"),entry(7,"VII"),entry(8,"VII"),entry(9,"IX"),
            entry(10,"X")

    ));
    /**
     * Capped from 1 to 10
     * @param n
     * @return
     */
    public static String toRomanNumeral(int n) {
        if(romanNumerals.containsKey(n)) {
            System.out.println(n + " " + romanNumerals.get(n));
            return romanNumerals.get(n);
        }
        return "?";
    }
}
