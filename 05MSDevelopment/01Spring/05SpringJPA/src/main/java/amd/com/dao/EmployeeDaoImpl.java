package amd.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import amd.com.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager _em;


	public Employee getEmployeeById(int id) {
		Employee employee = (Employee) _em.find(Employee.class, id);
		//find instance of entity in the entity manager
		return employee;

	}

	public List<Employee> getAllEmployees() {
		String HQL = "SELECT e FROM Employee e";
		Query query = _em.createQuery(HQL);//Create an instance of Query for executing aJava Persistence query language statement.
		List<Employee> resultList = (List<Employee>)query.getResultList();
		List<Employee> employees = resultList; 
		return employees;
	}

	@Transactional
	public void deleteEmployee(int id) {
		Employee employee = _em.find(Employee.class, id);
		if ( employee != null){
			_em.remove(employee);//remove the entity instance from entit manager
		}else{
			System.out.println("empid:[" + id + "] was not found, nothing to delete");
		}
	}
	
	
	@Transactional
	public void saveEmployee(Employee e) {
		
		_em.persist(e);
	}
	

}
