---------------------------------------------
-- 오라클 함수 : DECODE 함수와 CASE 문
---------------------------------------------

-- DECODE : 기준이되는 데이터를 먼저 지정한 후 해당 데이터값에 따라 다른 결과를 내보냄
    -- if 조건문 또는 switch-case 조건문과 비슷
select employee_id, first_name, job_id, salary,
    round(
        decode(job_id,
            'AD_VP', salary*1.1,
            'FI_MGR', salary*1.3,
            salary*1.2)
        ) as upsal
from employees
where job_id in ('AD_VP', 'FI_MGR', 'PU_MAN');

-- CASE : 특정 조건에 따라 반환할 데이터를 설정할 때 사용
select employee_id, first_name, job_id, salary,
    case job_id
        when 'AD_VP' then salary*1.1
        when 'FI_MGR' then salary*1.3
        else salary*1.2
    end as upsal
from employees
where job_id in ('AD_VP', 'FI_MGR', 'PU_MAN');

  -- case문은 비교한 기준 데이터를 지정하지 않고 조건으로 사용 가능
select employee_id, first_name, commission_pct,
    case 
        when commission_pct is null then '해당사항없음'
        when commission_pct > 0 then '수당: ' || commission_pct
    end as comm_text
from employees;

-- decode, case 문은 모두 조건별로 동일한 자료형의 데이터를 반환해야 함