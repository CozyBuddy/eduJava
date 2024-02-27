select * 
from user_sys_privs; -- 시스템 권한  UNLIMITED TABLESPACE 제한 없이 무한정 테이블스페이스 사용

select * 
from user_role_privs; --롤 권한 조회 

형변환 함수 : to_char(날짜 or 숫자 or문자열) , to_number () , upper() 

오라클 연산자 : ^= , <=,>=  ,  SQL 연산자  is [not] null ,between and
논리 연산자 not and or

[1] 기본풀이
select ename,nvl(comm,0)+sal 월급 frommp where (nvl(comm,0)+sal) e>=1000 and (nvl(comm,0)+sal)<=3000 and (deptno=20 or deptno=10 )order by ename;

[2] between 사용 
select deptno,ename,sal+nvl(comm,0) pay from emp where sal + nvl(comm,0) between 1000 and 3000 and deptno !=30 order by ename;

[3] with 사용

--• 자주 사용되는 query를 사용하기 전에 with 절로 미리 query block으로 정의한 후 사용한다.
--• 서브쿼리문에서 sub query에 의해 실행된 결과에 의해 main query가 실행되기 때문에 서브쿼리문은 성능이 저하된다.
--• With 절을 통해 서브쿼리를 보다 쉽고 간편하게 사용할 수 있게 한다.
--• WITH 절은 여러 개의 sub query가 하나의 main query에서 사용될 때 생기는 복잡성을 보다 간결하게 정의하여 사용함으로써 서브쿼리에서 발생할 수 있는 성능저하 현상을 방지할 수 있다.
--• 먼저, 하나의 main query에 정의될 sub query를 with 절과 함께 선언하고, 각각의 sub query가 정의될 때 sub query를 대신할 인라인 뷰의 이름을 사용자가 적절히 정의한다. 여러 개의 sub query가 사용된다면 순서대로 선언하면 된다.
--• sub query의 선언이 끝나면, 실제로 실행될 main query절을 작성하는데, 필요한 sub query는 인라인 뷰의 이름으로 새로운 sub query를 작성하여 사용한다. 
--【형식】
--    WITH  query1이름 AS (subquery1),
--          query2이름 AS (subquery2), ...
--
--•• with절 속에 반드시 select 문이 있어야 함
--•• query명과 기존의 테이블명이 동일하게 사용되는 경우, 쿼리 블럭명이 우선함
--•• 하나의 with절에 여러 개의 query block 사용이 가능하다.
--•• with절을 불러서 사용하는 body 영역에서는 block명이 우선되므로 테이블명은 사용할 수 없다.
--•• with절 내에 또 다른 with절을 포함할 수 없다.
--•• set operator를 사용한 쿼리에서는 사용할 수 없다.

with temp as ( select deptno ,ename , sal+nvl(comm,0) pay from emp)
select *
from temp
where pay between 1000 and 3000 and deptno!=30
order by ename;

[4]
with temp as ( select deptno ,ename , sal+nvl(comm,0) pay from emp)
select *
from temp
where pay between 1000 and 3000 and deptno!=30
order by ename;

--[시험]
--subquery란 쿼리내에 또다른 쿼리를 수행하는 것이다.
--즉 SELECT 문에 또다른 SELECT 문이 들어 있는 경우이며, FROM 절에 subquery가 있으면 이를 inline view라 하고, WHERE 절에 subquery가 있으면 이를 Nested subquery라 한다.
--그런데, Nested subquery중에서 참조되는 컬럼의 관계가 parent/child관계를 가지는 컬럼이 있으면 이를 correlated subquery라 한다.
--
--subquery는 다음과 같은 목적으로 사용됨
-- (scalar subquery) 란 ? select 절 + 서브쿼리 => 단일값 반환
--• INSERT 또는 CREATE TABLE 문에서 넣을 행을 정의하기 위해
--• CREATE VIEW 또는 CREATE MATERIALIZED VIEW 문에서 view 또는 materialized view에 포함시킬 행을 정의하기 위해
--• UPDATE 문에서 갱신할 행을 정의하기 위해
--• SELECT, UPDATE, DELETE 문의 WHERE절, HAVING 절, START WITH 절의 조건을 정의하기 위해
--• 쿼리에 의해 동작될 테이블을 정의하기 위해

