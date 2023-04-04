package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import confing.ServerInfo;

/*
 * 디비연결 프로그램에 서버정보에 관련된 실제값이 하드코딩 되어져있다.
 * 드라이버 FQCN
 * 서버주소, 계정이름, 비번
 * 
 * Meta Data (파일(xml, properties)로 분리)
 * 
 * 
 * 1. 드라이버 로딩
 * 2. 디비연결
 * 3. PreparedStatement
 * 4. 쿼리문 수행
 * 5. 자원 반환 close()
 * 	열린 순서대로 반대로 닫는다.
 *	반드시 항상 닫아야함 ... finally()
 *	
 */
public class DBConnectTest3 {
	
	public DBConnectTest3() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
	
			// 디비연결
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
	
			// 쿼리문 실행
			String query = "SELECT id, name, address FROM custom";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
	
			while (rs.next()) { // row데이터가 있을 때까지 실행
				System.out
						.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("address") + "\t");
			}
			
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectTest3();

	}

}
