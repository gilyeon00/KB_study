-- emp���̺��� ����� �̸��� ����� �Ի��� ��, ��, ���� ���� 
SELECT ename, hiredate,
    EXTRACT (YEAR FROM hiredate) "YEAR",
    EXTRACT (MONTH FROM hiredate) "MONTH",
    EXTRACT (DAY FROM hiredate) "DAY"
FROM emp
WHERE deptno = 20;


CREATE TABLE test(num number);

DESC test;

INSERT INTO test VALUES(2003050);

SELECT to_char(num, '999,999,999') FROM test;


-- ������ 
Select ename, job,
    DECODE(job, 'PRESIDENT', '����',
        'MANAGER', '������') �����з�
FROM emp;

SELECT ename, deptno,
    CASE WHEN deptno='10' THEN '����'
        WHEN deptno='20' THEN 'Dallas'
        ELSE 'city'
    END 