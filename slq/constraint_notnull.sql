-------------------------------------------
-- 제약 조건 : Not Null(Check 제약)
-------------------------------------------
drop table members;
create table members (
    mid varchar2(20) not null,
    mname varchar2(20) not null,
    mtel varchar2(20) null
);

insert into members (mid, mname, mtel) values ('winter', '한겨울', '010-1234-1234');
-- 컬럼 리스트가 생략되면 DB 에 추가된 컬럼 순서대로 모든 컬럼의 값을 제공
insert into members values ('winter', '한겨울', '010-1234-1234');

-- 명시적으로 null 저장
insert into members (mid, mname, mtel) values ('winter', '한겨울', null);
-- 컬럼 리스트에 없는 컬럼은 null 로 저장됨.
insert into members (mid, mname) values ('winter', '한겨울');

-- not null 은 null 로 수정할 수 없다.
update members set mid=null where mid='winter';

-- 제약 조건 이름 직접 지정
  -- 테이블 생성 시 지정하기
create table members (
    mid varchar2(20) constraint members_mid_nn not null,
    mname varchar2(20) not null,
    mtel varchar2(20) null
);
  -- 이미 생성된 테이블에 제약조건 지정
alter table member
modify(mtel constraint tel_nn not null);
