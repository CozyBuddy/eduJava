select ssn , substr(ssn,1,2) YEAR ,substr(ssn,3,2) MONTH ,substr(ssn,5,2) "DATE",substr(ssn,8,1) GENDER
from insa;

select ENAME, HIREDATE , TO_CHAR(HIREDATE,'yyyy') YEAR, substr(hiredate,4,2) MONTH, to_char(hiredate,'dd') "date" from emp;

select name , ssn
from insa
where ssn like '7_12%'
order by ssn;

with t as (select * from emp where nvl(comm,0) +sal >=1000 and nvl(comm,0) +sal <=3000 and deptno!=30 )
select *
from t
order by ename;

select name , ssn
from insa
where regexp_like(ssn,'^7[0-9]{5}-1')
order by ssn;

select * from emp
where ename like '%LA%' or ename like '%la%'or ename like '%La%'or ename like '%lA%';


select name,ssn, substr(ssn,8,1) gender from insa;


select * from insa where not( city='서울' or city = '인천'  or city = '경기');

select * from dept;

insert into dept values ( 50 ,'QC','SEOUL');
rollback;
update dept
set dname = (select dname from dept where deptno=20) , loc = (select loc from dept where deptno=20)
where deptno =50;

delete dept
where deptno=50;

select * from insa;
select name, ibsadate from insa where extact ( year from ibsadate) >=200r0 and  extract ( year from sysdate) >=extract ( year from ibsadate)  ;

select name, ibsadate from insa where to_char(ibsadate,'yy') >=0 and  to_char(sysdate,'yy') >=to_char(ibsadate,'yy')  ;

select current_timestamp
from dual;




----------------------------------------------------------------------------------

-- with 절 형식  : with 새로지정할 속성명  as ( select ~~~)

select name , ssn
from insa
where regexp_like(ssn,'^7[0-9]12') -- 그 뒤 문자는 상관안하고 해당하는 것만 확인하면 조건에 만족.
order by ssn;

--나머지 구하는 함수 MOD() 
REGEXP_LIKE(속성명, '정규식')

select name , ssn
from insa
where regexp_like(ssn,'^7[0-9]{5}-[13579]')
order by ssn;

select * from emp
where regexp_like(ename, '[lL][aA]'); 
select * from emp
where regexp_like(ename, 'la','i'); --옵션으로 대소문자 구별 안함. 

select ename , replace ( ename, 'LA','<sapn style = "color:red">LA</sapn>') from emp;
replace (문자열 혹은 속성명 , 교체할 문자 , 교체가 될 문자)  만약에 교체가 될 문자가 없으면 교체할 문자를 제거함.

-- if문  PL/SQL 

--select t.name, t.ssn ,replace ( replace ( t.gender,1,'O') ,0,'x'))

select t.name, t.ssn ,replace ( replace ( t.gender,1,'O') ,0,'x') gender
from (select name, ssn ,mod(substr(ssn,8,1),2) as gender from insa) t;

NULLIF(첫값,두번째값)
--첫값 == 두번째값 => NULL반환
--첫값 != 두번째값 => 첫값을 반환

SELECT ENAME,JOB,
lengthb(ename),lengthb(job),
 nullif(lengthb(ename),lengthb(job)) nullif_result
from emp
where deptno = 20;

select name,ssn,nvl2(nullif(mod(substr(ssn,8,1),2),1),'O','X') from insa;

select * from emp where ename = upper('king');

select * from emp where regexp_like(ename,'king','i');

select * from insa where city = '서울' or city = '경기' or city = '인천'
select * from insa where city in ( '서울','경기','인천');
select * from insa where regexp_like(city,'ㅇ');

Insert into dept ( deptno,dname ,loc) values ( 50,'QC','SEOUL') ;
select * from dept;

--DML(insert,update,delete) + commit,rollback 

select name, ibsadate from insa where to_char(ibsadate,'yyyy') >=2000  ;

select name, ibsadate from insa where extract ( year from ibsadate) >=2000;

