---------------------------------------------
-- 오라클 함수 : 문자 함수
---------------------------------------------

-- upper(대문자로), lower(소문자로), initcap(첫글자만 대문자로)
select last_name, upper(last_name), lower(last_name)
from employees;
-- 조건식에서도 쓸 수 있음
select first_name
from employees
where lower(first_name) like '%st%'; 

select initcap(email)
from employees;

-- LENGTH : 문자열의 길이
create table members (
    mid varchar(50) not null,
    mname varchar(50) not null
);

insert into members values ('fall', '한가을');
commit;
  -- LENGTHB : 문자열의 바이트 수를 반환
select mid, length(mname), lengthb(mname), lengthc(mname)
from members;  

-- SUBSTR : 문자열 자르기
select first_name, substr(first_name, 5) as col1, substr(first_name, -3, 2) as col2
from employees;

-- INSTR : 특정 문자 위치 찾기

-- REPLACE : 특정 문자를 다른 문자로 대치
select phone_number, replace(phone_number, '.', '-')
from employees;

-- LPAD, RPAD : 데이터의 빈 공간을 특정 문자로 채우기
select first_name, RPAD(substr(first_name, 1, 3), 6, '*') as rpad_1 
from employees;
 
-- CONCAT : 문자열을 합치기
select concat(first_name, concat(', ', last_name)) as name 
from employees;
  -- || 연산자
select first_name || ', ' || last_name as name 
from employees;

-- TRIM, LTRIM, RTRIM : 특정 문자를 제거

