create table tbl_emp(
 id number primary key, 
name varchar2(10) not null,
salary  number,
 bonus number default 100);

insert into tbl_emp(id,name,salary) values(1001,'jijoe',150);
insert into tbl_emp(id,name,salary) values(1002,'cho',130);
insert into tbl_emp(id,name,salary) values(1003,'kim',140);
commit;
select * from tbl_emp;

create table tbl_bonus ( id number, bonus number default 100 );

insert into tbl_bonus(id)
(select e.id from tbl_emp e);

select * from tbl_bonus;

merge into tbl_bonus D
using (select id,salary from tbl_emp) S
 on (D.id = S.id)
when matched then update set
D.bonus=D.bonus + S.salary*0.01
when not matched then insert(D.id, D.bonus)
values(S.id,S.salary*0.01);

-- 병합 2)
 create table tbl_merge1 ( 
 id number primary key, name varchar2(20),pay number , sudang number);
 
 create table tbl_merge2 ( id number primary key, sudang number);
 
 insert into tbl_merge1 values (1,'a',100,10);
 insert into tbl_merge1 values (2,'b',150,20);
 insert into tbl_merge1 values (3,'c',130,0);
 
 insert into tbl_merge2 values (2,5);
 insert into tbl_merge2 values (3,10);
 insert into tbl_merge2 values (4,20);
 
 commit;
 
 select * from tbl_merge2 order by id;
 
 --병합 : tbl_merge1
 
 merge into tbl_merge2 a
 using (select id,sudang from tbl_merge1) b on (a.id=b.id)
 when matched then update set a.sudang = a.sudang + b.sudang
 when not matched then insert (a.id , a.sudang) values(b.id , b.sudang );
 
 drop table tbl_bonus ;
 
 commit;
 
 
 --제약조건 (constraint)
 --scott이 소유하고 있는 테이블 조회
 select * from user_tables;
 select * from user_constraints where table_name = 'EMP';
 
 --제약조건은 테이블에  I/U/D 할때의 규칙으로 사용.(CRUD)
 -- DATA integrity(테이블 무결성)을 위해 
 update emp
 set deptno = 90
 where empno = 7369 ; --integrity constraint (SCOTT.FK_DEPTNO) violated 
 
 --도메인 무결성
 desc emp; 
 
 insert into emp (empno) values ( 9999);
 insert into emp (ename) values ('admin'); -- not null 오류
 
 select * from emp;
 
 --제약조건을 생성하는 시기에 따라
 ㄱ.  create table 문 : 테이블 생성+ 제약조건 추가/삭제 가능
    1) IN-LINE 제약조건 ( == 컬럼 레벨)  제약조건 설정 방법
            -- NOT NULL  제약조건 설정
    2) OUT-OF-LINE 제약조건 ( == 테이블 레벨)  제약조건 설정 방법
            -- 두 개 이상의 컬럼에 제약조건을 설정할때 ( 급여지급날짜 * 회원id)
       -- [사원 급여 지급 테이블] 가정
       급여지급 날짜 회원ID 급여액 ....
         20240125       7369  3000000
         20240125       7666  3000000
         20240125       8223  3000000
         
         -- 순번 부여 ( 역정규화) 인공키?
        순번     급여지급 날짜 회원ID 급여액 ....
        1       20240125       7369  3000000
         2        20240125       7666  3000000
         3        20240125       8223  3000000
         
       
 ㄴ.  alter table 문 : 테이블 수정 + 제약조건 추가 /삭제 가능
 
    select * from emp;
    
    --KING의 DEPTNO(왜래키)를 NULL로 수정   
    update emp
    set deptno = null 
    where ename = 'KING';
    commit;
    
    delete emp
    where empno=9999;
    
    --실습) create table 문에서 column level 방식으로 제약조건 설정하는 예 
    drop table tbl_constraint1;
    
    create table tbl_constraint1(
        empno number(4) not null constraint pk_tbl_constraint1_empno primary key , ename varchar2(20) not null , 
        -- dept 테이블의 deptno(pk) => deptno 컬럼으로 참조 
        deptno number(2) constraint fk_tblconstraint1_deptno references dept(deptno), email varchar2(150) constraint uk_tblconstraint1_email unique ,
        kor number(3) constraint ck_tblconstraint1_kor check ( kor between 0 and 100), city varchar2(20) constraint ck_tblconstraint1_city check ( city in ('서울','대구','인천')));
 
    select * from user_constraints where table_name like '%CONSTR%';
    
    --제약조건 삭제
    ALTER table tbl_constraint1 
    drop constraint pk_tbl_constraint1_empno ; 
    rollback;
 
    --제약조건 추가
    alter table tbl_constraint1
    add constraint pk_tbl_constraint1_empno primary key (empno);
    
    --제약 조건 비활성화
    alter table tbl_constraint1
    disable constraint pk_tbl_constraint1_empno ;
    
    --제약 조건 활성화 
    alter table tbl_constraint1
    enable constraint pk_tbl_constraint1_empno ;
    
    commit;
 
 --실습) create table 문에서 table level 방식으로 제약조건 설정하는 예 --not null은 column level로 밖에 설정 안됨. -- 복합키는 table level 방식으로 제약조건설정
        create table tbl_constraint2(
        empno number(4) not null , ename varchar2(20) not null , 
        -- dept 테이블의 deptno(pk) => deptno 컬럼으로 참조 
        deptno number(2) , email varchar2(150) ,
        kor number(3) , city varchar2(20),
        constraint pk_tbl_constraint2_empno primary key(empno),--(empno,ename) --복합키 ,
        constraint fk_tblconstraint2_deptno  foreign key (deptno) references dept(deptno),
        constraint uk_tblconstraint2_email unique(email),
        constraint ck_tblconstraint2_kor check ( kor between 0 and 100),
        constraint ck_tblconstraint2_city check ( city in ('서울','대구','인천'))
        );
        
        select * from tbl_constraint2;
        drop table tbl_constraint2 ;
        drop table tbl_constraint1 ;
        
        --실습3)테이블 생성 후에 alter table 문으로 제약조건 설정하는 예
     create table tbl_constraint3
     ( empno number(4) , ename varchar2(20) , deptno number(2) );
     
    -- 1) empno 컬럼에 pk 제약조건 추가.
    alter table tbl_constraint3
    add constraint pk_tbl_constraint3_empno primary key (empno);
    
    select * from user_constraints where table_name LIKE '%CONSTR%';
    
    -- 1) deptno 컬럼에 fk 제약조건 추가.
      alter table tbl_constraint3
    add constraint fk_tbl_constraint3_deptno foreign key (deptno) references dept(deptno);

    --2) emp = > tbl_emp 테이블 만들기
    create table tbl_emp as (
     select * from emp); 
     
    alter table tbl_emp 
    add constraint pkemp primary key(empno);
    
    select * from user_constraints where table_name like '%TBL%';
     
     --3) dept = > tbl_dept
      create table tbl_dept as (
     select * from dept); 
     
      alter table tbl_dept
     add constraint pkdept primary key(deptno);
     
        -- 문제) tbl_emp 테이블에 deptno 컬럼에 fk 설정 + on delete cascade 옵션 추가
        
        alter table tbl_emp
        add constraint fkdeptno foreign key(deptno) references tbl_dept(deptno) on delete cascade ; 
        
        alter table tbl_emp
        add constraint fkdeptno foreign key(deptno) references tbl_dept(deptno) on delete set null ; 
        
        
        delete from tbl_dept where deptno = 30 ;
        delete from dept where deptno = 30 ;
        
        select * from tbl_dept;
        select * from tbl_emp;
        
        drop table tbl_dept ;
        drop table tbl_emp ;
        
        CREATE TABLE book(
       b_id     VARCHAR2(10)    NOT NULL PRIMARY KEY   -- 책ID
      ,title      VARCHAR2(100) NOT NULL  -- 책 제목
      ,c_name  VARCHAR2(100)    NOT NULL     -- c 이름
     -- ,  price  NUMBER(7) NOT NULL
 );
