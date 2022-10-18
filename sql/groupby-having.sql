---------------------------------------------
-- 다중행 함수 : GROUP BY절
---------------------------------------------

-- GROUP BY절 : 특정 열 또는 데이터를 기준으로 데이터를 그룹으로 묶음.
    -- group by 에 있는 컬럼은 반드시 select 절에 있어야하고 그 다음에 집계함수가 무조건 있어야 한다.
    -- group by 에 없는 컬럼은 select절에서 사용 못함
select department_id, sum(salary)
from employees
where department_id in (10, 20, 30)
group by department_id
order by department_id;

select department_id, job_id,sum(salary)     --(x)
from employees
where department_id in (10, 20, 30)
group by department_id
order by department_id;

select department_id, job_id, sum(salary)
from employees
where department_id in (10, 20, 30)
group by department_id, job_id
order by department_id;

-- GROUP BY - HAVIN절
  -- having : 그룹핑이 끝난후 집계값을 가지고만 조건을 만들어야함
select department_id, avg(salary)
from employees
where department_id in (10, 20, 30)
group by department_id
having avg(salary) > 5000  
order by department_id;




