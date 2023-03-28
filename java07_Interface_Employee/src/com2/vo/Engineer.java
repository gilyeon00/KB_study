package com2.vo;

import com2.util.MyDate;

public class Engineer extends Employee5 {

	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate birthDate, double salary, String tech, double bonus) {
		super(name, birthDate,salary);	
		this.tech = tech;
		this.bonus = bonus;
	}	
	
	public void changeTech(String tech) {
		this.tech = tech;
	}	
	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}	
	
	public String getTech() {
		return tech;
	}
	public double getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+tech+","+bonus;
	}	
}
