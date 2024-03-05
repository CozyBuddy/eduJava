-- 1.[%TYPE형 변수] 
-- 2.[%ROWTYPE형 변수]
-- 3. [RECORD형 변수]


select d.deptno, dname,empno, ename, sal+ nvl(comm,0) pay
FROM dept d join emp e on d.deptno = e.deptno
where empno = 7369 ;

--1. 익명 프로시저 작성 + 실행
DECLARE
    vdeptno dept.deptno%type;
    vdname dept.dname%type;
    vempno emp.empno%type; 
    vename emp.ename%type;
    vpay number;
BEGIN
select d.deptno, dname, empno, ename, sal+ nvl(comm,0) pay
    into vdeptno, vdname,vempno, vename, vpay
FROM dept d join emp e on d.deptno = e.deptno
where empno = 7369 ;
dbms_output.put_line( vdeptno || ', ' || vdname || ', ' ||vempno || ', ' || vename || ', ' || vpay);
--EXCEPTION
END;

--2) 익명프로시저 작성 + 실행 ( %rowtype형 변수)
DECLARE
    vdrow dept%rowtype;
    verow emp%rowtype;
    vpay number;
BEGIN
select d.deptno, dname, empno, ename, sal+ nvl(comm,0) pay
 into vdeptno, vdname,vempno, vename, vpay
FROM dept d join emp e on d.deptno = e.deptno
where empno = 7369 ;
dbms_output.put_line(vdeptno || ', ' || vdname || ', ' ||vempno || ', ' || vename || ', ' || vpay);
--EXCEPTION
END;

--3) 익명프로시저 작성 + 실행 ( RECORD형 변수)
    --부서번호 ,부서명,사원번호,사원명,급여 새로운 하나의 자료형 선언
    -- (사용자 정의 구조체)
    --변수 선언
DECLARE
   TYPE empdepttype IS RECORD
   (
    deptno dept.deptno%type,
    dname dept.dname%type,
    empno emp.empno%type, 
    ename emp.ename%type,
    pay number);
   vderow empdepttype;
BEGIN
select d.deptno, dname, empno, ename, sal+ nvl(comm,0) pay
    into vderow.deptno, vderow.dname,vderow.empno, vderow.ename, vderow.pay
FROM dept d join emp e on d.deptno = e.deptno
where empno = 7369 ;
dbms_output.put_line(vderow.deptno || ', ' || vderow.dname || ', ' ||vderow.empno || ', ' || vderow.ename || ', ' ||vderow.pay);
--EXCEPTION
END;

--5 ) 커서 (cursor)
--1) 커서 ? PL/SQL의 실행블럭 안에서 실행되는 SELECT 문 의미
--2) 커서의 2가지 종류
    -- ㄱ. 묵시적 커서 : select 문의 실행 결과가 1개 , for 문 select 문 
        --(자동)
    -- ㄴ. 명시적 커서 : select 문의 실행 결과가 여러 개 
        --(1) CURSOR 선언 - 실행한 SELECT문 작성
        
        --(2) OPEN  - 작성된 SELECT 문이 실행되는 과정
        --(3) FETCH - 실행된 커서로부터 여러개의 레코드를 읽어옴 , 
        --  LOOP문(반복문) 사용
           --  [커서 속성을 사용]
                --%ISOPEN 속성
                --%NOTFOUND 속성
                --%FOUND 속성
                --%ROWCOUNT 속성
        --(4) CLOSE
        
        --커서 + 익명프로시저 작성 실행
        SET SERVEROUTPUT ON;
    DECLARE
     TYPE empdepttype IS RECORD
    (
    deptno dept.deptno%type,
    dname dept.dname%type,
    empno emp.empno%type, 
    ename emp.ename%type,
    pay number );
    vderow empdepttype;
    -- 1) 커서 선언
        CURSOR edcursor IS (
        SELECT D.deptno,dname,empno,ename,sal+nvl(comm,0) pay
        from dept d join emp e on d.deptno = e.deptno); 
    BEGIN
    --EXCEPTION
    --2) 커서 open
    open edcursor;
    --3) fetch
    --while (true) { if() break ;}
    loop 
        fetch edcursor into vderow;
         exit when edcursor%notfound ;
        dbms_output.put ( edcursor%rowcount || ' : ');
        dbms_output.put_line(vderow.deptno || ', ' || vderow.dname || ', ' ||vderow.empno || ', ' || vderow.ename || ', ' ||vderow.pay);

       
    end loop;
    --4) 커서 close
     close edcursor;
    END; 
    
