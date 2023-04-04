package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DBConnectTest2 {
	/*
	 * DB연결한 후, 데이터를 추가, 삭제, 수정, 반환 하는 작업을 하기 위해서는 1. 드라이버를 메모리(DBConnectTest2.java가
	 * 실행되는 메모리) 에 로딩 2. 디비연결
	 */
	public static void main(String[] args) {
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 디비연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE\r\n", "kb_db", "1234");

//			// PreparedStatement 객체 생성
//			String query = "DELETE custom WHERE id = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setInt(1, 333);
//			
//			String query = "UPDATE custom SET address=? WHERE id=?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, "뉴욕");
//			ps.setInt(2, 111);

			// excuteUpdate
//			System.out.println(ps.executeUpdate() + " row is deleted");
//			System.out.println(ps.executeUpdate() + " row is updated");

			String query = "SELECT id, name, address FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) { // row데이터가 있을 때까지 실행
				System.out
						.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("address") + "\t");
			}
			

		} catch (ClassNotFoundException e) {
			System.out.println("1.Driver is Loading...Failed");
		} catch (SQLException e) {
			System.out.println("2.DB Connect...Fail");
		}

	}

}
