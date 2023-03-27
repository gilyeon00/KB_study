package com.edu.vo;

/*
    Manager 에 대한 정보를 저잘하는 클래스
    [ 클래스 작성 방법 ]
    1. Private Field 선언
    2. Public 값이 주입되는 통로(생성자, setter())
    3. Public 주입된 값을 반환하는 기능
 */

import com.edu.utill.MyDate2;

public class Manager {
    // Field
    private String name;
    private MyDate2 birthdate;
    private double salary;
    private  String dept;

    // 기본 생성자
    public Manager() {
    }

    // 명시적 생성자 - 값을 주입하는 통로
    public Manager(String name, MyDate2 birthdate, double salary, String dept) {
        this.name = name;
        this.birthdate = birthdate;
        this.salary = salary;
        this.dept = dept;
    }

    // 값을 주입하는 통로 <- 하는 일이 똑같으면, 구현부가 똑같
    public void setManagerField(String name, MyDate2 birthdate, double salary, String dept) {
        this.name = name;
        this.birthdate = birthdate;
        this.salary = salary;
        this.dept = dept;
    }

    public String getDetails(){
        return name + ", " + birthdate.getDate() + ", " + salary + ", " + dept;
    }

    public String getName() {
        return name;
    }

    public MyDate2 getBirthdate() {
        return birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }
}