--ㄱ. [암시적 커서 + 익명프로시저 작성] for문 작성

 DECLARE
     TYPE empdepttype IS RECORD
    (
    deptno dept.deptno%type,
    dname dept.dname%type,
    empno emp.empno%type, 
    ename emp.ename%type,
    pay number);
   vderow empdepttype;
    -- 1) 커서 선언
        CURSOR edcursor IS (
        SELECT D.deptno,dname,empno,ename,sal+nvl(comm,0) pay
        from dept d join emp e on d.deptno = e.deptno); 
    BEGIN
    --EXCEPTION
    --2) 커서 open
    for vderow in edcursor
    loop 
       -- fetch edcursor into vderow;
       --  exit when edcursor%notfound ;
        dbms_output.put ( edcursor%rowcount || ' : ');
        dbms_output.put_line(vderow.deptno || ', ' || vderow.dname || ', ' ||vderow.empno || ', ' || vderow.ename || ', ' ||vderow.pay);

       
    end loop;
    --4) 커서 close
     
    END; 
    
 --ㄴ.  [암시적 커서 + 익명프로시저 작성] for문 작성

 DECLARE
    -- 1) 커서 선언
       
    BEGIN
    --EXCEPTION
    --2) 커서 open
    for vderow in ( SELECT D.deptno,dname,empno,ename,sal+nvl(comm,0) pay
        from dept d join emp e on d.deptno = e.deptno)
    loop 
       -- fetch edcursor into vderow;
       --  exit when edcursor%notfound ;
        --dbms_output.put ( edcursor%rowcount || ' : ');
        dbms_output.put_line(vderow.deptno || ', ' || vderow.dname || ', ' ||vderow.empno || ', ' || vderow.ename || ', ' ||vderow.pay);

       
    end loop;
    --4) 커서 close
     
    END; 
    --[저장 프로시저 (stored procedure)]
    create or REPLACE procedure 프로시저명 
    (
        매개변수(argument,parameter), --매개변수는 ,로 이어짐
        접두사 p 
    )
    is
        접두사 v; --변수는 ;으로 끝남
    begin
    exception
    end;
    
--저장 프로시저를 실행하는 3가지 방법
1) execute 문
2)익명프로시저에서 호출 해서 실행
3) 또 다른 저장프로시저에서 호출해서 실행

--서브쿼리를 사용해서 테이블 생성 
create table tbl_emp as (
select * from emp) ;

select * from tbl_emp;

--저장(stored) 프로시저 : up_ user procedure


create or replace procedure up_delete  
(
 --pempno in tbl_emp.empno%type  --매개변수를 선언할때는 자료형의 크기를 선언하지 않고 자료형만 선언함
  pempno tbl_emp.empno%type
)
is
begin
delete from tbl_emp 
where empno = pempno;
commit;
--exception
end;

execute up_delete(7499);
execute up_delete(pempno => 9999);

select * from tbl_emp;
begin
    up_delete(7902);
end;

create or replace procedure up_delete_1
as
begin
up_delete(7369);
end;
exec up_delete_1;


--문제1) dept - > tbl_Dept 테이블 생성
create table tbl_dept as
( select * from dept);

--문제2) tbl_dept 테이블에 deptno 컬럼에 PK 제약조건 설정
    alter table tbl_dept add constraint  pk_tbldept primary key(deptno);
    
    --문제3) 명시적 커서 + tbl_dept 테이블을 select 저장 프로시저 생성
-- 실행
-- tbl_seltbldept
-- 매개변수x


CREATE OR REPLACE PROCEDURE up_seltbldept
IS
   vdrow tbl_dept%ROWTYPE;
   CURSOR dcursor IS (
                         SELECT deptno, dname, loc
                         FROM tbl_dept
                       );
