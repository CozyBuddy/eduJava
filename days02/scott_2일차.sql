--schema?
--session?
--tablespace?

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

CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY
       ,name VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,city  VARCHAR2(10)
       ,tel   VARCHAR2(15)
       ,buseo VARCHAR2(15) NOT NULL
       ,jikwi VARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);

-- DML : INSERT, UPDATE, DELETE              TRUNCATE              + COMMIT, ROLLBACK
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, '홍길동', '771212-1022432', '1998-10-11', '서울', '011-2356-4528', '기획부', 
   '부장', 2610000, 200000);
   
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '이순신', '801007-1544236', '2000-11-29', '경기', '010-4758-6532', '총무부', 
   '사원', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '이순애', '770922-2312547', '1999-02-25', '인천', '010-4231-1236', '개발부', 
   '부장', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '김정훈', '790304-1788896', '2000-10-01', '전북', '019-5236-4221', '영업부', 
   '대리', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '한석봉', '811112-1566789', '2004-08-13', '서울', '018-5211-3542', '총무부', 
   '사원', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '이기자', '780505-2978541', '2002-02-11', '인천', '010-3214-5357', '개발부', 
   '과장', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '장인철', '780506-1625148', '1998-03-16', '제주', '011-2345-2525', '개발부', 
   '대리', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '김영년', '821011-2362514', '2002-04-30', '서울', '016-2222-4444', '홍보부',    
'사원', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '나윤균', '810810-1552147', '2003-10-10', '경기', '019-1111-2222', '인사부', 
   '사원', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '김종서', '751010-1122233', '1997-08-08', '부산', '011-3214-5555', '영업부', 
   '부장', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '유관순', '801010-2987897', '2000-07-07', '서울', '010-8888-4422', '영업부', 
   '사원', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '정한국', '760909-1333333', '1999-10-16', '강원', '018-2222-4242', '홍보부', 
   '사원', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '조미숙', '790102-2777777', '1998-06-07', '경기', '019-6666-4444', '홍보부', 
   '대리', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, '황진이', '810707-2574812', '2002-02-15', '인천', '010-3214-5467', '개발부', 
   '사원', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '이현숙', '800606-2954687', '1999-07-26', '경기', '016-2548-3365', '총무부', 
   '사원', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '이상헌', '781010-1666678', '2001-11-29', '경기', '010-4526-1234', '개발부', 
   '과장', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '엄용수', '820507-1452365', '2000-08-28', '인천', '010-3254-2542', '개발부', 
   '사원', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '이성길', '801028-1849534', '2004-08-08', '전북', '018-1333-3333', '개발부', 
   '사원', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '박문수', '780710-1985632', '1999-12-10', '서울', '017-4747-4848', '인사부', 
   '과장', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '유영희', '800304-2741258', '2003-10-10', '전남', '011-9595-8585', '자재부', 
   '사원', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, '홍길남', '801010-1111111', '2001-09-07', '경기', '011-9999-7575', '개발부', 
   '사원', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '이영숙', '800501-2312456', '2003-02-25', '전남', '017-5214-5282', '기획부', 
   '대리', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '김인수', '731211-1214576', '1995-02-23', '서울', NULL           , '영업부', 
   '부장', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '김말자', '830225-2633334', '1999-08-28', '서울', '011-5248-7789', '기획부', 
   '대리', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '우재옥', '801103-1654442', '2000-10-01', '서울', '010-4563-2587', '영업부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '김숙남', '810907-2015457', '2002-08-28', '경기', '010-2112-5225', '영업부', 
   '사원', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '김영길', '801216-1898752', '2000-10-18', '서울', '019-8523-1478', '총무부', 
   '과장', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '이남신', '810101-1010101', '2001-09-07', '제주', '016-1818-4848', '인사부', 
   '사원', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '김말숙', '800301-2020202', '2000-09-08', '서울', '016-3535-3636', '총무부', 
   '사원', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '정정해', '790210-2101010', '1999-10-17', '부산', '019-6564-6752', '총무부', 
   '과장', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '지재환', '771115-1687988', '2001-01-21', '서울', '019-5552-7511', '기획부', 
   '부장', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '심심해', '810206-2222222', '2000-05-05', '전북', '016-8888-7474', '자재부', 
   '사원', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '김미나', '780505-2999999', '1998-06-07', '서울', '011-2444-4444', '영업부', 
   '사원', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '이정석', '820505-1325468', '2005-09-26', '경기', '011-3697-7412', '기획부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '정영희', '831010-2153252', '2002-05-16', '인천', NULL           , '개발부', 
   '사원', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '이재영', '701126-2852147', '2003-08-10', '서울', '011-9999-9999', '자재부', 
   '사원', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '최석규', '770129-1456987', '1998-10-15', '인천', '011-7777-7777', '홍보부', 
   '과장', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '손인수', '791009-2321456', '1999-11-15', '부산', '010-6542-7412', '영업부', 
   '대리', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '고순정', '800504-2000032', '2003-12-28', '경기', '010-2587-7895', '영업부', 
   '대리', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '박세열', '790509-1635214', '2000-09-10', '경북', '016-4444-7777', '인사부', 
   '대리', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '문길수', '721217-1951357', '2001-12-10', '충남', '016-4444-5555', '자재부', 
   '과장', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, '채정희', '810709-2000054', '2003-10-17', '경기', '011-5125-5511', '개발부', 
   '사원', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '양미옥', '830504-2471523', '2003-09-24', '서울', '016-8548-6547', '영업부', 
   '사원', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '지수환', '820305-1475286', '2004-01-21', '서울', '011-5555-7548', '영업부', 
   '사원', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, '홍원신', '690906-1985214', '2003-03-16', '전북', '011-7777-7777', '영업부', 
   '사원', 960000 , 152000);         
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '허경운', '760105-1458752', '1999-05-04', '경남', '017-3333-3333', '총무부', 
   '부장', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '산마루', '780505-1234567', '2001-07-15', '서울', '018-0505-0505', '영업부', 
   '대리', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '이기상', '790604-1415141', '2001-06-07', '전남', NULL           , '개발부', 
   '대리', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '이미성', '830908-2456548', '2000-04-07', '인천', '010-6654-8854', '개발부', 
   '사원', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '이미인', '810403-2828287', '2003-06-07', '경기', '011-8585-5252', '홍보부', 
   '대리', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '권영미', '790303-2155554', '2000-06-04', '서울', '011-5555-7548', '영업부', 
   '과장', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '권옥경', '820406-2000456', '2000-10-10', '경기', '010-3644-5577', '기획부', 
   '사원', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '김싱식', '800715-1313131', '1999-12-12', '전북', '011-7585-7474', '자재부', 
   '사원', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '정상호', '810705-1212141', '1999-10-16', '강원', '016-1919-4242', '홍보부', 
   '사원', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '정한나', '820506-2425153', '2004-06-07', '서울', '016-2424-4242', '영업부', 
   '사원', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '전용재', '800605-1456987', '2004-08-13', '인천', '010-7549-8654', '영업부', 
   '대리', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '이미경', '780406-2003214', '1998-02-11', '경기', '016-6542-7546', '자재부', 
   '부장', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '김신제', '800709-1321456', '2003-08-08', '인천', '010-2415-5444', '기획부', 
   '대리', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '임수봉', '810809-2121244', '2001-10-10', '서울', '011-4151-4154', '개발부', 
   '사원', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '김신애', '810809-2111111', '2001-10-10', '서울', '011-4151-4444', '개발부', 
   '사원', 900000 , 102000);

