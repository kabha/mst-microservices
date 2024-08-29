package amd.com.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class EmployeeDAOImpl  implements EmployeeDao {
	

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public int savePerson(Employee e) {
		String sql = "insert  into Employee(name,salary, age) values  (?,?,?)";
		 Object[] args = { e.getName(),e.getSalary(), e.getAge() };
		 int[] types = { Types.VARCHAR, Types.DOUBLE,Types.INTEGER };
		 int insertCount = jdbcTemplate.update(sql, args, types);
		 return insertCount;

	}

	public int count(){
	    return this.jdbcTemplate.queryForObject("select count(*) from Employee",Integer.class);
	}  
	
	public String getEmployeeNameById(int id) {
		String sql = "select name from employee where id = ?";
		String name = jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
		//System.out.println("the name is"+name);
		return name;
		
	}
	
	public List<Employee> getAllEmployees() {
		 String sql = "select * from Employee";
		 Object[] args = null; // { id } ;
		 List<Employee> list = jdbcTemplate.query(sql, args, new EmployeeRowMapper());
		 return list;
		}

	public List<Employee> getEmployeesByNameLike(String name) {
		String sql = "select * from Employee where name like ?";
		  name = "%" + name + "%";
		 Object[] args = { name };
		 List<Employee> list = jdbcTemplate.query(sql, args, new EmployeeRowMapper());
		 return list;

	}

	public void deleteAll() {
		String sql= "delete from Employee";
		
	}


	
	
	

}