-- Table BOOK이(가) 생성되었습니다.
INSERT INTO book (b_id, title, c_name) VALUES ('a-1', '데이터베이스', '서울');
INSERT INTO book (b_id, title, c_name) VALUES ('a-2', '데이터베이스', '경기');
INSERT INTO book (b_id, title, c_name) VALUES ('b-1', '운영체제', '부산');
INSERT INTO book (b_id, title, c_name) VALUES ('b-2', '운영체제', '인천');
INSERT INTO book (b_id, title, c_name) VALUES ('c-1', '워드', '경기');
INSERT INTO book (b_id, title, c_name) VALUES ('d-1', '엑셀', '대구');
INSERT INTO book (b_id, title, c_name) VALUES ('e-1', '파워포인트', '부산');
INSERT INTO book (b_id, title, c_name) VALUES ('f-1', '엑세스', '인천');
INSERT INTO book (b_id, title, c_name) VALUES ('f-2', '엑세스', '서울');

COMMIT;

SELECT *
FROM book;

-- 단가테이블( 책의 가격 )
CREATE TABLE danga(
       b_id  VARCHAR2(10)  NOT NULL  -- PK , FK   (식별관계 ***)
      ,price  NUMBER(7) NOT NULL    -- 책 가격
      
      ,CONSTRAINT PK_dangga_id PRIMARY KEY(b_id)
      ,CONSTRAINT FK_dangga_id FOREIGN KEY (b_id)
              REFERENCES book(b_id)
              ON DELETE CASCADE
);
-- Table DANGA이(가) 생성되었습니다.
-- book  - b_id(PK), title, c_name
-- danga - b_id(PK,FK), price 
 
