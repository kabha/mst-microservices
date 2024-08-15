package com.mst.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/northwind";
		String username = "root";
		String password = "mysql";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println("Connected to the database!");
			// Perform database operations here
			System.out.println("************************************************************");
			System.out.println("Statement - Select Example");
			System.out.println("************************************************************");
			String sql = "select EmployeeID from employees where EmployeeID < 5";
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int employeeID = rs.getInt("EmployeeID");
				System.out.println("EmployeeID = " + employeeID);
			}
			rs.close();
			s.close();
			
			System.out.println("************************************************************");
			System.out.println("PreparedStatement - Select Example");
			System.out.println("************************************************************");
			sql = "SELECT * FROM employees WHERE Country = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "USA");
			rs = pstmt.executeQuery();
			while (rs.next()) {
			    System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
			}
			rs.close();
			pstmt.close();
			
			// Set Auto Commit mode (By Default it is true)
			connection.setAutoCommit(false);
			System.out.println("************************************************************");
			System.out.println("PreparedStatement - Update Example");
			System.out.println("************************************************************");
			sql = "update employees set lastname = ? where EmployeeID = ?";
			PreparedStatement pstmt2 = connection.prepareStatement(sql);
			pstmt2.setString(1, "Kabaha");
			pstmt2.setInt(2, 2);
			int rowsAffected = pstmt2.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Update successful. (" + rowsAffected + ") rows affected.");
			} else {
				System.out.println("No rows updated. Please check the employee ID.");
			}
			
			// Try commit()
			connection.commit();
			System.out.println("Transaction committed successfully.");
			
			// Try rollback()
//			connection.rollback();
			
			// Try with neither!
			rs.close();
			pstmt2.close();
			
			System.out.println("************************************************************");
			System.out.println("CallableStatement - Call Function Example");
			System.out.println("************************************************************");
			sql = "{? = CALL calculate_tax(?, ?)}";
			CallableStatement cstmt = connection.prepareCall(sql);
			cstmt.registerOutParameter(1,  java.sql.Types.DECIMAL);
			cstmt.setDouble(2, 200.0); // Setting input parameter
			// Current VAT = 17
			// Next Year's VAT = 18 (01/01/2025)
			cstmt.setDouble(3, 17.0); // Setting input parameter
			cstmt.execute();
			double tax = cstmt.getDouble(1);
			System.out.println("Tax = " + tax);
			cstmt.close();
			
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Got an SQL Exception!!");
			e.printStackTrace();
		}
	}
}
