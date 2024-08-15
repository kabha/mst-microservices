package com.mst.interview;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		String str = "TTesst";
		System.out.println(findUniqueCharsIndex(str));
	}

	public static int findUniqueCharsIndex(String str) {
		char[] arrChar = str.toCharArray();
		Map<Character, Integer> instanceMap = new HashMap<Character, Integer>();
		int count = 0;
		for (int i = 0; i < arrChar.length; i++) {
			if (!instanceMap.containsKey(arrChar[i])) {
				instanceMap.put(arrChar[i], 0);
			}
			count = instanceMap.get(arrChar[i]) + 1;
			instanceMap.replace(arrChar[i], count);
		}
		for (int i = 0; i < arrChar.length; i++) {
			if (instanceMap.get(arrChar[i]) == 1) {
				return i;
			}
		}
		return -1;
	}

}