BEGIN 
   OPEN dcursor; 
   LOOP
     FETCH dcursor INTO vdrow; 
     EXIT WHEN dcursor%NOTFOUND;     
     DBMS_OUTPUT.PUT( dcursor%ROWCOUNT || ' : '  );
     DBMS_OUTPUT.PUT_LINE( vdrow.deptno || ', ' || vdrow.dname 
      || ', ' ||  vdrow.loc);  
   END LOOP; 
   CLOSE dcursor;
--EXCEPTION
END;

EXEC UP_SELTBLDEPT;

--문제4) 새로운 부서를 추가하는 저장 프로시저
--      deptno 시퀀스 
--      dname,loc

select * from user_sequences;
--  4-1) seq_deptno 시퀀스 생성 50/10/nocycle/NO캐시/90
create sequence seq_deptno
    start with 50
    increment by 10
    maxvalue 90
    nocycle
    nocache;
--

create or replace procedure up_instbldept
(
    pdname in tbl_dept.dname%type := null,
    ploc in tbl_dept.loc%type default null-- :='SEOUL'
)
is
    vdeptno tbl_dept.deptno%type;
begin
--    select max(deptno) +10 into vdeptno 
--    from tbl_dept;
    insert into tbl_dept (deptno,dname,loc)
    values (seq_deptno.nextval , pdname,ploc);
    commit;
--exception
end;
    
EXEC UP_SELTBLDEPT;
exec up_instbldept('QC','SEOUL');   
exec up_instbldept('QC2','SEOUL');   
exec up_instbldept(ploc=>'QC2');   
exec up_instbldept; 

--문제 up_seltbldept , up_instbldept
--  [up_updtbldept] 
exec up_updtbldept(50,'x','y') ; =>
exec up_updtbldept(pdeptno => 50,pdname=>'QC3') ; --=> loc는 유지
exec up_updtbldept(pdeptno => 50,ploc=>'SEOUL') ; --=> pdname는 유지

--ㄱ 
CREATE OR REPLACE PROCEDURE up_updtbldept
(
    pdeptno IN tbl_dept.deptno%TYPE,
    pdname IN tbl_dept.dname%TYPE :=null,
    ploc IN tbl_dept.loc%TYPE := null
)
IS
    a tbl_dept.dname%type;
    b tbl_dept.loc%type;
    
BEGIN
    select dname,loc into a,b from tbl_dept where deptno=pdeptno ;
    if pdname is null and ploc is null then
    UPDATE tbl_dept
    SET
        dname =vdname,
        loc = vloc
    where deptno = pdeptno;
   
    else if pdname is null then
     UPDATE tbl_dept
    SET
        dname =vdname,
        loc = ploc
    where deptno = pdeptno;
   
    else if ploc is null then
     UPDATE tbl_dept
    SET
        dname =pdname,
        loc = vloc
    where deptno = pdeptno;
  
    else 
    UPDATE tbl_dept
    SET
        dname =pdname,
        loc = ploc
    where deptno = pdeptno;
 
    COMMIT;
    end if;
END up_updtbldept;

--ㄴ
CREATE OR REPLACE PROCEDURE up_updtbldept
(
    pdeptno IN tbl_dept.deptno%TYPE,
    pdname IN tbl_dept.dname%TYPE :=null,
    ploc IN tbl_dept.loc%TYPE := null
)
IS

BEGIN
    update tbl_dept
    set dname = nvl(pdname,dname),loc = case when ploc is null then loc else ploc
    end
    where deptno = pdeptno;
END up_updtbldept;

exec up_updtbldept(50,'z');
select * from tbl_dept;

--풀이) up_seltbldept 모든 부서 조회 ... + 명시적 커서
select * from tbl_emp ;
--해당되는 부서원들만 조회하는 저장 프로시저 작성.

CREATE OR REPLACE PROCEDURE up_seltblemp
    (
    pdeptno tbl_emp.deptno%type := null )
    
