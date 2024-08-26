package com.mst.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("employeeBean") // @Component - (Controller , Service , Repository)
@Scope("Singleton")
public class Employee {


	@Value("Alex")
	private String emplName; 
	
	@Value("87631")
	private int emplID;
	
	@Autowired //(DI by Type)   , Resource + qualifier (DI by Name)
	private Address address;
	
	
	public int getEmplID() {
		return emplID;
	}
	public void setEmplID(int emplID) {
		this.emplID = emplID;
	}
	public Address getAdress() {
		return address;
	}
	public void setAdress(Address adress) {
		this.address = adress;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	
	public void showDetails() {
		System.out.println("ID: " + emplID + ", Name: "+ emplName);
		address.showAddress();
	}
}
