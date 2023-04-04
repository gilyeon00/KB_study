package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectTest1 {
	/*
	 * DB연결한 후, 데이터를 추가, 삭제, 수정, 반환 하는 작업을 하기 위해서는
	 * 1. 드라이버를 메모리(DBConnectTest2.java가 실행되는 메모리) 에 로딩
	 * 2. 디비연결
	 */
	public static void main(String[] args)  {
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver"); // FQCN (Fully Qualified Class Name)
			System.out.println("1.Driver is Loading...Successed");
			
			// 2.  DB 연결 - 1)DB서버 주소 2)계정 3)비번
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE\r\n", "kb_db", "1234");
			System.out.println("2.Driver Connect is Successed");
			
			// 3. CRUD
			// PreparedStatement 객체 생성
			String query = "INSERT INTO custom(id, name, address) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement is Created");
			
			
			// ?에 대한 값 바인딩 (= 값 주입)
			ps.setInt(1, 333);  // 1번째 물음표의 값 111
			ps.setString(2, "박연진");
			ps.setString(3, "LA");
			
			System.out.println();
			System.out.println("==== INSERT RESULT ====");
			// 진짜 쿼리문이 실행될 때 ..  excuteUpdate() - return 시행된 행의 개수 
			System.out.println(ps.executeUpdate() + " Row INSERT OK ~!!!");
			
		}catch(ClassNotFoundException e) {
			System.out.println("1.Driver is Loading...Failed");
		} catch (SQLException e) {
			System.out.println("2.DB Connect...Fail");
		}
		
	}
	
	

}
