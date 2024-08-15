package com.mst.jdbc.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.mst.jdbc.exception.CompanyException;

public class DBConnection {

	private Set<Connection> connections = new LinkedHashSet<Connection>(10);
	private static DBConnection instance;
	// old driver
//	private String driver = "com.mysql.jdbc.Driver";
	// new driver
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/employee";
	private String user = "root";
	private String password = "mysql";

	private DBConnection() throws CompanyException {
	    try {
	        for (int i = 0; i < 10; i++) {
	            Connection conn = createConnection();
	            connections.add(conn);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        throw new CompanyException("Exception in DBConnection - " + e.getMessage());
	    }
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {
	    Class.forName(driver);
	    return DriverManager.getConnection(url, user, password);
	}

	public synchronized static DBConnection getInstance() throws CompanyException {
		if (instance == null) {
			instance = new DBConnection();
		}

		return instance;
	}

	 public synchronized Connection getConnection() throws CompanyException {
	        Connection conn = null;
	        try {
	            while (connections.isEmpty()) {
	                wait();
	            }
	            Iterator<Connection> it = connections.iterator();
	            conn = it.next();
	            it.remove();
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt(); // Restore interrupted status
	            throw new CompanyException("Exception in DBConnection - " + e.getMessage());
	        }
	        return conn;
	    }

	    public synchronized void restoreConnection(Connection connection) throws CompanyException {
	        if (connections.size() < 10) {
	            if (connection != null) {
	                connections.add(connection);
	                notify();
	            } else {
	                try {
	                    Class.forName(driver);
	                    connection = DriverManager.getConnection(url, user, password);
	                    connections.add(connection);
	                    notify();
	                } catch (ClassNotFoundException | SQLException e) {
	                    throw new CompanyException("Exception in DBConnection - " + e.getMessage());
	                }
	            }
	        }
	    }


		public void closeAllConnections() throws CompanyException {
			for (Connection connection : connections) {
				try {
					connection.close();
				} catch (SQLException e) {
					try {
						connection.close();
					} catch (SQLException e1) {
						throw new CompanyException("Exception in ConnectionPool - " + e1.getMessage());
					}
					throw new CompanyException("Exception in ConnectionPool - " + e.getMessage());
				}
			}
		}
	
}
