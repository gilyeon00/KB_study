package broker.twotier.test;

import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;

public class DatabaseTest {

	public static void main(String[] args)throws Exception{
		
		Database db = new Database("127.0.0.1");
//		db.addCustomer(new CustomerRec("888-888", "하바리", "다산동"));
//		db.deleteCustomer("888-888");
//		db.updateCustomer(new CustomerRec("888-888", "하바리1", "약수동1"));
		
//		ArrayList<SharesRec> v = db.getPortfolio("111-111");
//		for(SharesRec sr : v)System.out.println(v);
		
//		db.getCustomer("111-111");
		
		System.out.println(db.getAllCustomers());
		
	}

}
