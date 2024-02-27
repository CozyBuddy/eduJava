--select tablespace_name, file_name 
select *
from dba_data_files;
select tablespace_name,status from dba_tablespaces;

select * from dba_tables where owner='SCOTT';

select * from arirang;
select * from emp; --스키마가 없으면 조회가 불가능.

CREATE PUBLIC SYNONYM  arirang 
FOR scott.emp;

select * from all_synonyms where synonym_name like 'ARI%';

drop public synonym arirang;

commit;