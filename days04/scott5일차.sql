select emp.* from emp where sal+nvl(comm,0) >= all (select sal+nvl(comm,0) from emp ) union
select emp.* from emp where sal+nvl(comm,0) <= all (select sal+nvl(comm,0) from emp );

-- lnnvl(null) => false랑 null을 true 로 반환
select ename,sal,comm from emp where lnnvl(comm>400) ;
select * from emp where comm<400;

-- [문제] 사원 종보를 출ㄺ ( 부서번호,부서명,사원명,입사일자) --조인 방법
select s.deptno,ename,hiredate,dname
from emp s, dept 
where s.deptno=dept.deptno
order by deptno;

select * from dept;

--select emp.deptno,ename,hiredate,dname
--from emp join dept on emp.deptno=dept.deptno;
--select DEPTNO ,ENAME, sal + nvl(comm,0) PAY, lpad ( ' ' , round((sal + nvl(comm,0))/100)+1 , '#') "BAR_LENGTH"  from emp where deptno =30 order by pay desc ;
--
--select name,sal,comm,sal+nvl(comm,0) pay , (select 
--
--rownum 의 조건은 무조건 첫번째부터 나타낼 수 있는 조건만 먹힘. 다른 일부만 가져오는 조건이나 그런건 안됨.


select rank() over(order by sal+nvl(comm,0) desc) 급여순위, empno,ename,hiredate,sal+ nvl(comm,0)  pay from emp;

-- ㄱ) 
select e.* from (select rank() over(order by sal+nvl(comm,0) desc) 급여순위, empno,ename,hiredate,sal+ nvl(comm,0)  pay from emp) e where e.급여순위 between 3 and 5;


--ㄴ ) (시험) 각 부서별 pay  2등까지 출력 
-- rank() over (partition by deptno order by sal+nvl(comm,0) desc)
select deptno ,rank() over (partition by deptno order by sal+nvl(comm,0) desc ),e.* from emp e;
--select e.* from (select rank() over(order by sal+nvl(comm,0) desc) 급여순위, empno,ename,hiredate,sal+ nvl(comm,0)  pay from emp s) e where e.급여순위 between 1 and 2 and deptno=e.deptno;

select e.* from (select emp.* ,rank() over (partition by deptno order by sal+nvl(comm,0) desc ) payrank from emp) e where payrank<=2;

select hiredate ,add_months(add_months(hiredate,5) +20,12*10) from emp ;

select * from insa where num = 1002;

select to_char(sysdate, 'mmdd') from dual;

--801007-1544236
update (select * from insa where num = 1002) set ssn = substr(ssn,1,2)||to_char(sysdate, 'mmdd')||substr(ssn,7) ;
rollback;
commit;


select name ,ssn,sysdate ,replace( replace(replace(sign(trunc(to_date(substr(ssn,3,4) ,'mmdd')) - trunc(sysdate)),0,'오늘 생일'),-1,'생일이 지났습니다.'),1,'생일이 아직 아닙니다.') from insa;
with temp as (
select ename,sal+nvl(comm,0) pay, (select sum(sal+nvl(comm,0)) from emp) allsum
from emp)
select temp.* , round( temp.pay/temp.allsum *100,3)||'%' 급여백분위 ,lpad(' ' , round( temp.pay/temp.allsum *100)+1  , '*') from temp order by pay desc;

select sysdate , to_char (sysdate, 'cc') from dual;
-- ddd는 1월1일부터 며칠째인지를 카운트
-- iw 1년중 몇째주
-- ww 년중 몇번째 주 2024년을 일수를 기준으로 7일마다 1주로 카운트함.
-- w 월중 몇번째 주
select to_char(sysdate, 'ddd') from dual;
select to_char(sysdate, 'ww') from dual;
select to_char(to_date('2024.2.22'), 'w') from dual; -- 7일 기준 1주 구분
select to_char(sysdate, 'w') from dual;

select to_char(to_date('2022.01.01'), 'ww') , to_char(to_date('2022.01.02'), 'ww'),
 to_char(to_date('2022.01.03'), 'ww') ,to_char(to_date('2022.01.04'), 'ww') ,
to_char(to_date('2022.01.05'), 'ww') from dual;

--월요일부터 일요일을 1주
select to_char(to_date('2022.01.01'), 'iw') , to_char(to_date('2022.01.02'), 'iw'),
 to_char(to_date('2022.01.03'), 'iw') ,to_char(to_date('2022.01.04'), 'iw') ,
to_char(to_date('2022.01.05'), 'iw') from dual;

select to_char(sysdate, 'iw') from dual;
select to_char(sysdate, 'ddd') from dual;

select to_char(sysdate , 'q') from dual; -- 분기 
select to_char(sysdate , 'hh'),to_char(sysdate , 'hh24') ,to_char(sysdate , 'mi'),to_char(sysdate , 'ss'),to_char(sysdate , 'dy'),to_char(sysdate , 'day') ,to_char(sysdate , 'dl'), to_char(sysdate , 'ds')from dual; -- 분기 

select ename, hiredate , to_char(hiredate, 'dl') , to_char(sysdate,'ts') ,to_char(current_timestamp,'hh:mm:ss.ff3')from emp;

to_char() 날짜,숫자 -> 문자 형식 변환
--[문제] 오늘 날짜를 to_char ()  함수를 사용해서
-- 2024년 02월 20일 오후 16:05:29 (화) 
select to_char(sysdate , 'yyyy"년"  mm"월"  dd"일" pm hh24:mi:ss (dy)') from dual;
 select substr(to_char(sysdate,'DL'),1,13) || to_char(sysdate,'ts (dy)')   from dual;
 
 select name, ssn , substr(ssn,1,6),to_date(substr(ssn,1,6)) , to_char(to_date(substr(ssn,1,6)),'dl') from insa;
 
 select to_date('0821','mmdd') ,to_date('2023','yyyy')  from dual;
 
 --[문제] 수료일 6/14 오늘부터 남은 일수 ?
  select sysdate, trunc(to_date('6/14' , 'mm/dd'))-trunc(sysdate) 남은일수 from dual;
  
  --[문제] 4자리 부서 번호로 출력
    select to_char(deptno , '0999') "4자리부서번호" from emp;
    
--[문제] insa테이블에서 남자/여자 
select name ,decode(substr(ssn,8,1),1,'남자',2,'여자') 성별 from insa;

--[문제] insa 테이블에서 오늘을 기준으로 생일이 지남 여부를 출력하는 쿼리를 작성하세요 . 
--   ( '지났다', '안지났다', '오늘 ' 처리 )    

select name ,decode(sign(trunc(to_date(substr(ssn,3,4),'mmdd'))-trunc(sysdate)),-1,'지났다',1,'안지났다.' ,0,'오늘') "생일여부", substr(ssn,3,4) "실제생일" from insa;


