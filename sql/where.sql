-- 필요한 데이터만 쏙 출력하는 WHERE 절

-- order by 는 where 뒤에 위치해야 한다.
select email, job_id, salary, hire_date
from employees
where department_id = 30
order by hire_date;

-- 여러 개 조건식을 사용하는 AND, OR 연산자
select email, job_id, salary, hire_date
from employees
where department_id = 30 and salary > 3000
order by hire_date;

select email, job_id, salary, department_id, hire_date
from employees
where department_id = 30 or department_id = 20
order by department_id, hire_date;