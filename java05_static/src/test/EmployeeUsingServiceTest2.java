//package com.edu.test;
///*
//
//            Employee   -----------------------> EmployeeService ----->EmployeeUsingServiceTest
//               |
// Manager    Engineer   Engineer
//
//
//
// */
//
//
//import com.edu.test.service.EmployService2;
//import com.edu.test.utill.MyDate4;
//import com.edu.test.vo.Employee4;
//import com.edu.test.vo.Engineer4;
//import com.edu.test.vo.Manager4;
//import com.edu.test.vo.Secretary4;
//
//public class EmployeeUsingServiceTest2 {
//    public static void main(String[] args) {
//        Employee4[] employee4s = {
//                new Manager4(111, "James", new MyDate4(1990, 3, 24), 200002.0, "IT"),
//                new Engineer4(222, "Gosling", new MyDate4(1990, 2, 24), 150.0, "python", 1000.),
//                new Manager4(333, "Peter", new MyDate4(1990, 1, 24), 450002.0, "IT"),
//                new Secretary4(444, "Juliet", new MyDate4(1990, 1, 24), 350002.0, "Gosling"),
//                new Manager4(555, "James1", new MyDate4(1990, 3, 24), 200002.0, "IT")
//        };
//
//
//        // Service 객체 생성
//        EmployService2 service = new EmployService2();
//
//        // Service 객체의 기능을 호출, 리턴된 데이터를 받아서 출력
//        System.out.println("\n========== 1. 직원 정보를 출력합니다.=================");
//        service.listAllEmployee(employee4s);
//
//        System.out.println("\n========== 2. 특정 직원을 검색합니다.=================");
//        Employee4 e1 = service.findEmployee(employee4s,333);
//        System.out.println(e1);
//
//        System.out.println("\n=========== 3. 동일한 부서에서 근무하는 직원을 검색합니다.=================");
//        Employee4[] temp1 = service.findEmployee(employee4s, "IT");
//        for (Employee4 e : temp1) {
//            if(e == null) continue;
//            System.out.println(e);
//        }
//
//        System.out.println("\n========== 4. 특정 직원의 연봉을 받아옵니다.=================");
//        System.out.println(service.getAnnualSalary(employee4s[3]) + "원");
//
//        System.out.println("\n========== 5. 총 인건비 정보입니다.=================");
//        System.out.println(service.getTotalCost(employee4s) + "원");
//
//    }
//}