--[문제] emp 테이블에서 각 사원의 번호,이름,급여 출력 
-- 조건) 10번 부서원들은 급여의 15% 인상 ,  20번 부서원들은 급여의 10% 인상, 30번 부서원들은 급여의 5% 인상

 select ename , sal+nvl(comm,0) "인상전 금액",deptno ,decode(deptno,10, (sal+nvl(comm,0))*1.15 ,20,(sal+nvl(comm,0))*1.1,30,(sal+nvl(comm,0))*1.05) "인상후금액" from emp;

 [1] insa 테이블에서 각 부서별 사원수 조회
 select * from insa;
 
 --with t as ( select count(*) from insa s where buseo=s.buseo)
 select count(*) from insa s where s.buseo = some (select buseo from insa where s.buseo=buseo )  ;
 
 with t as ( select buseo from insa)
 select count(*),buseo from t where t.buseo= buseo group by buseo;
 select count(*),buseo from insa group by buseo;
 
 [2] emp 테이블에서 급여의 등수(rank)
 with t as ( select rank() over (order by sal+nvl(comm,0) desc) payrank , e.* from emp  e)
 select ename, sal+nvl(comm,0) 급여, payrank from t  where t.payrank <=3 ;
 
 with t as ( select e.*,count(*) from emp e where sal+nvl(comm,0) >=(select e.sal+nvl(e.comm,0) from emp) )
 select t.* from t ;
 
 
 
 select ( select count(*) +1 from emp c where sal +nvl(comm,0) > (p.sal +nvl(p.comm,0))) payrank , p.* from emp p order by sal +nvl(comm,0) desc;
 
 
 [3] insa 테이블에서 남자사원수 ,여자사원수 조회
 -- ㄱ. 
 with t as ( select name,ssn,substr(ssn,8,1) 성별 from insa )
 select decode(substr(ssn,8,1) ,'1','남자사원수','2','여자사원수'),count(*) 성별 from t group by substr(ssn,8,1) ; 
 
 --groupby 절에는 집계함수가 아닌 select 안에 함께 있는 단일함수가 와야함
 select  dname,count(ename) from emp e right outer join dept d on e.deptno=d.deptno group by dname union
 select '총인원수',count(*) from emp order by dname asc;
 
 select * from dept;
 
 select count(*) from insa;
 
 select count(*) 전체사원수 , count(decode(mod(substr(ssn,8,1),2),1,'남자')) 남자사원수 ,count(decode(mod(substr(ssn,8,1),2),0,'여자')) 여자사원수
 from insa;
 
 select count(decode(mod(substr(ssn,8,1),2),1,'0')) 남자,count(decode(mod(substr(ssn,8,1),2),0,'0')) 여자
 from insa;
 
  select count(*),count(decode(deptno,10,'o')) "10",count(decode(deptno,20,'o')) "20",count(decode(deptno,30,'o')) "30",count(decode(deptno,40,'o')) "40"
  from emp;
 
 [5] insa 테이블에서 "생일 후","생일 전" , "오늘 생일"
 --(decode() 사용)
 select num, name, ssn  ,decode(sign(trunc(sysdate) - trunc(to_date(substr(ssn,3,4),'mmdd'))),1,'생일 후',-1,'생일 전','오늘 생일'),
 case  when substr(ssn,3,4)=to_char(sysdate , 'mmdd') then '오늘생일' when substr(ssn,3,4)<to_char(sysdate , 'mmdd')  then '생일지남' when substr(ssn,3,4)>to_char(sysdate , 'mmdd')  then '생일 안지남' 
 end 생일유무
 from insa ; 
 [5-2] emp 테이블에서 10번 부서원의  sal 10%인상, 20번 부서원은 sal 15% 인상 , 그외 부서는 5% 인상.
 with t as (select ename ,sal*decode(deptno,'10',1.1,'20',1.15,1.05) 인상액 from emp) , e as (select ename,sal*(case deptno when 10 then 1.1 when 20 then 1.15 else 1.05 end) 인상액 from emp)
 select * from t left outer join e on t.ename=e.ename ;
 select * from emp;
 
 select * from insa where num=1002;
 select * from insa;
 --  ㄱ. 1002번 사원으 ㅣ주민번호 800221-1544236 update 
 update insa 
 set ssn = substr(ssn,1,2)||to_char(sysdate,'mmdd') || substr(ssn,7)
 where num=1002;
 commit;
 rollback;

[6] insa 테이블에서 총사원수,생일전사원수,오늘생일사원수, 생일후 사원수 출력
with t as (select  name,
case when substr(ssn,3,4)>to_char(sysdate, 'mmdd') then '생일 전' when substr(ssn,3,4)<to_char(sysdate, 'mmdd') then '생일후' when substr(ssn,3,4)=to_char(sysdate, 'mmdd') then '당일생일' end "생일유무" from insa
)
select count(decode(생일유무,'생일 전','ㅐ')),count(decode(생일유무,'생일후','ㅐ')),count(decode(생일유무,'당일생일','ㅐ')),count(*) 전체사원수 from t;


--[문제] emp 테이블에서 평균 pay보다 같거나 많은 사원들의 급여합을 출력

with t as (select to_char(avg(sal+nvl(comm,0)), '9999.00') avgpay , sal+nvl(comm,0) pay from emp ), e as ( select ename, sum(sal+nvl(comm,0)) sumsal from emp group by ename) 
select t.avgpay ,e.ename , e.sumsal, sum(e.sumsal) over() from emp m,t,e where sal+nvl(comm,0) >= t.avgpay and e.ename=m.ename  ;

-- sum over() group by 절을 안써도 집계함수를 사용가능

--[문제] emp,dept 테이블을 사용해서 부서원이 존재하지 안흔ㄴ 부서의 부서번호, 부서명을 출력
select * from emp;

select d.deptno,d.dname from dept d left outer join emp e on e.deptno =d.deptno where e.ename is null;

select * from dept d left outer join emp e on e.deptno =d.deptno ;
delete dept
where deptno=50;

select * from emp;
commit;

--select * from dept
select dname ,f.deptno
from (select deptno from dept minus select distinct deptno from emp) f ,dept d
where f.deptno = d.deptno;


[문제] emp,dept 테이블을 사용해서 사원이 존재하지 않는 부서의 부서번호, 부서명을 출력

select d.deptno , d.dname
from dept d
where not exists(select empno from emp where deptno=d.deptno) ;

select deptno,count(*), sum(sal) from emp group by deptno having sum(sal)>=8000;

