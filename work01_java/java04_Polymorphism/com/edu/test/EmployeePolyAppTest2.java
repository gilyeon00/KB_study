package com.edu.test;

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

    부모타입의 Container 생성(배열)
    해당 Container 안에 자식 객체를 할당
    Heterogeneous Collection
 */
public class EmployeePolyAppTest2 {
    public static void main(String[] args) {
        Employee3[ ] emps=  {
                new Manager3(111,"James", new MyDate3(1990,3,24),200002.0,"IT"),
                new Engineer3(222,"Gosling", new MyDate3(1990,2,24),150.0,"python"),
                new Manager3(333,"Peter", new MyDate3(1990,1,24),450002.0,"IT"),
                new Secretary3(444,"Juliet", new MyDate3(1990,1,24),350002.0,"Gosling"),
                new Manager3(555,"James1", new MyDate3(1990,3,24),200002.0,"IT")
        };

        System.out.println("========== 정보를 출력합니다.=================");
        for(Employee3 e : emps)
            System.out.println(e);


        System.out.println("\n========== 연봉 정보를 출력합니다.=================");

        for(Employee3 e : emps) {
            if(e instanceof Engineer3) {//Employee타입으로 생성된 객체가 Engineer 라면
                Engineer3 eg=(Engineer3)e;
                System.out.println(e.getName()+" 님의 연봉은 "+(e.getSalary() * 12+eg.getBonus())+" 달러입니다.");
            }else {
                System.out.println(e.getName()+" 님의 연봉은 "+e.getSalary() * 12+" 달러입니다.");
            }

        }

        System.out.println("\n========== 각 직원의 이름 정보를 출력합니다.=================");
        for(Employee3 e : emps) System.out.println("Employee Name :"+e.getName());

    }
}
