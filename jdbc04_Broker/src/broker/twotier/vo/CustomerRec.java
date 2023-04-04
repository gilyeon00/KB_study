package broker.twotier.vo;
/*
 * 주식을 보유하는 고객에 대한 정보를 담는 클래스...
 * 고객== 주식을 보유하지 않는 고객 + 현재 주식을 보유하고 있는 고객
 */

import java.util.ArrayList;


public class CustomerRec {
	private String ssn;
	private String name; //컬럼명은 cust_name
	private String address;
	
	// 조인을 쓰는 것보다 이 방식이 더 좋다. Has A Relation. 1:다 관계에선 이렇게 해준다.
	private ArrayList<SharesRec> portfolio;

	public CustomerRec(String ssn, String name, String address, ArrayList<SharesRec> portfolio) {
		super();
		this.ssn = ssn;
		this.name = name;		// DB 실컬럼명은 cust_name임
		this.address = address;
		this.portfolio = portfolio;
	}
	
	public CustomerRec(String ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public CustomerRec() {	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<SharesRec> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(ArrayList<SharesRec> portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "CustomerRec [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]";
	}
	
}










