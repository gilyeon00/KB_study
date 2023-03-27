package com.edu.test;

import com.edu.utill.MyDate2;
import com.edu.vo.Enginner2;
import com.edu.vo.Manager2;
import com.edu.vo.Secratary2;

/*
    Test 하는 일
    1. 객체 생성 === 클래스의 멤버를 메모리에 올린다.
    2. 접근
        1) 필드 접근 -> 값할당
        2) 메소드 접근 -> 호출
 */
public class EmployeeAppTest1 {
    public static void main(String[] args) {
        Manager2[] managers = {
                new Manager2("James", new MyDate2(2000, 12, 8), 70000.0, "it"),
                new Manager2("Petter", new MyDate2(1990, 2, 9), 21212.2, "Marketing"),
                new Manager2("Kim", new MyDate2(2010, 11, 21), 41415.2, "it")
        };

        Enginner2 eg = new Enginner2("gg", new MyDate2(2000, 12, 8), 55000, "Full");
        Secratary2 s = new Secratary2("ss", new MyDate2(1995, 8, 23), 45000, "gg");

        System.out.println("=========정보 출력============");
//        for(Manager2 m : managers) System.out.println(m.getDetails());

        System.out.println("=========이름 출력============");
//        for(Manager2 m : managers) System.out.println(m.getName());

        System.out.println("=========연봉 출력============");
//        for (Manager2 m : managers) System.out.println(m.getSalary() * 12 + "달러");

    }
}
