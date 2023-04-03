/*
    Self Join
    
*/

-- 1. Ư�� ����� ename ��ȸ
-- 2. ename�� �ش��ϴ� mgr��ȣ ã�´�
-- 3. �ٽ� emp���̺��� empno�� mgr�� ����� ã�Ƽ� ename�� ã�´�

--STEP 1.
SELECT ename, mgr FROM emp; -- BLAKE ����� ����ȣ�� ã��
SELECT ename, ename FROM emp; -- ����ȣ�� ��ġ�ϴ� �����ȣ�� ã�� �׿� �ش��ϴ� ��� �̸��� ã�´�

--STEP 2. ���� ���� �߰�
SELECT * 
FROM (SELECT ename, mgr FROM emp) e,
    (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

--STEP 3. 
SELECT e.empno, e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno;

--STEP 4. 
SELECT e.empno, e.ename ����̸�, m.ename ����̸�
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'BLAKE';


SELECT * FROM dept;

/*
    Outer Join
*/
Select e.empno, e.ename, e.job, e.deptno e_deptno, d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);