INSERT INTO danga (b_id, price) VALUES ('a-1', 300);
INSERT INTO danga (b_id, price) VALUES ('a-2', 500);
INSERT INTO danga (b_id, price) VALUES ('b-1', 450);
INSERT INTO danga (b_id, price) VALUES ('b-2', 440);
INSERT INTO danga (b_id, price) VALUES ('c-1', 320);
INSERT INTO danga (b_id, price) VALUES ('d-1', 321);
INSERT INTO danga (b_id, price) VALUES ('e-1', 250);
INSERT INTO danga (b_id, price) VALUES ('f-1', 510);
INSERT INTO danga (b_id, price) VALUES ('f-2', 400);

COMMIT; 

SELECT *
FROM danga; 

-- 책을 지은 저자테이블
 CREATE TABLE au_book(
       id   number(5)  NOT NULL PRIMARY KEY
      ,b_id VARCHAR2(10)  NOT NULL  CONSTRAINT FK_AUBOOK_BID
            REFERENCES book(b_id) ON DELETE CASCADE
      ,name VARCHAR2(20)  NOT NULL
);

INSERT INTO au_book (id, b_id, name) VALUES (1, 'a-1', '저팔개');
INSERT INTO au_book (id, b_id, name) VALUES (2, 'b-1', '손오공');
INSERT INTO au_book (id, b_id, name) VALUES (3, 'a-1', '사오정');
INSERT INTO au_book (id, b_id, name) VALUES (4, 'b-1', '김유신');
INSERT INTO au_book (id, b_id, name) VALUES (5, 'c-1', '유관순');
INSERT INTO au_book (id, b_id, name) VALUES (6, 'd-1', '김하늘');
INSERT INTO au_book (id, b_id, name) VALUES (7, 'a-1', '심심해');
INSERT INTO au_book (id, b_id, name) VALUES (8, 'd-1', '허첨');
INSERT INTO au_book (id, b_id, name) VALUES (9, 'e-1', '이한나');
INSERT INTO au_book (id, b_id, name) VALUES (10, 'f-1', '정말자');
INSERT INTO au_book (id, b_id, name) VALUES (11, 'f-2', '이영애');

COMMIT;

SELECT * 
FROM au_book;

 CREATE TABLE gogaek(
      g_id       NUMBER(5) NOT NULL PRIMARY KEY 
      ,g_name   VARCHAR2(20) NOT NULL
      ,g_tel      VARCHAR2(20)
);

 INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (1, '우리서점', '111-1111');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (2, '도시서점', '111-1111');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (3, '지구서점', '333-3333');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (4, '서울서점', '444-4444');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (5, '수도서점', '555-5555');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (6, '강남서점', '666-6666');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (7, '강북서점', '777-7777');

COMMIT;

SELECT *
FROM gogaek;





 CREATE TABLE panmai(
       id         NUMBER(5) NOT NULL PRIMARY KEY
      ,g_id       NUMBER(5) NOT NULL CONSTRAINT FK_PANMAI_GID
                     REFERENCES gogaek(g_id) ON DELETE CASCADE
      ,b_id       VARCHAR2(10)  NOT NULL CONSTRAINT FK_PANMAI_BID
                     REFERENCES book(b_id) ON DELETE CASCADE
      ,p_date     DATE DEFAULT SYSDATE
      ,p_su       NUMBER(5)  NOT NULL
);

INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (1, 1, 'a-1', '2000-10-10', 10);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (2, 2, 'a-1', '2000-03-04', 20);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (3, 1, 'b-1', DEFAULT, 13);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (4, 4, 'c-1', '2000-07-07', 5);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (5, 4, 'd-1', DEFAULT, 31);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (6, 6, 'f-1', DEFAULT, 21);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (7, 7, 'a-1', DEFAULT, 26);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (8, 6, 'a-1', DEFAULT, 17);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (9, 6, 'b-1', DEFAULT, 5);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (10, 7, 'a-2', '2000-10-10', 15);

