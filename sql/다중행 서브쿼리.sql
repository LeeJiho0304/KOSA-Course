---------------------------------------------
-- 서브 쿼리 : 다중행 서브쿼리(multiple-row subquery)  p.249~261
---------------------------------------------

select employee_id, first_name
from employees
where salary = (select max(salary) from employees);  -- 단일행

-- IN 연산자 (다중행 가능)
select employee_id, first_name
from employees
where department_id in (
    select department_id 
    from departments where location_id=1700
);
    
  -- 부서별 최대 봉급 (맞지않는 예시)
select employee_id, first_name, job_id, department_id, salary
from employees e
where salary in (
    select max(salary)
    from employees
    group by department_id
);

-- ANY, SOME 연산자
select employee_id, department_id
from employees
where department_id = any(10, 20);  --or 과 동일

select employee_id, salary, department_id
from employees
where department_id=100 and
    salary >= any(
            select avg(salary)
            from employees
            group by department_id
            );
    
select employee_id, salary, department_id
from employees
where department_id=100 and
    salary >= any(8000, 9000, 10000);   -- >= 8000 과 같다

-- ALL 연산자
select employee_id, salary, department_id
from employees
where department_id=100 and
    salary >= all(8000, 9000, 10000);  -- >=10000 와 같다
    
select employee_id, salary, department_id
from employees
where department_id=100 and
    salary >= all(
            select avg(salary)
            from employees
            group by department_id
            );
            
-- EXISTS 연산자
select employee_id, department_id
from employees
where exists (
    select department_name
    from departments
    where department_id = 1000
);
  -- 메인 쿼리의 값을 서브 쿼리로 읽어와서 처리하기
select employee_id, department_id
from employees e
where exists (
    select department_name
    from departments
    where department_id in (e.department_id + 200)
);

----------------
-- 문제1. 게시물을 전혀 작성하지 않은 멤버의 아이디와 이름을 가져오시오

select * from members;
select * from boards;

--1) Join 이용
select m.mid, m.mname
from members m, boards b
where m.mid = b.mid(+) and bno is null;

--2) SubQuery 이용
select m.mid, m.mname
from members m
where not exists (
    select bno
    from boards b
    where b.mid = m.mid
);

select mid, mname
from members
where mid not in (
    select mid
    from boards
);

-- 문제2. 근무도시가 시애틀인 사원의 이메일과 전화번호
--1) Join 이용
select email, phone_number
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id
    and l.city ='Seattle';

--2) SubQuery 이용
select email, phone_number
from employees e
where department_id in (
    select department_id 
    from departments
    where location_id = (
        select location_id
        from locations
        where city='Seattle'
    )
);
/*
select email, phone_number
from employees e
where exists(
    select department_id 
    from departments d, locations l
    where d.location_id = l.location_id and d.department_id = e.department_id and l.city ='Seattle'
);
*/

-- 다중열 서브쿼리 : 비교할 열이 여러개인 경우
select employee_id, salary, department_id
from employees
where (department_id, salary) in (
    select department_id, max(salary)
    from employees
    group by department_id
    );

-- FROM절에 사용하는 서브쿼리와 WITH절
  -- 테이블 내 데이터 규모가 너무 크거나 현재 작업에 불필요한 열이 너무 많아 일부 행과 열만 사용하고자할 때 유용
select email, department_name
from (
        select email, department_id
        from employees
    ) e,
    (
        select department_id, department_name
        from departments
    ) d
where e.department_id = d.department_id;

select email, department_name, city
from (
        select email, department_id
        from employees
        where department_id in (10, 20)
    ) e,
    (
        select department_id, department_name, location_id
        from departments
    ) d,
    (
        select location_id, city
        from locations
    ) l
where e.department_id = d.department_id and d.location_id = l.location_id;

-- WITH 절 : 메인 쿼리 안에서 사용할 서브 쿼리를 with문에 먼저 선언
with 
    e as ( select email, department_id from employees where department_id in (10, 20) ),
    d as ( select department_id, department_name, location_id from departments ),
    l as ( select location_id, city from locations )
select email, department_name, city
from  e, d, l
where e.department_id = d.department_id and d.location_id = l.location_id;


-- 상호 연관 서브쿼리
select employee_id, department_id, salary
from employees e1
where salary > ( 
    select min(salary)
    from employees e2
    where e2.department_id = e1.department_id
)
order by department_id, salary;

---------------------------------------
-- 문제. 사원 번호, 이름, 직위, 봉급, 등급, 부서 번호 출력

-- 사원 107명에 대해 모두 join을 한 후 조건에 성립하는 행을 읽어옴
select employee_id, first_name, job_id, salary, grade_id, department_id
from employees, grade
where salary between low_salary and hi_salary   -- 비등가 조인
    and department_id = 30;

-- from절에서 사용하는 서브쿼리
  -- 미리 해당 department_id = 30 인 사원을 뽑아놓고 join을 하기때문에 성능이 더 향상됨
select employee_id, first_name, job_id, salary, grade_id, department_id
from (
    select employee_id, first_name, job_id, salary, department_id
    from employees
    where department_id = 30
) e, grade
where salary between low_salary and hi_salary;

-- select절에서 사용하는 서브쿼리 (join 없이 하는 방법)
select employee_id, first_name, job_id, salary, department_id,
    (  -- 하나의 값이 나와야함 (단일행)
        select grade_id 
        from grade 
        where e.salary between low_salary and hi_salary  -- 연결 조건이 아닌 그냥 조건
    ) as grade_id
from employees e
where department_id = 30;

----------------------------------------
-- 문제. 사원 번호, 이름, 직위, 봉급, 부서번호, 부서이름 출력
select employee_id, first_name, job_id, salary, department_id, department_name
from employees
where job_id = 'ST_CLERK';

--1) Join 이용
select employee_id, first_name, e.job_id, salary, d.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id and job_id = 'ST_CLERK';

--2) from절 SubQuery 
select employee_id, first_name, job_id, salary, department_name
from (
    select employee_id, first_name, job_id, salary, department_id
    from employees
    where job_id = 'ST_CLERK'
    ) e, departments d
where e.department_id = d.department_id;

--3) select절 SubQuery
select employee_id, first_name, job_id, salary, (
    select department_name
    from departments
    where e.department_id = department_id
    ) as dname
from employees e
where job_id = 'ST_CLERK';
