package com.mst.jdbc.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Optional;

import com.mst.jdbc.exception.CompanyException;

public interface DBConnectionIFC {
	public ResultSet selectQuery(String sqlSelect) throws CompanyException;

	public Optional<Connection> getConn() throws CompanyException;

	public void restoreConn(Optional<Connection> connection) throws CompanyException;
}