select * from emp ; 
--[문제] insa 테이블에서 각 부서별 여자사원수를 파악해서 5명 이상인 부서 정보 출력

 select count(*), decode(substr(ssn,8,1),1,'남자',2,'여자') 성별,buseo from insa where substr(ssn,8,1)=2 group by buseo ,substr(ssn,8,1) having count(*)>=5;

-[문제] emp 테이블에서 부서별, job별 구별 사원의 총급여합

 select deptno,job,count(*), sum(sal+nvl(comm,0))  deptnopaysum  from emp group by deptno ,job order by deptno ;

-- oracle 10g partition outer join 구문

with t as ( select distinct job from emp)
select deptno, t.job ,nvl(sum(sal+nvl(comm,0)),0) pay from t left outer join emp e partition by (deptno) on t.job=e.job group  by deptno ,t.job order by deptno ,pay asc;

select * from dept;
-- grouping sets

select deptno, count(*) from emp group by deptno ;


select job, count(*) from emp group by job ; 

select deptno, job,count(*)
from emp group by grouping sets(deptno, job);

select deptno ,job,ename, count(*) from emp group by grouping sets(deptno, job,ename);

--[list] 목록의 집합 함수
select ename
from emp  where deptno = 30;

select d.deptno,nvl(listagg(ename,',') within group(order by ename),'사원이 존재하지 않습니다.')
from dept d left join emp e on d.deptno = e.deptno
group by d.deptno;

select d.deptno, listagg(ename,',') within group (order by ename) 
from emp e right join dept d on e.deptno =d.deptno
group by d.deptno;

from salgrade ; --급여등급을 나타내는 테이블

select  ename ,sal,
case  when sal between 700 and 1200 then 1 when sal between 1201 and 1400 then 2 when sal between 1401 and 2000 then 3 when sal between 2001 and 3000 then 4 when sal between 3001 and 5000 then 5 
end  "급여등급" from emp order by sal;

[salgrade  테이블  + emp 테이블 조인]
select ename,sal,grade
from emp ,salgrade 
where sal between losal and hisal;

--join on~
select ename,sal,grade ,losal||'~'||hisal from emp join salgrade on sal between losal and hisal;

--[정규 표현식 오라클 함수] 

select * from insa 
where regexp_like(ssn,'^7[0-9]');
where regexp_like(ssn,'^7[0-9]');
where regexp_like(ssn,'^7[0-9]');
where ssn like '7%' ;

-- 순위 함수
-- 1) rank() 
-- 2) dense_rank()
-- 3) percent_rank()
-- 4) row_number()
-- 5) first()/ last() 

-- [문제] emp 테이블에서sal 순위 
--rank() 같은 순위가 발생했을때 그 다음 등수가 같은 순위가 발생한 수 만큼 더해서 나타나짐.
select e.* , rank() over (order by sal desc) salgrade from emp e; 

--dense_rank() 같은 순위가 발생했을때 그 다음 등수가 그 영향을 받지 않음.
select e.* , dense_rank() over (order by sal desc) salgrade from emp e; 

--row_number() 같은 순위가 발생해도 고려하지 않고 자체 판단으로 단순히 등수를 매김.
select e.* , row_number() over (order by sal desc) salgrade from emp e; 

--3함수 모두 partition by 조건을 사용할 수 있다.
select e.* , rank() over (partition by deptno order by sal desc) salgrade, dense_rank() over (partition by deptno order by sal desc) salgrade, row_number() over (partition by deptno order by sal desc) salgrade from emp e; 

--[문제] emp 테이블에서 각 사원의 급여를 전체 순위와 부서 내의 순위를 출력

 select  e.ename, sal+nvl(comm,0) 급여 , rank() over (order by sal+nvl(comm,0))  "전체 순위" , rank() over (partition by deptno order by sal+nvl(comm,0))  "부서내 순위" from emp e order by deptno;

-- Rollup/cube 연산자
-- INSA 테이블
-- 남자사원수 : 31명
-- 여자사원수 : 29명
-- 전체사원수 : 60명\
select decode(substr(ssn,8,1),1,'남자',2,'여자',null,'전체사원수') 성별 ,count(*) "계" from insa i group by rollup(substr(ssn,8,1));

-- 예) 
-- cube는 null 값까지 조합하는 식으로 표현하고  rollup은 없는 null은 표시 안함.
select * from insa;
select buseo, jikwi,count(*),sum(basicpay)
from insa group by buseo,rollup(jikwi )
order by buseo;

--[문제] emp 테이블에서 가장 먼저 입사한 사원과 가장 최근에 입사한 사원의 정보
select * from emp;
select * from emp where hiredate <= all(select hiredate from emp) or hiredate >= all(select hiredate from emp);

from (select e.* from emp e where hiredate <= all(select hiredate from emp) or hiredate >= all(select hiredate from emp))
select max(hiredate)- min(hiredate) from emp;

------------------------------------------------[문제] insa 테이블에서 각 사원들의 만나이를 계산해서 출력
1) 만나이 = 올해년도 - 생일년도 (생일이 안 지났으면 -1)
select name, months_between(to_char(sysdate,'yyyy'),to_char(to_date(substr(ssn,1,6)),'19yy')) 만나이 from insa ;

select f.name , f.ssn, 올해년도 - 생일년도 + case 생일지남여부 when 1 then 1 when -1 then 0 else 0 end "실제나이"
from (select name, ssn , to_char(sysdate,'yyyy') 올해년도,case when substr(ssn,8,1) in (1,2,5,6) then 1900 when substr(ssn,8,1) in (3,4,7,8) then 2000 else 1800 end + substr(ssn,1,2) 생일년도,
sign(trunc(sysdate) - trunc(to_date(substr(ssn,3,4),'mmdd'))) 생일지남여부

from insa) f ;

--자바  임의의 난수 0.0 <= double Math.random() <1.0 , random 
-- 오라클 dbms_random 패키지  => 서로 관련된 PL/SQL 묶음
-- 자바 패키지 => 서로 관련된 클래스들의 묶음


select to_char(sysdate,'yyyy') from insa;

select 
    sys.dbms_random.value , -- 0.0 <=  <1.0
    sys.dbms_random.value(0,100), -- 0<=  <100
    sys.dbms_random.string('u',5), -- Upper(대문자)
    sys.dbms_random.string('L',5), -- Lower(소문자)
    sys.dbms_random.string('X',5), -- Upper(대문자) 또는 숫자
    sys.dbms_random.string('P',5) -- Upper(대문자) 또는 숫자 또는 특수문자
    from dual;
    
--[문제 ] 임의의 국어점수를 발생시켜서 출력
    select trunc(sys.dbms_random.value(0,101)) 국어점수,
         trunc(sys.dbms_random.value(1,46)) 로또번호
    from dual;
    
    --[피봇 (pivot)] 외워라
    --https://blog.naver.com/gurrms95/222697767118
    --pivot 사전적 의미 : 축을 중심으로 회전시키다.
        -- ㄴ 모니터 가로/세로 - 피벗 기능
        
