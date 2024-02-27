--HR ������ �����ϰ� �ִ� ���̺� ���� ��ȸ
select * from tabs;

--1)REGIONS
desc regions; --����� ������ ���� �ִ� ���̺�
--�̸�          ��?       ����           
------------- -------- ------------ 
--REGION_ID   NOT NULL NUMBER       
--REGION_NAME          VARCHAR2(25)   ���
select * from regions;
-- REGION_ID REGION_NAME              
------------ -------------------------
--         1 Europe                   
--         2 Americas                 
--         3 Asia                     
--         4 Middle East and Africa   
--2)COUNTRIES --���� ���̺�
desc countries;
--�̸�           ��?       ����           
-------------- -------- ------------ 
--COUNTRY_ID   NOT NULL CHAR(2)      ����ID 
--COUNTRY_NAME          VARCHAR2(40) ������
--REGION_ID             NUMBER      ���ID
select * from countries;
--CO COUNTRY_NAME                              REGION_ID
---- ---------------------------------------- ----------
--AR Argentina                                         2
--AU Australia                                         3
--BE Belgium                                           1
--BR Brazil                                            2
--CA Canada                                            2
--CH Switzerland                                       1
--CN China                                             3
--DE Germany                                           1
--DK Denmark                                           1
--EG Egypt                                             4
--FR France                                            1
--
--CO COUNTRY_NAME                              REGION_ID
---- ---------------------------------------- ----------
--IL Israel                                            4
--IN India                                             3
--IT Italy                                             1
--JP Japan                                             3
--KW Kuwait                                            4
--ML Malaysia                                          3
--MX Mexico                                            2
--NG Nigeria                                           4
--NL Netherlands                                       1
--SG Singapore                                         3
--UK United Kingdom                                    1
--
--CO COUNTRY_NAME                              REGION_ID
---- ---------------------------------------- ----------
--US United States of America                          2
--ZM Zambia                                            4
--ZW Zimbabwe                                          4

--3)LOCATIONS
desc locations;
--�̸�             ��?       ����           
---------------- -------- ------------ 
--LOCATION_ID    NOT NULL NUMBER(4)  ��ġ��ȣ  
--STREET_ADDRESS          VARCHAR2(40) �ּ�
--POSTAL_CODE             VARCHAR2(12) �����ȣ
--CITY           NOT NULL VARCHAR2(30) ��Ƽ
--STATE_PROVINCE          VARCHAR2(25) ��
--COUNTRY_ID              CHAR(2)   ����ID
select * from locations;
--LOCATION_ID STREET_ADDRESS                           POSTAL_CODE  CITY                           STATE_PROVINCE            CO
------------- ---------------------------------------- ------------ ------------------------------ ------------------------- --
--       1000 1297 Via Cola di Rie                     00989        Roma                                                     IT
--       1100 93091 Calle della Testa                  10934        Venice                                                   IT
--       1200 2017 Shinjuku-ku                         1689         Tokyo                          Tokyo Prefecture          JP
--       1300 9450 Kamiya-cho                          6823         Hiroshima                                                JP
--       1400 2014 Jabberwocky Rd                      26192        Southlake                      Texas                     US
--       1500 2011 Interiors Blvd                      99236        South San Francisco            California                US
--       1600 2007 Zagora St                           50090        South Brunswick                New Jersey                US
--       1700 2004 Charade Rd                          98199        Seattle                        Washington                US
--       1800 147 Spadina Ave                          M5V 2L7      Toronto                        Ontario                   CA
--       1900 6092 Boxwood St                          YSW 9T2      Whitehorse                     Yukon                     CA
--       2000 40-5-12 Laogianggen                      190518       Beijing                                                  CN
--
--LOCATION_ID STREET_ADDRESS                           POSTAL_CODE  CITY                           STATE_PROVINCE            CO
------------- ---------------------------------------- ------------ ------------------------------ ------------------------- --
--       2100 1298 Vileparle (E)                       490231       Bombay                         Maharashtra               IN
--       2200 12-98 Victoria Street                    2901         Sydney                         New South Wales           AU
--       2300 198 Clementi North                       540198       Singapore                                                SG
--       2400 8204 Arthur St                                        London                                                   UK
--       2500 Magdalen Centre, The Oxford Science Park OX9 9ZB      Oxford                         Oxford                    UK
--       2600 9702 Chester Road                        09629850293  Stretford                      Manchester                UK
--       2700 Schwanthalerstr. 7031                    80925        Munich                         Bavaria                   DE
--       2800 Rua Frei Caneca 1360                     01307-002    Sao Paulo                      Sao Paulo                 BR
--       2900 20 Rue des Corps-Saints                  1730         Geneva                         Geneve                    CH
--       3000 Murtenstrasse 921                        3095         Bern                           BE                        CH
--       3100 Pieter Breughelstraat 837                3029SK       Utrecht                        Utrecht                   NL
--
--LOCATION_ID STREET_ADDRESS                           POSTAL_CODE  CITY                           STATE_PROVINCE            CO
------------- ---------------------------------------- ------------ ------------------------------ ------------------------- --
--       3200 Mariano Escobedo 9991                    11932        Mexico City                    Distrito Federal,         MX
--4)DEPARTMENTS
select * from departments; --�μ���ȣ, �μ���,������ID,��ġID
--5)JOBS �� ���̺�(��ID,���̸�,�ּ�SAL,�ִ�SAL)
select * from jobs;
--6)EMPLOYEES ��� ���̺� (���ID,�̸�,��,�̸���,����ó,�Ի�����, ����,�޿� ..)
select * from employees;
--7)JOB_HISTORY �μ��̵� ���� ���̺� ( ��� ID,�Ի�����,�������,��åID,�μ�ID)
desc job_history;
select * from job_history;

