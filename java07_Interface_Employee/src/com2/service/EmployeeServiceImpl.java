//package com2.service;
//
//import com2.vo.Engineer5;
//import com2.vo.Manager5;
//import com2.vo.Employee5;
//
//public class EmployeeServiceImpl extends EmployeeService {
//
//	private static EmployeeServiceImpl service = new EmployeeServiceImpl(10);
//
////	Manager[ ] ms;
////	int midx;
////
////	Engineer[ ] egs;
////	int egidx;
//
//	Employee5[ ] employee5s;
//	int idx = 0;
//
//	public EmployeeServiceImpl(int size){
//		employee5s = new Employee5[size];
//	}
//
//	public static EmployeeServiceImpl getInstance() {
//		return service;
//	}
//
//	public void addEmployee(Employee5 e) {
//		employee5s[idx++] = e;
//		System.out.println(e.getName()+" 님이 등록되셨습니다~~!");
//	}
//
//	public void deleteEmployee(String name) {
//		for(int i=0; i<idx; i++) {
//			if(employee5s[i].getName().equals(name)) {
//				for(int j=i; j<idx; j++) {
//					employee5s[j] = employee5s[j+1];
//				}
//				employee5s[idx] = null;
//				idx--;
//			}
//		}
//		System.out.println(name+" 님이 탈퇴처리 되었습니다.~~!!");
//	}
//
//	public void updateEmployee(String name, double salary, String dept, int deptno, String tech, double bonus) {
//		for(Employee5 e : employee5s) {
//			if(e==null) continue;
//			if(e.getName().equals(name)) {
//				e.setSalary(salary);
//				if(e instanceof Manager5) {
//					((Manager5) e).changeDept(dept);
//					((Manager5) e).changeDeptno(deptno);
//				}
//				if(e instanceof Engineer5) {
//					((Engineer5) e).changeTech(tech);
//					((Engineer5) e).changeBonus(bonus);
//				}
//			}
//		}
//	}
//
//	public Employee5 findEmployee(String name) {
//		Employee5 e = null;
//		for(Employee5 emp : employee5s) {
//			if(emp==null)continue;
//			if(emp.getName().equals(name))
//				e = emp;
//		}
//
//		return e;
//	}
//	public Employee5[] findEmployee(int deptno) {
//		Employee5[ ] temp= new Employee5[10];
//		int count = 0;
//		for(Employee5 emp : employee5s) {
//			if(emp==null) continue;
//			if(emp instanceof Manager5) {
//				if(((Manager5) emp).getDeptno()== deptno)
//					temp[count++] = emp;
//			}
//		}
//
//		return temp;
//	}
//
//	public void printEmployees() {
//		for(Employee5 emp : employee5s) {
//			if(emp==null) continue;
//		System.out.println(emp);
//		}
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
