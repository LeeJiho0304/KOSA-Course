---------------------------------------------
-- 제약 조건 : FOREIGN KEY
---------------------------------------------

drop table members;
drop table freeboards;

create table members (
    mid varchar2(10) not null,
    mname varchar2(20) not null
);

alter table members
add constraint pk_mid primary key (mid);

create table freeboards (
    bno number not null,
    btitle varchar2(50) not null,
    writer varchar(10) not null
);

alter table freeboards
add constraint pk_bno primary key (bno);
---------------------------------------------------------------
insert into members values ('fall', '한가을');
insert into freeboards values (1, '단풍', 'fall');
insert into freeboards values (2, '눈', 'winter'); --(o) 사용자만 게시판을 쓸 수 있게해야함
---------------------------------------------------------------


--foreign key 지정하는 방법1
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar2(50) not null,
    writer varchar(10) constraint fk_writer references members(mid)
);

--foreign key 지정하는 방법2
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar2(50) not null,
    writer varchar(10),
    constraint fk_writer foreign key (writer) references members(mid)
);

--foreign key 지정하는 방법3
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar2(50) not null,
    writer varchar(10) not null
);
alter table freeboards
add constraint fk_writer foreign key (writer) references members(mid);

---------------------------------------------------------------------

insert into freeboards values (1, '단풍', 'fall');
insert into freeboards values (2, '눈', 'winter'); --(x)무결성 제약조건(JAVA.FK_WRITER)이 위배되었습니다- 부모 키가 없습니다

-- 참조하고 있는 키는 삭제할 수 없음
delete from members where mid='fall'; --(x)무결성 제약조건(JAVA.FK_WRITER)이 위배되었습니다- 자식 레코드가 발견되었습니다

-- 삭제하는 방법1 : 역순 차례대로 삭제후 (freeboards 에서 먼저 지우고 members에서 삭제)
delete from freeboards where writer='fall';
delete from members where mid='fall'; --(o)

-- 삭제하는 방법2 : on delete cascade;
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar2(50) not null,
    writer varchar(10) not null
);
alter table freeboards
    add constraint fk_writer 
        foreign key (writer) 
        references members(mid) on delete cascade;

insert into freeboards values (1, '단풍', 'fall');
commit;

delete from members where mid='fall';


-- 삭제하는 방법3 : on delete set null;
-- 삭제하려는 참조키가 not null 이면 불가능
drop table freeboards;
create table freeboards (
    bno number not null,
    btitle varchar2(50) not null,
    writer varchar(10) null
);
alter table freeboards
    add constraint fk_writer 
        foreign key (writer) 
        references members(mid) on delete set null;

insert into freeboards values (1, '단풍', 'fall');

delete from members where mid='fall';
