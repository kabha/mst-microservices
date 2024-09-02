package amd.com.dao;

import java.util.List;

public interface EmployeeDao {

	    public String getEmployeeNameById(int id);
	    public List<Employee> getAllEmployees();
	    public List<Employee> getEmployeesByNameLike(String name);
	    public int savePerson(Employee e);
	    public void deleteAll();
	}
