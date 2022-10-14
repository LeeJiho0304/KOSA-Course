--------------------------------------------------
-- 테이블  생성 및 수정, 이름 변경, 테이블 삭제
--------------------------------------------------

-- 테이블 생성
create table emp_ddl(
    empno number(4) not null,
    ename varchar2(10) not null
);

-- 행 저장
insert into emp_ddl(empno, ename) values (1, 'winter');
insert into emp_ddl(empno, ename) values (2, 'summer');
commit;

-- 테이블 생성
create table emp_ddl(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(9) null,
    mgr number(4) null,
    hiredate date not null,
    sal number(7, 2) not null,
    comm number(7, 2) not null,
    deptno number(2) null
);

-- 테이블 삭제
drop table emp_ddl;

-- 기존이 데이터가 있는 데이블에서 컬럼을 새로 추가할 때에는
-- null을 허용하도록 해야 함
-- 데이터를 채우고 후에 not null로 변경해야함.
alter table emp_ddl
    add (
        city varchar(10) not null,
        age number(3) not null
    );
    
-- 테이블의 이름 변경
alter table emp_ddl rename to employees;

-- 컬럼 이름 변경
alter table employees 
    rename column city to ecity;
    
alter table employees 
    rename column age to eage;
    
-- 컬럼 데이터 타입 변경
alter table employees
    modify (
        ename varchar2(15),
        ecity varchar2(20)
    );
    
-- 컬럼 삭제하기
alter table employees
    drop column eage;
    
alter table employees
    drop ( ename, ecity );
    
    
drop table employees;

create table employees (
    eno number(4) not null,
    ename varchar2(15) not null
);

insert into employees(eno, ename) values (1, '홍길동');
insert into employees(eno, ename) values (2, '감자바');
commit;

select * from employees;

-- 모든 행을 삭제
delete from employees;
rollback;

-- 실제 테이블의 저장 공간의 초기화
-- rollback 대상이 아님
truncate table employees;
