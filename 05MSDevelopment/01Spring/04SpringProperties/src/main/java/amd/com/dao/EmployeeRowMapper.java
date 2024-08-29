package amd.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


//An interface used by JdbcTemplate for mapping rows of a ResultSet on a per-row basis. 
//Implementations of this interface perform the actual work of mapping each row to a result object,
//but don't need to worry about exception handling. 
//SQLExceptions will be caught and handled by the calling JdbcTemplate.
public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int index) throws SQLException {
		Employee employee   = new Employee();
		employee .setId( rs.getInt   ("id")  );
        employee .setName( rs.getString("name"));
        employee.setAge( rs.getInt   ("age") );
        employee.setSalary(rs.getDouble("salary"));
        return employee;
	}

}
