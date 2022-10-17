---------------------------------------------
-- 오라클 함수 : NULL 처리 함수
---------------------------------------------

select 10 + null from dual; -- 연산식에 null 이 포함되면 값은 null 이 나옴
select salary*12 + commission_pct*salary from employees;

-- NVL(expr1, expr2) : expr1 이 NULL 이면 expr2 리턴, NULL 이 아니면 expr1 그대로
select 10 + nvl(null, 0) from dual;
select salary*12 + nvl(commission_pct, 0)*salary from employees;

-- NVL2(expr1, expr2, expr3) : expr1 이 NULL 이면 expr2 리턴, NULL 이 아니면 expr3 리턴
select salary*12 + nvl(commission_pct, commission_pct*salary ,0) 
from employees;