-- SELECT *  형식
-- FROM (피벗 대상 쿼리문)
-- PIVOT (그룹함수(집계컬럼) FOR 피벗컬럼 IN(피벗컬럼 값 AS 별칭...))

--각 job별로 사원수가 몇 명인지 조회.

select job, count(*)
from emp
group by rollup(job);


select job , count(*)
from emp
group by job ;

select * 
from (select job
from emp)  
pivot( count(job) for job in( 'CLERK','ANALYST','MANAGER','PRESIDENT','SALESMAN'));

select 
count(decode(job,'clerk','o') clerk,count(decode(job,'ANALYST','o') ANALYST,count(decode(job,'MANAGER','o') MANAGER,count(decode(job,'PRESIDENT','o') PRESIDENT,count(decode(job,'SALESMAN','o') SALESMAN 
from emp;

--문제3
select * from 

--실습2) 월별 입사한 사원의 수를 파악
select hiredate , to_char(hiredate, 'MM') from emp;
1월 2월 3월 ...
2   0   4 ....

select * 
from (select to_char(hiredate, 'MM') m from emp)
pivot ( count(m) for m in ('01','02','03','04','05','06','07','08','09','10','11','12'));


--실습3 년도별 월별 입사한 사원의 수를 파악
select * 
from (select to_char(hiredate, 'yyyy') 년도 ,to_char(hiredate, 'MM') m from emp)
pivot ( count(m) for m in ('01' "1월",'02' "2월",'03' "3월",'04' "4월",'05' "5월",'06' "6월",'07' "7월",'08' "8월",'09' "9월",'10' "10월",'11' "11월",'12' "12월"));



--문제3 ) emp 테이블에서 각 부서별 , job의 사원수를 조회
sel
    select deptno, job from emp;
    select * 
    from (select deptno , job from emp)
    pivot ( count(job) for job in ( 'CLERK','ANALYST','MANAGER','PRESIDENT','SALESMAN'))
    order by deptno;
    
   
   select * 
   from (select * 
    from (select deptno , job from emp)
    pivot ( count(job) for job in ( 'CLERK','ANALYST','MANAGER','PRESIDENT','SALESMAN'))
    order by deptno) f right join dept d on d.deptno = f.deptno;

    select * from ( select d.deptno ,dname,job from emp e right join dept d on e.deptno = d.deptno)
    pivot ( count(job) for job in ( 'CLERK','ANALYST','MANAGER','PRESIDENT','SALESMAN'))
    order by deptno;
    
    --실습)
    select job, deptno, sal from emp;
    
    select * from (select job,deptno, sal from emp) pivot ( sum(sal) for deptno in ('10','20','30'));
    
    select * from (select job,deptno, sal,ename from emp) pivot ( sum(sal) 합계 , max(ename) 최고연봉 for deptno in ('10','20','30'));
    select * from (select job,deptno, sal,ename from emp) pivot ( sum(sal) 합계 , max(sal) 최고액,max(ename) 최고연봉 for deptno in ('10','20','30'));


--right outer join 
select d.deptno ,dname,job
from emp e, dept d 
where e.deptno(+) = d.deptno --오른쪽의 빈 null 값을 나오게하는 외부조인 
order by deptno;


from emp e right join dept d on e.deptno = d.deptno

-- 문제 emp 테이블에서 sal가 상위 20%에 해당되는 사원의 정보를 조회
    select *
    from (select rank() over(order by sal desc) r , e.* from emp e )
    where r<= 0.2 * ( select count(*) from emp);
    
    --[문제]
--    emp 에서 각 사원의 급여가 전체급여의 몇 %가 되는 지 조회.
--       ( %   소수점 3자리에서 반올림하세요 )
--            무조건 소수점 2자리까지는 출력.. 7.00%,  3.50%     
--
--ENAME             PAY   TOTALPAY 비율     
------------ ---------- ---------- -------
--SMITH             800      27125   2.95%
--ALLEN            1900      27125   7.00%
--WARD             1750      27125   6.45%
--JONES            2975      27125  10.97%
--MARTIN           2650      27125   9.77%
--BLAKE            2850      27125  10.51%
--CLARK            2450      27125   9.03%
--KING             5000      27125  18.43%
--TURNER           1500      27125   5.53%
--JAMES             950      27125   3.50%
--FORD             3000      27125  11.06%
--MILLER           1300      27125   4.79%
--
--12개 행이 선택되었습니다.  

select ename , sal+nvl(comm,0) pay , (select sum( sal+ nvl(comm,0)) from emp) TOTALPAY  from emp ;
    
    
    select f.* , to_char(round(pay/totalpay*100, 2),'99.00')||'%' 비율
    from (select ename , sal+nvl(comm,0) pay , (select sum( sal+ nvl(comm,0)) from emp) TOTALPAY  from emp ) f;
    

--     [총사원수]      [남자사원수]      [여자사원수] [남사원들의 총급여합]  [여사원들의 총급여합] [남자-max(급여)] [여자-max(급여)]
------------ ---------- ---------- ---------- ---------- ---------- ----------
--        60                31              29           51961200                41430400                  2650000          2550000
select ,f.*
from (select count(*) c from insa group by substr(ssn,8,1)) f
;
select count(*) from insa union (select count(*) c from insa group by substr(ssn,8,1)) union

select sum(basicpay+sudang) from insa where substr(ssn,8,1)=1 or substr(ssn,8,1)=2 group by substr(ssn,8,1);

--(ㄱ)
select decode( mod(substr(ssn,8,1),2), 1 , '남자',0,'여자', '전체') || '사원수' , count(*) 사원수 , sum(basicpay) 급여합 , max(basicpay) 최고급여 from insa group by rollup(mod(substr(ssn,8,1),2) );

--ㄴ
select count(*) 총사원수 , count(decode( mod(substr(ssn,8,1),2), 1 , '남자')) 남자사원수 , count(decode( mod(substr(ssn,8,1),2), 0 , '여자')) 여자사원수 ,sum(decode( mod(substr(ssn,8,1),2), 1 , '남자')) 남자사원총급여합 ,
sum(decode( mod(substr(ssn,8,1),2), 0 , '여자')) 여자사원총급여합 , max(decode( mod(substr(ssn,8,1),2), 1 , basicpay)) "남자 max급여", max(decode( mod(substr(ssn,8,1),2), 0 , basicpay)) "여자 max급여"
from insa;


---- [문제] 순위(RANK) 함수 사용해서 풀기 
--   emp 에서 각 부서별 최고급여를 받는 사원의 정보 출력
--   
--    DEPTNO ENAME             PAY DEPTNO_RANK
------------ ---------- ---------- -----------
--        10 KING             5000           1
--        20 FORD             3000           1
--        30 BLAKE            2850           1

select deptno, ename,(sal+nvl(comm,0)) pay, rank() over(partition by deptno order by sal) "deptno_rank" from emp ;

-- 식별자에 "" 를 붙이면 다른 곳에서도 ""를 포함해서 사용해야함. 
select b.*
from (select deptno, ename,(sal+nvl(comm,0)) pay, rank() over(partition by deptno order by sal+nvl(comm,0) desc) deptno_rank from emp) b
where b.deptno_rank = 1;

--[ 문제] emp 테이블에서 각 부서의 사원ㅅ, 부서 총급여합, 부서 평균급여
select d.deptno , nvl(count(empno),0) 부서원수, nvl(sum(e.sal+nvl(e.comm,0)),0) 합 , nvl(round(avg(e.sal+nvl(e.comm,0)),2),0) 평균 from emp e right join dept d on e.deptno=d.deptno group by d.deptno  
order by d.deptno;

select * from dept;

--[문제] insa 테이블에서 각 부서별 /출신지역별 /사원수 몇 명인지 출력(조회)
 select buseo ,city, count(*)
 from insa 
 group by buseo, city
 order by buseo, city;

select i.buseo ,i.city ,count(*)
from insa i right outer join insa n partition by (i.buseo) on i.city=n.city 
group by i.buseo, i.city
order by i.buseo , i.city;

with t as (select distinct city from insa)
select buseo ,t.city, count(num)
from insa i partition by (buseo) right join t on i.city=t.city 
group by buseo ,t.city
order by buseo, t.city;

select * from insa;

select s.* , round( 부서사원수/총사원수 * 100,2) || '%' as "부/전%",round( 성별사원수/총사원수 * 100,2) || '%' as "성/전%",round( 성별사원수/부서사원수 * 100,2) || '%' as "성/부%"
from (select buseo ,(select count(*) from insa)  총사원수, (select count(*) from insa where buseo = t.buseo)  부서사원수, gender 성별, count(*) 성별사원수
from ( select buseo, name, ssn ,decode(mod(substr(ssn,8,1),2),1,'M','F') gender
from insa ) t
group by buseo, gender
order by buseo ,gender ) s;

--[문제] SMS 인증번호 임의의 6자리 숫자 발생 
select trunc(sys.dbms_random.value(100000,1000000)) 
from dual;

select to_char( trunc(sys.dbms_random.value(0,1000000)), '000000') from dept;


--[문제]  LIStAgg 함수

select d.deptno, nvl(listagg(ename , '/') within group( order by ename),' 사원없음')  from emp e right join dept d on e.deptno = d.deptno group by d.deptno ;

-- [문제]  emp 테이블에서 30번 부서의 최고,최저 sal를 받는 사원의 정보 조회
    select max(sal),min(sal)
    from emp 
    where deptno = 30;
    
    select deptno, ename, hiredate , sal
    from  emp s 
    where s.sal = ( select max(sal)
    from emp 
    where deptno = 30) or s.sal = ( select min(sal)
    from emp 
    where deptno = 30) and 
    s.deptno = 30 ;
    
    select b.*
    from (select max(sal) d ,min (sal) c from emp where deptno = 30 ) a join emp b on a.c=b.sal  or a.d=b.sal
    ;
    
select * from emp;

--[ 마지막문제] 

-- emp 테이블에서 사원수가 가장 작은 부서명과 사원수 , 사원수가 가장 많은 부서명과 사원수 출력

select (select max(count(*)) from emp group by deptno)  ,(select min( count(*) )from emp group by deptno)  from emp group by deptno ;

--select t.deptno, cnt
--from (select d.deptno , count(empno) cnt , rank() over (order by count(empno) ) rank from dept d left join emp e on d.deptno=e.deptno group by d.deptno) t
--where t.rank in (1,(select count(*) from dept));

--ㄱ
with t as (select d.deptno, dname, count(empno) cnt from emp e right join dept d on d.deptno = e.deptno group by d.deptno ,dname )
select dname,cnt
from t 
where cnt in ((select min(cnt) from t),(select max(cnt) from t));

--ㄴ
with t as (select d.deptno, dname, count(empno) cnt from emp e right join dept d on d.deptno = e.deptno group by d.deptno ,dname )
, b as ( select min(cnt) mincnt , max(cnt) maxcnt from t)
select t.dname , t.cnt  from t ,b 
where t.cnt in (b.mincnt,b.maxcnt);

-- ㄷ . 분석함수 : first , last 
--              ? 집계함수 와 같이 사용하여 주어진 그룹에 대해 내부적으로 순위를 매겨 결과를 산출하는 함수.

with t as (select d.deptno, dname, count(empno) cnt from emp e right join dept d on d.deptno = e.deptno group by d.deptno ,dname )
select max(cnt),max(dname) keep(dense_rank last order by cnt) max_dname ,min(cnt),min(dname) keep(dense_rank first order by cnt) min_dname
from t; 

-- 분석함수 cume_dist() : 주어진 그룹에 대한 상대적인 누적 분포도 값을 반환
                    -- 분포비율은 0< <=1
                    
select deptno, ename, sal , cume_dist() over (partition by deptno order by sal) from emp;

--분석함수 percent_Rank() : 해당 그룹 내의 백분위 순위  0<=  <=1
--백분위 순위  그룹 안에서 해당 행의 값보다 작은 값의 비율
select deptno, ename, sal--,percent_rank() over(order by sal) percent 
 ,percent_rank() over( order by sal) percent2 
from emp;

--ntile(expr) : 파티션 별로 expr 에 명시된 만큼 분할한 결과를 반환하는 함수
-- 분할하는 수를 버킷(bucket) 이라고 함.
select deptno, ename , sal, ntile(7) over (order by sal) ntiles
from emp;

select buseo , name , basicpay, ntile(2) over(partition by buseo order by basicpay) from insa;

-- width_bucket(expr, minvalue,maxvalue,numbuckets) == ntile() 함수와 유사한 분석함수 
-- 차이점 => 최소값과 최대값을 설정 가능

select deptno , ename ,sal , ntile(4) over (order by sal) ntiles, width_bucket(sal,0,3000,4) from emp;

--LAG(expr,offset,default_value)
-- lag(컬럼명, 가져올 행의 위치 ,값이 없을 때 기본값)
-- 주어진 그룹과 순서에 따라 다른 행에 있는 값을 참조할 때 사용하는 함수, 선행되는 행을 참조
--LEAD(expr,offset,default_value)
-- 주어진 그룹과 순서에 따라 다른 행에 있는 값을 참조할 때 사용하는 함수, 후행하는 행을 참조

select deptno, ename ,hiredate ,sal, lag(sal,1,0) over(order by hiredate) pre_sal ,lag(sal,2,-1) over(order by hiredate) pre_sal,lead(sal,1,-1) over(order by hiredate) pre_sal from emp where deptno = 30;
-- 첫번째는 1번째 행에서 그 앞에 행이 없어서 default value로 대신함.


--[오라클 자료형(Data Type)] --
--1)문자,문자열 저장하는 자료형
    형식 ) 
    char[(size byte|char)]
    예)
    char(3 char) ?10문자를 저장하는 자료형 -- 'abc' , '세글자' 바이트수 상관없이 
    char(3 byte) 3바이트를 젖장하는 자료형 -- 'abc', '한' 
    char(3) -- 생략되면 바이트로 생략함. 따라서 3바이트의 문자
    char==char(1) == char(1 byte) -- 고정 길이의 문자 자료형 

    
    char(14) == char(14 byte) ['A'],['B'] ....
    
    create table tbs_char
    (
     aa char ,bb char(3),cc char(3 char));
     
     select * from tabs where table_name like '%CHAR%';
     
     desc tbs_char ;
     -- 한글자마다 자음 모음 상관없이 3바이트를 소모함.
     INSERT into tbs_char (aa,bb,cc) values ('a','aa','aaa');
     INSERT into tbs_char (aa,bb,cc) values ('a','한','우리');
     INSERT into tbs_char (aa,bb,cc) values ('a','우리','우리');
     commit;
     
     update tbs_char
     set bb='aaa'
     where bb='aa';
     
     select vsize('ㅇ') from dual;
     
     --N == 유니코드(unicode) 한 칸마다 모든문자를 2바이트로 소모하는 것. 
    -- nchar[(size)] == n + char[(size)]
     select * from tbs_char;
     
      drop table tbs_char ;
    
    예) 주민등록번호ㅗ(14자리), 우편번호 (7자리) - 문자열의 길이가 정해져 있는 값ㅇ르 저장할 때 

