package com.edu.exception.test3;
/*
    사용자 정의 Exception
    1. 내가 직접 Exception 클래스를 만들어서 사용한다
    2. 특정한 조건일 때 내가 고의적으오 예외를 발생시키는 경우에 사용

    " 예외는 일조의 버그가 아니라, 강력한 제어문의 일종"
 */


// 생성자 오버로딩 기법을 사용해서, 사용자 정의 Exception 클래스 생성
class ZeroBoom extends Exception{
    ZeroBoom(){
        this("This is ZeroBoom Exception");
    }

    ZeroBoom(String message) {
        super(message);
    }
}

class ACase{
    public void go() throws  ZeroBoom {
        System.out.println("2. go().. calling..");
        int i = 10;
        int j = 0;

        if (j == 0) {
            throw new ZeroBoom("분모가 0이면 안됩니다.");    // 고의적으로 폭탄을 터뜨린다 ! <== ArithmeticException
        }
    }
}
public class UserException {
    public static void main(String[] args) {
        ACase aCase = new ACase();
        System.out.println("1. ACase .. calling..");
        try {
            aCase.go();
        } catch (ZeroBoom e) {
            System.out.println(e.getMessage());
        }


    }
}
