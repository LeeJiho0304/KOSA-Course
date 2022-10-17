---------------------------------------------
-- 오라클 함수 : 날짜 함수
---------------------------------------------

-- SYSDATE : 현재 날짜와 시간
create table boards (
    bno number primary key,
    btitle varchar(50) not null,
    bdate date not null
);

insert into boards
values(1, '제목', sysdate);

select * from boards;

select sysdate from dual;

  --날짜 연산 (일수 기준)
select sysdate + 14 from dual;
select to_date('2022-12-31', 'YYYY-MM-dd') - sysdate from dual;

-- ADD_MONTHS : 몇 개월 이후 날짜 구하기
select sysdate, add_months(sysdate, 1) from dual;

-- MONTHS_BETWEEN : 두 날짜 간의 개월 수 차이 구하기
select months_between(to_date('2022-12-31', 'YYYY-MM-dd'), sysdate) as month from dual;

-- NEXT_DAY : 돌아오는 요일
select sysdate, next_day(sysdate, '금요일') from dual;

-- LAST_DAY : 달의 마지막 날짜
select sysdate, last_day(sysdate) from dual;