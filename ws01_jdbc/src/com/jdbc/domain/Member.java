package com.jdbc.domain;
/*
 * Customer 테이블의 정보를 저장하는 클래스
 * 
 * Encapsulation 패턴으로 작성
 * Customer 생성자 오버로딩
 *  
*/


public class Member {
	private long id;
	private String name;
	private String email;
	private String phone;
	
//	public static final String BASIC_ADDR = "선릉";

	public Member(long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public Member(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	

}
