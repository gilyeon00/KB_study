-- ���̺� �����ϱ�
-- �÷� �������� pk�߰�
 CREATE TABLE MYDEPT (
    no number(3) CONSTRAINT PK_MYDEPT PRIMARY KEY,
    dname varchar2(30) not null,
    loc varchar2(30) );
    
--DROP TABLE MYDEPT;

-- ���̺� �����ϱ�
-- ���̺� �������� pk�߰�
 CREATE TABLE CUSTOM (
    SSN NUMBER(7),
    CUST_NAME VARCHAR2(20),
    ADDRESS VARCHAR2(50),
    CONSTRAINT CUSTOM_PK PRIMARY KEY (SSN) );

    
-- ������ �Է��ϱ�
INSERT INTO custom(ssn, cust_name, address) VALUES(111, USER,'Brandon');
INSERT INTO custom(ssn, cust_name, address) VALUES(222, 'JAMES','NY');
INSERT INTO custom(ssn, cust_name, address) VALUES(333, 'JULIET','TEXAS');
INSERT INTO custom(ssn, cust_name, address) VALUES(444, 'VELLA','SUNNYVALE');


SELECT SSN, CUST_NAME, ADDRESS FROM CUSTOM;

-- ������ �����ϱ�
UPDATE custom SET cust_name = '������', address = '�Ż絿' WHERE ssn=111;

-- <<< ������ �����ϱ� >>>
/*  DELETE THUNCATE  DROP  
    DELETE
        1) ���ǿ� �ش��ϴ� �ุ ����
        2) �Ϻ��� �����Ȱ� �ƴ�. rollback���� �ǵ��� ������
    TRUNCATE :: DROP + CREATE
        1) ��� �����Ͱ� �����ȴ�
        2) rollback�� �ȵ�
        3) ���̺��� ������ �����
    DROP
        1) ��� �����Ͱ� �������°� �翬
        2) ���̺��� ������ ���ش�
        
*/
