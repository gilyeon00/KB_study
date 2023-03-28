package com2.vo;

import com2.util.MyDate;

public class Employee5 {
    private String name;
    private MyDate birthDate;
    private double salary;

    public Employee5() {}

    public Employee5(String name, MyDate birthDate, double salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public Employee5(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
