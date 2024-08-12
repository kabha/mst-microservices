package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
*/
public class Single {

	public static void main(String[] args) {
		int[] arr = { 1,2,1,2,4};
		System.out.println(getSingle(arr));
	}

	public static int getSingle(int[] nums) {
		Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
		int single = 0;
		for (int i = 0; i < nums.length; i++) {

			if (!arrMap.containsKey(nums[i])) {
				arrMap.put(nums[i], 0);
			}

			arrMap.replace(nums[i], arrMap.get(nums[i]) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : arrMap.entrySet()) {
			if (entry.getValue() == 1) {
				single= entry.getKey();
			}
		}

		System.out.println("New Hashmap: " + arrMap);
		return single;
	
	}

}
