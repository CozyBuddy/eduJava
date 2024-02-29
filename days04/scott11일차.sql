--계층적 질의 (hire query)
--관계형 데이터베이스는 2차원 테이블 구조에 의해 모든 데이터를 저장한다.

select * from dept;
--하지만, 실무에서는 기업의 조직도, 집안의 족보처럼 계층적인 데이터 구조를 많이 사용하고 있다.
--따라서 평면적인 구조를 가지는 테이블에서도 계층적인 데이터를 저장하여 조회할 수 있는 방법이 필요하다.
--테이블에서 기업의 조직도와 같은 계층적인 데이터 자체를 저장하기는 어렵다. 하지만, 관계형 데이터베이스에서도 데이터간의 부모-자식 관계를 표현할 수 있는 컬럼을 지정하여 계층적인 관계를 표현할 수 있다.
--하나의 테이블에서 계층적인 구조를 표현하는 관계를 순환관계(recursive relationship)라고 한다.
    -- ex) emp 계층구조 ...
-- 부모 -자식 관계를 표현할 수 있는 [컬럼] : mgr

select * from emp;
select level from dual connect by level<= to_char(last_day(sysdate),'dd');

SELECT empno,ename,mgr,lpad(' ',(level-1)*3) || ename ,level
   FROM emp
  START WITH mgr IS  NULL
  CONNECT BY PRIOR empno=mgr;
  --CONNECT BY PRIOR mgr=empno;
  
    mgr =7698인 Blake를 매니저로 둔 직원들 조회
  SELECT mgr,empno,ename,LEVEL
   FROM emp
  WHERE mgr = 7698
  START WITH mgr IS NULL
  CONNECT BY PRIOR empno=mgr;
  
  create table tbl_test(
  deptno number(3) not null primary key,
  dname varchar2(40) not null,
   college number(3),
  loc varchar2(10));


    insert into tbl_test values (  101, '컴퓨터공학과', 100 ,'1호관');
    insert into tbl_test values (  102, '멀티미디어학과 ', 100 ,'2호관');
    insert into tbl_test values (   201 , '전자공학과', 200 ,'3호관');
    insert into tbl_test values (  202, '기계공학과  ', 200 ,'4호관');
    insert into tbl_test values (  100  , '정보미디어학부', 10 ,null);
    insert into tbl_test values (  200 , '메카트로닉스학부', 10 ,null);
    insert into tbl_test values (  10 , '공과대학', null ,null);
      
select lpad('ㄴ',(level-1)*3) || dname,level from tbl_test start with college is null connect by prior  deptno=college and deptno!=100;

-- 1.start with 절
-- 2.connect by 절 : 계층형 구조가 어떤 식으로 연결되는지를 기술하는 구문
--  prior 연산자 : 
-- 3. connect_by_root : 계층형 쿼리에서 최상위 행을 반환하는 연산자
-- 4. connect_by_isleaf : connect by 조건에 정의된 관계에 따라 해당 행이 최하위 자식행이면 1 그렇지 않으면 0 반환하는 의사 컬럼.
--5. sys_connect_by_path (column,char) : 루트 노드에서 시작해서 자신의 행까지 연결 경로를 반환하는 함수
-- 6. connect_by_iscycle : 루프(반복) 알고리즘 의사컬럼. 1또는0 반환

--select e.empno,lpad(' ', 3*(level-1))||ename,level,d.dname,d.deptno from emp e left join dept d
--on e.deptno = d.deptno start with e.mgr is null connect by prior e.empno = e.mgr;

select e.empno,d.dname,d.deptno from emp e , dept d
where e.deptno = d.deptno ;

--connect by root
select e.empno,lpad(' ', 3*(level-1))||ename,level,e.deptno,connect_by_root ename,connect_by_isleaf , sys_connect_by_path(ename, '/') from emp e 
 start with e.mgr is null connect by prior e.empno = e.mgr;

-- 뷰(View)
from 

create or replace view panview as
(select b.b_id,title,price,g.g_id,g_name,p_date,p_su
from book b join danga d on  b.b_id=d.b_id join panmai p on p.b_id=b.b_id join gogaek g on g.g_id = p.g_id )
order by p_date desc;

 select * from user_sys_privs;
