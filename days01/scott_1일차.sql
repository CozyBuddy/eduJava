-- [문제] 접속자의 소유한 테이블목록을 조회하는 쿼리
select *
from dba_tables; 
from all_tables; --데이터 사전,뷰(view) // 자신이 접근할 수 있는 계정명들의 table들
from user_tables; --데이터 사전,뷰(view)
--from tabs; --tablespace 가 tabs
--[문제] tabs?
--data dictionary(자료사전==데이터사전 == 데이터 딕셔너리) 이란?
-- ㄴ 테이블,뷰
    
-- [문제] dept 테이블 정보를  조회하는쿼리
select *
from dept;
select *
from emp;
select *
from bonus;
select *
from salgrade;
--count() 오라클 집계 함수 
select count(*)
from dictionary;