create table tbl_nchar (
    aa char(3) , bb char(3 char) , cc nchar(3) );
    
     INSERT into tbl_nchar (aa,bb,cc) values ('홍','길동','홍길동');
     INSERT into tbl_nchar (aa,bb,cc) values ('홍길동','홍길동','홍길동');
     
     commit;
     
     select * from tbl_nchar;
     
     -- char / nchar - 고정길이 2000byte
     
     --
     VARCHAR2(size[BYTE ¦ CHAR])
     varchar2(5) --5바이트 할당
     varchar2 == varchar2(1) == varchar2(1 byte) 4000byte
    
    ------------9일차
    
    Insert into dept (deptno,dname,loc) values (100,'QC','SEOUL');
    Insert into dept (deptno,dname,loc) values (100,'QC','SEOUL');
    
    desc dept;
    
    --데이터 타입 number ((precisioin [, scale]);
    p(정밀도) : 1~38 , 실제숫자가 표현되는 유효숫자의 자리수
    s(규모) : -84~ 127, 소수점 이하 자리수
    
    number
    deptno number(2) == number(2,0) == 2자리 정수 -99~99
    kor number(3) == number (3,0) == 3자리 정수 -999~999 정수
    
    number(5,2)
    
    --국어 점수를 랜덤하게 발생해서 저장
    insert into 성적테이블(kor,math,eng) values ( sys.dbms_random(0,100), sys.dbms_random(0,100), sys.dbms_random(0,100)); -- 자료형이 number(3) 인경우 101까지 안해도 99.9 에서 자동 반올림이 됨.
    
    --학번,학생명,국어,수학,영어,총점,평균,등수
    create table tbl_score( no  number(2) not null primary key , name varchar2(10 char) not null, kor  number(3),math number(3), eng  number(3) ,tot number(3), avg number(5,2), rank number(2) );
    
    Insert into tbl_score ( no ,name ,kor ,math,eng ) values (1,'김진영',90,87,88.89);
    Insert into tbl_score ( no ,name ,kor ,math,eng ) values (2,'홍길동',99,88,65);
    Insert into tbl_score ( no ,name ,kor ,math,eng ) values (3,'신슬기',19,68,82);
    
    rollback;
    select * from tbl_score;
    
    //3명 학생의 정보 추가 입력 (총점,평균,등수) 
    update tbl_score
    set tot = kor+math+eng , avg= (kor+eng+math)/3 ,rank= 1;
    commit;
    
    --문제
    
    update tbl_score t
    set rank = (select count(*)+1 from tbl_score b where b.tot>t.tot); 
    
    
    update tbl_score
    set eng=0
    where no =2;
    
    drop table tbl_tel ;
    
    --float() 정밀도 p는 1∼126 binary digits로, 1∼22bytes가 필요함
    
    
    --date 자료형은 시간 초까지 저장 = 날짜 + 시간
    
    --timestamp(n) 자료형은 기본 n=6 시간 분 초 , n=9 면 95/08/08 00:00:00.000000000 이런식으로 저장가능.
    
    --이진데이터 저장
--    RAW(size) 2000byte
--    LONG RAW 2GB

--  BFILE    Binary 데이터를 외부에 file형태로 (2^64 -1바이트)까지 저장 
--  BLOB    Binary 데이터를 4GB까지 저장 (4GB= (2^32 -1바이트)) 
--  CLOB    Character 데이터를 4GB까지 저장 
--  NCLOB    Unicode 데이터를 4GB까지 저장 

--count() over() 질의한 행의 누적된결과값을 반환
select buseo, name, basicpay , count(*) over(partition by buseo order by basicpay) from insa;


select buseo, name, basicpay , sum(basicpay) over(partition by buseo order by basicpay) from insa;



select buseo, name, basicpay , avg(basicpay) over(partition by buseo order by basicpay) from insa;

--[문제] 각 지역별 (city) 급여 평균
select city,name,basicpay, basicpay - trunc(avg(basicpay) over(partition by city order by city)) "지역평균 차이"
from insa;

--[테이블 생성, 테이블 수정, 테이블 삭제 ] + 튜플 추가,수정,삭제 

--1) 테이블(table) ? 데이터 저장소
--2) DB 모델링 -> 테이블 생성
-- 예) 게시판의 게시글을 저장하기 위한 테이블 생성
    --ㄱ. 테이블명 : tbl_board
    --ㄴ. 논리적 컬럼명 
        --글번호,작성자, 비밀번호 ,제목,내용,작성일 , 조회수 등등
          --물리적 컬럼명
                --seq,writer,password,title,content,regdate,readno
                --자료형 (크기) number,varchar2(20),varchar2(15),varchar2(100),clob , date,number
                --널허용(필수입력허용) not null,not null, not null, not null  ,default sysdate, default 0 
                