--HR 
select *
from employees;
desc employees;
--���� ���̺��� �����ȣ,����̸�,�Ի����� �� ��� 
-- first_name ,last_name �� ���ļ� name���� ��� �ϳ���  1)concat �̿� 2)|| ���� �̿�
--ORA-01722: invalid number
--����Ŭ���ڿ� '' ��¥ ''�� ǥ��
--����Ŭ ���ڿ� ���� ������ || 
--����Ŭ ���ڿ� ���� �Լ� concat(���ڿ�1,���ڿ�2) 
--as ���� ��ĭ�� �ʿ��� ��쿡 "" �� ��
 select employee_id-100 as �����ȣ ,
 --first_name||' '||last_name as ����̸� 
 concat(first_name,concat(' ',last_name)) " ����̸�" 
 ,hire_date as �Ի�����
 from employees;
 select '�̸��� '|| scott.ename || '�̰�, ������ ' || job || ' �̴�.'
 from scott.emp;
-- ORA-00911: invalid character
--00911. 00000 -  "invalid character"
--*Cause:    The identifier name started with an ASCII character other than a
--           letter or a number. After the first character of the identifier
--           name, ASCII characters are allowed including "$", "#" and "_".
--           Identifiers enclosed in double quotation marks may contain any
--           character other than a double quotation. Alternate quotation
--           marks (q'#...#') cannot use spaces, tabs, or carriage returns as
--           delimiters. For all other contexts, consult the SQL Language
--           Reference Manual.
--*Action:   Check the Oracle identifier naming convention. If you are
--           attempting to provide a password in the IDENTIFIED BY clause of
--           a CREATE USER or ALTER USER statement, then it is recommended to
--           always enclose the password in double quotation marks because
--           characters other than the double quotation are then allowed.
--127��, 21������ ���� �߻�

 
 select last_name, salary from employees
  where last_name LIKE 'R%'
  order by salary;
  
  select last_name,salary
  from employees
  where last_name like 'R___'
  order by salary;
  
  --[문제] 
  
  
  select * from arirang; --ORA-00942: table or view does not exist
 
select * from employees
where salary = ANY
(SELECT salary from employees
where department_id = 30); 
 
 
 
 
 