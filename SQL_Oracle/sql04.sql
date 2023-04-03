/*
    Self Join
    
*/

-- 1. 특정 사원의 ename 조회
-- 2. ename에 해당하는 mgr번호 찾는다
-- 3. 다시 emp테이블에서 empno가 mgr인 사원을 찾아서 ename을 찾는다

--STEP 1.
SELECT ename, mgr FROM emp; -- BLAKE 사원의 상사번호를 찾고
SELECT ename, ename FROM emp; -- 상사번호와 일치하는 사원번호를 찾아 그에 해당하는 사원 이름을 찾는다

--STEP 2. 조인 조건 추가
SELECT * 
FROM (SELECT ename, mgr FROM emp) e,
    (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

--STEP 3. 
SELECT e.empno, e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno;

--STEP 4. 
SELECT e.empno, e.ename 사원이름, m.ename 상사이름
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'BLAKE';


SELECT * FROM dept;

/*
    Outer Join
*/
Select e.empno, e.ename, e.job, e.deptno e_deptno, d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);