--【간단한형식】
--    CREATE [GLOBAL TEMPORARY] TABLE [schema.] table
--      ( 
--        열이름  데이터타입 [DEFAULT 표현식] [제약조건] 
--       [,열이름  데이터타입 [DEFAULT 표현식] [제약조건] ] 
--       [,...]  
--      ); 
--global temporary -임시테이블로 만든 세션이 종료되면 자동으로 삭제됨.
create table tbl_board (seq number not null primary key ,
writer varchar2(20) not null ,
password varchar2(15) not null ,
title varchar2(100) not null,content clob,
regdate date default sysdate);

create global temporary table tbl_board2 (seq number not null primary key,
writer varchar2(20) not null ,
password varchar2(15) not null ,
title varchar2(100) not null,
content clob,
regdate date);

desc tbl_board;
commit;
drop table tbl_board;

-- 테이블 생성 : create table (ddl)
-- 테이블 수정 : alter table (ddl)
--• alter table 테이블명 ... add 컬럼 ,제약조건
--• alter table ... modify 컬럼 
--• alter table ... drop[constraint] 제약조건 
--• alter table ... drop column 컬럼 삭제
-- 테이블 삭제 : drop table (ddl)

select *
from tbl_board;

Insert into tbl_board values(1,'김진영','1234','테스트-1','내용테스트-1',sysdate);
Insert into tbl_board values(2,'권맑음','1234','테스트-2','내용테스트-2',sysdate);
Insert into tbl_board values(3,'신슬기','1234','테스트-3','내용테스트-3',sysdate);
Insert into tbl_board values(4,'신슬기','1234','테스트-3','내용테스트-3',sysdate);
Insert into tbl_board (seq,writer,password,title,content) values(5,'이나딘','1234','테스트-3','내용테스트-3');
Insert into tbl_board (seq,writer,password,title,content,regdate) values(6,'임민수','1234','테스트-3','내용테스트-3',null);
alter table tbl_board add readno number default 0 ;

