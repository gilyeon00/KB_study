-- �����ȣ�� 7369�̰ų� 7521�̰ų� 7782�� ���
SELECT empno, ename, job
FROM emp
WHERE empno=7369 OR empno=7521 OR empno=7782;

-- OR���� �� ���� ���
SELECT empno, ename, job
FROM emp
WHERE empno IN(7369, 7521,7782);

-- �ݴ� ��Ȳ
SELECT empno, ename, job
FROM emp
WHERE empno!=7369 OR empno^=7521 OR empno<>7782;

SELECT empno, ename, job
FROM emp
WHERE empno NOT IN(7369, 7521,7782);


-- SUBSTR()
-- ���ڿ��� �����ϴ� ���... �Լ����� ���ڰ��� ��Ȯ�� ����
SELECT SUBSTR('HELLO world', 6) FROM dual;    --world
SELECT SUBSTR('HELLO world', 6, 3) FROM dual; --wo

-- emp���̺��� 10�� �μ��� ��� �Ի�⵵�� ����
SELECT SUBSTR(hiredate, 1,2) �Ի�⵵
FROM emp
WHERE deptno = 10;


-- PAD : LPAD , RPAD
SELECT LPAD('abc', 6, '*') FROM DUAL;   -- ***abc
SELECT LPAD('abc', 6, '0') FROM DUAL;   -- abc00
SELECT LPAD(deptno, 10, '-') FROM emp;

-- TRIM : RTRIM, LTRIM
SELECT RTRIM('          James Gosling       ')FROM DUAL;        --          James Gosling 
SELECT LTRIM('          James Gosling       ')FROM DUAL;        -- James Gosling       |
SELECT TRIM('          James Gosling       ')FROM DUAL;         -- James Gosling 
SELECT REPLACE('          James Gosling       ', ' ','')FROM DUAL; -- JamesGosling


--- �����Լ�
SELECT ROUND(45.928, 2) FROM dual;  -- 45.93

-- FLOOR : �Ҽ��� �Ʒ��� ���� (= ������ ǥ�� = �ڸ��� �����ȵ�)
SELECT FLOOR(45.923) FROM dual;   -- 45

-- TRUNK : ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923, 2) FROM dual;  -- 45.92
SELECT TRUNC(45.923, 0) FROM dual;  -- 45

-- CEIL : �Ҽ��� �Ʒ��� �ø� (����)
SELECT CEIL(23.644) FROM dual;  -- 24


-- ��¥�Լ�
-- SYSDATE : ���� ��¥ 
SELECT SYSDATE FROM dual; 
SELECT SYSDATE + 1 FROM dual;  -- ���� ��¥
SELECT SYSDATE - 1 FROM dual;  -- ���� ��¥
SELECT SYSDATE + 100 "�츮���� �� 100��°" FROM dual;  

-- ���� ��ƿ� �ϻ�
SELECT ROUND(SYSDATE - TO_DATE('2000/12/08')) FROM dual;

-- ���ú��� 4���� ���� ��¥
SELECT ADD_MONTHS(SYSDATE, 4) "4���� ��"  FROM dual;

-- ���� ��ƿ� ���� �˻�
SELECT ROUND(MONTHS_BETWEEN(SYSDATE, TO_DATE('2000/12/08'))) "��ƿ� �� ��" FROM dual;

--EMP���̺��� ������� ������� �ٹ��� ��(Weeks)���� �˻�
SELECT ename, hiredate, TRUNC((SYSDATE -hiredate)/7) "Weeks"
FROM emp