package strings;

public class ReverseStr {

	public static void main(String[] args) {
		String str = new String("Loen");

		revreseString1(str);

	}

	public static void revreseString1(String str) {
		char[] charArr = str.toCharArray();
		int endIndx = charArr.length - 1;
		char temp;
		for (int i = 0; i < charArr.length / 2; i++) {
			temp = charArr[i];
			charArr[i] = charArr[endIndx];
			charArr[endIndx] = temp;
			System.out.println(charArr[i]);
			endIndx--;
		}

		for (int i = 0; i < charArr.length; i++) {
			System.out.print(charArr[i]);
		}
	}

	public static void reverseString2(String str) {
		String reverseStr = "";
		for (int i = str.length() - 1; i >= 0; i++) {
			reverseStr += str.charAt(i);
		}
		System.out.println("the reverse String is " + reverseStr);
	}

	public static String reverseStringRec(String str) {
		if (str.length() == 1) {
			return str;
		} else {
			return str.charAt(str.length() - 1) + reverseStringRec(str.substring(0, str.length() - 1));

		}
	}

}