--인라인뷰
-- 예제는 subquery, with 없이 적용
select * from ( select deptno,ename,sal + nvl(comm,0) pay from emp) t where t.pay between 1000 and 3000 and t.deptno !=30
order by t.ename ;

--- SQL 연산자 is Null , is not null
select i.*, nvl(tel,'연락처 등록 안됨') from insa i;

select * from insa where not(city = '서울' or city='인천' or city='경기'); 
--  where city in ('서울','경기','인천')
--  where city not in ('서울','경기','인천')

--문제 emp 테이블에서 입사일자(hiredate)가 81년도인 사원 정보를 조회 
--[1]
select e.* 
from emp e
where hiredate between '1981/1/1' and '1981/12/31';

desc emp;

[2] 풀이
-- [2] DATE => 입사년도만 얻어오기
select ename,hiredate
from emp
where  extract (year from hiredate)=1981 ;

select extract (year from current_timestamp) 년도 ,extract (month from sysdate) 월 ,extract (day from sysdate) 일 
from dual;

select to_char(sysdate,'yyyy-mm-dd') as"오늘 날짜", current_timestamp as"모든 시간 정보"
from dual;
--sysdate 시간분초까지 가지고 있음 출력을 dd까지만 함) ,current_timestamp (나노세컨드까지)
select sysdate, current_timestamp, extract (year from sysdate),
to_char (sysdate,'yyyy'),to_char(sysdate,'year'),to_char (sysdate,'yy'),to_char (sysdate,'y')
from dual;

select ename,hiredate
from emp
where to_char(hiredate,'yyyy')='1981';

[3] 
select ename,hiredate
from emp
where substr(hiredate,0,2) = 81 ;

select 'abcdefg' , substr('abcdefg' , 1 ,2), substr('abcdefg' , 0 ,2) , substr('abcdefg',3),substr('abcdefg',-5,3),substr('abcdefg',-1,1) 
-- 0과1이 처음 자리로 고정 , -5나 -1은 뒤에서부터의 시작자리를 가리킴
from dual;

--[문제] insa 테이블에서 사원명, 주민등록번호,년도,월,일 성별 출력
select name,ssn , extract ( year from to_date(substr(ssn,0,6)) ) year ,extract ( month from to_date(substr(ssn,0,6)) ) month,extract ( day from to_date(substr(ssn,0,6)) ) day , substr(ssn,8,1) gender
from insa;

--오라클의 예약어를 속성명으로 두는것은 금지됨. 오류남. 예약어가 date , 그래서 쓸려면 " " 를 붙이면 사용할 수 있음.
select *
from dictionary
where table_name like '%words%';
select *
from v$reserved_words; -- sys에서 예약어를 조회

--[문제] insa 테이블에서 name ,rrn 출력
 select name, substr(ssn,0,8) || '******' rrn
 from insa
 where extract (year from to_date(substr(ssn,0,6)) ) between 1970 and 1979 ;


-- Like SQL연산자 설명 -- 
-- 문자의 패턴 일치 여부 
-- 와일드카드  %, _ 두개만 사용 %는 자바 정규식에 *와 같음 여러 문자가 와도 상관없음.
-- _ 는 한개의 문자 
-- 와일드카드를 일반문자처럼 사용하려면 ESCAPE 옵션을 사용

--[문제] insa 테이블에서 name ,rrn 출력 12월생 조회
select name,ssn rrn
from insa
where ssn like '7_12%';

select name,ssn rrn,city
from insa;


select name,ssn rrn
from insa
where extract (month from to_date(substr(ssn,0,4),'yymm')) =12;


--[문제] insa 테이블에서 김씨 성을 가진 사원 모두 출력
select name,ssn
from insa
where name like '김%';

--[문제] insa 테이블에서 김씨 성이 아닌 사원 모두 출력
select name,ssn
from insa
where name not like '김%';