drop table tbl_test;
select * from tbl_test;

select * from panview;
drop view panview ;
desc panview;

--뷰 목록 조회
select *
from tab
where tabtype = 'VIEW';
from tabs;

-- 뷰 사용 => DML  작업 (실습) 
-- ㄴ 단순뷰
    
-- ㄴ 복합뷰 x

CREATE TABLE testa (
   aid     NUMBER                  PRIMARY KEY
    ,name   VARCHAR2(20) NOT NULL
    ,tel    VARCHAR2(20) NOT NULL
    ,memo   VARCHAR2(100)
);

CREATE TABLE testb (
    bid NUMBER PRIMARY KEY
    ,aid NUMBER CONSTRAINT fk_testb_aid 
            REFERENCES testa(aid)
            ON DELETE CASCADE
    ,score NUMBER(3)
);

INSERT INTO testa (aid, NAME, tel) VALUES (1, 'a', '1');
INSERT INTO testa (aid, name, tel) VALUES (2, 'b', '2');
INSERT INTO testa (aid, name, tel) VALUES (3, 'c', '3');
INSERT INTO testa (aid, name, tel) VALUES (4, 'd', '4');

INSERT INTO testb (bid, aid, score) VALUES (1, 1, 80);
INSERT INTO testb (bid, aid, score) VALUES (2, 2, 70);
INSERT INTO testb (bid, aid, score) VALUES (3, 3, 90);
INSERT INTO testb (bid, aid, score) VALUES (4, 4, 100);

COMMIT;

--1.단순뷰 생성
create or replace view aview as 
select aid,name,tel from testa;

--2.DML 실행 ( insert)
insert into testa(aid, name, tel) values (5,'f','5'); -- 단순뷰를 memo만 만들면 insert가 불가함 ( not null 이라서) 다른건 가능한듯? 

delete from aview where aid = 5; --삭제는 자유롭게 가능.
COMMIT;

select * from testa;

--select a.*
--from (SELECT a.car_id,a.car_type,b.start_date,b.end_date,to_number(b.end_date - b.start_date) * a.daily_fee * (100-c.discount_rate)/100 FEE 
--      from car_rental_company_car a,CAR_RENTAL_COMPANY_RENTAL_HISTORY b,CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
--
--      where a.car_id = b.car_id  and a.car_type and substr (DURATION_TYPE,1,instr(b.duration_type,'일')-1) )a
--      
--where a.fee >=500000 and a.fee<2000000 and ( a.car_type ='세단' or a.car_type = 'SUV');

create or replace view abview as 
select  a.aid ,name ,tel ,bid,score 
from testa a join testb b on a.aid = b.aid;


select * from abview;

insert into abview (aid,name,tel,bid,score)
values ( 10,'x',55,20,70); -- 동시에 두개의 테이블에 각각의 컬럼값들이 insert 될 수 없다.
--복합뷰를 사용해서 update : 한 테이블의 내용만 수정 가능. 두테이블의 각각의 내용을 동시에 수정x 
update abview 
set score= 99
where bid=1;

--복합뷰를 사용해서 delete :
delete from abview 
where aid =1;

--with check opition 뷰에 의해 access될 수 있는 행(row)만이 삽입, 수정 가능 
-- [점수가 90점 이상인 뷰 생성]
create or replace view bview as 
select bid,aid,score
from testb
where score >=90
with check option constraint ck_bview_score; --where 절의 조건을 제약조건의 이름을 붙여서 저장함 다른 데에서 이 제약조건이 적용되는 수정이 됨.

select * from bview;

update bview set score = 70 where bid = 3; --안됨
update bview set score = 98 where bid = 3; --됨

drop view bview;
drop view aview;
drop view abview;
drop table testb;
drop table testa;

