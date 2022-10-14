---------------------------------------------
-- 제약 조건 : CHECK  (영역 무결성 domain integrity )
---------------------------------------------

drop table freeboards;
drop table members;

-- 방법1
create table members (
    mid varchar(20) primary key,
    mname varchar(20) not null,
    mage number(3) check(mage>0 and mage<200),  --mage 범위 체크(0 초과 200 미만)
    mgrade char(1) check(mgrade in ('A', 'B', 'C'))  --mgrade 가 'A', 'B', 'C' 중에 있어야함
);

insert into members values('winter', '한겨울', 25, 'A');

-- 방법2
drop table members;
create table members (
    mid varchar(20) primary key,
    mname varchar(20) not null,
    mage number(3) not null, 
    mgrade char(1),
    constraint ch_mage check(mage>0 and mage<200),
    constraint ch_grade check(mgrade in ('A', 'B', 'C'))
);

insert into members values('winter', '한겨울', 25, 'A');

-- 방법3
drop table members;
create table members (
    mid varchar(20) not null,
    mname varchar(20) not null,
    mage number(3) not null, 
    mgrade char(1) not null
);

alter table members
    add constraint pk_mid primary key (mid);

alter table members
    add constraint ch_mage check(mage>0 and mage<200);
    
alter table members
    add constraint ch_grade check(mgrade in ('A', 'B', 'C'));
    