COMMIT;

SELECT *
FROM panmai;   

--1) EQUI JOIN

--문제 ) 책ID,책제목,출판사(c_name),단가 컬럼 출력
-- book : [b_id(pk),title,c_name]
-- danga : [b_id(pk,fk) , price]

-- ㄱ. 오라클에서는 natural join 이라고 부른다.
    select book.b_id , title ,c_name , price
    from book,danga
    where book.b_id = danga.b_id;  -- 조인조건

    --ㄴ. 
    select b.b_id ,title,c_name , price
    from book b ,danga d
    where b.b_id = d.b_id;
    --ㄷ. join ~ on 구문
    select b.b_id , title,c_name,price
    from book b join danga d on b.b_id = d.b_id;
    
    --ㄹ. using 절 사용 : 
    select b_id,title,c_name,price
    from book join danga using (b_id);
    
    -- ㅁ. natural join
    select b_id,title,c_name,price
    from book natural join danga;
    
--문제 ) 책ID,책제목,판매수량,단가,서점명,판매금액(단가*판매수량) 컬럼 출력
-- ㄱ.  위의 ㄱ,ㄴ, 방법으로 풀기
    select b.b_id,title,p_su,price, g.g_name, (d.price* p.p_su) totalsalesprice
    from book b ,panmai p ,danga d,gogaek g 
    where b.b_id = p.b_id and d.b_id= b.b_id and g.g_id=p.g_id;
    
-- ㄴ. join ~ on 
    select b.b_id,title,p_su,price, g.g_name, (d.price* p.p_su) 판매금액
    from book b join panmai p on b.b_id = p.b_id join gogaek g  on g.g_id=p.g_id join danga d on  d.b_id= b.b_id;
    
    
--  ㄷ. using 
select b_id,title,p_su,price, g_name, (price* p_su) 판매금액
    from book  join panmai using(b_id) join gogaek using(g_id) join danga using(b_id);


 select * from gogaek;
 
 --none equi join 
 --일정한 관계 x
 -- between ~ and 연산자 사용
 select ename, sal,grade ,losal ||'~'|| hisal 
 from emp e , salgrade s
 where e.sal between s.losa and s.hisal;
 
 select * from emp e , dept d where e.deptno = d.deptno ;
 select * from emp;
 
 --OUTER JOIN   
 --ㄱ. LEFT OUTER JOIN
select d.deptno,ename,hiredate
from dept d left join emp e on d.deptno = e.deptno;

--ㄴ.RIGHT OUTER JOIN 
select d.deptno,ename,hiredate
from dept d right join emp e on d.deptno = e.deptno;

--ㄷ.FULL OUTER JOIN
select d.deptno,ename,hiredate
from dept d full join emp e on d.deptno = e.deptno;

--SELF JOIN
--사원번호 ,사원명,입사일자,직속상사 사원번호 , 직속상사의 사원명
SELECT e.EMPNO, e.ENAME,e.hiredate,e.mgr, m.ename
from emp e , emp m where e.mgr=m.empno;

SELECT e.EMPNO, e.ENAME,e.hiredate,e.mgr, m.ename
from emp e join emp m on e.mgr=m.empno;


--문제) 책ID, 책제목, 판매수량, 단가, 서점명(고객), 판매금액(판매수량*단가) 출력 
    select b.b_id 책ID,title 책제목,p_su 판매수량,price 단가, g.g_name 서점명, (d.price* p.p_su) 총판매금액
    from book b ,panmai p ,danga d,gogaek g 
    where b.b_id = p.b_id and d.b_id= b.b_id and g.g_id=p.g_id;
-- 문제) 출판된 책들이 각각 총 몇권이 판매되었는지 조회     
--      (    책ID, 책제목, 총판매권수, 단가 컬럼 출력   )
       select b.b_id,title,p_su,price  from book b , danga d ,(select b_id,sum(p_su) p_su from panmai group by b_id) p where b.b_id=d.b_id  and p.b_id= b.b_id;
        
-- 문제) 판매권수가 가장 많은 책 정보 조회 
      select  a.title,a.p_su,a.price
      from (select b.b_id,title,p_su,price,rank() over (order by p_su desc) srank from book b , danga d ,(select b_id,sum(p_su) p_su from panmai group by b_id) p where b.b_id=d.b_id  and p.b_id= b.b_id ) a                       
     where a.srank =1;
