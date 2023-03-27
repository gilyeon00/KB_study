package com.edu.service;
/*
    기능들만 정의된 Service 클래스

    1. 상속 기술 사용 안했을 경우
    Manager     Engineer        Secretary

    step1) 가장 저차원적인 기능 정의
        >> 추가에 돠년된 기능을 정의
            public void addManager(Manger m) {}
            public void insertEngineer(Engineer eg){}
            public void plusSecretaryMember(Secretary s){}
    step2)
        public void addManager(Manager m) {}
        public void addEngineer(Engineer eg) {}
        public void addSecretary (Secretary s) {}


    2. 상속을 사용할 경우
                Employee (다양한 이기종간의 자식 클래스들을 단일하게 관리)
    Manager     Engineer        Secretary

    step3)
        public void addEmployee(Manager m) {}
        public void createEmployee(Engineer eg) {}
        public void deleteEmployee(Secretary s) {}
    -> Method Overloading : 하는 일은 같지만 처리하는 데이터를 달리할 때 사용
        1. 메소드 이름은 같아야함
        2. 메소드 인자값은 다르다
        3. 리턴 타입은 상관없다.

    step4) - Employee e로 모든 자식들을 받는다. Polymorphic Argument
        public void addEmployee(Employee e){
        if(e instanceOf Manager) {}
        if(e instanceOf Engineer) {}
        if(e instanceOf Secretary) {}
        }

 */

import com.edu.vo.Employee;
import com.edu.vo.Employee3;

import java.util.ArrayList;

public class EmployService {

    // 1. 모든 직원의 정보를 출력하는 기능을 정의
    public void listAllEmployee () {

    }

    // 2. 모든 직원 중 특정한 직원을 검색하는 기능을 정의
    // 검색은 find ~ search ~ 로 시
    public Employee3 findEmployee(Employee3[ ] employees, int empId){
        Employee3 employee = null;  // 무조건 초기화해주기

        return employee;
    }

    // 3. 모든 직원중 동일한 부서에서 근무하는 직원을 검색 - overRoading
    public Employee3[] findEmployee(Employee3[ ] employees, String dept){
        Employee3[] temp = new Employee3[employees.length];   // 항상 사이즈 초기화. 일단은 임시로 크게 잡아주기때문에 temp로 설정

        return temp;
    }

    // 4. 특정한 직원의 연봉을 리턴하는 기능을 정의
    public int getAnnualSalary (Employee3 e) {
        int annualSalary = 0;

        return annualSalary;
    }

    // 5. 모든 직원의 연간 총 인건비를 리턴하는 기능을 정의
    public int getTotalCost(Employee[] employees) {
        int totalCost = 0;

        return totalCost;
    }


}
