package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.domain.Customer;
import com.jdbc.exception.DuplicatedSSNException;
import com.jdbc.exception.RecordNotFoundException;

public interface CustomerDAO {
	// 공통적인 기능 (앞에 public abstract 생략되어져있음)
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;

	
	// Business Logic Template
	void registerCustomer(Customer vo) throws SQLException, DuplicatedSSNException;
	void removeCustomer(String ssn) throws SQLException, RecordNotFoundException;
	void updateCustomer(Customer vo) throws SQLException, RecordNotFoundException, DuplicatedSSNException;
	
	Customer getCustomer(String ssn) throws SQLException;
	ArrayList<Customer> getCustomer() throws SQLException;
}
