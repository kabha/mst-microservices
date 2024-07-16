package com.mst.oop;

public class Runner {
	public static void main(String[] args) {
		// public Person(String name, float age, String city, char gender) {
		
		Person p = new Person("John", 35, "Delhi", 'M');
		p.play();
		p.setName("Ameen");
		System.out.println(p.getName());
		System.out.println(p);
//		p.toString();
//		System.out.println(p.play());
	}
}
