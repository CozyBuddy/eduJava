select customer.name , book.bookname
from customer,book,orders
where customer.custid=orders.custid and book.bookid = orders.bookid and orders.saleprice=20000;

select * from tabs;

select customer.name , orders.saleprice
from customer left outer join orders on customer.custid = orders.custid; --외부조인은 left join 즉 왼쪽 기준 외부조인은 왼쪽에 있는 게 기준이 되서 오른쪽 테이블의 해당하는 값이 없어도 null로 표시                                                                                                                                                                                                                                                                                                                    

create or replace procedure interest as  myinterest number ;price number ; cursor mycursor is select saleprice from orders;
begin 
myinterest :=0.0;
open mycursor ;
loop
    fetch mycursor into price ;
    exit when mycursor%notfound;
    if price>=30000 then myinterest := myinterest + price*0.1;
    else myinterest := myinterest + price *0.05;
    end if;
    end loop;
    close mycursor;
    DBMS_output.put_line ('총 이익은' || myinterest);
    end;
    
    set serveroutput on;
    
    exec interest;
    
    create table book_log(
    bookid number, bookname varchar2(40), publisher varchar2(40),price number);
    
    create or replace trigger afterinsertbook 
    after insert on book for each row
    begin insert into book_log values(:new.bookid,:new.bookname,:new.publisher,:new.price);
    DBMS_OUTPUT.put_line('로그 저장 완료');
    end ;
    
    insert into book values(14,'스포츠 과학1','이상미디어',25000);
    select * from book;
    select * from book_log;
    
    