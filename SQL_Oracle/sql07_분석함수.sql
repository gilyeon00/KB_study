/*
    �м��Լ�
*/

-- PARTITION BY :  �׷���
SELECT ename, sal, deptno,
    RANK() OVER( ORDER BY sal DESC ) ALL_RANKING,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC ) DEPT_RANKING
FROM emp;




SELECT ename, sal, rownum
FROM emp
ORDER BY sal DESC;

SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC);

-- over()�� ���� ���������� �ٸ� ���̺� 1�� �����ϱ⶧��
----   over() ���� partition by()�� ������ �׷����� �Ǽ� �� ����
SELECT ename, sal,
    ROW_NUMBER() 
        OVER(ORDER BY sal DESC) ranking
FROM emp;

-- �μ� ������ �޿��� ���� ������� ���� �ο�
SELECT empno, ename, deptno, sal,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal,
    DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) "RK"
FROM emp;