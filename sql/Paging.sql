---------------------------------------------
-- ROWNUM  (p.344)
--------------------------------------------- 

-- rownum 은 데이터를 읽어오는 순서대로 번호를 매김

select employee_id, first_name
from employees;
--
select rownum, employee_id, first_name
from employees;
-- 
select rownum, employee_id, first_name
from employees
order by employee_id;  -- 테이블에서 데이터를 가지고 온 후에 정렬을 하므로 rownum 이 정렬이 안된다.
--
select rownum, first_name, salary
from employees
order by salary;
-- 실제 테이블에서 데이터를 가지고 온 다음에 메모리에서 정렬을 함
-- rownum은 order by 하기 전에 적용됨
-- 데이터를 가져오는 순서대로 rownum을 매김

select rownum, first_name, salary
from (
    select first_name, salary
    from employees
    order by salary
);

-- 회사에서 봉급이 가장 낮은 5명을 출력
select rownum, first_name, salary
from (
    select first_name, salary
    from employees
    order by salary
)
where rownum <= 5;
--
select rownum, first_name, salary
from (
    select first_name, salary
    from employees
    order by salary
)
where rownum > 5; --(x) rownum은 데이터를 가지고 올 때 매겨지는데 값이 매겨지기도 전에 조건을 비교할 수 없다.
-- row보다 작은건(<=row) 비교 가능한데, row보다 큰거(>)는 불가능




---------------------------------------------
-- Paging (페이징) 처리
--------------------------------------------- 

-- 함수(rownum)는 alias (별칭) 정해줘야함

-- 한 페이지는 10개의 행으로 - (1페이지:1~10행, 2페이지:11~20헹, 3페이지:21~30행, ... )
-- 예시. 3페이지 행 불러오기(row_num 21~30)
select rnum, employee_id, first_name
from (
    select rownum as rnum, employee_id, first_name
    from (
        select employee_id, first_name
        from employees
        order by employee_id
    )
    where rownum <= 30  --(pageNo * rowsPerPage)
)
where rnum >= 21;  --(pageNo-1)* rowsPerPage + 1

/* Pager 설명

[처음] 1, 2, 3, 4, 5 [다음][맨끝]              --1그룹
[처음][이전] 6, 7, 8, 9, 10 [다음][맨끝]        --2그룹
[처음][이전] 11, 12, 13, 14, 15 [다음][맨끝]    --3그룹
...
[처음][이전] 96, 97 [맨끝]

페이지당 행수(rowsPerPage) : 10 행
그룹당 페이지 수(pagesPerGroup) : 5 페이지

전체 행수(totalRows) : 963 행  select count(*) from table

전체 페이지수 : Math.ceil( (double) totalRows / rowsPerPage )
각 페이지 시작 번호 : (page-1) * rowsPerPage + 1
각 페이지 끝 번호 : page * rowsPerPage
각 그룹의 시작 페이지 번호 : (gruop-1) * pagesPerGroup + 1   // 1, 6, 11
각 그룹의 끝 페이지 번호: group * pagesPerGroup

*/


