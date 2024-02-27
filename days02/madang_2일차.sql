--madang ���� ����--
--CREATE TABLE Book (
--bookid NUMBER(2) PRIMARY KEY,
--bookname VARCHAR2(40),
--publisher VARCHAR2(40),
--price NUMBER(8)
--);
--CREATE TABLE Customer (
--custid NUMBER(2) PRIMARY KEY,
--name VARCHAR2(40),
--address VARCHAR2(50),
--phone VARCHAR2(20)
--);
--CREATE TABLE Orders (
--orderid NUMBER(2) PRIMARY KEY,
--custid NUMBER(2) REFERENCES Customer(custid),
--bookid NUMBER(2) REFERENCES Book(bookid),
--saleprice NUMBER(8),
--orderdate DATE
--);
--/* Book, Customer, Orders ������ ���� */
--INSERT INTO Book VALUES(1, '�౸�� ����', '�½�����', 7000);
--INSERT INTO Book VALUES(2, '�౸�ƴ� ����', '������', 13000);
--INSERT INTO Book VALUES(3, '�౸�� ����', '���ѹ̵��', 22000);
--INSERT INTO Book VALUES(4, '���� ���̺�', '���ѹ̵��', 35000);
--INSERT INTO Book VALUES(5, '�ǰ� ����', '�½�����', 8000);
--INSERT INTO Book VALUES(6, '���� �ܰ躰���', '�½�����', 6000);
--INSERT INTO Book VALUES(7, '�߱��� �߾�', '�̻�̵��', 20000);
--INSERT INTO Book VALUES(8, '�߱��� ��Ź��', '�̻�̵��', 13000);
--INSERT INTO Book VALUES(9, '�ø��� �̾߱�', '�Ｚ��', 7500);
--INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);
--INSERT INTO Customer VALUES (1, '������', '���� ��ü��Ÿ', '000-5000-0001');
--INSERT INTO Customer VALUES (2, '�迬��', '���ѹα� ����', '000-6000-0001');
--INSERT INTO Customer VALUES (3, '��̶�', '���ѹα� ������', '000-7000-0001');
--INSERT INTO Customer VALUES (4, '�߽ż�', '�̱� Ŭ������', '000-8000-0001');
--INSERT INTO Customer VALUES (5, '�ڼ���', '���ѹα� ����', NULL);
--INSERT INTO Orders VALUES (1, 1, 1, 6000, TO_DATE('2020-07-01','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (2, 1, 3, 21000, TO_DATE('2020-07-03','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (3, 2, 5, 8000, TO_DATE('2020-07-03','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (4, 3, 6, 6000, TO_DATE('2020-07-04','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (5, 4, 7, 20000, TO_DATE('2020-07-05','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (6, 1, 2, 12000, TO_DATE('2020-07-07','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (7, 4, 8, 13000, TO_DATE('2020-07-07','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (8, 3, 10, 12000, TO_DATE('2020-07-08','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (9, 2, 10, 7000, TO_DATE('2020-07-09','yyyy-mm-dd'));
--INSERT INTO Orders VALUES (10, 3, 8, 13000, TO_DATE('2020-07-10','yyyy-mm-dd'));
--CREATE TABLE Imported_Book (
--bookid NUMBER,
--bookname VARCHAR(40),
--publisher VARCHAR(40),
--price NUMBER(8)
--);
--INSERT INTO Imported_Book VALUES(21, 'Zen Golf', 'Pearson', 12000);
--INSERT INTO Imported_Book VALUES(22, 'Soccer Skills', 'Human Kinetics', 15000);
--COMMIT;
select *
from user_tables;
select *
from imported_book;
desc imported_book;
select *
from book;
select name "�̸� " ,nvl(phone,'CEO') "��ȭ��ȣ"
from customer;
select * from phone_tabs;

select orderid,saleprice
from orders
where saleprice > all (select (saleprice) from orders where custid=3); --부속질의의 모든 값을 비교하게 하는 연산자 all (최대) , 부속질의의 하나의 값이 비교 연산자에 만족하게 되면 any,some (최소)


--Exist 질의 4-16
-- avg ,sum,max,min 집계함수 ()
select sum(saleprice) "total",avg(saleprice),max(saleprice), min (saleprice)
from orders;

select sum(saleprice) "total"
from orders
where exists ( select  * from customer where customer.address like '대한민국%' and orders.custid=customer.custid);

select * from customer;

select EXTRACT(day FROM orderdate) "day",
  count(orderdate) "Orders"
   from orders
  group by EXTRACT(day FROM orderdate)
  order by 'Orders' DESC;
  
  select * from orders;
  
  
  
  
  
  
