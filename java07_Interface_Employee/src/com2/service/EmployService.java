package com2.service;

import com2.vo.Employee5;

public interface EmployService {
    void addEmployee(Employee5 e);
    void deleteEmployee(String name);
    Employee5 findEmployee(String name);
    Employee5[] findEmployee(int deptno);
    void printEmployees();
}
