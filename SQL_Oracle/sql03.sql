-- �׷��Լ� (GROUP)
-- �׷��Լ��� NULL���� �ǳʶڴ�. ���⼭ ���ܵǴ� �׷��Լ��� COUNT(*)

-- ��ü ����� ���� ����
SELECT COUNT(*) FROM emp;
SELECT COUNT(empno) FROM emp; -- ù��°���� �̰� �� ���� ǥ��, PK�̱⶧���� NULL���� ����
SELECT COUNT(-1) FROM emp; --�̰� ���ɻ� ���� ���� ǥ�� : �� ������ ���� ����

SELECT ROUND(AVG(sal)) "��ü ��� �޿��� ���", 
        SUM(sal)"��ü ��� �޿��� ��", 
        MIN(sal)"��ü ��� �޿� �� �ּҰ�", 
        MAX(sal) "��ü ��� �޿� �� �ְ�"
FROM emp;

SELECT MIN(hiredate) "�Ի����� ���� ������ ����� �Ի���", MAX(hiredate)"�Ի����� ���� �ֱ��� ����� �Ի���" FROM emp;


-- �μ���ȣ�� 10���̰ų� 20���� ����� ��ȸ COUNT()
SELECT COUNT(empno)
FROM emp
WHERE depto IN(10,20);

-- ��� ����� ���ʽ� ��� AVG()
-- Null�� ����
SELECT ROUND(AVG(comm)) "���ʽ� ���" FROM emp;
-- Null�� ����
SELECT ROUND(AVG(NVL(comm, 0))) "���ʽ� ���" FROM emp;


-- emp���̺����� �μ� ����(�ߺ� ��� x)
SELECT COUNT(DISTINCT(deptno)) "�μ� ����" FROM emp;

---- �μ��� ��� �޿�
-- �׷��Լ��� ����������� �÷��� SELECT���� ����
-- �ݵ�� GROUP By�� �ڿ� deptno�÷��� ����ؾ��Ѵ�. 
-- SELECT deptno, ROUND(AVG(sal))
-- FROM emp;
 SELECT deptno, ROUND(AVG(sal))
 FROM emp
 GROUP BY deptno;

SELECT deptno DNumber, ROUND(AVG(sal))
 FROM emp
 GROUP BY deptno   -- GROUP BY DNumer   -- GROUP BY�� SELECT���� ����ǹǷ� Alias��� �Ұ�
 ORDER BY DNumber;
--- Alias���� �Ұ� ���� : Where, Group By

SELECT deptno DNumber, ROUND(AVG(sal))
 FROM emp
 WHERE deptno != 10
 GROUP BY deptno    
 ORDER BY DNumber;
 
 
 -- �Ի�⵵�� ����� �ο��� ��ȸ
 SELECT EXTRACT(YEAR FROM hiredate) as Year FROM emp;
 SELECT EXTRACT(YEAR FROM hiredate) as Year, COUNT(empno)
 FROM emp
 GROUP BY EXTRACT(YEAR FROM hiredate)
 ORDER BY Year;
 
 SELECT TO_CHAR(hiredate, 'YY')�⵵, COUNT(*)
 FROM emp
 GROUP BY TO_CHAR(hiredate, 'YY')
 ORDER BY �⵵;


-- �μ��� ��ձ޿��� 2000�޷� �̻��� �μ��� �μ���ȣ�� ��� �޿��� ��ȸ
-- WHERE���ȿ� GROUP BY ���Ұ�
--SELECT detpno, ROUND(AVG(sal)) AvgSalary
--FROM emp 
--WHERE ROUND(AVG(sal)) >= 2000
--GROUP BY detpno;

-- �ǹ̷������� �׷����� �ϰ� �׸��� ���� ���ǿ� �´� �͸� ����
SELECT deptno, ROUND(AVG(sal)) AvgSalary
FROM emp 
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- �μ��� �ִ�޿��� 2900�޷��� �Ѵ� �μ����� �ִ�޿��� ����
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal)>=2900;

-- �μ��� ��ձ޿��� �ִ�޿��� �μ��� �޿� �˻�
SELECT *
FROM (
    SELECT deptno, ROUND(AVG(sal)) AvgSalary
    FROM emp
    GROUP BY deptno
    ORDER BY AvgSalary DESC
    )
WHERE rownum <= 1;



-- ROLLUP : �׷��Լ��� �����̳�, �� �׷캰 �߰��հ谡 �ʿ��� ���
SELECT deptno, job, SUM(sal)
FROM emp 
GROUP BY ROLLUP(deptno, job)
--GROUP BY ROLLUP(job, deptno);
ORDER BY 1;

-- �׷��� ������ : GROUPING SETS , UNION ALL 
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job)
ORDER BY deptno;

SELECT deptno, NULL job, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL deptno, job, SUM(sal)
FROM emp
GROUP By job
ORDER BY deptno;