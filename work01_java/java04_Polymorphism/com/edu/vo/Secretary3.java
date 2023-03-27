package com.edu.vo;

/*
    Manager 에 대한 정보를 저잘하는 클래스
    [ 클래스 작성 방법 ]
    1. Private Field 선언
    2. Public 값이 주입되는 통로(생성자, setter())
    3. Public 주입된 값을 반환하는 기능
 */


import com.edu.utill.MyDate3;

public class Secretary3 extends Employee3 {
    // Field
    private  String bossOfName;

    // 기본 생성자
    public Secretary3() {
    }

    public Secretary3(int id, String name, MyDate3 birthdate, double salary, String bossOfName) {
        // 무조건 부모 생성이 무조건 일어난다.
        super(id, name, birthdate , salary);
        this.bossOfName = bossOfName;
    }

    public String getBossOfName() {
        return bossOfName;
    }

    public void changeBossOfName(String bossOfName) {
        this.bossOfName = bossOfName;
    }

    @Override
    public String toString() {
        return super.toString() + " " + bossOfName;
    }
}
