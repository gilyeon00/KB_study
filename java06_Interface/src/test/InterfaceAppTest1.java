package test;

// 원래 인터페이스는 public
// 인터페이스 구성요소: 추상 메소드(abstract), static final 상수(NO FIELD)
interface Flyer{
    int MAX_SPEED = 424; // public static final int임

    public abstract void fly(); // 완벽한 템플릿. 구현부가 없다
    void land(); // 자동으로 public abstract이 붙음
    void takeOff();
}

// 인터페이스를 상속한 클래스는 반드시 추상 메소드들을 모두 구현해야 한다 -> 일종의 오버라이딩
// 인터페이스의 사용법만 알면, 클래스에서 직접 구현해서 사용한다.
class Bird implements Flyer{

    // 만약 인터페이스를 상속받았는데 구현이 안된 메소드가 있다면, 이 클래스는 abstract class이다.
    // public abstract void fly();

    @Override
    public void fly() {
        System.out.println("새가 난다요");
    }

    @Override
    public void land() {
        System.out.println("닭둘기");
    }

    @Override
    public void takeOff() {
        System.out.println("이륙해 새 TAKE OFF");
    }

    public String layEggs() {
        return "알싸개";
    }

}

class SuperMan implements Flyer{

    @Override
    public void fly() {
        System.out.println("사라미 난다요");
    }

    @Override
    public void land() {
        System.out.println("닝겐ww");
    }

    @Override
    public void takeOff() {
        System.out.println("이륙해 닝겐 TAKE OFF");
    }

    public String stopBullet() {
        return "봉쉐죠?";
    }

}

public class InterfaceAppTest1 {

    public static void main(String[] args) {
        // Flyer f1 = new Flyer(); // 인터페이스는 객체 생성의 대상이 아님
        Flyer f2 = new Bird(); // 불가
        Flyer f3 = new SuperMan(); // 객체 생성시 타입으로 존재한다


    }

}