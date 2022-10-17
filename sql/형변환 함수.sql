---------------------------------------------
-- 오라클 함수 : 형 변환 함수
---------------------------------------------

-- TO CAHR : 날자, 숫자 데이터를 문자 데이터로 변환
select to_char(sysdate, 'yyyy.mm.dd hh24:mi:ss am') from dual;

select to_char(salary, 'L99,999.00') as salary from employees;

-- TO_NUMBER : 문자 데이터를 숫자 데이터로 변환

-- TO_DATE : 문자 데이터를 날짜 데이터로 변환
    -- 변환이 가능한 타입은 묵시적으로 수행됨
insert into boards values(2, '제목2', '2022.10.17');
select * from boards where bdate='2022.10.17'; --(o)
select * from boards where bdate >= '2022.1.16'; --(o)

select '2022.12.31' - sysdate from dual; --(x)
select to_date('2022.12.31', 'YYYY.MM.dd') - sysdate from dual;