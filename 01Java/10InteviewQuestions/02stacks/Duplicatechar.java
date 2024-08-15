package strings;

import java.util.Stack;


public class Test {
	 public static String getString(String input_str) {
         
		 Stack<Character> stack = new Stack<Character>();
		 int[] count  = new int[26];
		 int[] isExsit = new int[26];
		 
		for(int i=0 ; i<input_str.length() ; i++)
		{
			count[input_str.charAt(i) -'a']++;
		}
		
		for (int i = 0; i < input_str.length(); i++) {
			count[input_str.charAt(i)-'a']--;
			if(isExsit[input_str.charAt(i)-'a'] >0 )
				continue; 
		while(!stack.isEmpty() && stack.peek()<input_str.charAt(i) && count[stack.peek()-'a'] !=0 )
		{
			isExsit[stack.peek()-'a'] =0;
			stack.pop();
		}
		
		stack.push(input_str.charAt(i));
		isExsit[input_str.charAt(i) -'a']=1;
		}
		
	String output_str ="";
	while(!stack.isEmpty() )
	{
		output_str = stack.peek() + output_str;
		stack.pop();
	}
     return output_str;

 }
	 
	 
	 public static void main(String[] args) {
		String str ="abacaba"; 
		System.out.println(getString(str));
	}
}
