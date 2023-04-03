[Oracle ��������]
emp , dept ���̺��� ���� �Ѵ�.
1.CTAS�� �̿��ؼ� EMPLOYEE, DEPARTMENT ���̺� ����
DROP TABLE employee;
DROP TABLE department;

-- ���뷮 ������ ���ø��� �� ����ϴ� �뵵, pk�ڵ����� x
CREATE TABLE employee
AS
SELECT * FROM emp;

DESC employee;

CREATE TABLE department
AS
SELECT * FROM dept;


2.�⺻Ű �������� �߰�
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);

desc employee; //�������� �߰�Ȯ��

ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

desc department; //�������� �߰�Ȯ��

delete employee where deptno=10; --������

-- �ܷ�Ű�� �����ϴ� ���� �ڽĻ���. �ڽ��� ������ �����ȵ� -> ON DELETE CASCADE�ɼ� �־�ߵ�
delete department where deptno=20; --������

select * from employee; -- �� �κп� 20�� �μ��� ����� �����־�� �� �ȴ�..������ ���� ��
��


3.�ܷ�Ű ���������� �߰�
�� �۾� �ϱ� ���� �ٽ� employee�� department�� ������� �س���
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno);

--- department�� �μ� 20���� ����
delete department where deptno=20; //�ڽ��� ���� �θ�� ������ �� ����.

/*
�ذ�å
�ڽ��� ���̰� �θ� �״´�
�⺻Ű, �ܷ�Ű ���������� �߰���. �̶� ON DELETE CASCADE �ɼ��� �Բ� ����
*/


4. ON DELETE CASCADE �ɼ��� ������
--  �ڽ��� �������ִ� �θ� �����ȵ�
--�ڽ��� ���� ���̰� �θ� �׾�ߵ�
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;
Ȯ���۾�
delete employee where deptno=10;
delete department where deptno=20;
select * from employee;