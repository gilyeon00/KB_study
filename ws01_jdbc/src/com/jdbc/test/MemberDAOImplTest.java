package com.jdbc.test;

import java.util.ArrayList;

import com.jdbc.dao.MemberDAOImpl;
import com.jdbc.domain.Member;

import config.ServerInfo;

public class MemberDAOImplTest {

	public static void main(String[] args) {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
//			dao.registerCustomer(new Member("하도영", "1223@name.com", "010-6565-8488"));
//			dao.registerCustomer(new Customer("999", "김연아", "한남동"));
//			dao.removeCustomer(111);
//			dao.updateCustomer(new Member(999, "정우성", "1223@name.com", "010-6565-8488"));
			
			ArrayList<Member> arrMember = dao.getMember();
			for (Member m : arrMember) {
				System.out.println(m);
			}
			
			Member m = dao.getMember(111);
			System.out.println(m);
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading...ok");
		} catch (Exception e) {
			System.out.println("Driver Loading...fail");
		}
	}

}
