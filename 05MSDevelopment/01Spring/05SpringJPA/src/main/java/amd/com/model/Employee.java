package amd.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employees")

public class Employee {

	private int employee_id;

	private String employee_name;

	private double employee_salary;

	private int employee_age;

	private String gender ;



	public Employee()
	{

	}

	public Employee( String employee_name, double employee_salary, int employee_age) {

		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
		this.employee_age = employee_age;
	}




	@Column
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Id
	@GeneratedValue
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Column
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	@Column
	public double getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(double employee_salary) {
		this.employee_salary = employee_salary;
	}


	@Column
	public int getEmployee_age() {
		return employee_age;
	}
	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}




	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_salary="
				+ employee_salary + ", employee_age=" + employee_age + "]";
	}



}