select name,ssn , substr(ssn,0,6) || substr(ssn,8,7) as ssn2 
from insa;

--select 5+3 ,5-3,5*3,5/3,mod(5,3)

select mod(5,-2), remainder(5,-2)
from dual;

--Public Synonym 생성
CREATE PUBLIC SYNONYM  arirang 
FOR scott.emp;

--ORA-01031: insufficient privileges
--01031. 00000 -  "insufficient privileges"
--*Cause:    An attempt was made to perform a database operation without
--           the necessary privileges.
--*Action:   Ask your database administrator or designated security
--           administrator to grant you the necessary privileges


select name,ssn ,substr(ssn,1,6) || substr(ssn,8) from insa;

select staff.ename,staff.job ,manager.ename
from emp staff , emp manager
where staff.mgr = manager.empno and manager.ename like 'BLAKE';


 select * from insa;
 select * from emp;

select name,ssn ,replace(ssn,'-','') ssn2 from insa;
select name,ssn ,replace(ssn,'-') ssn2 from insa; -- 3번째 매개변수를 안주면 그냥 제거함.

select to_date('2024','yyyy'),to_date('2024/05/21'),to_date('2024/3','yyyy/mm')
from dual;

select * from insa where regexp_like (name ,'^[김이]') and ssn like '7_12%' ;

여기서 YY와 RR의 차이점:
 RR과 YY는 둘다 년도의 마지막 두자리를 출력해 주지만, 현재 system상의 세기와 나타내고자 하는 년도의 세기를 비교할 했을 때 출력되는 값이 다르다.
RR은 시스템상(1900년대)의 년도를 기준으로 하여 이전 50년도에서 이후 49년까지는 기준년도와 가까운 1850년도에서 1949년도까지의 값으로 표현하고, 
이 범위를 벗아날 경우 다시 2100년을 기준으로 이전 50년도에서 이후 49년까지의 값을 출력한다.
YY는 무조건 system상의 년도를 따른다.


4자리인 경우엔 차이가 없구요. 2자리인경우엔 차이가 있습니다.
yy 는 무조건 '20'이 앞에 붙습니다.
rr 은 50년을 기준으로 작으면 '20' 크거나 같으면 '19'가 붙습니다.
TO_DATE('00','yy') ==> 2000
TO_DATE('50','yy') ==> 2050
TO_DATE('00','rr') ==> 2000
TO_DATE('50','rr') ==> 1950

select '05/01/10' --문자열
    ,to_char(to_date('97/01/10','RR/MM/DD'),'yyyy') a,to_char(to_date('97/01/10','YY/MM/DD'),'yyyy') b
    from dual;
    
    
    select name, ibsadate
    from insa;
    
    select deptno,ename,sal + nvl(comm,0) pay
    from emp
    order by deptno;
    
     select deptno,ename,sal + nvl(comm,0) pay
    from emp
    order by deptno,sal +nvl(comm,0) desc;
    
    --------------------------------------------------------------------------------
    오라클 연산자 (operator) 정리
    1) 비교 연산자 
     ㄴSQL 연산자 ANY,SOME,ALL  => 결과값은 true,false,null 3중에 하나
     
     select ename,sal
     from emp 
     where sal >= null; -- 오류는 안남.? 근데 무슨 의미?
     where sal> 1250;
     where sal =1250;
     where sal <=1250;
     where sal <1250;
     where sal >=1250;
     where sal >1250;
     where sal !=1250;
     
     any , some ,all ( sql 연산자 이면서 동시에 비교 연산자임)
     
     --emp 테이블에서 평균급여보다 많이 받는 사원들의 정보를 조회
     -- 1. emp 테이블의 평균 급여? avg() 집계함수 
     select avg(sal+nvl(comm,0)) avg_pay
     from emp;
        --2260.41666666666666666666666666666666667
        
    select *
    from emp
    where sal+nvl(comm,0) >= (select avg(sal+nvl(comm,0)) avg_pay
    from emp);
    
    --각 부서별 평균 급여보다 많이 받는 사원들의 정보를 조회.
    select * from emp m where sl+nvl(comm,0) >= (seleact avg(sal+nvl(comm,0)) avg_pay from emp e where e.deptno = m.deptno) ;
    
    -- 30번 부서의 최고급여 보다 많이 받는 사원들의 정보를 조회
