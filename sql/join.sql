---------------------------------------------
-- JOIN : 등가조인, 비등가조인
---------------------------------------------

select email, phone_number, department_name    --(x) 연결 조건이 없으면 employees X departments 나옴 
from employees, departments;   

select email, phone_number, department_name 
from employees, departments
where employees.department_id = departments.department_id;  -- 연결(조인) 조건 : 테이블 수 -1

select email, phone_number, department_name 
from employees e, departments d         -- 테이블 별칭은 as 안씀
where e.department_id = d.department_id;

select employee_id, email, phone_number, department_name 
from employees e, departments d
where e.department_id = d.department_id;

select email, phone_number, e.department_id, department_name -- 동일한 컬럼명이 있으면 어느 테이블에서 가져와야하는 지 언급해줘야함
from employees e, departments d
where e.department_id = d.department_id;

/* 등가 조인(equi join, inner join, simple join) */
select email, phone_number, e.department_id, department_name, salary
from employees e, departments d
where e.department_id = d.department_id
        and d.department_id = 20
        and salary > 100;

-- 사원 번호, 전화번호, 사원 근무 도시(location-city), 부서이름
select employee_id, phone_number, city, department_name
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id;

-- 사원 번호, 전화번호, 지역 이름
select employee_id, phone_number, region_name
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id 
        and d.location_id = l.location_id
        and l.country_id = c.country_id
        and c.region_id = r.region_id;
        
-- 사원 번호, 이름, 관리자 이름
-- 자체 조인 (self join)
select e1.employee_id as 사번, e1.first_name as 이름, e2.first_name as "관리자 이름"  -- as 에서 띄어쓰기가 포함된 문자를 쓸 때는 "" 
from employees e1, employees e2
where e1.employee_id = e2.manager_id;



/* 비등가 조인 */
create table grade (
    grade_id char(1) primary key,
    low_salary number(8, 2) not null,
    hi_salary number(8, 2) not null
);
insert into grade values('E', 700, 1200);
insert into grade values('D', 1201, 1400);
insert into grade values('C', 1401, 2000);
insert into grade values('B', 2001, 3000);
insert into grade values('A', 3001, 99999);
commit;
  -- 비등가 조인은 범위로 비교
select employee_id, salary, grade_id
from employees e, grade g
where e.salary between g.low_salary and g.hi_salary;

/* 외부 조인 (Outer Join) */
-- 오른쪽 외부 조인
select employee_id, e.department_id, d.department_id, department_name
from employees e, departments d
where e.department_id(+) = d.department_id;

-- 사원이 없는 부서의 이름
select d.department_id, department_name
from employees e, departments d
where e.department_id(+) = d.department_id
        and employee_id is null;

/*
-- 매니저가 없는 사원도 포함해서 출력        
select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id(+);

-- 매니저가 없는 사원
select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id(+)
        and emp.manager_id is null;

-- 관리자 번호가 148 인 사원
select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id = mgr.employee_id(+)
        and emp.manager_id=148;       

-- 사원이 없는 매너지 포함해서 출력
select emp.employee_id, emp.manager_id, mgr.first_name
from employees emp, employees mgr
where emp.manager_id(+) = mgr.employee_id;
*/