--문제  출신도가 서울, 부산, 대구 이면서 전화번호에 5 또는 7이 포함된 자료 출력하되 부서명의 마지막 부는 출력되지 않도록함. (이름, 출신도, 부서명, 전화번호)
-- 문자열의 길이를 알아내는ㄴ 함수 length(속성명 or 문자열)
SELECT name,city,substr(buseo,0,length(buseo)-1) BUSEO,tel
FROM insa
WHERE city in ('서울','부산','대구') and (tel like '%5%' or tel like '%7%');  

--[Like 연산자의 ESCAPE 옵션 설명]
-- dept 테이블 구조 확인
DESC dept;

select deptno,dname,loc
from dept;

10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON

--DML([Insert]) 새로운 부서를 추가 
desc dept ; 
insert into dept [(컬럼명,컬럼명...)] values (값,...) ;

insert into dept (deptno,dname,loc) values ( 50 , '한글_나라','COREA');
insert into dept  values ( 50 , '한글_나라','COREA'); --유일성 제약조건 deptno가 50 이 중복됨. primary key = 기본키 고유키
insert into dept  values ( 60 , '한글_나라','COREA'); 
commit;
rollback;
select * from dept; --
desc dept;

--[문제] dept 테이블에서 부서명 검색을 하는데 부서명에 _ 이 있는 부서 정보를 조회

select * from dept where dname like '%\_%' escape '\' ; -- _를 한문자로 쓰지 않고 (와일드카드로 사용하지 않고) 진짜 언더바(일반문자)로 인식하기 위해 escape를 사용
select * from dept where dname like '%\%%' escape '\' ; -- _를 한문자로 쓰지 않고 (와일드카드로 사용하지 않고) 진짜 언더바(일반문자)로 인식하기 위해 escape를 사용

-- dml(insert,[update],delete) +  완료 commit,취소 rollback

update [스키마].테이블명 
set 컬럼명 = 값, 컬럼명 = 값 ... 
[where 조건절 ];  -- where 조건이 없으면 모든 레코드를 수정. 

update scott.dept
set loc = 'xxx';

rollback;


update scott.dept
set loc = 'Gangnam' , dname = '한글나라'
where deptno = 60 ;
commit;
--[문제] 60번 부서명,지역명을  30번 부서명,지역명으로 업데이트

update scott.dept
set loc = (select loc from dept where deptno=30) , dname = (select dname from dept where deptno=30)
where deptno = 60;

--
update scott.dept
set (loc,dname) = (select loc,dname from dept where deptno=30) 
where deptno = 60;

-- dml(insert,update,[delete]) +  완료 commit,취소 rollback
delete from [스키마.]테이블명
[where 조건절] where 조건없으면 모두 삭제 ;

delete from dept -- integrity 무결성 제약 조건 ( 왜래키로 다른 테이블에서 해당 테이블의 속성을 참조하고 있음.
where deptno=60 or deptno =50;
commit;



--[문제] emp 테이블에서 sal의 10%를 인상해서 새로운 sal로 수정.
update emp
set sal = sal*1.1;

select * from emp;
rollback;

-- Like sql 연산자 : % _ 패턴기호
-- Regexp_like 함수 : 정규표현식
-- [문제] insa 테이블에서 성이 김씨 , 이씨 만 사원 조회.

select * from insa where substr(name,0,1) = '김' or substr(name,0,1) = '이';
select * from insa where substr(name,0,1) in ('김','이');
select * from insa where name like '김%' or name like '이%';
select * from insa where regexp_like (name,'^[김이]');
select * from insa where regexp_like (name,'^(김|이)');
select * from insa where regexp_like (name,'[경자]$');
select * from insa where regexp_like (ssn,'^7[0-9]12');

--[문제] insa 테이블에서 70년대 남자 사원만 조회...
-- 성별 1,3,5,7,9 남자 
-- 나머지 연산자가 없음. 나머지 함수 mod() 가 존재

--where substr(ssn,8,1) in (1,3,5,7) and ssn like '7%' ;
--where regexp_like ( substr(ssn,0,8), '[1|3|5|7|9]$') and regexp_like ( substr(ssn,0,8), '^7');
select *
from insa 
where mod(substr(ssn,8,1),2)=1 and ssn like '7%' ;








