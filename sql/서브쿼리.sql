---------------------------------------------
-- 서브 쿼리
---------------------------------------------

select salary
from employees
where first_name='John';

select salary
from employees
where employee_id=110;

select employee_id, salary
from employees
where salary > (select salary from employees where employee_id=110); -- 서브쿼리는 항상 괄호()안에

select employee_id, salary
from employees
where salary > (select salary
                from employees
                where first_name='John');  --(x) 서브쿼리의 결과가 메인쿼리의 비교 대상과 같은 자료형과 같은 개수로 지정해야함
                
select employee_id, salary
from employees
where salary > (
    select salary
    from employees
    where employee_id=110
    order by salary          --(x) 서브쿼리에서는 order by 사용 못함
);

select employee_id, salary, department_id
from employees
where department_id in (   --(o) 
    select department_id
    from departments
    where department_id < 30
);

-- 110번보다 입사날짜가 빠른 사원
select *
from employees
where hire_date < (
    select hire_date
    from employees
    where employee_id=110
);

-- 전체 평균 봉급보다 많은 봉급을 받는 사원
select *
from employees
where salary > (
    select avg(salary)
    from employees
);

select *
from employees
where salary > avg(salary);   --(x)


