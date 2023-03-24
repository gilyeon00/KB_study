package com.edu.vo;
/*
    1. private 필드 선언
    2. 값이 주입되는 통로
        public 명시적 생성자
        public setter()
    3. public 주입된 값을 반환하는 기능을 정의
 */

import com.edu.utill.MyDate;

public class Enginner {
    private String name;
    private MyDate birthdate;
    private double salary;
    private String tech;
    private double bonus;

    public Enginner() {
    }

    public Enginner(String name, MyDate birthdate, double salary, String tech, double bonus) {
        this.name = name;
        this.birthdate = birthdate;
        this.salary = salary;
        this.tech = tech;
        this.bonus = bonus;
    }

    public String getDetails(){
        return name + "," + birthdate.getDate()  + " , " + salary + ", " + tech;
    }

    public String getName() {
        return name;
    }

    public MyDate getBirthdate() {
        return birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public String getTech() {
        return tech;
    }

    public double getBonus() {
        return bonus;
    }
}
