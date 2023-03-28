package test.vo;
/*
    1. private 필드 선언
    2. 값이 주입되는 통로
        public 명시적 생성자
        public setter()
    3. public 주입된 값을 반환하는 기능을 정의
 */

import test.utill.MyDate4;

public class Engineer4 extends Employee4 {
    private String tech;
    private double bonus;

    public Engineer4(int empId, String name, MyDate4 birthdate, double salary, String tech, Double bonus) {
        // 무조건 부모 생성이 무조건 일어난다.
        super(empId, name, birthdate, salary);
        this.tech = tech;
        this.bonus = bonus;
    }

    public String getTech() {
        return tech;
    }

    public void changeTech(String tech) {
        this.tech = tech;
    }

    public double getBonus() {
        return bonus;
    }

    public void changeBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", tech : " + tech + ", bonus : " + bonus;
    }


}
