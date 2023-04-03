-- emp테이블에서 사원의 이름과 사원이 입사한 년, 월, 일을 추출 
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


-- 조건절 
Select ename, job,
    DECODE(job, 'PRESIDENT', '사장',
        'MANAGER', '관리자') 직원분류
FROM emp;

SELECT ename, deptno,
    CASE WHEN deptno='10' THEN '뉴욕'
        WHEN deptno='20' THEN 'Dallas'
        ELSE 'city'
    END 