package com.mst.interview;

public class Find2ndLargestNum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static int get2ndLargestNum(int[] arr)
	{
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > highest)
			{
				secondHighest=highest;
				highest=arr[i];
			}else if(arr[i] > secondHighest && arr[i] != highest){
				secondHighest =arr[i];
			}
		}
		return secondHighest;
	}

}
