-- 테이블 생성하기
-- 컬럼 레벨에서 pk추가
 CREATE TABLE MYDEPT (
    no number(3) CONSTRAINT PK_MYDEPT PRIMARY KEY,
    dname varchar2(30) not null,
    loc varchar2(30) );
    
--DROP TABLE MYDEPT;

-- 테이블 생성하기
-- 테이블 레벨에서 pk추가
 CREATE TABLE CUSTOM (
    SSN NUMBER(7),
    CUST_NAME VARCHAR2(20),
    ADDRESS VARCHAR2(50),
    CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN) );

    
-- 데이터 입력하기
INSERT INTO custom(ssn, cust_name, address) VALUES(111, USER,'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(222, 'JAMES','NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(333, 'JULIET','TEXAS');
INSERT INTO custom(ssn, cust_name, address) VALUES(444, 'VELLA','SUNNYVALE');


SELECT SSN, CUST_NAME, ADDRESS FROM CUSTOM;

-- 데이터 수정하기
UPDATE custom SET cust_name = '이정재', address = '신사동' WHERE ssn=111;

-- <<< 데이터 삭제하기 >>>
/*  DELETE THUNCATE  DROP  
    DELETE
        1) 조건에 해당하는 행만 삭제
        2) 완벽히 삭제된건 아님. rollback으로 되돌릴 수있음
    TRUNCATE :: DROP + CREATE
        1) 모든 데이터가 삭제된다
        2) rollback이 안됨
        3) 테이블의 구조는 남긴다
    DROP
        1) 모든 데이터가 없어지는건 당연
        2) 테이블의 구조도 없앤다
        
*/
