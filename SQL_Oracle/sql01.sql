-- ���̺��� ������ Ȯ��
DESC emp;
--�̸�       ��?       ����           
---------- -------- ------------ 
--EMPNO    NOT NULL NUMBER(4)    
--ENAME             VARCHAR2(10) 
--JOB               VARCHAR2(9)  
--MGR               NUMBER(4)    
--HIREDATE          DATE         
--SAL               NUMBER(7,2)  
--COMM              NUMBER(7,2)  
--DEPTNO            NUMBER(2) 

DESC dept;
--�̸�     ��?       ����           
-------- -------- ------------ 
--DEPTNO NOT NULL NUMBER(2)    
--DNAME           VARCHAR2(14) 
--LOC             VARCHAR2(13) 


SELECT * FROM emp;

-- Projection : �˻��ϰ��� �ϴ� �÷��� �����ؼ� �����´�
--  emp���̺��� ����� �̸�, �޿�, ����, �μ���ȣ�� �˻�
SELECT ename, sal, job, deptno FROM emp;

-- SELECTION : ����(WHERE��)�� �ο��ؼ� ���� ����
-- 10�� �μ����� �ٹ��ϴ� ����� �̸�, �޿�, �Ի�⵵�� �˻�
-- �̶�, �޿��� ���� ���� ��� ������ ���� (ORDER BY) 
SELECT ename, sal, hiredate
FROM emp
WHERE deptno = 10
ORDER BY sal DESC;

-- ALIAS 
SELECT empno, ename, job, deptno �μ���ȣ
FROM emp
WHERE job = 'SALESMAN'
ORDER BY �μ���ȣ;


SELECT empno, ename, job, deptno �μ���ȣ, hiredate
FROM emp
WHERE deptno = 20
--WHERE �μ���ȣ = 20
ORDER BY hiredate;



-- (x) ��� �߿��� �޿��� ���� ���� �޴� ��� ���� 3�� �� �˻� (rownum)
SELECT ename, job, sal
FROM emp
WHERE rownum<=3
ORDER BY sal DESC;

-- (o) ��� �߿��� �޿��� ���� ���� �޴� ��� ���� 3�� �� �˻� (rownum)
-- WHERE������ ORDER BY���� ���� ����Ǿ���� (rownum�� ORDER BY���� ���� ���;���)
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;


-- ��� ����� �޿��� ���� �޿��� 2�迡 20�޷��� �߰��� �޿��� �λ�
-- Alias�� ������ �ְų� Ư������, ��ҹ��� ���� ��Ȳ�� ���� ���, ""�� ���� 
SELECT ename, sal "�λ� �� �޿�", sal*2+20 "�λ� �� �޿�"
FROM emp;


SELECT ename, sal "�λ� �� �޿�", sal*2+20 "�λ� �� �޿�"
FROM emp
ORDER BY "�λ� �� �޿�";


--��� �޿����� ������ ������ ������ ���� �˻� (������ ������ 10 %)
SELECT ename, sal, sal*0.9 "������ ����"
FROM emp;


-- EMP���̺� �ִ� �μ�(deptno)�� �˻�
SELECT deptno FROM emp;

-- DISTINCT : �ߺ��� ����
SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT(deptno) FROM emp;

-- DISTINCT ��ȸ ��� -> EXISTS ��� (IN���� ����)
SELECT deptno FROM dept d
WHERE EXISTS 
    (SELECT * 
        FROM emp e 
            WHERE d.deptno = e.deptno);

 --  Ư���� �������� �˻� ..
 -- LIKE ������ + ���ϵ�ī��() 
 -- ���ϵ�ī�� : %(All), _(Only One)
 -- ��� �߿��� ��� �̸��� S�� �����ϴ� ����� �˻�
 SELECT ename , job
 FROM emp
 WHERE ename LIKE 'S%';
 
 -- ��� �߿��� ��� �̸��� a�� ���Ե� ����� �˻�
 SELECT ename, job
 FROM emp
 WHERE ename LIKE '%A%';
 
 --80�⿡ �Ի��� ��� �˻�
 SELECT ename, job, hiredate
 FROM emp
 WHERE hiredate LIKE '80%';
 