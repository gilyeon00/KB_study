package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;


public class CustomerDAO {

	// 생성자
	public CustomerDAO() {
		System.out.println("2. DAO ... is created"); // test클래스에서 호출 확인용

	}

	// 공통적인 로직 : 서비스가 아니라 이쪽에서만 사용하는 거라면 private으로 //
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("3. DB Connection....OK");
		return conn;
	}

	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!= null) rs.close();
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}
	

	// 비즈니스 로직
	public void addCustomer(String ssn, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();

			String query = "INSERT INTO customer (ssn, name, address) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			ps.setString(2, name);
			ps.setString(3, addr);

			int row = ps.executeUpdate();
			System.out.println(row + " row INSERT ok...");
		} finally {
			closeAll(conn, ps);
		}
	}
	

	public void removeCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();

			String query = "DELETE customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);

			int row = ps.executeUpdate();
			System.out.println(row + " ROW DELETE OK~~!!");

		} finally {
			closeAll(conn, ps);
		}
	}
	

	public void updateCustomer(String ssn, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnect();

			String query = "UPDATE customer SET name=?, address=? WHERE ssn=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setString(3, ssn);

			int row = ps.executeUpdate();
			System.out.println(row + " ROW UPDATE OK ~!");
		} finally {
			closeAll(conn, ps);
		}

	}

	
	public void printAllCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();

			String query = "SELECT ssn, name, address FROM customer";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getString("ssn") + "\t" + 
						rs.getString("name") + "\t" + 
						rs.getString("address") + "\t");
			}

		} finally {
			closeAll(conn, ps, rs);
		}

	}
}