IS
   verow tbl_emp%ROWTYPE;
   CURSOR ecursor IS (
                         SELECT *
                         FROM tbl_emp
                         where deptno = nvl(pdeptno , 10)
                       );
BEGIN 
   OPEN ecursor; 
   LOOP
     FETCH ecursor INTO verow; 
     EXIT WHEN ecursor%NOTFOUND;     
     DBMS_OUTPUT.PUT( ecursor%ROWCOUNT || ' : '  );
     DBMS_OUTPUT.PUT_LINE( verow.deptno || ', ' || verow.ename 
      || ', ' ||  verow.hiredate);  
   END LOOP; 
   CLOSE ecursor;
--EXCEPTION
END;

exec up_seltblemp;
exec up_seltblemp(30);
create table tbl_emp as (select * from emp);

--ㄴ 커서에 매개변수가 있는 경우
--풀이) up_seltbldept 모든 부서 조회 ... + 명시적 커서
--select * from tbl_emp ;
--해당되는 부서원들만 조회하는 저장 프로시저 작성.
-- 커서 파라미터를 이용하는 방법
CREATE OR REPLACE PROCEDURE up_seltblemp
    (
    pdeptno tbl_emp.deptno%type := null )
    
IS
   verow tbl_emp%ROWTYPE;
   CURSOR ecursor(cdeptno tbl_emp.deptno%type) IS (
                         SELECT *
                         FROM tbl_emp
                         where deptno = nvl(cdeptno , 10)
                       );
BEGIN 
   OPEN ecursor (pdeptno); 
   LOOP
     FETCH ecursor INTO verow; 
     EXIT WHEN ecursor%NOTFOUND;     
     DBMS_OUTPUT.PUT( ecursor%ROWCOUNT || ' : '  );
     DBMS_OUTPUT.PUT_LINE( verow.deptno || ', ' || verow.ename 
      || ', ' ||  verow.hiredate);  
   END LOOP; 
   CLOSE ecursor;
--EXCEPTION
END;

----ㄷ for문 사용
--풀이) up_seltbldept 모든 부서 조회 ... + 명시적 커서
--select * from tbl_emp ;
--해당되는 부서원들만 조회하는 저장 프로시저 작성.
-- 커서 파라미터를 이용하는 방법
CREATE OR REPLACE PROCEDURE up_seltblemp
    (
    pdeptno tbl_emp.deptno%type := null )
    
IS
BEGIN 
    for verow in ( SELECT *
                         FROM tbl_emp
                         where deptno = nvl(pdeptno , 10)
                       )
                       loop
                     DBMS_OUTPUT.PUT_LINE( verow.deptno || ', ' || verow.ename 
      || ', ' ||  verow.hiredate); 
                       end loop;
--EXCEPTION
END;

exec up_seltblemp(30);

--문제) tbl_dept 테이블의 레코드 삭제하는 up_deltbldept  저장 프로시저를 작성, 50,60,70 ,80 삭제
--삭제할 부서번호를 매겨변수로 받아야한다.
create or replace procedure up_deltbldept
    (
     pdeptno tbl_dept.deptno%type )
is
begin
    delete tbl_dept 
    where deptno= pdeptno;
    commit;
end;

exec up_deltbldept(50);
exec up_deltbldept(60);
exec up_deltbldept(90);
select * from tbl_dept;
commit;

--[저장 프로시저]
--입력용 매개변수 IN
--출력용    "     OUT
--입,출력용     " IN OUT
select num, name,ssn 
from insa 
where num = 1001; -- IN
--
CReate or replace procedure up_selinsa
(
    pnum in insa.num%type,
    pname out insa.name%type,
    prrn out varchar2
)
is
    vname insa.name%type;
    vssn insa.ssn%type;
begin
select name,ssn into vname,vssn
from insa 
where num = pnum;

pname := vname;
prrn := substr(vssn,1,8) || '******' ;
--exception
end;

declare
    vname insa.name%type;
    vrrn varchar2(14);
begin 
up_selinsa(1001,vname,vrrn ) ;
dbms_output.put_line(vname || ', '|| vrrn);
end;

