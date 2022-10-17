---------------------------------------------
-- 연산자 종류와 활용 방법 알아보기
---------------------------------------------

-- 산술 연산자
select email, salary*12 as yearsal
from employees
where salary*12 >= 200000;

-- 비교 연산자 >, < , >=, <=, =
-- 문자도 비교연산자로 비교가 가능(사전순)
select first_name
from employees
where first_name >= 'A' and first_name < 'C';

-- !=, <> , ^=
select email, job_id
from employees
where job_id != 'IT_PROG' and job_id <> 'FI_ACCOUNT';

-- NOT
select email, job_id
from employees
where NOT (job_id != 'IT_PROG' and job_id <> 'FI_ACCOUNT');

-- IN
select email, job_id
from employees
where job_id IN ('IT_PROG', 'FI_ACCOUNT');

select email, job_id
from employees
where job_id NOT IN ('IT_PROG', 'FI_ACCOUNT');

-- BETWEEN A and B
select email, salary
from employees
where salary >= 5000 and salary <= 7000;

select email, salary
from employees
where salary between 5000 and 7000;

-- LIKE 연산자와 와일드 카드
select first_name
from employees
where first_name like '%St%';

select first_name, email 
from employees
where first_name like '%ev%' or email like '%ev%';

select email 
from employees
where email like '_L%';

-- IS NULL
-- NULL 은 값이 없기때문에 연산을 할 수 없음
-- NULL 이 하나라도 포함된 연산할 시 값도 NULL
select employee_id, first_name
from employees
where department_id is null;

select employee_id, first_name
from employees
where department_id is not null;

select *
from employees
where commission_pct is null;

select (salary*12) + (commission_pct*salary) as yearsal
from employees;

-- UNION
select email, phone_number, department_id
from employees
where department_id = 10
union
select email, phone_number, department_id
from employees
where department_id = 20;
  -- 동일한 결과
select email, phone_number, department_id
from employees
where department_id = 10 or department_id = 20;
