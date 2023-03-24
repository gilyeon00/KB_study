package com.edu.greet.test;

import com.edu.greet.Greeting;

import java.lang.reflect.GenericArrayType;

public class GreetingAppTest {
    public static void main(String[] args) {
        /*
            1. 클래스 객체를 생성 == 클래스의 멤버를 메모리에 올린다.
            2. 접근
                1) 필드접근 ----> 값할당
                2) 메소드 접근 --> 호출
         */

        // 1.
        Greeting greeting = new Greeting();

        // 2.
        greeting.target = "1반";
        greeting.message = "반가워요";


        System.out.println(greeting.sayHello());
    }
}