-- 예) 주민등록번호 14자리를 입력용 매개변수로...
--  앞자리 6자리를 출력용 매개변수로 사용.
create or replace procedure up_rrn
(
    prrn in out varchar2
)
is
begin
    prrn := substr(prrn,1,6);
    
--exception
end;

declare 
  vrrn varchar2(14) := '761230-1700001';
begin
    up_rrn(vrrn);
    dbms_output.put_line(vrrn);
    end;
    
-- 저장 프로시저
create or replace procedure 저장프로시저명 
(
 p 파라미터, 
 p 파라미터)
 return 리턴자료형
 is 
    v 변수명;
    v 변수명;
    begin
    
        return (리턴값);
    exception
    end;
    --저장 함수 (Stored Function)
-- 
-- 예제1) 저장함수 ( 주민등록번호를 매개변수 남자/여자 문자열 반환하는 함수) 
select num,name,ssn ,decode( mod( substr(ssn,-7,1) ,2),1,'남자','여자') gender  --주민등록번호를 사용해서 성별 구분
from insa;
--
create or replace function uf_gender
(
    prrn in varchar2 -- 입력용이면 in
)
return varchar2
is
    vgender varchar2(6);
begin
  if substr(prrn,-7,1) = '1' then
    vgender := '남자'; 
   
    else 
    vgender := '여자';
    
    end if;
    return vgender ;
--exception
end;

--
create or replace function uf_age 
(
    prrn in varchar2
    ,ptype in number --,whatrrn number --1(세는 나이) 0 (만나이)
)
return number
is
    ㄱ number(4) ; --올해년도
    ㄴ number(4) ; --생일년도
    ㄷ number(4) ; --생일 지남 여부 -1 0 1
    vcounting_age number(3); --세는 나이
    vamerican_age number(3); --만 나이
begin 
    --만나이  = 올해년도 - 생일년도 =세는나이 -1   생일지남여부 -1 결정.
    --세는 나이 = 올해년도 -생일년도 +1 ;
    ㄱ := to_char(sysdate,'yyyy');
    ㄴ := case when substr(prrn,8,1) in (1,2,5,6) then 1900 
               when substr(prrn,8,1) in (3,4,7,8) then 2000
               else 1800
               end + substr(prrn,1,2);
               ㄷ := sign(to_date(substr(prrn,3,4), 'MMDD') - trunc(sysdate)); --1 이면 생일 안지남
               vcounting_age := ㄱ-ㄴ+1;
               vamerican_age := case ㄷ when 1 then  vcounting_age -2 else vcounting_Age-1 end;
            if ptype =1 then
            return vcounting_age;
            else 
                return vamerican_age;
                end if;
--exception
end;

select name,ssn,uf_age(ssn,1),uf_age(ssn,0) from insa;


--예) 주민등록번호 -> 1998.01.20(화) 형식의 문자열ㄹ ㅗ반환하는 저장함수 작성 실행
select name,ssn
    ,scott.uf_birth(ssn)--1998.01.20(화)
from insa;
create or replace function uf_birth
(
    prrn varchar2 -- prrn insa
    )
return varchar2
is
    vcentury number(2); -- 19,20,18
    vbirth varchar2(20 char); 
begin
    vbirth := substr(prrn,1,6); --
    vcentury := case 
                when substr(prrn,-7,1) in (1,2,5,6) then 19 
                when substr(prrn,-7,1) in (3,4,7,8) then 20 
                else 18
                end;
                vbirth := vcentury || vbirth ; -- '19770221'
                vbirth := to_char(to_date(vbirth,'yyyymmdd'),'yyyy.mm.dd (dy)');
                return vbirth;
                
--exception
end;

return data_type;
is [as]
begin 

    return(변
--문제
select power(2,3),power(2,-3) ,scott.uf_power(2,3),scott.uf_power(2,-3) from dual;

create or replace function uf_power 
(
    a number,
    b number
)
return number
is
     c number default 1;
begin
for i in 1..abs(b) loop
    c:=c*a;
    end loop ;
    
    if b>0 then
    return c;
    else if b=0 then return 1;
    else
    return 1/c;
    end if;
    end if;
end uf_power;











