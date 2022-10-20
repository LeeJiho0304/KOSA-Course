---------------------------------------------
-- 13.1 데이터베이스를 위한 데이터를 저장한 데이터 사전(p.327)
--------------------------------------------- 

-- 데이터 사전 : system 테이블 
  -- 데이터 사전에 직접적으로 접근해서 변경 못함, 뷰를 통해서 조회만 가능하다
  -- 뷰 : 테이블처럼 사용하지만 테이블이 아닌 select 문. 실제 데이터를 가지고 있지않음. 



---------------------------------------------
-- 13.2 더 빠른 검색을 위한 인덱스 (p.334)
--------------------------------------------- 

-- 인덱스 생성
create index ix_member_mname
on members(mname);

-- 테이블의 primary key와 UNIQUE 제약이 있는 컬럼은 자동으로 UNIQUE 인덱스 생김 

-- select의 where 절에 많이 언급될 경우 인덱스로 만들어서 이용하는 게 좋다.
select * from members where mname like '홍%';

select * from members 
where mtel like '%1234%' and mcity='서울';

create index ix_member_mtel_mcity
on members(mtel, mcity);

-- 인덱스 삭제
drop index ix_member_mtel_mcity;


