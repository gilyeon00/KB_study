package test;

/*
    static한 멤버는 객체생성 없이 사용가능
    로컬 레벨에서 사용 불가 -> 멤버 레벨에서만 사용가능
 */

class StaticExam{
    static String name1 = "홍길동"; // 멤버 지역, 이탤릭체로 되는 이유 : final 취급 -> 상수 취급 -> 어디서든 쓸 수 있음
    String name2 = "박연진";
    public void getMember1() {
        System.out.println("우/유/빛/깔 " + name1);
        System.out.println("우/유/빛/깔 " + name2);
//        System.out.println("우/유/빛/깔 " + name3); 로컬변수라 사용 불가능
    }

    public static void getMember2() {
        System.out.println("우/유/빛/깔 " + name1);
//        System.out.println("우/유/빛/깔 " + name2);  static 함수와 static 변수 이미 메모리에 올라가 있기때문에 호출 가능, name2는 메모리 없음. 객체 생성해야 올라감
//        System.out.println("우/유/빛/깔 " + name3); 로컬변수라 사용 불가능
    }
}

public class StaticExamTest1 {

    public static void main(String[] args) {
//        static String name1 = "홍길동";    로컬 지역이라 안됨
        String name3 = "문동은";

        StaticExam.getMember2(); // static 클래스이므로 객체 생성 없이 바로 사용, 호출 가능 ( [클래스이름].static 멤버 )

//        StaticExam.getMember1();  반드시 객체 생성 한 후(메모리에 올린 후) 멤버 호출해야한다.
        StaticExam staticExam = new StaticExam();
        staticExam.getMember1();


    }
}