select *
from emp
where sal+nvl(comm,0) >all(select (sal+nvl(comm,0))
from emp
where deptno=30);


with temp as ( select sal+nvl(comm,0) pay from emp)
select max(pay ),min(pay ),sum(pay ),avg(pay )
from temp;

select max(pay ),min(pay ),sum(pay ),avg(pay )
from  (select sal+nvl(comm,0) pay from emp);

-- 상관 서브 쿼리 ( correlated subquery) 
--[문제1] 사원 전체에서 최고 급여를 받는 사원의 정보를 조회 
select * from emp where sal+nvl(comm,0)= (select max(sal+nvl(comm,0)) from emp);
--[문제2]각 부서별 최고 급여를 받는 사원의 정보를 조회
select * from emp e where sal+nvl(comm,0)= (select max(sal+nvl(comm,0)) from emp m where e.deptno = m.deptno );

--각 부서별 평균급여보다 큰 부서원들 정보 조회
---ORA-00937: not a single-group group function
select deptno,ename,sal,(select avg(sal) from emp where deptno = t1.deptno)
from emp t1
where sal > (
            select avg(sal)
            from emp t2
            where t2.deptno=t1.deptno)
            
order by deptno ;  


    오라클 함수 (function ) 정리
    
    
    오라클 자료형 ( data type ) 정리
    
    
select * from emp ;
select count(*) from  emp where emp.job =emp.job;
select count(*) from (select distinct job from emp) ; 
select * from emp where regexp_like (ename,'la','i');
select * from emp where nvl(comm,0)+sal=( select max(nvl(comm,0)+sal) from emp);
select * from emp where nvl(comm,0)+sal=( select min(nvl(comm,0)+sal) from emp);
select * from emp where  not(nvl(comm,0)+sal > any( select (nvl(comm,0)+sal) from emp));
select count(*),deptno from emp group by deptno order by deptno;

-- [1] set(집계) 연산자 : union => 값이 중복이면 하나만 표시함, => union all 값이 중복이어도 다 표시함.
    
select '10' deptno,count(*) cnt from emp where deptno = 10  union all select '20' deptno,count(*) from emp where deptno = 20 union all select '30' deptno,count(*) from emp where deptno = 30;

--[2] select distinct deptno from emp;
select distinct deptno from emp order by deptno;

--select * from emp s where deptno =(select distinct deptno from emp order by deptno);
select distinct deptno , (select count(*) from emp c where c.deptno = d.deptno) from emp d order by deptno ;
--등수를 계산하는 로직 
select a.* , sal+nvl(comm,0) pay ,(select count(*) from emp b where sal+nvl(comm,0) >= a.sal + nvl(a.comm,0)) from emp a order by pay desc;

----[set] 집합 연산자
----1) 합집합 ( union ,union all)
--    select name,city,buseo from insa where buseo = '개발부' union
--    select name,city,buseo from insa where city = '인천';
----2)차집합 (minus)
--select name,city,buseo from insa where buseo = '개발부' minus
--    select name,city,buseo from insa where city = '인천';
----3)교집합 ( intersect)
--select name,city,buseo from insa where buseo = '개발부' intersect
--    select name,city,buseo from insa where city = '인천';
--    
--    --[set] 연산자 주의점
--    union  , union all => 중복 제거하냐 마냐 
 select name,city,buseo from insa where buseo = '개발부' union
   select name,city,basicpay from insa where city = '인천';
   --expression must have same datatype as corresponding expression 데이터타입이 다르면 안됨. 타입만 같으면 속성명이 달라도 가능.
   select * from insa;
   
    select name,city,buseo from insa where buseo = '개발부' union
   select name,city from insa where city = '인천';
    --query block has incorrect number of result columns 속성명의 갯수가 같아야함.
    
    -- insa 테이블의 사원 정보 + emp 테이블의 사원 정보 모두 출력
