/*
    ��������
*/

-- ������ ��������
-- CLARK�� �޿����� �� ���� �޿��� �޴� ����� �˻�

--- STEP 1 : ���� ���� why? SQL parsing�� 2�� �ϱ� ����
SELECT sal FROM emp WHERE ename='CLARK';    -- ��������  -- 2450
SELECT ename, sal FROM emp WHERE sal>2450;  -- ��������

--- STEP 2 : sql�Ľ��� 1���ϰ� ���̺��� 2�� ȣ��
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='CLARK');


-- 1. Where���� ���� ��������
-- ename�� KING�� ����� ���� �μ����� ���ϴ� ��� �˻�
SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename='KING');

-- 2. Having���� ���� ��������
-- job�� ��� �޿�����, ���� ���� ��� �޿�
SELECT ROUND(MIN(AVG(sal))) FROM emp GROUP BY job;  -- 1038

SELECT job, ROUND(AVG(sal))     -- 1038�� ������ job
FROM emp
GROUP BY job
HAVING AVG(sal)  = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--  �μ��� �ּұ޿� �߿��� 20�� �μ��� �ּұ޿����� �� ū �ּұ޿� �˻�
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno=20);


-- 3. From�� ���� ��������
SELECT ename, sal, rownum 
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;


-- ���� �� ���� ��������
SELECT empno, ename
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp GROUP BY deptno);


-- job�� SALESMAN�� �ּ� �� �� �̻��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ������ ��ȸ
--- ������ �������� ���
SELECT ename,sal, job
FROM emp 
WHERE job != 'SALESMAN'  AND
    sal > ANY (SELECT sal FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;

--- ������ �������� ���
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' AND
    sal > (SELECT MIN(sal) FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;


-- job�� SALESMAN�� ��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ������ ��ȸ
--- ������ �������� ���
SELECT ename,sal, job
FROM emp 
WHERE job != 'SALESMAN'  AND
    sal > ALL (SELECT sal FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;

--- ������ �������� ���
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' AND
    sal > (SELECT MAX(sal) FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;


-- SCOTT�� �޿����� �� ���� �޿��� �޴� ����� �˻�
-- 1.
SELECT ename, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- 2.
SELECT *
FROM emp main, (SELECT sal FROM emp WHERE ename = 'SCOTT') sub
WHERE main.sal > sub.sal;


--- ��ȣ ����
-- ��ȣ���� ���������� main query�� �ִ� ���̺� Į���� �����Ѵ�.
-- ���� ���� ���� : 1.��ȣ���� ��������  2.��������  3.��������
SELECT ename, sal, deptno, hiredate, job
FROM EMP E
WHERE sal > (SELECT AVG(sal) FROM EMP WHERE deptno = E.deptno);

-- ����� ������ �� �ִ� ���(mgr)�� ��� �޿�����, �޿��� �� ���� �޴� ��� ������ ��ȸ
SELECT ename, job, sal
FROM EMP E
WHERE sal > (SELECT AVG(sal) FROM EMP WHERE E.empno = mgr);


/* ���������� �����ϴ� �����Ͱ� ��뷮�� ���, 
    EXISTS�� �ϳ� �����ϸ� �ٷ� True ���ϵǼ� Main������ ���ư�
    IN�� ���δ� �����ϰ�, MAIN�� ������ ���Ѵ�. 
*/

--- EXISTS : �����ϴ� ���� 1���̶� �����ϸ� Scan�� ���߰� �ٷ� True -> ���� �ְ� 
SELECT deptno, dname
FROM dept d
WHERE EXISTS (SELECT 1 FROM emp WHERE deptno = d.deptno);

--- DISTINCT 
SELECT DISTINCT d.deptno, dname
FROM dept d, emp e
WHERE e.deptno = d.deptno;

--- IN : �־��� ���� why? 1.������������ : emp�ȿ� �ִ� deptno�� ���δ� ����) 2.Where������ ������ ��
SELECT deptno, dname
FROM dept
WHERE deptno IN (SELECT deptno FROM emp WHERE job='MANAGER');

