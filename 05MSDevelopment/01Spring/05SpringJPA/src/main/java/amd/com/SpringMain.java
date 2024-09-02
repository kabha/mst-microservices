package amd.com;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import amd.com.config.JPAConfig;
import amd.com.dao.EmployeeDao;

import amd.com.model.Employee;

public class SpringMain {

	public static void main(String[] args) {
	      ApplicationContext ctx =  new AnnotationConfigApplicationContext(JPAConfig.class);
	      EmployeeDao empDAO = ctx.getBean(EmployeeDao.class);
	      
	      Employee employee1 = new Employee("Jumman Marsh", 28900.0, 35);
	      empDAO.saveEmployee(employee1);
	      System.out.println(employee1);
	      Employee emp = empDAO.getEmployeeById(1);
	      System.out.println("Employee 1 is: " + emp);
	      System.out.println("\nEmployees List:");
	      List<Employee> list = empDAO.getAllEmployees();
	      for (Employee employee : list) {System.out.println(employee);}
	     
	     
	     ((AbstractApplicationContext) ctx).close(); 
	}

}
