package com2.test;


import com2.service.EmployeeService;
import com2.util.MyDate;
import com2.vo.Employee5;
import com2.vo.Engineer5;
import com2.vo.Manager5;

public class EmployeeServiceTest2 {
	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeService service = new EmployeeService();

		final int SIZE = 7;
		Employee5[] employee5s = new Employee5[SIZE];
		
		//2. method를 각각 호출..
		System.out.println("============ addManager ============ ");
		service.addEmployee(employee5s, new Manager5("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addEmployee(employee5s, new Manager5("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addEmployee(employee5s, new Manager5("BBB", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		service.addEmployee(employee5s, new Manager5("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		service.addEmployee(employee5s, new Manager5("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		service.addEmployee(employee5s, new Engineer5("EEE", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEmployee(employee5s, new Engineer5("FFF", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEmployee(employee5s, new Engineer5("GGG", new MyDate(1994,11,2), 450000.0, "Python", 300.0));


		System.out.println("============ Employee - 전체 정보확인 ============ ");
		service.printAllEmployee(employee5s);
		
		System.out.println("\n============ Delete (AAA 삭제) ============ ");
//		service.deleteEmployee("AAA", employees);
//		System.out.println(Arrays.toString(employees.toArray()));
		
		System.out.println("\n============ Update (CCC 연봉 수정 200->350) ============ ");
		Employee5 e = new Manager5("CCC", 350);
		service.updateEmployee(employee5s, e);

		
		System.out.println("\n============ findManager(10) ============ ");
		System.out.println("10번 부서에 근무하는 직원들 입니다..");
		service.findEmployee(employee5s, 10);
	}
}







