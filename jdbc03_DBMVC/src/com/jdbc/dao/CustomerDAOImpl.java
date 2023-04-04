package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.domain.Customer;
import com.jdbc.exception.DuplicatedSSNException;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class CustomerDAOImpl implements CustomerDAO {
	
	private static CustomerDAOImpl dao = new CustomerDAOImpl();

	public static CustomerDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("1. DB.. is Connected ...");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}
	
	//close를 안해준 이유.. 파라미터로 받아옴
	private boolean isSSNExist(String ssn, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT ssn FROM customer WHERE ssn=?";
		ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		rs = ps.executeQuery();

		return rs.next(); // 있으면 true;
	}
	

	@Override
	public void registerCustomer(Customer vo) throws SQLException, DuplicatedSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!isSSNExist(vo.getSsn(), conn)) {
				String query = "INSERT INTO customer(ssn, name, address) VALUES(?,?,?) ";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getSsn());
				ps.setString(2, vo.getName());
				ps.setString(3, vo.getAddress());
				System.out.println(ps.executeUpdate() + " row INSERT OK!!");
			} else {
				throw new DuplicatedSSNException("이미 존재하는 고객입니다.");
			}
			
		} finally {
			closeAll(conn, ps);
		}
		
	}
	

	@Override
	public void removeCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "DELETE customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			System.out.println(ps.executeUpdate() + " row DELETE OK!!");
		}finally {
			closeAll(conn, ps);
		}
	}
	

	@Override
	public void updateCustomer(Customer vo) throws SQLException, RecordNotFoundException, DuplicatedSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(isSSNExist(vo.getSsn(), conn)) {
				String query = "UPDATE customer SET name=?, address=? WHERE ssn=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getAddress());
				ps.setString(3, vo.getSsn());
				System.out.println(ps.executeUpdate() + " row UPDATE OK!!");
			} else throw new DuplicatedSSNException("존재하지 않는 고객입니다.");
		}finally {
			closeAll(conn,ps);
		}
	}


	@Override
	public ArrayList<Customer> getCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Customer> arrCustomer = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT ssn, name, address FROM customer ORDER BY ssn";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				arrCustomer.add(new Customer(rs.getString("ssn"), rs.getString("name"), rs.getString("address")));
			}
			for(Customer c : arrCustomer) {
				System.out.println(c.getSsn());
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return arrCustomer;
	}

	@Override
	public Customer getCustomer(String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
