[Oracle 제약조건]
emp , dept 테이블에서 먼저 한다.
1.CTAS를 이용해서 EMPLOYEE, DEPARTMENT 테이블 생성
DROP TABLE employee;
DROP TABLE department;

-- 데용량 데이터 샘플링할 때 사용하는 용도, pk자동생성 x
CREATE TABLE employee
AS
SELECT * FROM emp;

DESC employee;

CREATE TABLE department
AS
SELECT * FROM dept;


2.기본키 제약조건 추가
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);

desc employee; //제약조건 추가확인

ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

desc department; //제약조건 추가확인

delete employee where deptno=10; --삭제됨

-- 외래키를 설정하는 순간 자식생김. 자식이 있으면 삭제안됨 -> ON DELETE CASCADE옵션 넣어야됨
delete department where deptno=20; --삭제됨

select * from employee; -- 이 부분에 20번 부서의 사원이 남아있어서는 안 된다..연관성 없는 결
과


3.외래키 제약조건을 추가
이 작업 하기 전에 다시 employee와 department를 원래대로 해놓자
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno);

--- department의 부서 20번을 삭제
delete department where deptno=20; //자식을 가진 부모는 삭제될 수 없다.

/*
해결책
자식을 죽이고 부모가 죽는다
기본키, 외래키 제약조건을 추가함. 이때 ON DELETE CASCADE 옵션을 함께 지정
*/


4. ON DELETE CASCADE 옵션을 지정함
--  자식을 가지고있는 부모 삭제안됨
--자식을 먼저 죽이고 부모가 죽어야됨
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;
확인작업
delete employee where deptno=10;
delete department where deptno=20;
select * from employee;