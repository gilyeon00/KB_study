-- 그룹함수 (GROUP)
-- 그룹함수는 NULL값을 건너뛴다. 여기서 제외되는 그룹함수는 COUNT(*)

-- 전체 사원의 수를 리턴
SELECT COUNT(*) FROM emp;
SELECT COUNT(empno) FROM emp; -- 첫번째보다 이게 더 나은 표현, PK이기때문에 NULL값이 없음
SELECT COUNT(-1) FROM emp; --이게 성능상 가장 좋은 표현 : 맨 마지막 행을 리턴

SELECT ROUND(AVG(sal)) "전체 사원 급여의 평균", 
        SUM(sal)"전체 사원 급여의 합", 
        MIN(sal)"전체 사원 급여 중 최소값", 
        MAX(sal) "전체 사원 급여 중 최고값"
FROM emp;

SELECT MIN(hiredate) "입사한지 가장 오래된 사원의 입사일", MAX(hiredate)"입사한지 가장 최근인 사원의 입사일" FROM emp;


-- 부서번호가 10번이거나 20번인 사원수 조회 COUNT()
SELECT COUNT(empno)
FROM emp
WHERE depto IN(10,20);

-- 모든 사원의 보너스 평균 AVG()
-- Null값 포함
SELECT ROUND(AVG(comm)) "보너스 평균" FROM emp;
-- Null값 제거
SELECT ROUND(AVG(NVL(comm, 0))) "보너스 평균" FROM emp;


-- emp테이블에서의 부서 개수(중복 허용 x)
SELECT COUNT(DISTINCT(deptno)) "부서 개수" FROM emp;

---- 부서별 평균 급여
-- 그룹함수에 적용되지않은 컬럼이 SELECT절에 나열
-- 반드시 GROUP By절 뒤에 deptno컬럼을 명시해야한다. 
-- SELECT deptno, ROUND(AVG(sal))
-- FROM emp;
 SELECT deptno, ROUND(AVG(sal))
 FROM emp
 GROUP BY deptno;

SELECT deptno DNumber, ROUND(AVG(sal))
 FROM emp
 GROUP BY deptno   -- GROUP BY DNumer   -- GROUP BY가 SELECT먼저 실행되므로 Alias명시 불가
 ORDER BY DNumber;
--- Alias적용 불가 구간 : Where, Group By

SELECT deptno DNumber, ROUND(AVG(sal))
 FROM emp
 WHERE deptno != 10
 GROUP BY deptno    
 ORDER BY DNumber;
 
 
 -- 입사년도별 사원의 인원수 조회
 SELECT EXTRACT(YEAR FROM hiredate) as Year FROM emp;
 SELECT EXTRACT(YEAR FROM hiredate) as Year, COUNT(empno)
 FROM emp
 GROUP BY EXTRACT(YEAR FROM hiredate)
 ORDER BY Year;
 
 SELECT TO_CHAR(hiredate, 'YY')년도, COUNT(*)
 FROM emp
 GROUP BY TO_CHAR(hiredate, 'YY')
 ORDER BY 년도;


-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균 급여를 조회
-- WHERE절안에 GROUP BY 사용불가
--SELECT detpno, ROUND(AVG(sal)) AvgSalary
--FROM emp 
--WHERE ROUND(AVG(sal)) >= 2000
--GROUP BY detpno;

-- 의미론적으로 그룹핑을 하고 그리고 나서 조건에 맞는 것만 추출
SELECT deptno, ROUND(AVG(sal)) AvgSalary
FROM emp 
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

-- 부서별 최대급여가 2900달러가 넘는 부서들의 최대급여를 추출
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal)>=2900;

-- 부서별 평균급여가 최대급여인 부서의 급여 검색
SELECT *
FROM (
    SELECT deptno, ROUND(AVG(sal)) AvgSalary
    FROM emp
    GROUP BY deptno
    ORDER BY AvgSalary DESC
    )
WHERE rownum <= 1;



-- ROLLUP : 그룹함수의 총합이나, 각 그룹별 중간합계가 필요한 경우
SELECT deptno, job, SUM(sal)
FROM emp 
GROUP BY ROLLUP(deptno, job)
--GROUP BY ROLLUP(job, deptno);
ORDER BY 1;

-- 그룹핑 여러개 : GROUPING SETS , UNION ALL 
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