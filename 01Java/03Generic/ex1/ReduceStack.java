package com.mst.generics.ex1;

import java.util.Stack;

public class ReduceStack {
	
	public static <T extends Comparable<T>> Stack<T> reduceStack(Stack<T> stack, T element) {
		Stack<T> tempStack = new Stack<>();
		
		while (!stack.isEmpty()) {
			T current = stack.pop();
			if (current.compareTo(element) <= 0) {
				tempStack.push(current);
			}
		}
		
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
		return stack;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(20);
		stack.push(5);
		stack.push(100);
		stack.push(150);
		stack.push(200);
		
		System.out.println(stack);
		Stack<Integer> reducedStack = reduceStack(stack, 100);
		System.out.println(reducedStack);
	}
}
