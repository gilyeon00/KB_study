package test;

class Service{
    // 1.
    private static Service service = new Service();

    //2.
    private Service(){
        System.out.println("Singletone is Ready");
    }

    // 3.
    public static Service getInstance() {
        return service;
    }
}


public class StaticExamTest3 {
    public static void main(String[] args) {
//       Service s1 = new Service();
        Service s1 = Service.getInstance();     // static 싱글톤 사용 방법
        Service s2 = Service.getInstance();
        System.out.println(s1);     // com.edu.test.Service@511baa65
        System.out.println(s2);     // com.edu.test.Service@511baa65     같은 주소 = 같은 객체
    }
}
