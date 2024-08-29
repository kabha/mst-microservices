package aop.com.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component("customerBean")
@Scope("singleton")
public class Customer {

	public void addCustomer(){
		System.out.println("addCustomer() is running ");
	}

	public String addCustomerReturnValue(){
		System.out.println("addCustomerReturnValue() is running ");
		return "Hello amdocs";
	}

	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running ");
		throw new Exception("amdocs Error");
	}

	public void addCustomerAround(String name){
		System.out.println("addCustomerAround() is running, args : " + name);
	}

}
