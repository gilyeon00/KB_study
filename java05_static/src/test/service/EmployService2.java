//package com.edu.test.service;
//
//import com.edu.test.vo.Employee4;
//import com.edu.test.vo.Engineer4;
//import com.edu.vo.Employee3;
//import com.edu.vo.Engineer3;
//import com.edu.vo.Manager3;
//
//// 싱글톤 패턴으로 작성
//public class EmployService2 {
//
//    // 1.
//    private static EmployService2 service = new EmployService2();
//
//
//    // 2.
//    private EmployService2() {
//        System.out.println("EmployeeService creating... Only One !");
//    }
//
//    // 3.
//    public static EmployService2 getService(){
//        return service;
//    }
//
//
//    // 1. 모든 직원의 정보를 출력하는 기능을 정의
//    public void listAllEmployee (Employee4[] employee3s) {
//        for (Employee4 e : employee3s) {
//            System.out.println(e);
//        }
//    }
//
//    // 2. 모든 직원 중 특정한 직원을 검색하는 기능을 정의
//    // 검색은 find ~ search ~ 로 시
//    public Employee4 findEmployee(Employee4[ ] employees, int empId){
//        Employee3 employee = null;  // 무조건 초기화해주기
//        for (Employee4 e : employees) {
//            if (e.getEmpId() == empId) {
//                employee = e;
//                break;
//            }
//        }
//        return employee;
//    }
//
//    // 3. 모든 직원중 동일한 부서에서 근무하는 직원을 검색 - overRoading
//    public Employee4[] findEmployee(Employee4[ ] employees, String dept){
//        Employee4[] temp = new Employee3[employees.length];   // 항상 사이즈 초기화. 일단은 임시로 크게 잡아주기때문에 temp로 설정
//        int idx = 0;
//        for (Employee4 e : employees) {
//            if (e instanceof Manager4) {
//                if (((Manager4) e).getDept().equals(dept)) temp[idx++] = e;
//            }
//        }
//        return temp;
//    }
//
//    // 4. 특정한 직원의 연봉을 리턴하는 기능을 정의
//    public int getAnnualSalary (Employee4 e) {
//        int annualSalary = 0;
//        annualSalary = (int)(e.getSalary() * 12);
//
//        if (e instanceof Engineer4) {
//            annualSalary += ((Engineer4) e).getBonus();
//        }
//        return annualSalary;
//    }
//
//    // 5. 모든 직원의 연간 총 인건비를 리턴하는 기능을 정의
//    public int getTotalCost(Employee3[] employees) {
//        int totalCost = 0;
//        for (Employee3 e : employees) {
//            totalCost = getAnnualSalary(e);     // 코드 재사용
//        }
//        return totalCost;
//    }
//
//}
