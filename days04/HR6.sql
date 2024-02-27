


--[문제3]
select e.first_name  || ' ' ||e.last_name || ' report to ' || upper(m.first_name) ||' ' ||upper(m.last_name)  from employees e left join employees m on e.manager_id=m.employee_id;


--[부속질의]

[문제1]
select first_name  || ' ' ||last_name name , job_id,salary,hire_date from employees e where  salary =(select  min(salary) from employees where e.job_id=job_id  );

--[문제2]
select first_name  || ' ' ||last_name name,salary,department_id,job_id from employees where salary >( select avg(salary) from employees);

--[문제3]
select employee_id,first_name  || ' ' ||last_name name,job_id,hire_date from employees e where department_id = ( select department_id from departments where location_id = (select location_id from locations where city like 'O%')) ;


--[문제4]
select first_name  || ' ' ||last_name name,job_id,salary,department_id,to_char((select avg(salary) from employees where e.department_id = department_id),'99999') "department avg salary" from employees e order by "department avg salary";

-----------
--문제1
select employee_id,job_id,department_id from employees union 
select employee_id,job_id,department_id from job_history;

--문제2
select employee_id,job_id from job_history intersect select employee_id,job_id from employees;

--문제2-1
select*from job_history where employee_id =176;

--문제3
select employee_id from employees minus select employee_id from job_history;

---
--문제1
select department_id ,(select sum(salary) from employees e where  e.department_id = m.department_id) sum_sal, case when sum(salary)>100000 then 'Excellent' when sum(salary)>50000 then 'Good' when sum(salary)>10000 then 'Medium'when sum(salary)<=10000 then 'Well' end from employees m group by department_id;

--문제2
select employee_id,first_name  || ' ' ||last_name name,job_id,hire_date,salary, case when job_id like '%MGR%' and hire_date <to_date(2005/1/1)  then salary*1.15 when job_id like '%MAN%' and hire_date <to_date(2005/1/1) then salary*1.2 end "Department Grade Salary" from employees;

--문제3 
--2)
select * 
from ( select substr(hire_date,4,2) 월 from employees ) 
pivot ( count(월) for 월 in( '01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'));


select * from employees;

select * from regions;

select * from locations;

select * from tabs;

select * from DEPARTMENTS;