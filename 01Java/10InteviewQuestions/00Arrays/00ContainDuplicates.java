package arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainDuplicates {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 9,5,7,9,4,8 };
		System.out.println(isUnique(arr));
		
		System.out.println(isUnique2(arr));

	}

	public static boolean isUnique(int[] arr) {
		boolean result = true;
		int counter = 0;
		Map<Integer, Integer> dupMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {

			if (!dupMap.containsKey(arr[i])) {
				dupMap.put(arr[i], 0);
			}
			counter = dupMap.get(arr[i]);
			System.out.println("the counter is " + arr[i] + " :  " + counter);
			dupMap.replace(arr[i], counter + 1);

			}

		for (Map.Entry<Integer, Integer> entry : dupMap.entrySet()) {
			if (entry.getValue() > 1) {
				result = false;
			}
		}

		System.out.println("New Hashmap: " + dupMap);
		return result;
	}
	
	public static boolean isUnique2(int[] arr)
	{
		Set<Integer> arrSet = new HashSet<Integer>();
		
		for(int i=0;i<arr.length ;i++)
		{
			arrSet.add(arr[i]);
		}
		System.out.println(arr.length + " : "+ arrSet.size());
		if(arrSet.size() == arr.length)
		 {
			return true ;
		 }else {
			 return false;
		 }
		
		
	}

}