select buseo, num,name,ibsadate ,basicpay,sudang from insa i union all
select deptno ||'',empno, ename,hiredate, sal,comm from emp e;

select * from insa  cross join emp ;

select --10/0
--'A'/2
mod(10,0)
from dual;
--is [not] nan -- not a number 
is [not] infinite 

--함수의 개념
--복잡한 쿼리문을 간단하게 해주고 데이터의 값을 조작하는데 사용되는 것을 함수라 한다. 일반적으로 주어진 데이터(인수)를 처리하고 그 결과를 반환하는 기능을 수행한다.

--숫자 함수 
--ROUND(number) 숫자값을 특정 위치에서 반올림하여 리턴한다. 
select round(3.141592,3)  -- 소수점 4 번째 자리에서 반올림.

from dual;

-- [문제] emp 테이블에서 pay, 평균급여,총급여,사원수 출력
--not a single-group group function 복수행 함수와 단일행 함수가 동시에 사용했을때  group by 없이
    select c.* , sal+nvl(comm,0) pay, (select count(*) from emp m where m.deptno=c.deptno), round((select avg(s.sal+nvl(s.comm,0)) from emp s where s.deptno = c.deptno),2), (select sum(a.sal+nvl(a.comm,0)) from emp a where a.deptno = c.deptno)  from emp c;



--TRUNC(number) 숫자값을 특정 위치에서 절삭하여 리턴한다. 
--CEIL 숫자값을 소숫점 첫째자리에서 올림하여 정수값을 리턴한다. 
--FLOOR 숫자값을 소숫점 첫째자리에서 절삭하여 정수값을 리턴한다. 
--MOD 나머지값을 리턴한다. 
--ABS 숫자값의 절대값을 리턴한다. 
--SIGN 숫자값의 부호에 따라 1, 0, -1의 값으로 리턴한다. 
--POWER(n1,n2) n1^n2한 지수곱값을 리턴한다. 
--SQRT(n) n의 제곱근 값을 리턴한다. 
--SIN(n) n의 sine 값을 리턴한다. 
--COS(n) n의 cosine 값을 리턴한다. 
--TAN(n) n의 tangent 값을 리턴한다. 
--SINH(n) n의 hyperbolic sine 값을 리턴한다. 
--COS(n) n의 hyperbolic cosine 값을 리턴한다. 
--TAN(n) n의 hyperbolic tangent 값을 리턴한다. 
--LOG(a,b) 밑이 a인 b의 지수 값을 리턴한다. 즉, 뒤의 값이 앞의 값의 몇 배수인지를 알림 
--LN(n) n의 자연로그 값을 리턴한다. 

-- 집계함수
select count(*),count(comm) from emp;

-- 평균커미션 ?
select avg(comm) from emp;

select * from emp;

select trunc(3.141592 , 3),floor(3.141592), ceil(3.141592) from dual;

select ceil(3.141592*100)/100 from dual;

