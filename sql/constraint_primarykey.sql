---------------------------------------------
-- 제약 조건 : PRIMARY KEY (UNIQUE + NOT NULL)
---------------------------------------------

drop table members;
create table members (
    mid varchar2(10) primary key,
    memail varchar2(50) null
);

insert into members values ('winter', '한겨울');
insert into members values ('winter', '한겨울'); ---(x) 중복 불가
insert into members values (null, '한겨울'); ---(x) null 허용 안함

-- 이미 생성된 테이블에 제약조건 지정
drop table members;
create table members (
    mid varchar2(10) not null,
    memail varchar2(50) null
);

alter table members
modify( mid constraint pk_mid primary key);

alter table members
add constraint pk_mid primary key (mid);

----------------복합 키----------------

drop table members;
create table members (
    first_no char(6) not null,
    second_no char(7) not null,
    memail varchar2(50) null
);
-- alter table 테이블명 add 를 이용해 복합 primary key 추가
alter table members
add constraint pk_ssn primary key (first_no, second_no);

------- 제약조건을 지정하는 다른 방식 -------
-- out-of-line (table-levle) 방식
drop table members;
create table members (
    mid varchar2(10) not null,
    memail varchar2(50) null,
    constraint pk_mid primary key(mid),
    constraint u_emial unique (memail)
);
