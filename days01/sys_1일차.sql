        --�ּ�ó�� ctrl /
--��� ����� ���� ��ȸ
--���θ��� ������ �ڵ�
--keyword(�����)�� �빮�ڷ� ����\
--���̺��,column �̸��� �ҹ��ڷ� ����
--������(��,�� ����) ����

--select * from all_users; --ctrl + enter ,F5

--select * From all_users;  --��ҹ��� �������
--select * from book;
--���� �߿� ����� ���� ����,����,���� 
--1)scott ���� ���� , ���� ,�輼 
--    1) scott ���� ���� ���� Ȯ��

--    2) scoot ���� ����
--CREATE user scott identified by tiger; --������ ����� ������ �ν��Ͻ�(��Ű��)�� ��������� ������ --User SCOTT��(��) �����Ǿ����ϴ�. --sys��� �ý��۱����� ���� �������� ��������.
--select username from all_users ;
--    3) scott ���� ��й�ȣ 1234 ����
--    4)  scott ���� ����
--drop user scott cascade; --�����ϰ� �ִ� ������ ���� ���� (cascade) --User SCOTT��(��) �����Ǿ����ϴ�.
--select username from all_users;
--create user scott identified by tiger;
--alter user scott identified by 1234; --��й�ȣ ����
--�α����� �ҷ��� create session ������ �ʿ��� ERROR:ORA-01045: user SCOTT lacks CREATE SESSION privilege; logon denied
-- => scott ������ ������ �� �� �ִ� ������ create session ������ �ο�

-- sql 5���� �� ���� �ο�/ȸ�� �� ? DCL

--sys �ְ������ ������ create session �����ͺ��̽� ����(����) �ý��� ������ scott ������ �ο�
--grant create session to scott

--��(Role) ����
-- ��) ȸ�� 
--        ����(�����)               �پ��� ����(a1,a2,a3 ..... a100) - ���Ի���� ���� ����
--        :                         �پ��� ����(s1,s2,s3 ..... s100) - ������ �μ����� ���� ����
--        :
--        :
--        ������(���ο� ���� ����)
--GRANT  a1,a2... ,a100 to ������  => ���Ի�� ���� ȸ��
--Grant s1,s2... s100 to ������

-- ���� (role) ���Ի������ : a1~a100 ������ ���Ի���̶�� �� ���� �ο�
--grant a1~a100 to ���Ի������
--grant s1~s100 to �����������
-- => grant ���Ի������ to ������ ( ���Ի�����ҿ��� Ư�� ������ ȸ���ϸ� �ڵ����� �ο��� ���������� �����)
--grant create session to student_role;
--grant student_role to scott;

--ddl (create,drop,alter)
-- create user, drop user, alter user
-- create tablespace, drop tablespace, alter tablespace
-- create role, drop role, alter role

--����Ŭ ��ġ �ÿ� �̸� ���ǵ� ��(role) Ȯ���ϴ� ����(sql) �ۼ�.
--grant CONNECT,RESOURCE,DBA to scott;
 
--select grantee,privilege 
-- from DBA_SYS_PRIVS 
-- WHERE grantee = 'CONNECT'; 
 --scott���� _ ���� ���̺� �߰� 
 --C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin
 --��������
--SQL> @C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\scott.sql
--SQL> show user
--USER is "SCOTT"
-- [����] scott���� �����Ŀ� scott.sql �����ؼ� ������� ���̺��� Ȯ��
--select *
--from tabs ;

-- 11. ������ �� ? ��ǻ�Ϳ� �����͸� �����ϴ� ����� ������ ���� ���� �� 
-- ������ ���� ���� - ������,��Ʈ��ũ��,������,��ü ������ ������ �� ���
-- ���뿡�� ���� ���� ����ϴ� ������ �� - ������ ������ ��
-- 11-2 . ������ ������ �� (RDBMS)
    -- 1)������ ���� ���迡 ������ �� ��
    -- 2) ������ �����(���̺�)�� ���̺� ���� ���迡 ������ �� ��
--11-3. ������ ������ ���� �ٽ� ���� ���.
--    1)��ü(Entity) - �����͸� �����ϴ� ���� ���� ���� = RDMBS ���̺� (table) == �����̼�(relation)
--    2)�Ӽ�(Attribute) - ��ü�� Ư¡,����,���� == Į��(column)
--    3)����(Relationship) - ��ü�� ��ü ���� ������
--    
--    ��) scott - dept,emp ���̺����
--    
--     dept�μ� ��ü(E)                         emp��� ��ü(E)
--     �Ӽ�(A)              
--     (A)�μ� ��ȣ ,�μ���,������              �����ȣ,�����,�Ի�����
--                                                    :
--                                                    �μ���ȣ(����)
--                             �Ҽ� ����(R)
--                             
-- ��)     ��ǰ ��ü             �ֹ�����                  �� ��ü
-- 
-- 12. DBA == DB(database) + A(administrator) == �����ͺ��̽� ������
--        ����Ŭ DBA ���� : sys > system
--        
-- 13.���̺�(table) ? �����͸� �����ϴ� ���� ���� ����
--    ���̺����̽�(tablespace) ? ���� ���� �߿� �����͸� �����ϴ� ���� ���� ����
select *
from dba_users;
--HR ���� Ȯ�� 
--1) HR ������ ��й�ȣ�� lion���� �����ϰ� 
--2) +�� ���� Ŭ�� - HR ����
--3) HR ������ �����ϰ� �ִ� ���̺� ����� ��ȸ
--alter user hr identified by lion
alter user hr account unlocked;

�ֿ� ����Ŭ ���� 
��.oracleservice[SID]
��.Oracle[sid]Listener

SQL�� �⺻ ���̺�,�並 ������� ����ȴ�.

    



