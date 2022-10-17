-- 원하는 순서로 출력 데이터를 정렬하는 ORDER BY

-- 봉급액 올림차순으로 사원번호와 봉급 가져오기
select employee_id, salary
from employees
order by salary asc;

-- 봉급액 내림차순으로 사원번호와 봉급 가져오기
select employee_id, salary
from employees
order by salary desc;

-- 부서별로 올림차순으로 정렬하고(1차), 
-- 같은 부서내에서 봉금을 내림차순으로 가져오기(2차)
select department_id, salary
from employees
order by department_id, salary desc;