-- 총 페이지 수를 계산할 때 CEIL() 올림(절상) 함수를 사용한다.
--총 게시글(사원) 수  :  
select count(*) from emp ;
select ceil((select count(*) from emp)/5) --5명씩 출력할때 나머지 마지막 2명도 한 페이지가 되어야 하므로 ceil로 올려야함.
from dual;

 select * from emp order by sal+nvl(comm,0) desc;
 
 --[문제] emp 테이블의 평균 급여를 구해서 각 사원의 급여(pay)가 평균급여보다 많으면 "평균급여보다 많다"라고 출력 , 적으면 적다라고 출력
 
 select avg(sal+nvl(comm,0)) from emp ;
 
 select s.* , (select d.* from emp d where d.sal + nvl(d.comm,0) >(select avg(sal+nvl(comm,0)) from emp )) from emp s;
 
 [1]
 select s.* , '많다' 평균급여비교 from emp s where s.sal+nvl(comm,0) > (select avg(sal+nvl(comm,0)) from emp) union
 select s.* , '적다' from emp s where s.sal+nvl(comm,0) < (select avg(sal+nvl(comm,0)) from emp) ;
 
 [2]
 SELECT ename, sal+NVL(comm,0) pay 
    , (SELECT AVG( sal + NVL(comm,0 )) avg_pay FROM emp) avg_pay
    , SIGN( sal+NVL(comm,0) - (SELECT AVG( sal + NVL(comm,0 )) avg_pay FROM emp) ) s 
    , REPLACE(   REPLACE( SIGN( sal+NVL(comm,0) - (SELECT AVG( sal + NVL(comm,0 )) avg_pay FROM emp) ), -1, '적다'), 1, '많다') 
  FROM emp;
  
  [3]
   select ename,pay,avg_pay, sign(pay-avg_pay) ,nvl2(nullif( sign(pay - avg_pay),1),'적다','많다') from (select ename,sal+nvl(comm,0) pay , (select avg(sal +nvl(comm,0)) from emp) avg_pay
   from emp
   );
   
--문자 함수 
-- instr() -- 문자 위치값 반환 다만 문자 위치 시작이 0 이 아니라 1부터임.
select instr ( 'corea' ,'e') from dual;
select instr('corporate floor','or',5,2) from dual; --문자위치 5에서부터 찾기시작 , 단 2번째 'or' 위치 반환
select instr('corporate floor','or',-3,2) from dual; --문자위치 -3에서부터 찾기시작 , 단 2번째 or 위치 반환
  
select '010-3399-4975' phone , substr('010-3399-4975',1,instr('010-3399-4975','-')-1),substr('010-3399-4975',instr('010-3399-4975','-')+1,instr('010-3399-4975','-',1,1)),substr('010-3399-4975',instr('010-3399-4975','-',1,2)+1,instr('010-3399-4975','-',1,1)), substr('02-1234-5678',instr('02-1234-5678','-')+1,instr('02-1234-5678','-',1,2)-instr('02-1234-5678','-',1,1)-1) a  from dual;




desc tbl_Tel;

select * from tbl_tel;
insert into tbl_Tel values ( '063)469-4567','신슬기');
insert into tbl_Tel values ( '063)1456-2367','이나딘');
commit;

--지역번호 / 앞자리 전화번호 / 뒷자리 전화번호

select substr(tbl_tel.tel,1,instr(tbl_tel.tel,')')-1) 지역번호,substr(tbl_tel.tel,instr(tbl_tel.tel,')')+1,instr(tbl_tel.tel,'-')-instr(tbl_tel.tel,')')-1) 앞자리번호,substr(tbl_tel.tel,instr(tbl_tel.tel,'-')+1) 뒷자리번호 from tbl_tel;

select ename,pay, lpad(pay,10,'$') from (select ename, sal+ nvl(comm,0) pay from emp) ; -- 문자 자리수를 미리 10자리 확보하고 lpad면 오른쪽에 pay를 채우고 왼쪽 남은 문자공간은 '*'로 채움.


select ascii(substr(ename,1,1)),substr(ename,1,1) , chr(ascii(substr(ename,1,1))) from emp;

-- greatest , least => 나열된 숫자, 문자 중에 가장 크거나 가장 작은 값을 반환.

select greatest(3,5,2,1,4),greatest('Z','A','B','X','R') from dual;

select ename ,vsize(ename) from emp; -- 알파벳은 한문자당 한 바이트 한글은 자음 , 모음 각각 한 바이트 먹음

select sysdate from dual;
select round(sysdate) from dual;
select trunc(sysdate) from dual;

select round(sysdate,'dd') b , round(sysdate,'year') , round(sysdate, 'mm') from dual;

select sysdate, to_char(sysdate, 'yyyy.mm.dd hh.mi.ss') ,to_char(trunc(sysdate), 'yyyy.mm.dd hh.mi.ss') ,to_char(trunc(sysdate,'dd'), 'yyyy.mm.dd hh.mi.ss') ,to_char(trunc(sysdate,'month'), 'yyyy.mm.dd hh.mi.ss') ,to_char(trunc(sysdate,'year'), 'yyyy.mm.dd hh.mi.ss')from dual;

