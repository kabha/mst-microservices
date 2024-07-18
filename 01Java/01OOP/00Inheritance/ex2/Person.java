package com.mst.oop.inheritance.ex1;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		setAge(age);
	}
	
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 0 || age > 120) {
			age = 1;
		}
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void getDetails() {
		System.out.println(this);
	}
	
}
