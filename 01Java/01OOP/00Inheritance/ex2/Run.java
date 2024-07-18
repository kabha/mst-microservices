package com.mst.oop.inheritance.ex1;

public class Run {
	public static void main(String[] args) {
		Person p1 = new Person("Ameen");
		Person p2 = new Person("Dauod", 24);
		
		Employee e1 = new Employee("ABC");
		Employee e2 = new Employee("CDE", 31, 10000);
		
		Person[] persons = {
				p1, p2, e1, e2
		};
		
		for (Person p : persons) {
			p.getDetails();
		}
		
	}
}
