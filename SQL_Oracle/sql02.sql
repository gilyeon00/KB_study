-- 사원번호가 7369이거나 7521이거나 7782인 사원
SELECT empno, ename, job
FROM emp
WHERE empno=7369 OR empno=7521 OR empno=7782;

-- OR보다 더 좋은 방법
SELECT empno, ename, job
FROM emp
WHERE empno IN(7369, 7521,7782);

-- 반대 상황
SELECT empno, ename, job
FROM emp
WHERE empno!=7369 OR empno^=7521 OR empno<>7782;

SELECT empno, ename, job
FROM emp
WHERE empno NOT IN(7369, 7521,7782);


-- SUBSTR()
-- 문자열을 추출하는 기능... 함수안의 인자값을 정확히 이해
SELECT SUBSTR('HELLO world', 6) FROM dual;    --world
SELECT SUBSTR('HELLO world', 6, 3) FROM dual; --wo

-- emp테이블에서 10번 부서의 사원 입사년도만 추출
SELECT SUBSTR(hiredate, 1,2) 입사년도
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


--- 숫자함수
SELECT ROUND(45.928, 2) FROM dual;  -- 45.93

-- FLOOR : 소수점 아래를 버림 (= 정수만 표시 = 자리수 지정안됨)
SELECT FLOOR(45.923) FROM dual;   -- 45

-- TRUNK : 지정된 자릿수 이하를 버림
SELECT TRUNC(45.923, 2) FROM dual;  -- 45.92
SELECT TRUNC(45.923, 0) FROM dual;  -- 45

-- CEIL : 소수점 아래를 올림 (정수)
SELECT CEIL(23.644) FROM dual;  -- 24


-- 날짜함수
-- SYSDATE : 오늘 날짜 
SELECT SYSDATE FROM dual; 
SELECT SYSDATE + 1 FROM dual;  -- 내일 날짜
SELECT SYSDATE - 1 FROM dual;  -- 어제 날짜
SELECT SYSDATE + 100 "우리만난 지 100일째" FROM dual;  

-- 내가 살아온 일생
SELECT ROUND(SYSDATE - TO_DATE('2000/12/08')) FROM dual;

-- 오늘부터 4개월 후의 날짜
SELECT ADD_MONTHS(SYSDATE, 4) "4개월 후"  FROM dual;

-- 내가 살아온 월수 검색
SELECT ROUND(MONTHS_BETWEEN(SYSDATE, TO_DATE('2000/12/08'))) "살아온 월 수" FROM dual;

--EMP테이블에서 사원들이 현재까지 근무한 주(Weeks)수를 검색
SELECT ename, hiredate, TRUNC((SYSDATE -hiredate)/7) "Weeks"
FROM emp