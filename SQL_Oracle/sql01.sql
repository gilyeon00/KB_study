-- 테이블의 구조를 확인
DESC emp;
--이름       널?       유형           
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
--이름     널?       유형           
-------- -------- ------------ 
--DEPTNO NOT NULL NUMBER(2)    
--DNAME           VARCHAR2(14) 
--LOC             VARCHAR2(13) 


SELECT * FROM emp;

-- Projection : 검색하고자 하는 컬럼을 지정해서 가져온다
--  emp테이블에서 사원의 이름, 급여, 업무, 부서번호를 검색
SELECT ename, sal, job, deptno FROM emp;

-- SELECTION : 조건(WHERE절)을 부여해서 행을 제한
-- 10번 부서에서 근무하는 사원의 이름, 급여, 입사년도를 검색
-- 이때, 급여를 많이 받은 사원 순으로 정렬 (ORDER BY) 
SELECT ename, sal, hiredate
FROM emp
WHERE deptno = 10
ORDER BY sal DESC;

-- ALIAS 
SELECT empno, ename, job, deptno 부서번호
FROM emp
WHERE job = 'SALESMAN'
ORDER BY 부서번호;


SELECT empno, ename, job, deptno 부서번호, hiredate
FROM emp
WHERE deptno = 20
--WHERE 부서번호 = 20
ORDER BY hiredate;



-- (x) 사원 중에서 급여를 가장 많이 받는 사원 상위 3명 만 검색 (rownum)
SELECT ename, job, sal
FROM emp
WHERE rownum<=3
ORDER BY sal DESC;

-- (o) 사원 중에서 급여를 가장 많이 받는 사원 상위 3명 만 검색 (rownum)
-- WHERE절보다 ORDER BY절이 먼저 실행되어야함 (rownum이 ORDER BY보다 먼저 나와야함)
SELECT ename, job, sal
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;


-- 모든 사원의 급여를 기존 급여의 2배에 20달러를 추가한 급여로 인상
-- Alias에 공백이 있거나 특수문자, 대소문자 구분 상황이 있을 경우, ""로 묶기 
SELECT ename, sal "인상 전 급여", sal*2+20 "인상 후 급여"
FROM emp;


SELECT ename, sal "인상 전 급여", sal*2+20 "인상 후 급여"
FROM emp
ORDER BY "인상 후 급여";


--사원 급여에서 세금을 제외한 수령한 월급 검색 (세금은 원급의 10 %)
SELECT ename, sal, sal*0.9 "수령한 월급"
FROM emp;


-- EMP테이블에 있는 부서(deptno)를 검색
SELECT deptno FROM emp;

-- DISTINCT : 중복을 없앰
SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT(deptno) FROM emp;

-- DISTINCT 우회 방법 -> EXISTS 사용 (IN보다 좋음)
SELECT deptno FROM dept d
WHERE EXISTS 
    (SELECT * 
        FROM emp e 
            WHERE d.deptno = e.deptno);

 --  특정한 패턴으로 검색 ..
 -- LIKE 연산자 + 와일드카드() 
 -- 와일드카드 : %(All), _(Only One)
 -- 사원 중에서 사원 이름이 S로 시작하는 사원을 검색
 SELECT ename , job
 FROM emp
 WHERE ename LIKE 'S%';
 
 -- 사원 중에서 사원 이름에 a가 포함된 사원을 검색
 SELECT ename, job
 FROM emp
 WHERE ename LIKE '%A%';
 
 --80년에 입사한 사원 검색
 SELECT ename, job, hiredate
 FROM emp
 WHERE hiredate LIKE '80%';
 