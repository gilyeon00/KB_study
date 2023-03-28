package com.edu.service.impl;

import com.edu.service.EmployeeListService;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

import java.util.ArrayList;

public class EmployeeListServiceImpl implements EmployeeListService {

    // 필드 추가
    private ArrayList<Employee> list;

    // 싱글톤 - 생성자 생성
    private static EmployeeListServiceImpl service = new EmployeeListServiceImpl();
    private EmployeeListServiceImpl(){
        list = new ArrayList<>();
    }
    public static EmployeeListServiceImpl getInstance() {
        return service;
    }

    @Override
    public void addEmployee(Employee e) {
        // 추가하고자하는 인원이 존재 한다면 추가하면 안됨
        // 추가하고자하는 인원이 없을 때 추가
        boolean find = false;
        for (Employee emp : list) {
            if (emp.getEmpId().equals(e.getEmpId())) {
                find = true;
                System.out.println(e.getName() + "님은 이미 직원으로 등록되어있습니다");
                return;
            }
        }

        if (find == false) {
            list.add(e);
            System.out.println(e.getName() + "님을 직원으로 등록했습니다");
        }

    }

    @Override
    public void deleteEmployee(String empId) {
        boolean find = false;
        for (Employee e : list) {
            if (e.getEmpId().equals(empId)) {
                find = true;
                System.out.println(e.getName() + "님이 탈퇴처리 됐습니다.");
                list.remove(empId);
                return;
            }
        }
        System.out.println("삭제대상 직원을 찾을 수 없습니다.");
    }

    @Override
    public void updateEmployee(Employee e) {
        boolean find= false;
        for(Employee emp : list) {
            if(emp.getEmpId().equals(e.getEmpId())) { //수정할 대상이 존재한다면
                find = true;
                emp.setName(e.getName());
                emp.setAddr(e.getAddr());
                emp.setSalary(e.getSalary());
                if(emp instanceof Manager) {
                    ((Manager) emp).changeDept(((Manager) e).getDept());
                }else {
                    ((Engineer) emp).changeTech(((Engineer) e).getTech());
                    ((Engineer) emp).changeBonus(((Engineer) e).getBonus());
                }
            }//if
        }//for
        if (find == false) {
            System.out.println("수정할 직원정보가 존재하지 않습니다.");
        }
    }

    @Override
    public ArrayList<Employee> findEmployees(String addr) {
        ArrayList<Employee> temp = new ArrayList<>();
        boolean flag = false;
        for (Employee e : list) {
            if (e.getAddr().equals(addr)) {
                temp.add(e);
            }
        }
        if (temp == null) {
            System.out.println("해당 직원이 존재하지 않습니다");
        }
        return temp;
    }

    @Override
    public void findEmployees() {
        for (Employee e : list) {
            System.out.println(e);
        }
    }
}
