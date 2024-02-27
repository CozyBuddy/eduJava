select scott from tabs;
--alter user hr identified by lion;
select * from dba_users where user_name=scott;
alter user hr identified by abcd;
alter user hr account unlock;
desc scott;
select * from user_sys_privs;
select * from user_role_privs;

------------ scott 계정의 시스템 권한 및 롤 조회하는 SQL을 작성.

select *
from v$reserved_words
order by keyword;
where keyword=upper('date');