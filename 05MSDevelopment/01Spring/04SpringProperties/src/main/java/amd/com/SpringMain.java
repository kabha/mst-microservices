package amd.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import amd.com.dao.Employee;
import amd.com.dao.EmployeeDAOImpl;
import amd.com.dao.SpringConfig;


public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext ctx= new  AnnotationConfigApplicationContext(SpringConfig.class);
		EmployeeDAOImpl dao= ctx.getBean(EmployeeDAOImpl.class);
		
		Employee e = new Employee("Natalia Sh",26000.0, 21);
		System.out.println("Insert new Employee to DB MySql:"+dao.savePerson(e));
		System.out.println("Employee count from MySQL: "+dao.count());
		System.out.println("get Employee name by id from MySQL: "+dao.getEmployeeNameById(8));
		System.out.println("get all employees from MySQL: "+dao.getAllEmployees());

	}

}
