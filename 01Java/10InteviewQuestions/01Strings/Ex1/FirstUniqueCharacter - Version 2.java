package com.mst.interview;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String str = "TTesst";
        int index = findUniqueCharsIndex(str);
        System.out.println("Index of the first unique character: " + index);
    }

    public static int findUniqueCharsIndex(String str) {
        if (str == null || str.isEmpty()) {
            return -1; // Handle edge case for null or empty string
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        
        // First pass: Count occurrences of each character
        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        // Second pass: Find the index of the first unique character
        for (int i = 0; i < str.length(); i++) {
            if (charCountMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // No unique character found
    }
}
