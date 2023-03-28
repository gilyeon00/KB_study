package test;
/*
final
<<access modifier>>
    public / protected / private
<<usage modifier>>
    static / abstract / final

fianl "내가 마지막이야!"
final + 변수 -> "내가 마지막 뱐수야!" 상수
final + 클래스 -> "내가 마지막 클래스야!" 상속금지
final + 메서드 -> "내가 마지막 메소드야!" Overriding 금지
*/

class SuperAA {
    public static final int BASIC_SALARY = 3000000; // 상수
    public final String test(){
        return "Overriding 금지";
    }
}

final class SuperA{ // 상속금지

}

//class Child extends SuperA{
//
//}

class ChildA extends SuperAA{
//    BASIC_SALARY = 100000000; // 값 변경 안됨

//    public final String test(){
//        String name = "James";
//        return name;
//    }
}

public class FinalExamTest2 {
    public static void main(String[] args) {

    }
}