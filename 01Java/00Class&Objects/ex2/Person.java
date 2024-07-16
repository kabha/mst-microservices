package com.mst.oop;

public class Person {
	private int unique_id;
	private String name;
	private float age;
	private String city;
	private char gender;
	
	public Person(String name, float age, String city, char gender) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.gender = gender;
	}
	
	// methods
	public void eat() {
		System.out.println("Eating!!");
	}
	
	public void sleep() {
		System.out.println("Sleeping, don't disturb!");
	}
	
	public void study() {
		System.out.println("Syudying!!, please bother me I need a break");
	}
	
	public void play() {
		System.out.println("Playing Call Of Duty!");
	}

	@Override
	public String toString() {
		return "Person [unique_id=" + unique_id + ", name=" + name + ", age=" + age + ", city=" + city + ", gender="
				+ gender + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
}