--뷰 : 물리적 뷰(materialized view) 실제 데이터를 가지고 있는 뷰
-- 문제 년도,월,고객코드,고객명,판매금액합(년도별 월), (년도, 월 오름차순) . 뷰로 작성

    select to_char(p_date, 'yy'),to_char(p_date, 'mm'),g_name, sum( from panmai p ,gogaek g;
    select * from gogaek;
    
    create or replace view panmeview as  (
    select to_char(p_date, 'yyyy') 년도,to_char(p_date, 'mm') 월, g_name 고객명 , sum(d.price*p_su) 판매금액합 from panmai p ,gogaek g,danga d where g.g_id=p.g_id and d.b_id = p.b_id group by to_char(p_date, 'yyyy'),to_char(p_date, 'mm'),g_name
    )
    order by 년도,월;
    
    
    select * from panmeview;
    
    -- 1.DB 모델링 정의
    1) 데이터베이스(Database) ? 서로 관련된 데이터의 집합(모임)
    2) DB모델링 ? 현실 세계의 업무적인 프로세스를 물리적으로 DB화 시키는 과정.
        예) 스타벅스에서 음료 주문(현실 세계의 업무 프로세스)
        음료(상품) 검색 -> 주문 ->주문 -> 결제 -> 대기 -> 상품 픽업
        
        2. DB 모델링 과정(단계, 순서)
        1) 업무 프로세스 ( 요구분석서작성) ->  2)개념적 DB모델링(ERD) => 논리적 DB 모델링(스키마,정규화)  => 물리적 DB모델링 (역정규화,인덱스,DBMS(오라클) 타입 ,크기)
    
    
        3. DB 모델링 과정(2단계) -개념적 DB 모델링 (ERD작성)
        1) 개념적 DB 모델링 ? DB 모델링을 함에 있어 가장 먼저 해야될 일은 사용자가 필요로하는데이터가 무엇인지 파악. 어떤 데이터를 DB에 저장해야되는 지 충분히 분석
         -> 업무 분석, 사용자 요구 분석 등을 통해서
         수집된 현실 세계의 정보들을 사람들이 이해할 수 있는 명확한 형태로 표현하는 단계를 "개념적 Db모델링"이라고 한다.
         
    2) 명확한 형태로 표현하는 방법 ? 
    ㄱ.개체(ENtity) - 직사각형, 관계 모델을 그래프 형식으로 알아보기 쉽게 표현 => ERD
        ㄴ업무 수행을 위해 데이터로 관리되어져야할 사람,사물,장소,사건 등을 "실체"라고함.
            구축하고자 하는 업무의 목적,범위,전략에 따라 데이터로 관리되어져야할 항목을 파악하는 것이 중요
                ㄴ실체는 학생,교수 등 과 같이 물리적으로 존재하는 유형 
                            학과,과목 등과 같이 개념적으로 존재하는 무형.
                            ㄴ실체는 테이블로 정의
                            ㄴ 실체는 인스턴스라 불리는 개별적인 객체들의 집합. 예) 과목(실체) : 오라클과목,자바과목,JSP과목 등등의 인스턴스의 집합
                                예)학과(실체) : 컴공과,수학과 등등의 인스턴스의 집합
                                    ㄴ 실체를 파악하는 요령 (가장 중요)
                                    예) 학원에서는 학생들의 출결상태와 성적들을 과목별로관리하기를 원한다.
                                    => 실체 > 학원,학생,출결상태,성적,과목
                                        출결상태 => 출결날짜,출석시간, 퇴실시간 
                
            ㄴ. 속성(Attribute) 타원형 
--                ㄴ 저장할 필요가 있는 실체에 대한 정보
--                즉 속성은 실체의 성질,분류,수량,상태,특징,특성 등등 세부항목을 의밓
--                속성 설정 시 가장 중요한 부분은 관리의 목적과 활용 방향에 맞는 속성의 설정.
--                속성의 갯수는 10개 내외가 된다.
--                속성은 컬럼으로 정의
--                속성의 유형
--              1) 기초 속성 - 원래 갖고 있는 속성
   --           예) 사원실체 - 사원번호 속성, 사원명 속성, 주민등록번호 속성,입사일자 속성 등등
