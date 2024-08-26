package com.mst;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mst.beans.Address;
import com.mst.beans.Employee;

@Configuration
@ComponentScan({"com.mst.beans"})
public class SpringMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringMain.class);
		
		//the master of Bean Creatio is the Developer  : Employee emp = new Employee();
		// IOC
		//Employee emp = (Employee)context.getBean("employeeBean"); 
		Employee emp = context.getBean(Employee.class);  //Sigleton , prototype
	
		
		emp.showDetails();
		
	
		
	}

}
