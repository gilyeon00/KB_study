package com.edu.test;

import com.edu.utill.MyDate2;
import com.edu.vo.*;

/*
    Employee 타입의 배열을 생선
    이 안에 여러 명의 Manager, engineer, Secratary 객체를 넣고
    부모 타입으로 단일하게 이기종간의 객체들을 핸들링 할 수 있는 코드를 작성
    ::
    Heterogenous
 */
public class EmployeeAppTest2 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager2("James", new MyDate2(2000, 12, 8), 70000.0, "it"),
                new Enginner2("Petter", new MyDate2(1990, 2, 9), 21212.2, "Marketing"),
                new Secratary2("Kim", new MyDate2(2010, 11, 21), 41415.2, "gilyeon"),
                new Manager2("Park", new MyDate2(1988, 10, 18), 7022.0, "QA"),
        };


        System.out.println("=========정보 출력============");
        for(Employee e : employees) System.out.println(e.getDetails());

        System.out.println("=========이름 출력============");
        for(Employee e : employees) System.out.println(e.getName());

        System.out.println("=========연봉 출력============");
        for (Employee e : employees) {
            if (e instanceof Enginner2) {       // casting
                Enginner2 eg = (Enginner2) e;
                System.out.println(e.getName() + "님의 연봉은 " + (e.getSalary() * 12  + eg.getBonus()) + "달러입니다.");
            } else {
                System.out.println(e.getName() + "님의 연봉은 " + e.getSalary() * 12 + "달러입니다.");
            }

        }

    }
}