-- 문제) 올해 판매권수가 가장 많은 책(수량을 기준으로)
--      (  책ID, 책제목, 수량 )
        select b.b_id,title,p_su,rank() over (order by p_su desc) srank from book b , danga d ,( select b_id,sum(p_su) p_su from panmai where substr(p_date,1,2) = to_char(sysdate,'yy') group by b_id ) p where b.b_id=d.b_id  and p.b_id= b.b_id; 
        
        select * from panmai;
        select b_id,sum(p_su) p_su from panmai where substr(p_date,1,2) = to_char(sysdate,'yy') group by b_id ;
--  
-- 문제) book 테이블에서 판매가 된 적이 없는 책의 정보 조회
            select b.b_id ,title ,price from book b ,panmai p,danga d  where not(b.b_id = any(select b_id from panmai))and b.b_id=d.b_id group by b.b_id,title,price;
         
-- 문제) book 테이블에서 판매가 된 적이 있는 책의 정보 조회
--      ( b_id, title, price  컬럼 출력 )
            select b.b_id ,title,price from book b ,panmai p ,danga d where (b.b_id = any(select b_id from panmai)) and b.b_id=d.b_id group by b.b_id,title,price;
-- 문제) 고객별 판매 금액 출력 (고객코드, 고객명, 판매금액)
          
           with a as(select g.g_id,g.g_name , p_su ,price from panmai p , gogaek g,danga d where p.g_id=g.g_id  and d.b_id = p.b_id)
           select g_id,g_name, sum(p_su*price) from a group by g_id , g_name order by a.g_id ;
           
-- 문제) 년도, 월별 판매 현황 구하기
            select to_char(p_date,'yy') 년도 ,to_char(p_date,'mm') 월 ,sum(p_su) 판매수량 ,title 판매책제목 from panmai p ,book b where b.b_id=p.b_id group by to_char(p_date,'yy') , to_char(p_date,'mm'),title;
-- 문제) 서점별 년도별 판매현황 구하기
        select g_name 서점,to_char(p_date,'yy') 년도,sum(p_su) ,title from panmai p ,gogaek g,book b where b.b_id=p.b_id and g.g_id = p.g_id group by g.g_name, to_char(p_date,'yy') ,title order by g.g_name;

       
-- 문제) 책의 총판매금액이 15000원 이상 팔린 책의 정보를 조회
--      ( 책ID, 제목, 단가, 총판매권수, 총판매금액 )
   select a.*
   from ( with a as( select b.b_id,title,p_su,price  from book b , danga d ,(select b_id,sum(p_su) p_su from panmai group by b_id) p where b.b_id=d.b_id  and p.b_id= b.b_id)
     select a.*, a.price * a.p_su 총판매금액 from a order by a.b_id) a
     where a.총판매금액>=15000;
    

        select b.b_id,title,price , p_su from book b ,panmai p ,danga d where b.b_id=p.b_id and d.b_id =b.b_id;



---- 1) TOP-N 분석 방법
--;
--SELECT t.*
--FROM ( 
--        SELECT b.b_id, title, price, SUM( p_su  ) 총판매권수
--        FROM book b JOIN danga d ON b.b_id = d.b_id
--                    JOIN panmai p ON b.b_id = p.b_id 
--        GROUP BY b.b_id, title, price
--        ORDER BY 총판매권수 DESC
--) t
--WHERE ROWNUM BETWEEN 3 AND 5; -- 주의
--WHERE ROWNUM <= 3;
--WHERE ROWNUM = 1;
--
---- 2) RANK 순위 함수 ..
--
--WITH t AS (
--    SELECT b.b_id, title, price, SUM( p_su  ) 총판매권수
--       , RANK() OVER( ORDER BY SUM( p_su  ) DESC ) 판매순위
--    FROM book b JOIN danga d ON b.b_id = d.b_id
--                JOIN panmai p ON b.b_id = p.b_id 
--    GROUP BY b.b_id, title, price
--)
--SELECT *
--FROM t
--WHErE 판매순위 BETWEEN 3 AND 5;
--WHErE 판매순위 <= 3;
--WHErE 판매순위 = 1;
--
--WITH t
--AS 
--  (
--  SELECT b.b_id, title , price, SUM( p_su )  총판매권수
-- FROM  book b JOIN  panmai p ON b.b_id = p.b_id
--              JOIN danga d ON  b.b_id = d.b_id
-- GROUP BY   b.b_id, title , price
-- ORDER BY  b.b_id
-- ), 
-- s AS (
-- SELECT t.*
--   , RANK() OVER( ORDER BY  총판매권수 DESC ) 판매순위
-- FROM t
-- )
-- SELECT s.*
-- FROM s
-- WHERE 판매순위 = 1;


















