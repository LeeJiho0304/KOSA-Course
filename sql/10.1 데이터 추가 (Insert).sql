---------------------------------------------
-- 10. 데이터를 추가, 수정, 삭제하는 데이터 조작어(DML)
   -- 10.1 테이블에 데이터 추가하기 (Insert)  (p.266)
--------------------------------------------- 


drop table boards;
drop table members;

create table members (
    mid varchar2(20) primary key,
    mname varchar2(20) not null,
    memail varchar2(100) unique null,  -- unique : 중복 허용X, null은 들어갈 수 있다.
    mage number check (mage > 0 and mage < 300),  -- mage 의 범위가 0보다 크고 300보다 작은 값만 저장 가능
    mtel varchar2(20),
    mcity varchar2(20) default '서울' not null -- default 를 쓰면 '서울'값이 저장
);

-- 테이블에 데이터를 추가하는 insert문 (p.267)
insert into members values ('winter', '눈송이', 'snow@mycompany.com', 25, '010-1234-1234', '부산'); -- 테이블이름 뒤에 컬럼명을 명시해주지않으면 반드시 테이블 컬럼 개수만큼 값을 입력해줘야함
insert into members values ('spring', '봄돌이', null, 25, null, default); --default를 쓰면 default 값인 '서울'이 들어감
insert into members (mid, mname) values ('summer', '하여름');  -- not null 인 컬럼만 입력해줘도 가능, not null인 컬럼 값은 반드시 있어야함.

select * from members;

create table boards (
    bno number primary key,
    btitle varchar2(100) not null,
    bcontent clob not null,
    bwrite varchar2(20) references members(mid) on delete cascade,  -- members 테이블의 mid를 참조해서 F.K로 지정
    bdate date default sysdate not null                             -- on delete cascade : mid를 삭제할 때 mid를 참조하는 모든 행 자체를 삭제
);                                                                  -- on delete set null : mid를 삭제할 때 mid를 참조하는 값을 null로 바꿈

insert into boards values (1, '제목1', '내용1', 'winter', sysdate); 
insert into boards values (2, '제목2', '내용2', 'winter', '2022.12.25'); --날짜에 '2022/12/25' '2022-12-25'도 가능 / '12.25.2022'은 불가능(년,월,일 순서가 맞아야함)
insert into boards values (3, '제목3', '내용3', 'fall', '2022.12.25');  --(x)members테이블의 mid값에 'fall'이 없기 때문
insert into boards values (3, '제목3', '내용3', 'summer', default);
insert into boards (bno, btitle, bcontent, bwrite) values (4, '제목4', '내용4', 'summer');

-- TO_DATE 함수를 사용하여 날짜 데이터 입력하기 (p.274)
insert into boards values (5, '제목5', '내용5', 'winter', to_date('12.25.2022', 'mm.dd.yyyy'));

-- 서브쿼리를 사용하여 한 번에 여러 데이터 추가하기 (p.275) 참고만 하기
