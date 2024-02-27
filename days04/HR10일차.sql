--self join : exists 연산자 사용한 경우
select employee_id,first_name,last_name,manager_id,department_id
from employees
where department_id not in ( select department_id from departments where location_id = 1700 ) ;

--self join : exists 연산자 사용한 경우
select *
from departments d
where exists( select * from employees e where d.department_id = e.department_id and e.salary>2500 ) ;

