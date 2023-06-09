package edu.vo;

/*
    Manager 에 대한 정보를 저잘하는 클래스
    [ 클래스 작성 방법 ]
    1. Private Field 선언
    2. Public 값이 주입되는 통로(생성자, setter())
    3. Public 주입된 값을 반환하는 기능
 */

import edu.utill.MyDate3;

public class Manager3 extends Employee3 {
    // Field
    private  String dept;

    public Manager3(int empId, String name, MyDate3 birthdate, double salary, String dept) {
        // 무조건 부모 생성이 무조건 일어난다.
        super(empId, name, birthdate, salary);
        this.dept = dept;
    }

    public void changeDept(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return super.toString() + ", "+ dept;
    }
}
