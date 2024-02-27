--schema? 사용자가 만든 모든 객체들
--session? 사용자가 login ~  logout 까지의 구간
--tablespace? database 생성시 자동생성,  데이터 딕셔너리 정보 저장

--SQL - DQL : select 문 -- 
--하나 이상의 테이블, 뷰로 부터 데이터를 가져올 때 사용하는 문
--【형식】
--    [subquery_factoring_clause] subquery [for_update_clause];
--
--【subquery 형식】
--   {query_block ?
--    subquery {UNION [ALL] ? INTERSECT ? MINUS }... ? (subquery)} 
--   [order_by_clause] 
--
--【query_block 형식】
--   SELECT [hint] [DISTINCT ? UNIQUE ? ALL] select_list
--   FROM {table_reference ? join_clause ? (join_clause)},...
--     [where_clause] 
--     [hierarchical_query_clause] 
--     [group_by_clause]
--     [HAVING condition]
--     [model_clause]
--
--【subquery factoring_clause형식】
--   WITH {query AS (subquery),...}
-- SQL 문은 절(clause)이라 하는 몇 개의 섹션으로 나뉘어지며, SELECT 문에서 사용되는 절은 다음과 같다.  + 처리 순서(?)
--1with 2 from 3 where 4group by 5 having 6 select 7 order by
--(1) WITH 
--(6) SELECT 
--(2) FROM 
--(3) WHERE 
--(4) GROUP BY 
--(5) HAVING 
--(7)ORDER BY 

--처리 순서대로 코딩
--from 조회할 대상 == 테이블,뷰 
select *
from emp; --테이블
--from tabs; --뷰

-- emp 테이블 어떤 컬럼으로 이루어져 있는 지 확인 ? ( 테이블 구조 확인)
describe emp; --scott.emp; scott 생략하면 자신의 emp 테이블을 지칭
desc emp; 
--이름                        널?                                 유형           
----------                  --------                      ------------ 
--EMPNO 사원번호        NOT NULL == 필수입력                 NUMBER(4)  4자리정수  
--ENAME  사원명                                             VARCHAR2(10) 10바이트문자열 
--JOB   잡                                               VARCHAR2(9)  
--MGR  직속상사의 사원번호                                    NUMBER(4)    
--HIREDATE  입사일자                                            DATE         
--SAL     기본급                                           NUMBER(7,2)  소수점2자리인 7바이트 실수
--COMM   커미션                                             NUMBER(7,2)  
--DEPTNO 부서번호                                            NUMBER(2)  

--scott이 소유하는 테이블 확인
select * from tabs;
--select 문 키워드 : distinct,all ,as 사용 가능.
--select * --*는 모든 속성을 조회.
select *
from emp;
--emp 테이블의 사원번호, 사원명, 입사일자 만 조회
select empno,ename,hiredate
from emp;

-- emp 테이블의 job, 속성만 조회 
select job
from emp;
--emp 테이블의 job만 조회 distinct 출력할 컬럼이 중복이 될때 한번만 출력
select distinct job
from emp;

--select  job , count(*)
--from emp
--group by job;
select distinct empno,ename,hiredate --3개의 컬럼이 다 동일해야 중복을 제거
from emp; 
select empno,ename,hiredate
from emp;

-- 환경설정에 NLS : 날짜 형식 RR/MM/DD
--1)National Language Support (국가 지원 언어)
--2) NLS parameter 는 session,client,server의 세가ㅣㅈ로 분류된다. nls national language support
--    session > client > server 
--    예) 오라클 서버     <- 클라이언트도구 출장 
--        미국                  일본
--        달러                  엔화
--        
--                나 (원) 세션
select * from v$nls_parameters;
--insa 테이블 생성 + insert 60명 사원 정보 추가

--emp 테이블에서 사원 정보 조회 ( 사원정보,사원명,입사일자,월급(pay) = 기본급(salary) + 커미션(comm))
-- null 은 미확인된 값, 0이 아님.
-- null을 다른 값으로 처리하는 함수 : NVL(),NVL2(),NULLIF(),COALESCE() 4가지 --시험 nullif 제외
nvl(컬럼명, null일때 바꾸고 싶은 값) nvl2 ( 속성명, null이 아닐때 값, null 일때 바꾸고 싶은 값)  coalesce ( 속성명 , null일 경우의 대체값 아니면 기존의 값을 사용)
select empno,ename,hiredate,sal,nvl(comm,0) comm,nvl2(comm,comm,0) comm,coalesce (sal+comm,sal,0) coalesce,nullif(),sal+nvl(comm,0) 월급
from emp;
 select '이름은 '''||'ename' || '''이고, 직업은 ' || job || ' 이다.'
 from emp;
 
 -- [문제] emp테이블에서 직속상사가 알 수 없다. (미정,불확실) mgr 컬럼이  null인 사원
select e.* ,nvl(e.mgr,0) as mgr
from emp e;
--[문제] emp 테이블에서 직속상사가  null 인 경우 'CEO' 문자열 출력...
-- MGR     Number(4) - > 문자열 변환 'CEO'

select e.* ,nvl(''||mgr,'CEO') as 직속상사ID,nvl2(mgr,''||mgr,'CEO')
from emp e;
select  0 , '0' -- 정렬에 차이가 있음 숫자는 오른쪽부터 문자는 반대
from dual;
desc emp;
--DQL : select 문
-- All,distinct ,as 키워드
--      예) from emp e ; select e.*
-- null 의미?
-- null 처리 함수 ? NVL(),NVL2(),coalesce()
-- number -> char 변환 : to_char() 
--          to_number(),to_date()
--with
--select
--from
----where 참/거짓 조건절 설명
--groupby
--having
--order by

select *
from emp;
--[문제] 부서번호가 10번인 사원들의 정보만 출력(조회)
--오라클 비교연산자 : = != ^= <>
select * 
from emp
where deptno = 10; --참 거짓 판단해줌
--where deptno = 10;
--[문제] 부서번호가 10번이 아닌 사원들의 정보만 출력(조회)
select * 
from emp
where not(deptno= 10); -- 부정연산자 not
--where deptno=10;
--where deptno ^= 10;  오라클 전용 문법
--where deptno <> 10;  오라클 전용 문법?
--[문제] emp 테이블에서 10번 또는 20번 사원만 조회
select * 
from emp
where deptno = 20 or deptno =10;

--[문제] emp 테이블에서 comm 이 null 인 사원의 정보를 조회.
select * 
from emp
where comm is null;
--where comm is not null; -- null을 비교할때는 is null or is not null 로 비교함

--[문제] 사원명이 'king','King','KiNg' 인 사원의 정보 조회. -- 대소문자 구분 문자열은
-- count() 그룹함수 , 복수행 함수(여러개 행을 통해 하나의 결과값을 도출하는 함수) ,집계 함수 
select *
from emp;
where ename= upper('king') ;

--[문제] 월급 (pay) 이 2000이상 4000이하 로 받는 사원의 정보를 출력
 select empno,ename,job,mgr,hiredate,sal,comm,deptno, sal+nvl2(comm,comm,0) as 월급
 from emp
 where sal+nvl2(comm,comm,0) >= 2000 and sal+nvl2(comm,comm,0) <=4000;
--where sal +nvl2(comm,comm,0) between 2000 and 4000;
 --pay 기준으로 오름차순 정렬 : order by 절 기본 오름차순 정렬
 --order by 월급 asc;
--order by 월급 desc;
























