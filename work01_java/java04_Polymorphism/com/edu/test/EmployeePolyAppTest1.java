package com.edu.test;

import com.edu.utill.MyDate;
import com.edu.utill.MyDate2;
import com.edu.utill.MyDate3;
import com.edu.vo.*;

/*
    Polymorphism
    ::
    Poly(여러가지) + morphism(형태, 모양) -> 다형성
    여러가지 모양과 모습을 가지는 능력
    부모타입으로 여러가지 자식 클래스 객체 생성
    -> 다양한 이기종간의 sub class 들을 단일하게 관리할 수 있음
    이 부분을 프로그램 적으로 반드시 이해해야함

 */
public class EmployeePolyAppTest1 {
    public static void main(String[] args) {
        Employee3 manager = new Manager3(111, "James", new MyDate3(2000, 12, 8), 70000.0, "it");
        Employee3 engineer = new Engineer3(222, "Petter", new MyDate3(1990, 2, 9), 21212.2, "Marketing", 199.);
        Employee3 secretary = new Secretary3(333, "Kim", new MyDate3(2010, 11, 21), 41415.2, "gilyeon");

        /*
            Virtual Method Invocation 원리가 작동
            1. 컴파일 시점의 메소드 -- Employee 의 toString() 호출
            2. 실행 시점의 메소드가 -- 실질적으로 생성된 자식클래스(Manager3)의 toString() 호출
            상속관계로 이어진 클래스 사이에 Overriding 된 메소드에서 발생하는 원리
            여기서 Virtual Method 는 가상의 메소드로 자식의 메소드를 일컫는다.
         */
        System.out.println(manager.toString()); // James com.edu.utill.MyDate2@34b7bfc0 70000.0, it
        System.out.println(engineer);   // Petter com.edu.utill.MyDate2@7946e1f4 21212.2, tech : Marketing, bonus : 0.0
        System.out.println(secretary);  //  Kim com.edu.utill.MyDate2@3c09711b 41415.2 gilyeon

        System.out.println("================");

        // Manager3의 부서를 Marketing 부서로 변경하기
        // Employee 타입에서는 변경이 불가하니, Manager3로 casting 해줘야한다.
        ((Manager3) manager).changeDept("Marketing");

    }
}
