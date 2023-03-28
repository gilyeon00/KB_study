package com2.util;

public class MyDate5 {
	private int year;
	private int month;
	private int day;
	public MyDate5(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public String getDate() {
		return year+"-"+month+"-"+day;
	}	
}
