package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.domain.Member;
import com.jdbc.exception.DuplicatedIDException;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl dao = new MemberDAOImpl();

	public static MemberDAOImpl getInstance() {
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

	private boolean isIDExist(long id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT id FROM member WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setLong(1, id);
		rs = ps.executeQuery();

		return rs.next(); // 있으면 true;
	}

	public void registerCustomer(Member vo) throws SQLException, DuplicatedIDException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if (!isIDExist(vo.getId(), conn)) {
				String query = "INSERT INTO member(id, name, email, phone) VALUES(seq_id.nextval,?,?,?) ";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getEmail());
				ps.setString(3, vo.getPhone());
				System.out.println(ps.executeUpdate() + " row INSERT OK!!");
			} else {
				throw new DuplicatedIDException("이미 존재하는 고객입니다.");
			}
		} finally {
			closeAll(conn, ps);
		}

	}

	public void removeCustomer(long id) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "DELETE member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			System.out.println(ps.executeUpdate() + " row DELETE OK!!");
		} finally {
			closeAll(conn, ps);
		}
	}

	public void updateCustomer(Member vo) throws SQLException, RecordNotFoundException, DuplicatedIDException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if (isIDExist(vo.getId(), conn)) {
				String query = "UPDATE member SET name=?, email=?, phone=? WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getEmail());
				ps.setString(3, vo.getPhone());
				ps.setLong(4, vo.getId());
				System.out.println(ps.executeUpdate() + " row UPDATE OK!!");
			} else
				throw new DuplicatedIDException("존재하지 않는 고객입니다.");
		} finally {
			closeAll(conn, ps);
		}
	}

	public ArrayList<Member> getMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> arrMember = new ArrayList<>();
		try {
			conn = getConnect();
			String query = "SELECT id, name, email, phone FROM member";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {
				arrMember.add(new Member(rs.getLong("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone")));
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return arrMember;
	}


	@Override
	public Member getMember(long id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member m = null;
		try {
			conn = getConnect();
			String query = "SELECT id, name, email, phone FROM member WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				m = new Member(id, rs.getString("name"), rs.getString("email"), rs.getString("phone"));
			} 
			
		} finally {
			closeAll(conn, ps, rs);
		}
		return m;
	}

}
