package com.edu.test;

import com.edu.utill.MyDate;
import com.edu.vo.Enginner;
import com.edu.vo.Manager;
import com.edu.vo.Secratary;

/*
    Test 하는 일
    1. 객체 생성 === 클래스의 멤버를 메모리에 올린다.
    2. 접근
        1) 필드 접근 -> 값할당
        2) 메소드 접근 -> 호출
 */
public class EmployeeAppTest1 {
    public static void main(String[] args) {
//        Manager manager = new Manager();    // 생성자 호출
        Manager manager1 = new Manager("James", new MyDate(2000, 12, 8), 70000.0, "it");
//
//        // manager.name = "Gosling";    // private 이라 접근 안됨
//        manager.setManagerField("Gosling", new MyDate(2000, 1, 10), 3000, "Marketing");
//
//        System.out.println(manager.getDetails());
//        System.out.println(manager1.getDetails());
//
//        manager.getDetails();

        Enginner eg = new Enginner("gg", new MyDate(2000, 12, 8), 55000, "Full", 8888);
        Secratary s = new Secratary("ss", new MyDate(1995, 8, 23), 45000, "gg");

        System.out.println("=========정보 출력============");
        System.out.println(manager1.getDetails());
        System.out.println(eg.getDetails());
        System.out.println(s.getDetails());

        System.out.println("=========이름 출력============");
        System.out.println(manager1.getName());
        System.out.println(eg.getName());
        System.out.println(s.getName());

        System.out.println("=========연봉 출력============");
        System.out.println(manager1.getSalary() * 12);
        System.out.println(eg.getSalary() * 12 + eg.getBonus());
        System.out.println(s.getSalary() * 12);

    }
}
