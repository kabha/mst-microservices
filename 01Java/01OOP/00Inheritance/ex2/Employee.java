package com.mst.oop.inheritance.ex1;

public class Employee extends Person {
	private float salary;
	public Employee(String name, int age, float salary) {
		super(name, age);
		setSalary(salary);
	}

	public Employee(String name) {
		super(name);
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		if (salary < 0) {
			salary = 1;
		}
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + "]" + super.toString();
	}

}
