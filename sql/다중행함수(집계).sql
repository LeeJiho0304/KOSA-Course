---------------------------------------------
-- 다중행 함수 : sum, count, max, min, avg
---------------------------------------------

select sum(salary) from employees;
select avg(salary) from employees;
select max(salary) from employees;
select min(salary) from employees;

select count(employee_id) from employees;
select count(department_id) from employees; -- count 는 null 포함 안함
select count(*) from employees; -- employees 의 전체 행 갯수 (null 포함)
