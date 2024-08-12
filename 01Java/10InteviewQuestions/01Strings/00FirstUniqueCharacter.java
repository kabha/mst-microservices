package strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		
		}
	
	
	
	public static int findUniqueCharsIndex (String str)
	{
		char[] arrChar = str.toCharArray();
		Map<Character , Integer> instanceMap = new HashMap<Character, Integer>();
		int count =0;
		for (int i = 0; i < arrChar.length; i++) {
			if(! instanceMap.containsKey(arrChar[i]))
			{
				instanceMap.put(arrChar[i], 0);
			}
			
			instanceMap.replace(arrChar[i], count++);
		}
		
		return -1;
	}

}
