---------------------------------------------
-- 오라클 함수 : 숫자 함수
---------------------------------------------

-- ROUND : 반올림
select salary, round(salary/31), round(salary/31, 2)
from employees;

-- CEIL : 올림
-- FLOOR : 버림 (몫)
-- MOD : 나머지
-- TRUNC : 버림
select salary, 
        ceil(salary/31) as ceil, 
        floor(salary/31) as floor,
        mod(salary, 31) as mod, 
        trunc(salary/31) as trunc_1,
        trunc(salary/31, 2) as trunc_2
from employees;
