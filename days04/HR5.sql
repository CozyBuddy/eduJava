--[문제1]
 select first_name||last_name name,job_id,salary,salary*12 +100 "Increased Ann_salary" ,(salary + 100)*12 "Increased salary" from employees;
 
 select * from employees;
 
 --[문제2]
 select last_name || '1 Year salary = $' || salary*12 from employees;
 
 --[문제3]
 select distinct department_id , job_id from employees;
 
 -----------------
 
 select * from employees;
 --[문제1]
 select e.* from employees e where last_name like '%e%o%' or last_name like '%o%e%' ;
 
 --[문제2]
 select first_name||last_name name ,employee_id , hire_date from employees where hire_date between to_date('06/05/20') and to_date('07/05/20') order by hire_date;
 
 --[문제3]
 select first_name || last_name name ,salary,job_id,commission_pct from employees where commission_pct is not null order by salary  desc , commission_pct;
 
 ------------
 
 --[문제1]
  select initcap(first_name) || initcap(last_name) || ' is a '|| job_id from employees e;
  
  --[문제2]
  select first_name || last_name name,salary, salary*12 +salary*nvl(commission_pct,0), decode(commission_pct,null,'salary only','with commision') "commision?" from employees;
  
 --[문제3]
  select first_name || last_name name , hire_date , to_char(hire_date , 'day') d from employees order by to_number(to_char(hire_date , 'd'));
  
  
  
  --
  --[문제1]
  select department_id ,to_char(sum(salary), '$999,999.00') "Sum salary" , to_char(avg(salary), '$999,999.00') "Avg Salary" , to_char(max(salary), '$999,999.00') "Max salary" , to_char(min(salary), '$999,999.00') "Min Salary" from employees group by department_id order by department_id  
  ;
  
  --[문제2]
  select job_id , avg(salary) "Avg Salary" from employees group by job_id having avg(salary) >10000  order by avg(salary) desc;
  
  --[---------
  
  
  -- [문제1]
  select * from departments;
  
  select f.*
  from (select d.department_name, count(*) c from employees e join departments d on e.department_id = d.department_id group by d.department_name order by count(*) desc) f
  where f.c>=5;
  
  --[문제2]
  create table Job_Grades (
  grade_level VARCHAR2(3),lowest_sal Number,highest_sal number);
  
  insert INto Job_Grades values ( 'A',1000,2999);
  insert INto Job_Grades values ( 'B',3000,5999);
  insert INto Job_Grades values ( 'C',6000,9999);
  insert INto Job_Grades values ( 'D',10000,14999);
  insert INto Job_Grades values ( 'E',15000,24999);
  insert INto Job_Grades values ( 'F',25000,40000);
  
  ROLLBACK; 
  drop table job_grades;
  select * from job_grades;
  commit;
  
  select name, job_id, department_name,hire_date,salary,grade_level from departments d join job_grades j on d.salary between lowest_sal and highest_sal ;
  
 select f.* , (select grade_level from job_grades where f.salary between lowest_sal and highest_sal)
 from  (select first_name || last_name name,job_id ,department_name,hire_date,salary from  employees e join departments d on e.department_id = d.department_id  ) f  ;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  