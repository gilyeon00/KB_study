//package com2.test;
//
//import com2.service.EmployeeServiceImpl;
//import com2.util.MyDate;
//import com2.vo.Employee5;
//import com2.vo.Engineer5;
//import com2.vo.Manager5;
//
//public class EmployeeServiceTest {
//	public static void main(String[] args) {
//		//1. Service 객체를 생성
//		EmployeeServiceImpl service = EmployeeServiceImpl.getInstance();
//
//		//2. method를 각각 호출..
//		System.out.println("============ 1. addEmployee ============ ");
//		service.addEmployee(new Manager5("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
//		service.addEmployee(new Engineer5("BBB", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
//		service.addEmployee(new Manager5("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
//		service.addEmployee(new Manager5("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
//		service.addEmployee(new Engineer5("EEE", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
//		service.addEmployee(new Engineer5("FFF", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
//
//		System.out.println("============ Employee 정보확인 ============ ");
//		service.printEmployees();
//
//
//
//
//		System.out.println("\n============ 2. deleteEmployee(BBB 삭제) ============ ");
//		service.deleteEmployee("BBB");
//
//
//		System.out.println("============ Employee 정보확인 ============ ");
//		service.printEmployees();
//
//		System.out.println("\n============ 3. updateEmployee(CCC 부서 수정 교육부->개발부) ============ ");
//		service.updateEmployee("CCC", 20000.0, "개발부", 30, "", 0.0);//?
//
//		System.out.println("============ Employee 정보확인 ============ ");
//		service.printEmployees();
//
//
//		System.out.println("\n============ 4. findMEmployee(AAA) ============ ");
//		Employee5 emp1=service.findEmployee("AAA");
//		System.out.println(emp1);
//
//		System.out.println("\n============ 4. findMEmployee(10) ============ ");
//		System.out.println("30번 부서에 근무하는 직원들 입니다..");
//		Employee5[ ] emps= service.findEmployee(10);
//		for(Employee5 e : emps) {
//			if(e==null) continue;
//			System.out.println(e);
//		}
//	}
//}
//
//
//
//
//
//
//