delete tbl_board
where seq=6;
-- 제약조건이름을 지정해서 제약조건을 설정할 수 있고 제약조건이름을 지정하지 않으면 sys_xxx 이름을 자동 부여,  -- 유일성 위배  제약조건이름 : scott.sys_c007040

select * from user_constraints where table_name like '%BOARD%'; 
        
insert into tbl_board(writer,seq,password,title)
values ('이동우',(select nvl(max(seq),0)+1 from tbl_board),'1234','test-6') ;
commit;

--content null ㅣㄴ 경우 "내용없음" 
update tbl_board
set content = '내용없음'
where content is null ;

select * from tbl_board;

alter table tbl_board modify (writer varchar2(40));
--제약조건은 수정할 수가 없다. ( 삭제 -> 새로 추가해야함)
-- not null 제약조건의 한 일종

--컬럼명 수정 ( title => subject ) 수정
--      ㄴ컬럼이름의 직접적인 변경은 불가느하다.
-- 간접적으로 식별자로 변경하는 것처럼 

select title as subject ,content
from tbl_board;


-- rename 함수로 컬럼명 변경 가능.
alter table tbl_board
rename column title to subject ; 

-- [기타 여러 가지 설명 bigo 컬럼 새로 추가 -> 컬럼 삭제]
alter table tbl_board add bigo varchar2(100);
desc tbl_board;

alter table tbl_board modify bigo ;

select * from tbl_board;

alter table tbl_board drop column bigo;

--[테이블 이름을 tbl_board -> tbl_test 로 변경]

rename tbl_board to tbl_Test;

select * from tbl_test;

--테이블 생성하는 방법 : 6가지
--[3.Subquery를 이용한 table 생성]
--  ㄴ 이미 존재하는 테이블 이용해서 -> 새로운 테이블 생성 + 데이터(튜플) 추가
create table tbl_test2 as (select writer from tbl_test where writer like '%슬%');
drop table tbl_test2;
select * from tbl_Test2;

--예)  emp 테이블을 이용해서 30번 부서원들의 empno, ename,hiredate,job ,pay추가해서 새로운 테이블 생성
-- pay 컬럼의 데이터타입은 시스템이 알아서 설정해서 생성.
-- 데이터 타입은 복제하지만 제약조건은 복사가 안됨.
create table tbl_emp30 as (select empno,ename,hiredate,job,sal+nvl(comm,0) pay from emp where deptno=30);
select * from tbl_emp30;
drop table tbl_emp30;
commit;
desc emp;
desc tbl_emp30;

--select * from user_constraints where table_name = 'tbl_emp30';
--select * from user_constraints where table_name = 'TBL_EMP30';
select * from user_constraints;

-- 예) 기존 테이블 -> 새로운 테이블 생성 + 레코드 x ,기존 테이블의 구조만 복사(제약조건제외)

create table tbl_emp20
as (
 select * from emp where 1=0) ;
 
 select * from tbl_emp20;
 desc tbl_emp20;
 
 drop table tbl_emp20;
 
 --[문제] emp,dept,salgrade 테이블을 이용해서 deptno,dname,empno,ename,hiredate,pay, grade 컬럼을 가진 새로운  테이블 생성. ( tbl_empgrade)
 
 create table tbl_empgrade as (

    select f.* , s.grade
   from (select d.deptno,dname,empno,ename,hiredate, sal+ nvl(comm,0) pay 
   from emp e, dept d 
   where e.deptno =d.deptno) f left join salgrade s on  f.pay<=s.hisal and f.pay>=s.losal
  );
  
  drop table tbl_emp30;
  drop table tbl_test2;
  commit;
  -- xe 말고 다른 버전에서는 drop 하고 purge 로 완전삭제 해야함.
  purge recyclebin;
  
  --테이블 삭제 + 완전 삭제 (휴지통 비우기)
  drop table tbl_empgrade purge; -- 완전 테이블 삭제
  
  select * from tbl_empgrade;
  select * from salgrade;
  
  --Insert into 테이블명[(컬럼명, 컬럼명, .... )] values (컬럼값,컬럼값 ,.... );
  -- [MultiTable INSERT문]  4가지 종류
  --unconditional insert all
  create table tbl_dept10 as (select * from dept where 1=0) ;
  create table tbl_dept20 as (select * from dept where 1=0) ;
  create table tbl_dept30 as (select * from dept where 1=0) ;
  create table tbl_dept40 as (select * from dept where 1=0) ;
--  conditional insert all 
--  conditional first 
--  insert pivoting insert 

--  insert all into 테이블명(컬럼명...) values (서브쿼리의 컬럼명, .. ...) 서브쿼리의 모든 레코들을 조건없이 모든 테이블에 값을 넣음 ; 

