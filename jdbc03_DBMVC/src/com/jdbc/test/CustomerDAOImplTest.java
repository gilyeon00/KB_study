package com.jdbc.test;

import com.jdbc.dao.CustomerDAOImpl;
import com.jdbc.domain.Customer;

public class CustomerDAOImplTest {

	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		try {
//			dao.registerCustomer(new Customer("222", "제임스", "La"));
//			dao.registerCustomer(new Customer("999", "김연아", "한남동"));
//			dao.removeCustomer("222");
//			dao.updateCustomer(new Customer("999", "정우성", "방배동"));
			dao.getCustomer();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
