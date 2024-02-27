select *
from tabs;

 select count(*) from employees 
where commission_pct IS NOT nan;
select * from employees;

select last_name from employees
 where salary IS NOT INFINITE;
 
 select last_name, RPAD(' ',salary/1000+1, '*') "Salary"
 from employees
  where department_id = 80
 order by last_name, "Salary";
 
 --rtrim(), ltrim(),trim() 
 -- 형식 ) rtrim (char[,set])
 select '                         admin    ' a , ltrim('                         admin    '),rtrim('                         admin    '), trim('                         admin    ')
 from dual;
 
 select trim(both 'kim' from 'sinseulkiandkimjinyoung' ) ;
 


show user;

select last_name, employee_id, hire_date,EXTRACT(year FROM to_date( hire_date))
  from employees
  where EXTRACT(year FROM to_date( hire_date)) >1998
  order by hire_date;
  

  
  
  
  
  