insert all 
    into tbl_dept10 values ( deptno , dname  , loc )
    into tbl_dept20 values ( deptno , dname  , loc )
    into tbl_dept30 values ( deptno , dname  , loc )
    into tbl_dept40 values ( deptno , dname  , loc )
select deptno ,dname,loc from dept;

drop table tbl_dept10;
drop table tbl_dept20;
drop table tbl_dept30;
drop table tbl_dept40;

commit;

select * from tbl_dept30;

---conditional insert all 

  create table tbl_emp10 as (select * from emp where 1=0) ;
  create table tbl_emp20 as (select * from emp where 1=0) ;
  create table tbl_emp30 as (select * from emp where 1=0) ;
  create table tbl_emp40 as (select * from emp where 1=0) ;
  
  drop table tbl_emp10;
drop table tbl_emp20;
drop table tbl_emp30;
drop table tbl_emp40;
  
insert all 
  when deptno = 10 then
    into tbl_emp10 values (empno,ename,job,mgr,hiredate,sal,comm,deptno)
    when deptno = 20 then
    into tbl_emp20 values (empno,ename,job,mgr,hiredate,sal,comm,deptno)
    when deptno = 30 then
    into tbl_emp30 values (empno,ename,job,mgr,hiredate,sal,comm,deptno)
    when deptno = 40 then
    into tbl_emp40 values (empno,ename,job,mgr,hiredate,sal,comm,deptno)
  select * from emp;

--  conditional (조건이 있는) first insert
Insert all first
when deptno = 10 then 
into tbl_emp10 values() 
when job = 'clerk' then
    into tbl_emp_clerk values ()

    select * from emp;
 -- first 두 조건에 동시에 만족하면 맨 처음 맞는 조건에서만 실행함
 

-- pivoting insert

create table sales(
  employee_id       number(6), --판매를 한 사원ID
  week_id            number(2), -- 판매한 주
  sales_mon          number(8,2), --요일별 판매량
  sales_tue          number(8,2),--요일별 판매량
  sales_wed          number(8,2),--요일별 판매량
  sales_thu          number(8,2),--요일별 판매량
  sales_fri          number(8,2));--요일별 판매량
  
  insert into sales values(1101,4,100,150,80,60,120);
  insert into sales values(1102,5,300,300,230,120,150);
  
   create table sales_data(
   employee_id        number(6),
    week_id            number(2),
   sales              number(8,2));
   
   select * from sales_data;
   
  select * from sales;
  desc sales;
  
  drop table salgrade;
  commit;

    Insert all 
    into sales_data values (employee_id,week_id,sales_mon)
    into sales_data values (employee_id,week_id,sales_tue)
    into sales_data values (employee_id,week_id,sales_wed)
    into sales_data values (employee_id,week_id,sales_thu)
    into sales_data values (employee_id,week_id,sales_fri)
    select employee_id,week_id,sales_mon,sales_tue,sales_wed,sales_thu,sales_fri
    from sales;
    
    select * from sales_data;
    
    --truncate 문
    
    drop table sales ; --테이블 자체가 삭제
    delete from sales_data; --모든 레코드 삭제,커밋전 롤백 가능
    
    rollback ; -- 삭제된 레코드를 되돌릴 수 있음.
    truncate table sales_data ; -- 테이블 안의 모든 레코드 삭제, 자동 커밋으로 인한 롤백 불가
    
    drop table sales_data purge; 
    
--    [문제1] insa 테이블에서 num, name 컬럼만을 복사해서 
--      새로운 tbl_score 테이블 생성
--      (  num <= 1005 )

    create table tbl_score as ( select num,name from insa where num<=1005 );
    
--
--[문제2] tbl_score 테이블에   kor,eng,mat,tot,avg,grade, rank 컬럼 추가
--( 조건   국,영,수,총점은 기본값 0 )
--(       grade 등급  char(1 char) )
-- 
alter table tbl_score add ( kor number(3) default 0,eng number(3) default 0,math number(3) default 0 , tot number(3) default 0 , avg number (5,2), grade char(1 char),rank number(2) default 1);
desc tbl_score;
--[문제3] 1001~1005 
--  5명 학생의 kor,eng,mat점수를 임의의 점수로 수정(UPDATE)하는 쿼리 작성.
    update tbl_score 
    set kor = sys.dbms_random.value(0,101) , eng= sys.dbms_random.value(0,101),math= sys.dbms_random.value(0,101);
--  
--[문제4] 1005 학생의 k,e,m  -> 1001 학생의 점수로 수정 (UPDATE) 하는 쿼리 작성.
--
    update tbl_score
    set kor = (select kor from tbl_score where num=1001),eng = (select eng from tbl_score where num=1001),math = (select math from tbl_score where num=1001)
    where num =1005;
--[문제5] 모든 학생의 총점, 평균을 수정...
--     ( 조건 : 평균은 소수점 2자리 )
--
        alter table tbl_score  modify avg number(5,2);
     update tbl_score
     set tot=kor+eng+math , avg= (kor+eng+math)/3;
--[문제6] 등급(grade) CHAR(1 char)  'A','B','c', 'D', 'F'
----  90 이상 A
----  80 이상 B
----  0~59   F  
        update tbl_score t
        set grade = (select case when avg>=90 then 'A' when avg>=80 then 'B' when avg>=70 then 'C' when avg>=60 then 'D' else 'F' end from tbl_score b where t.num=b.num);
--
--[문제7] tbl_score 테이블의 등수 처리.. ( UPDATE) 
        --alter table tbl_score  modify rank number(1) default 1 ;
        update tbl_score t --default값에 상관없이 새로 값을 줘버림.
        set rank = (select count(*)+1 from tbl_score b where t.tot>b.tot);


    drop table tbl_score;
    commit;
    select * from tbl_score;
    
    select empno,ename,sal ,row_number() over(order by sal desc) rn_rank ,
    rank() over(order by sal desc) r_rank,
    dense_rank() over (order by sal desc) r_rank2
    from emp;
    
    update tbl_score p 
    set rank = (select t.r from ( select num,tot,rank() over (order by tot desc) r from tbl_score ) t where t.num = p.num ) ;
    
    --[문제8] 모든 학생들의 영어 점수 : 10점 추가 (문제오류)
    update tbl_score
    set eng = case  when 100-eng <=10 then 100 when 100-eng>10 then eng+10 end  ;
    commit;
    rollback;
    
    --[문제] 1001~1005 학생 중에 남학생들만 5점씩 증가...
    select * from tbl_score t left join insa i on t.num=( select num from insa where substr(ssn,8,1)='1' );
    
    update tbl_score t
    set kor = kor + 5
    where t.num = (select num from insa where substr(ssn,8,1)='1' and t.num =num);
    select * from tbl_score;
    