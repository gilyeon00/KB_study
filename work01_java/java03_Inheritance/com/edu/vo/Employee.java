package com.edu.vo;

import com.edu.utill.MyDate2;

// 부모 클래스 = Super class = Parent class
public class Employee {
    private String name;
    private MyDate2 birthdate;
    private double salary;

    // 상수값
//    public static final

    public Employee(String name, MyDate2 birthdate, double salary) {
        this.name = name;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    /*
        this
            1) local V와 field 의 이름이 동일할 때 구분하기 위하여 필드 앞에 붙인다.
            2) this() --> 하나의 클래스ㅔ서 또다른 생성자를 호출할 때 사용한다.
     */

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate2 getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(MyDate2 birthdate) {
        this.birthdate = birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public void changeSalary(double salary) {
        this.salary = salary;
    }

    public String getDetails() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", salary=" + salary +
                '}';
    }

}
