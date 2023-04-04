package com.jdbc.test;

import java.sql.SQLException;

import com.jdbc.dao.CustomerDAO;

import config.ServerInfo;


public class CustomerDAOTest { //원래 main이 가장 먼저 실행.

	public static void main(String[] args) throws SQLException {
	    CustomerDAO dao = new CustomerDAO();
	    
	    //사용 확인
//	    dao.addCustomer("444", "전지현", "석수동");
//	    dao.removeCustomer("333");
//	    dao.updateCustomer("전지현", "청담동", "333");
	    dao.printAllCustomer();
	}
	
	static { 	// 가장 먼저 실핼
	    try {
	        Class.forName(ServerInfo.DRIVER_NAME);
	        System.out.println("1. Driver ... is Loading..");
	    } catch(ClassNotFoundException e){
	    	 System.out.println("1. Driver ... is failed..");
	    }
	}
	
}