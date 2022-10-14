-------------------------------------------
-- 제약 조건 : UNIQUE 중복 불가   (개체 무결성 entity integrity)
-------------------------------------------

drop table members;

create table members (
    mid varchar2(10) unique not null,
    memail varchar2(50) constraint u_mid unique,
    mname varchar2(10) not null
);

-- 한번 더 실행하면 오류. 무결성 제약 조건(JAVA.U_MID)에 위배됩니다.
insert into members values ('fall', 'fall@mycompany.com', '홍길동');

-- null은 중복의 대상이 아니다
insert into members values ('winter', null, '홍길동');
select * from members;


--------------------------------------------------------

drop table members;
create table members (
    mid varchar2(10) not null,
    memail varchar2(50) null,
    mname varchar2(10) not null
);

-- 이미 생성된 테이블에 제약조건 지정
alter table members 
modify (
    mid constraint u_mid unique,
    memail constraint u_email unique
);

-- 제약조건 삭제
alter table members
drop constraint u_email;
