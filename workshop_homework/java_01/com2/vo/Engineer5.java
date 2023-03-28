package com2.vo;

import com2.util.MyDate;

public class Engineer5 extends Employee5 {
	private String tech;
	private double bonus;

	public Engineer5(String name, MyDate birthDate, double salary, String tech, double bonus) {
		super(name, birthDate, salary);
		this.tech = tech;
		this.bonus = bonus;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
