select * from emp;

create table emp2 (
empno number(4) , increased_sal number(4));

insert into emp2 (empno, increased_sal)
select empno, sal*1.1
from emp
where empno=7369;

select * from emp2;

sele