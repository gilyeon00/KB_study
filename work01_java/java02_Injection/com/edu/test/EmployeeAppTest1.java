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
        Manager[] managers = {
                new Manager("James", new MyDate(2000, 12, 8), 70000.0, "it"),
                new Manager("Petter", new MyDate(1990, 2, 9), 21212.2, "Marketing"),
                new Manager("Kim", new MyDate(2010, 11, 21), 41415.2, "it")
        };

        Enginner eg = new Enginner("gg", new MyDate(2000, 12, 8), 55000, "Full", 8888);
        Secratary s = new Secratary("ss", new MyDate(1995, 8, 23), 45000, "gg");

        System.out.println("=========정보 출력============");
        for(Manager m : managers) System.out.println(m.getDetails());

        System.out.println("=========이름 출력============");
        for(Manager m : managers) System.out.println(m.getName());

        System.out.println("=========연봉 출력============");
        for (Manager m : managers) System.out.println(m.getSalary() * 12 + "달러");

    }
}
