/*
    분석함수
*/

-- PARTITION BY :  그룹핑
SELECT ename, sal, deptno,
    RANK() OVER( ORDER BY sal DESC ) ALL_RANKING,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC ) DEPT_RANKING
FROM emp;




SELECT ename, sal, rownum
FROM emp
ORDER BY sal DESC;

SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC);

-- over()을 쓰면 성능적으로 다름 테이블 1번 접근하기때문
----   over() 안의 partition by()을 넣으면 그루핑이 되서 더 좋음
SELECT ename, sal,
    ROW_NUMBER() 
        OVER(ORDER BY sal DESC) ranking
FROM emp;

-- 부서 내에서 급여가 많은 사원부터 순위 부여
SELECT empno, ename, deptno, sal,
    RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal,
    DENSE_RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) "RK"
FROM emp;