---------------------------------------------
-- DEFAULT : 특정 열에 저장할 값이 지정되지 않았을 경우에 기본값 지정
---------------------------------------------
drop table members;

create table members (
    mid varchar(20) primary key,
    mname varchar(20) not null,
    mdate date default sysdate not null,
    mcity varchar2(10) default '서울' null,
    mgrade char(1) default 'C' check(mgrade in ('A', 'B', 'C'))  
);

insert into members values('winter', '한겨울', default, default, default);

insert into members(mid, mname) values('summer', '하여름');

insert into members(mid, mname, mcity) values('fall', '김가을', null);

select * from members;
