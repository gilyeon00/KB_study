package com2.service;

import com2.vo.Employee5;
import com2.vo.Engineer5;
import com2.vo.Manager5;

public class EmployeeService {
	int midx;

	// Create
	public void addEmployee(Employee5[] employee5s, Employee5 e) {
		employee5s[midx++] = e;
		System.out.println(e.toString());
	}

	// Read All
	public void printAllEmployee(Employee5[] employee5s) {
		for(Employee5 e : employee5s) System.out.println(e.toString());
	}

	// Read One
	public Employee5 findEmployee(Employee5[] employee5s, String name) {
		for (Employee5 e : employee5s) {
			if (e == null) continue;
			if (e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}

	// Read One
	public Employee5 findEmployee(Employee5[] employee5s, int deptno) {
		for (Employee5 e : employee5s) {
			if(e instanceof Engineer5) return null;
			if (e == null) continue;
			if ( ((Manager5) e).getDeptno() == deptno ) {
				return e;
			}
		}
		return null;
	}

	// Delete One
	public void deleteEmployee(Employee5[] employee5s, String name) {
		for (Employee5 e : employee5s) {
			if (e.getName().equals(name)) {
//				employees.remove(e);
			}
		}
	}

	// Update
	public void updateEmployee(Employee5[] employee5s, Employee5 target) {
		for (Employee5 e : employee5s) {
			if(e == null) continue;
			if (e.getName().equals(target.getName())) {
				if (target instanceof Manager5) {
					((Manager5) e).setDept(((Manager5) target).getDept());
					((Manager5) e).setDeptno(((Manager5) target).getDeptno());
					e.setSalary(target.getSalary());
				} else if (target instanceof Engineer5) {
					e.setSalary(target.getSalary());
					((Engineer5) e).setBonus(((Engineer5) target).getSalary());
					((Engineer5) e).setTech(((Engineer5) target).getTech());
				}
			}
		}
	}


}