--날짜에 산술 연산을 사용하는 경우, 반환 되는 데이터 타입 연산 결과 의 미 
--날짜 + 숫자 날짜 날짜에 일수를 더하여 날짜 계산 
--날짜 - 숫자 날짜 날짜에 일수를 감하여 날짜 계산 
--날짜 + 숫자/24 날짜 날짜에 시간을 더하여 날짜 계산 
--날짜 - 날짜 일수 날짜에 날짜를 감하여 일수 계산 

--[문제] 입사한 날짜 부터 오늘 날짜 까지 근무한 일수 계산
select ename , (trunc(sysdate) + 1 -trunc(hiredate)) 총근무일수 from emp;

select to_char(sysdate+2/24, 'yyyy.mm.dd hh.mi.ss') "2시간후" from dual;

--[문제] 24년 2월 마지막 날짜 며칠까지?
select to_char(add_months(trunc(sysdate,'mm'),1)-1,'dd') "이번달 마지막 날짜" from dual;




--[문제] 개강일로부터 오늘날짜까지 일수 ? 
select trunc(sysdate)- trunc( to_date('2023/12/29', 'YYYY/MM/DD'))+1  from dual;
--[문제] 오늘날짜로부터 수료일까지 일수 ? 
select abs(trunc(sysdate)- trunc( to_date('2024/06/14', 'YYYY/MM/DD')))  from dual;

select last_day(sysdate) from dual;

-- next_day() 함수 가장 빨리 오는 요일의 날짜를 반환
select sysdate , to_char(sysdate, 'yyyy/mm/dd (dy)') a,to_char(sysdate, 'yyyy/mm/dd (day)') b, next_day(sysdate , '금') c from dual;

--[문제] 4월 첫 번째 화요일 
select to_date('2024.04.01'), next_day(last_day(add_months(to_date('2024.04.01'),-1)),'월') from dual;

--month_between() 두 날짜사이의 개월수를 반환하는 함수
 select ename,hiredate ,sysdate, ceil(abs(hiredate-sysdate) ) 근무일수, ceil(months_between(sysdate,hiredate)) 근무개월수 ,ceil(months_between(sysdate,hiredate)/12) 근속년수 from emp;


select sysdate , current_date , current_timestamp from dual;

 -- 2) to_char ( 날짜,숫자) 
  -- [문제] insa 테이블에서  basicpay를 세자리 마다 콤마를 출력하고 앞에 통화기호를 붙임.
  select insa.* , to_char( basicpay + sudang , 'L9,999,999')  from insa; --자리수가 부족하면 #### 이 찍힘.
  
  select to_char(12345 , '999,999.99') from dual;
  select to_char(-12345 , '99999pr') from dual;
  
  select substr('아아',1,1) from dual;
  select coalesce() from dual;
  
  select * from emp;
  select ename , (select sal+nvl(comm,0)  from emp s where e.empno=s.empno) pay , to_char((select avg(sal+nvl(comm,0)) from emp s ),'9999.99') avg_pay , ceil(((select sal+nvl(comm,0)  from emp s where e.empno=s.empno) - (select avg(sal+nvl(comm,0)) from emp ))*100)/100 "차 올림",round(((select sal+nvl(comm,0)  from emp s where e.empno=s.empno) - (select avg(sal+nvl(comm,0)) from emp ))*100)/100 "차 반올림",trunc(((select sal+nvl(comm,0)  from emp s where e.empno=s.empno) - (select avg(sal+nvl(comm,0)) from emp ))*100)/100 "차 내림" from emp e;
  
  
  select ename , (select sal+nvl(comm,0)  from emp s where e.empno=s.empno) pay , to_char((select avg(sal+nvl(comm,0)) from emp s ),'9999.99') avg_pay , replace(replace(sign((select sal+nvl(comm,0)  from emp s where e.empno=s.empno) - (select avg(sal+nvl(comm,0)) from emp )),'-1','적다'),'1','많다') "평균비교" from emp e;
  
  
  select * from emp;
  
  select (select count(*) from insa where substr(ssn,8,1)='1') 남자사원수 ,(select count(*) from insa where substr(ssn,8,1)='2') 여자사원수 from dual;
  
  select ceil(count(*)/14) "총 팀수" from insa;
  
   select empno,ename,job,mgr,hiredate,(sal+nvl(comm,0))pay,deptno , '최저급여자' from emp s where (sal+nvl(comm,0))= ( select min(sal+nvl(comm,0)) from emp)union
