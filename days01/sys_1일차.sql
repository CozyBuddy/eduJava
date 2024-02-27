        --주석처리 ctrl /
--모든 사용자 계정 조회
--라인마다 절별로 코딩
--keyword(예약어)는 대문자로 권장\
--테이블명,column 이름은 소문자로 권장
--가독성(탭,줄 맞춤) 권장

--select * from all_users; --ctrl + enter ,F5

--select * From all_users;  --대소문자 상관없음
--select * from book;
--수업 중에 사용할 계정 생성,수정,삭제 
--1)scott 계정 생성 , 수정 ,삭세 
--    1) scott 계정 존재 유무 확인

--    2) scoot 계정 생성
--CREATE user scott identified by tiger; --계정을 만들면 계정의 인스턴스(스키마)를 저장공간에 만들어둠 --User SCOTT이(가) 생성되었습니다. --sys라는 시스템권한을 가진 계정에서 생성가능.
--select username from all_users ;
--    3) scott 계정 비밀번호 1234 수정
--    4)  scott 계정 삭제
--drop user scott cascade; --소유하고 있는 데이터 전부 삭제 (cascade) --User SCOTT이(가) 삭제되었습니다.
--select username from all_users;
--create user scott identified by tiger;
--alter user scott identified by 1234; --비밀번호 수정
--로그인을 할려면 create session 권한이 필요함 ERROR:ORA-01045: user SCOTT lacks CREATE SESSION privilege; logon denied
-- => scott 계정에 권한을 줄 수 있는 계정이 create session 권한을 부여

-- sql 5가지 중 권한 부여/회수 문 ? DCL

--sys 최고관리자 계정이 create session 데이터베이스 접속(연결) 시스템 권한을 scott 계정에 부여
--grant create session to scott

--롤(Role) 설명
-- 예) 회사 
--        계정(사용자)               다양한 권한(a1,a2,a3 ..... a100) - 신입사원에 대한 권한
--        :                         다양한 권한(s1,s2,s3 ..... s100) - 영업부 부서원에 대한 권한
--        :
--        :
--        김진영(새로운 계정 생성)
--GRANT  a1,a2... ,a100 to 김진영  => 신입사원 권한 회수
--Grant s1,s2... s100 to 김진영

-- 역할 (role) 신입사원역할 : a1~a100 권한을 신입사원이라는 롤 에게 부여
--grant a1~a100 to 신입사원역할
--grant s1~s100 to 영업사원역할
-- => grant 신입사원역할 to 김진영 ( 신입사원역할에서 특정 권한을 회수하면 자동으로 부여된 계정에서도 적용됨)
--grant create session to student_role;
--grant student_role to scott;

--ddl (create,drop,alter)
-- create user, drop user, alter user
-- create tablespace, drop tablespace, alter tablespace
-- create role, drop role, alter role

--오라클 설치 시에 미리 정의된 롤(role) 확인하는 쿼리(sql) 작성.
--grant CONNECT,RESOURCE,DBA to scott;
 
--select grantee,privilege 
-- from DBA_SYS_PRIVS 
-- WHERE grantee = 'CONNECT'; 
 --scott계정 _ 샘플 테이블 추가 
 --C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin
 --프롬프터
--SQL> @C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\scott.sql
--SQL> show user
--USER is "SCOTT"
-- [문제] scott으로 접속후에 scott.sql 실행해서 만들어진 테이블을 확인
--select *
--from tabs ;

-- 11. 데이터 모델 ? 컴퓨터에 데이터를 저장하는 방식을 정의해 놓은 개념 모델 
-- 데이터 모델의 종류 - 계층형,네트워크형,관계형,객체 지향적 데이터 모델 등등
-- 현대에서 가장 많이 사용하는 데이터 모델 - 관계형 데이터 모델
-- 11-2 . 관계형 데이터 모델 (RDBMS)
    -- 1)데이터 간의 관계에 초점을 둔 모델
    -- 2) 데이터 저장소(테이블)과 테이블 간의 관계에 초점을 둔 모델
--11-3. 관계형 데이터 모델의 핵심 구성 요소.
--    1)개체(Entity) - 데이터를 저장하는 가장 작은 단위 = RDMBS 테이블 (table) == 릴레이션(relation)
--    2)속성(Attribute) - 개체의 특징,종류,상태 == 칼럼(column)
--    3)관계(Relationship) - 개체와 개체 간의 연관성
--    
--    예) scott - dept,emp 테이블생성
--    
--     dept부서 개체(E)                         emp사원 개체(E)
--     속성(A)              
--     (A)부서 번호 ,부서명,지역명              사원번호,사원명,입사일자
--                                                    :
--                                                    부서번호(참조)
--                             소속 관계(R)
--                             
-- 예)     상품 개체             주문관계                  고객 개체
-- 
-- 12. DBA == DB(database) + A(administrator) == 데이터베이스 관리자
--        오라클 DBA 계정 : sys > system
--        
-- 13.테이블(table) ? 데이터를 저장하는 가장 작은 단위
--    테이블스페이스(tablespace) ? 논리적 단위 중에 데이터를 저장하는 가장 상위 개념
select *
from dba_users;
--HR 계정 확인 
--1) HR 계정의 비밀번호를 lion으로 수정하고 
--2) +새 접속 클릭 - HR 접속
--3) HR 계정이 소유하고 있는 테이블 목록을 조회
--alter user hr identified by lion
alter user hr account unlocked;

주요 오라클 서비스 
ㄱ.oracleservice[SID]
ㄴ.Oracle[sid]Listener

SQL은 기본 테이블,뷰를 대상으로 수행된다.

    



