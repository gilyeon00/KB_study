package edu.access.test;


import edu.access.parent.Parent2;

class Child extends Parent2 {
    public void test() {
        System.out.println(publicVar);      // 서로 다른 패키지, 클래스여도 public 은 접근 가능
        System.out.println(protectedVar);   // 상속 관계이기 때문에 protected 접근 가능
//        System.out.println(var);  다른 패키지에 있기 때문에 접근 불가
//        System.out.println(privateVar);  같은 패키지 안에 있어도 접근 불가
    }


}

public class AccessAppTest {
    public static void main(String[] args) {

    }
}
