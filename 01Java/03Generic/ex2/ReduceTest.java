package com.mst.generics.ex2;

import java.util.ArrayList;

public class ReduceTest {
	public static <T> ArrayList<T> reduceAll(ArrayList<? extends Reduceable<T>> list) {
		ArrayList<T> reducedList = new ArrayList<T>();
		for (Reduceable<T> item : list) {
			reducedList.add(item.reduce());
		}
		return reducedList;
	}
	
	public static void main(String[] args) {
		ArrayList<Example> list = new ArrayList<Example>();
		list.add(new Example(10));
		list.add(new Example(20));
		list.add(new Example(40));
		list.add(new Example(30));
		System.out.println("original = " + list);
		ArrayList<Integer> reducedList = reduceAll(list);
		System.out.println("reduced = " + reducedList);
		
		
	}
	
}
