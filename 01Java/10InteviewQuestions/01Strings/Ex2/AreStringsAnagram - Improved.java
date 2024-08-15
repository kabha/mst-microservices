package com.mst.interview;

import java.util.HashMap;
import java.util.Map;

public class AreStringsAnagram {

    public static void main(String[] args) {
        String name1 = "Dawod";
        String name2 = "woadD";

        System.out.println(isAnagram(name1, name2));
    }

    public static boolean isAnagram(String str1, String str2) {
        // Check if the lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create maps to store the frequency of characters
        Map<Character, Integer> charCountMap1 = buildCharCountMap(str1);
        Map<Character, Integer> charCountMap2 = buildCharCountMap(str2);

        // Compare the two maps
        return charCountMap1.equals(charCountMap2);
    }

    private static Map<Character, Integer> buildCharCountMap(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }
}
