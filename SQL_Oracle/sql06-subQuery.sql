/*
    서브쿼리
*/

-- 단일행 서브쿼리
-- CLARK의 급여보다 더 많은 급여를 받는 사원을 검색

--- STEP 1 : 성능 저하 why? SQL parsing을 2번 하기 때문
SELECT sal FROM emp WHERE ename='CLARK';    -- 서브쿼리  -- 2450
SELECT ename, sal FROM emp WHERE sal>2450;  -- 메인쿼리

--- STEP 2 : sql파싱을 1번하고 테이블을 2번 호출
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='CLARK');


-- 1. Where절에 들어가는 서브쿼리
-- ename이 KING인 사원과 같은 부서에서 일하는 사원 검색
SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE ename='KING');

-- 2. Having절에 들어가는 서브쿼리
-- job별 평균 급여에서, 가장 작은 평균 급여
SELECT ROUND(MIN(AVG(sal))) FROM emp GROUP BY job;  -- 1038

SELECT job, ROUND(AVG(sal))     -- 1038을 가지는 job
FROM emp
GROUP BY job
HAVING AVG(sal)  = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--  부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여 검색
SELECT deptno, MIN(sal)
FROM emp
GROUP BY deptno
HAVING MIN(sal) > (SELECT MIN(sal) FROM emp WHERE deptno=20);


-- 3. From절 들어가는 서브쿼리
SELECT ename, sal, rownum 
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;


-- 다중 행 리턴 서브쿼리
SELECT empno, ename
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp GROUP BY deptno);


-- job이 SALESMAN인 최소 한 명 이상의 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무를 조회
--- 다중행 서브쿼리 사용
SELECT ename,sal, job
FROM emp 
WHERE job != 'SALESMAN'  AND
    sal > ANY (SELECT sal FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;

--- 단일행 서브쿼리 사용
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' AND
    sal > (SELECT MIN(sal) FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;


-- job이 SALESMAN인 모든 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무를 조회
--- 다중행 서브쿼리 사용
SELECT ename,sal, job
FROM emp 
WHERE job != 'SALESMAN'  AND
    sal > ALL (SELECT sal FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;

--- 단일행 서브쿼리 사용
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' AND
    sal > (SELECT MAX(sal) FROM emp WHERE job = 'SALESMAN')
ORDER BY sal;


-- SCOTT의 급여보다 더 많은 급여를 받는 사원을 검색
-- 1.
SELECT ename, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SCOTT');

-- 2.
SELECT *
FROM emp main, (SELECT sal FROM emp WHERE ename = 'SCOTT') sub
WHERE main.sal > sub.sal;


--- 상호 연관
-- 상호연관 서브쿼리는 main query에 있는 테이블 칼럼을 참조한다.
-- 쿼리 실행 순서 : 1.상호연관 서브쿼리  2.서브쿼리  3.메인쿼리
SELECT ename, sal, deptno, hiredate, job
FROM EMP E
WHERE sal > (SELECT AVG(sal) FROM EMP WHERE deptno = E.deptno);

-- 사원을 관리할 수 있는 사람(mgr)의 평균 급여보다, 급여를 더 많이 받는 사원 정보를 조회
SELECT ename, job, sal
FROM EMP E
WHERE sal > (SELECT AVG(sal) FROM EMP WHERE E.empno = mgr);


/* 서브쿼리를 수행하는 데이터가 대용량일 경우, 
    EXISTS는 하나 만족하면 바로 True 리턴되서 Main쿼리로 돌아감
    IN은 전부다 수행하고, MAIN과 일일히 비교한다. 
*/

--- EXISTS : 만족하는 행이 1건이라도 존재하면 Scan을 멈추고 바로 True -> 성능 최고 
SELECT deptno, dname
FROM dept d
WHERE EXISTS (SELECT 1 FROM emp WHERE deptno = d.deptno);

--- DISTINCT 
SELECT DISTINCT d.deptno, dname
FROM dept d, emp e
WHERE e.deptno = d.deptno;

--- IN : 최악의 쿼리 why? 1.서브쿼리실행 : emp안에 있는 deptno을 전부다 수행) 2.Where절에서 일일히 비교
SELECT deptno, dname
FROM dept
WHERE deptno IN (SELECT deptno FROM emp WHERE job='MANAGER');

