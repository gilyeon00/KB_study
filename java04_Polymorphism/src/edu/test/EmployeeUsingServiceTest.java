package edu.test;
/*

            Employee   -----------------------> EmployeeService ----->EmployeeUsingServiceTest
               |
 Manager    Engineer   Engineer



 */
import edu.service.EmployService;
import edu.utill.MyDate3;
import edu.vo.Employee3;
import edu.vo.Engineer3;
import edu.vo.Manager3;
import edu.vo.Secretary3;

public class EmployeeUsingServiceTest {
    public static void main(String[] args) {
        Employee3[] employee3s = {
                new Manager3(111, "James", new MyDate3(1990, 3, 24), 200002.0, "IT"),
                new Engineer3(222, "Gosling", new MyDate3(1990, 2, 24), 150.0, "python", 1000.),
                new Manager3(333, "Peter", new MyDate3(1990, 1, 24), 450002.0, "IT"),
                new Secretary3(444, "Juliet", new MyDate3(1990, 1, 24), 350002.0, "Gosling"),
                new Manager3(555, "James1", new MyDate3(1990, 3, 24), 200002.0, "IT")
        };


        // Service 객체 생성
        EmployService service = new EmployService();

        // Service 객체의 기능을 호출, 리턴된 데이터를 받아서 출력
        System.out.println("\n========== 1. 직원 정보를 출력합니다.=================");
        service.listAllEmployee(employee3s);

        System.out.println("\n========== 2. 특정 직원을 검색합니다.=================");
        Employee3 e1 = service.findEmployee(employee3s,333);
        System.out.println(e1);

        System.out.println("\n=========== 3. 동일한 부서에서 근무하는 직원을 검색합니다.=================");
        Employee3[] temp1 = service.findEmployee(employee3s, "IT");
        for (Employee3 e : temp1) {
            if(e == null) continue;
            System.out.println(e);
        }

        System.out.println("\n========== 4. 특정 직원의 연봉을 받아옵니다.=================");
        System.out.println(service.getAnnualSalary(employee3s[3]) + "원");

        System.out.println("\n========== 5. 총 인건비 정보입니다.=================");
        System.out.println(service.getTotalCost(employee3s) + "원");

    }
}