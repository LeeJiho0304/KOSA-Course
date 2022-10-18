---------------------------------------------
-- JOIN : SQL-99 표준 문법
---------------------------------------------

select email, d.department_id, department_name
from employees e, departments d
where e.department_id=d.department_id;

-- INNER JOIN
select email, department_name
from employees e inner join departments d on e.department_id=d.department_id;

-- NATURAL JOIN
select e.email, department_id, d.department_name
from employees e natural join departments d;

-- JOIN ~ USING
select e.email, department_id, d.department_name
from employees e join departments d using (department_id);

-- JOIN ~ ON
select e.email, d.department_name
from employees e join departments d on (e.department_id = d.department_id);

-- OuTER JOIN
select email, department_name
from employees e, departments d
where e.department_id(+) = d.department_id;

select e.email, d.department_name
from employees e right join departments d on (e.department_id = d.department_id);

select count(distinct(department_id))
from employees;

-----------------------
-- natural join test
drop table boards;
drop table members;

create table members (
    mid varchar2(10) primary key,
    mname varchar2(20) not null
);

create table boards (
    bno number primary key,
    btitle varchar(100) not null,
    mid varchar2(10) references members(mid) on delete cascade,
    mname varchar(20) not null
);

insert into members values ('spring', '김하늘');
insert into members values ('summer', '하여름');
insert into members values ('fall', '단풍잎');
insert into members values ('winter', '동장군');
commit;

insert into boards values(1, '제목1', 'spring', '김하늘');
insert into boards values(2, '제목2', 'fall', '단풍잎');
insert into boards values(3, '제목3', 'spring', '이바다');
commit;

select m.mid, m.mname, bno, b.mid, btitle 
from members m, boards b 
where m.mid = b.mid;

select mname, mid, bno, btitle 
from members m natural join boards b;