select empno,ename,job,mgr,hiredate,(sal+nvl(comm,0))pay,deptno , '최고급여자' etc from emp s where (sal+nvl(comm,0))= ( select max(sal+nvl(comm,0)) from emp);
 
  
  select  ename  , sal   ,  comm from emp where nvl(comm,0)<=400 ;
  select * from emp s where s.sal+nvl(s.comm,0) = (select max(e.sal+nvl(e.comm,0)) from emp e where e.deptno = s.deptno)  ;
  
  
  select * from emp where deptno=10 and sal+nvl(comm,0) >= all (select sal+nvl(comm,0) from emp where deptno=10 ) union select * from emp where  deptno=20 and sal+nvl(comm,0) >= all (select sal+nvl(comm,0) from emp where deptno=20 )  union select * from emp where deptno=30 and sal+nvl(comm,0) >= all (select sal+nvl(comm,0) from emp where deptno=30 ) ;
  
  
  
  select DEPTNO ,ENAME, sal + nvl(comm,0) PAY, lpad ( ' ' , round((sal + nvl(comm,0))/100)+1 , '#') "BAR_LENGTH"  from emp where deptno =30 order by pay desc ;
  
  
  select name,ssn, rpad( substr( ssn, 1,8),14,'*') modify_ssn from insa ;
  
  
  select to_char( last_day(sysdate) , 'dd') from dual;
  
   SELECT TRUNC( SYSDATE, 'YEAR' )
      , TRUNC( SYSDATE, 'MONTH' )      
      , TRUNC( SYSDATE  )
    FROM dual;

    select ename ,sal ,  comm  , sal+nvl(comm,0)  PAY , to_char((select avg(sal+nvl(comm,0)) from emp ),'9999.99') avg_pay  from emp where sal+nvl(comm,0) >= (select avg(sal+nvl(comm,0)) from emp ) ;
    
    select * from emp;
    
    select replace (replace(mod(substr(ssn,8,1),2),0,'여자'),1,'남자') || '사원수' "성별"
        ,count(*) "사원수"
        from insa group by mod(substr(ssn,8,1),2);
      
      -- 6번 문제 최고급여자, 최저급여자 출력  
SELECT *
FROM emp
WHERE sal+NVL(comm,0) IN ( 5000, 800 );
WHERE sal+NVL(comm,0) = (SELECT MAX(sal+NVL(comm,0)) max_pay FROM emp) 
     OR sal+NVL(comm,0) = (SELECT MIN(sal+NVL(comm,0)) min_pay FROM emp);
WHERE sal+NVL(comm,0) IN (
                   (SELECT MAX(sal+NVL(comm,0)) max_pay FROM emp)
                  , (SELECT MIN(sal+NVL(comm,0)) min_pay FROM emp) 
      );     
     sal+NVL(comm,0) =  ()  ; X
WHERE sal+NVL(comm,0) = 5000 OR   sal+NVL(comm,0) =  800  ; X
-- 5000   800
SELECT MAX(sal+NVL(comm,0)) max_pay, MIN(sal+NVL(comm,0)) min_pay FROM emp;
--
SELECT *
FROM emp
-- ORA-00913: too many values
WHERE sal+NVL(comm,0) IN (  SELECT MAX(sal+NVL(comm,0)) max_pay, MIN(sal+NVL(comm,0)) min_pay FROM emp );
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    