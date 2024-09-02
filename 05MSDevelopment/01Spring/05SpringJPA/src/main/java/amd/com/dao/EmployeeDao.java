package amd.com.dao;

import java.util.List;

import amd.com.model.Employee;

public interface EmployeeDao {

	
	  public Employee getEmployeeById(int id);
	    public List<Employee> getAllEmployees();
	    public void deleteEmployee(int id);
	    public void saveEmployee(Employee e);
}
