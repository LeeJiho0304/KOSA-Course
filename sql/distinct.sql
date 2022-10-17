-- 테이블 전체 열 출력
select * from employees;

-- 테이블 부분 열 출력
select employee_id, first_name, last_name, department_id 
from employees;

-- 사원들이 소속되어 있는 부서 번호 가져오기(중복 제거)
select distinct department_id
from employees;

-- 직무번호와 부서번호를 결합해서 중복을 제거 
select distinct job_id, department_id
from employees;

-- 중복 설정이 없으면 all 을 기본으로 사용
select all job_id, department_id
from employees;