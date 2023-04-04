package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.domain.Member;
import com.jdbc.exception.DuplicatedIDException;
import com.jdbc.exception.RecordNotFoundException;

public interface MemberDAO {
	// 공통적인 기능 (앞에 public abstract 생략되어져있음)
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;

	
	// Business Logic Template
	void registerMember(Member vo) throws SQLException, DuplicatedIDException;
	void removeMember(long id) throws SQLException, RecordNotFoundException;
	void updateMember(Member vo) throws SQLException, RecordNotFoundException, DuplicatedIDException;
	
	Member getMember(long id) throws SQLException;
	ArrayList<Member> getMember() throws SQLException;
}
