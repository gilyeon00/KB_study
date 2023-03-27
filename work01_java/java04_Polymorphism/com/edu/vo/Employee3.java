package com.edu.vo;

import com.edu.utill.MyDate3;

// 부모 클래스 = Super class = Parent class
public class Employee3 {
    private String name;
    private MyDate3 birthdate;
    private double salary;
    private int empId;

    public Employee3(int empId, String name, MyDate3 birthdate, double salary) {
        this.empId = empId;
        this.name = name;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    /*
        this
            1) local V와 field 의 이름이 동일할 때 구분하기 위하여 필드 앞에 붙인다.
            2) this() --> 하나의 클래스ㅔ서 또다른 생성자를 호출할 때 사용한다.
     */

    public Employee3() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate3 getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(MyDate3 birthdate) {
        this.birthdate = birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public void changeSalary(double salary) {
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return name + " " + getBirthdate() + " "+ salary;
    }
}
