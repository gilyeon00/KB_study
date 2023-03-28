package com2.vo;

import com2.util.MyDate;

public class Manager5 extends Employee5 {

	private String dept;
	private int deptno;

	public Manager5(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super(name, birthDate, salary);
		this.dept = dept;
		this.deptno = deptno;
	}

	public Manager5(String name, double salary) {
		super(name, salary);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}






