---------------------------------------------
-- 13.3 테이블처럼 사용하는 뷰 (p.338)
--------------------------------------------- 

--뷰 생성 
create view v_emp
    as (select employee_id, email, salary from employees);
    
select * from v_emp;

-- 뷰를 사용하는 이유
--1. 편리성 : 테이블에 컬럼이 너무 많아 일부 컬럼만 반복해서 자주 사용할 때 편리하게 사용하기 위해 뷰를 사용
--2. 보안성 : 보안상 이유로 DBA가 보는 컬럼과 개발자가 보는 컬림이 다를 수 있다. 아무나 테이블에 접근할 수 없게 하기 위해
   -- employees 테이블 데이터에 대해 못보게 권한을 다 막아놓고, employees 테이블 중 일부만 뷰로 공개해서 볼 수 있게 할 수 있다.
   
create view v_emp2
as ( -- 복잡한 select 문을 감추는 효과
    select employee_id, first_name, department_name
    from employees e, departments d
    where e.department_id = d.department_id
);

-- view는 데이터를 물리적을 저장하는 게 아니라 select 문을 저장
select * from v_emp2;


-- 30번 부서인 사원정보만 접근할 수 있게 하는 view (모든 부서에 대한 데이터가 아닌 제한된 데이터만 제공)
create view v_emp3
as ( -- 컬럼과 행 제한
    select employee_id, email, salary
    from employees
    where department_id = 30
);

-- 이미 만들어진 객체에 대해 객체 실행(사용) 권한 : select, insert, update, delete
-- 시스템 권한 (객체를 생성, 수정, 삭제하는 권한)  : create, alter, drop

-- 같은 이름의 뷰가 있을 경우 or replace를 붙이면 다시 갱신
create or replace view v_emp3
as ( 
    select employee_id, email, salary
    from employees
    where department_id = 40
);

select * from v_emp3;

-- 뷰 삭제
drop view v_emp3;

-----------------------------------------------------
-- 한 발 더 나가기) 뷰와 데이터 조작어 (p.344)
-- View 를 통해서 DML (insert, update, delete) 실행
create table products (
    pno number primary key,
    pname varchar(50) not null,
    pprice number default 0 not null,
    pdate date default sysdate not null,
    pcompany varchar(50) null
);

create or replace view v_prod
as (
    select pno, pname, pprice
    from products
);

insert into v_prod values (1, 'TV', 1000);  --View 에 저장되는게 아니라 products 테이블에 데이터가 저장됨
select * from products;  
-- table에 값을 저장할 때 반드시 필요한 값(not null인 컬럼들)이 view에 존재하면 view를 통해 테이블에 값을 insert 할 수 있다. 

-----

create or replace view v_emp3
as ( -- 부서 번호가 30번인 사원 정보
    select employee_id, email, salary, department_id
    from employees
    where department_id = 30
);

-- 부서 번호가 30번인 사원 중 사원 아이디가 114번인 사원의 부서번호를 50번을 변경
  -- view 를 통해서 update 가능
update v_emp3 set department_id=50
where employee_id=114;