--              2) 추출 속성 - 기초 속성으로 계산해서 얻어질 수 있는 속성
                    예) 기초 속성 주민등록번호에서 생일,성별,나이 속성 등등
--              3) 설계 속성
                    실제로는 존재하지 않지만 시스템의 효율성을 위해서 설계자가 임의로 부여하는 속성"
                    예)
                    
            ㄴ(ㄱ) - 속성 도메인 설정
                1) 속성이 가질 수 있는 값들으 ㅣ범위(세부적인 업무, 제약조건 등 특성을) 정의한 것.
                    예) 성적(E) - 국어 (A) 속성의 범위 0~100 정수 kor number(3) default 0 check(kor between 0 and 100)
                    도메인 설정은 추후 개발 및 실체를 db로 생성할 때 사용되는 산출물
                    도메인 정의 시에는 속성의 이름,자료형,크기,제약조건 등등 파악
                    도메인 무결성
             ㅁ. 식별자(Identifier) : 대표적인 속성, 언더라인(밑줄)
                1) 한 실체 내에서 각각의 인스턴스를 구분할 수 있는 유일한 단일 속성, 속성 그룹
                2)식별자가 없으면 데이터를 수정,삭제할 때 문제가 발생
                3) 식별자의 종류
                    1) 후보키(Candiate key)
                    실체에 각각의 인스턴스를 구분할 수 있는 속성
                    예) 학생실체 (E) 주민번호,학번,이메일,전화번호, 등등 
                    인스턴스 - 홍길동
                    인스턴스 - 김길동
                    
                    2) 기본키 (Primary key)
                        후보키 중에 대표적인 가장 적합한 후보키가 기본키
                        업무적인 효율성,활용도,길이(크기) 등등 파악해서 후보키 중에 하나를 기본키로 설정
                    3) 대체키 (Alternate key)
                        후보키 - 기본키 = 나머지 후보키
                    4) 복합키 (composite key)
                    5) 대리키(surrogate Key) 인공키
                        -학번을 기본키로 사용하자고 결정 
                        -식별자가 너무 길거나 여러 개의 복합키로 구성되어 있는 경우 인위적으로 추가한 식별자
                            -역정규화 작업
            ㄷ. 개체 관계 (Relational) - 마름모
                업무의 연관성에 따라서 실체들 간의 관계 설정..
                예) 부서 실체 (E)
                    부서번호 , 부서명,지역명
                    
                    관계 표현
                    1) 두 개체간의 실선으로 연결하고 관계를 부여한다.
                    2) 관계 차수 표현 ( 부서E -01 ---- ON-사원E)
            ㄹ. 연결(링크) - 실선
            
            3.DB 모델링 과정(3단계) - 논리적 DB모델링(스키마,정규화)
                ㄴ 개념적 모델링의 결과물(ERD) = > 릴레이션 (테이블) 스키마 생성(변환) + 정규화 작업
    
                ㄴ. 부모테이블과 자식테이블 구분
                -관계형 데이터 모델
                -예 ) 부서 (dept) <소속관계>사원(emp) 생성순서
                      부모                자식
                       -예 ) 고객   <주문관계>    상품 관계 주체
                              부모                자식
                             
                             ㄴ 기본키 (pk) 와 외래키(fk)
                                dept(deptno pk) emp(deptno fk) 
                                    ㄴ식별관계   : 실선 , 부모테이블의 pk가 자식테이블의 pk로 전이 되는것
                                        ㄴ 비식별관계 : 점선 , 부모테이블의 pk가 자식테이블의 fk로 전이 되는것
    
        (1) ERD => 5가지 규칙(매핑룰) => 릴레이션 스키마 생선(변환) + 이상현상 발생 => 정규화 과정.
                규칙1: 모든 개체는 릴레이션으로 변환한다 
                규칙2: 다대다(n:m) 관계는 릴레이션으로 변환한다
                규칙3: 일대다(1:n) 관계는 외래키로 표현한다
                규칙4: 일대일(1:1) 관계를 외래키로 표현한다
                규칙5: 다중 값 속성은 릴레이션으로 변환한다

    
    
    
    
    
    
    
    
    