COMMIT;
select * 
from insa;


select empno,ename,hiredate
from emp;

-- 환경설정에 NLS : 날짜 형식 RR/MM/DD
--1)National Language Support (국가 지원 언어)
--2) NLS parameter 는 session,client,server의 세가ㅣㅈ로 분류된다.
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

select * from emp;
select job,empno,ename,hiredate
from emp;

select * from insa;
select distinct buseo from insa order by buseo;

select ename,nvl(comm,0)+sal 월급 from emp where (nvl(comm,0)+sal)>=1000 and (nvl(comm,0)+sal)<=3000 and (deptno=20 or deptno=10 )order by ename;

select emp.*,nvl(''||mgr,'CEO') mgr from emp;
select nvl(tel,'연락처 등록 안됨') tel from insa ;

select num,name,nvl2(tel,'o','x') tel from insa where buseo = '개발부';
select empno,ename,sal,nvl(comm,0) comm, nvl(comm,0)+sal pay  from  emp ;

select * from emp where deptno !=10 and job='CLERK';
select * from emp where ename='KING';

select * from insa where city = '서울' or city='인천' or city='경기';

select deptno , ename,sal,comm, nvl(comm,0)+sal pay from emp where deptno=30 and comm is null order by pay desc;


desc all_users;
select * from user_tab_privs;

---------------------------------------------scott 3일차 -------------------------------
select * 
from user_sys_privs; -- 시스템 권한  UNLIMITED TABLESPACE 제한 없이 무한정 테이블스페이스 사용

select * 
from user_role_privs; --롤 권한 조회 

형변환 함수 : to_char(날짜 or 숫자 or문자열) , to_number () , upper() 

오라클 연산자 : ^= , <=,>=  ,  SQL 연산자  is [not] null ,between and
논리 연산자 not and or

select ename,nvl(comm,0)+sal 월급 from emp where (nvl(comm,0)+sal)>=1000 and (nvl(comm,0)+sal)<=3000 and (deptno=20 or deptno=10 )order by ename;








