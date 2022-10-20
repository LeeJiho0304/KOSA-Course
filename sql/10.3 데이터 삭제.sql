---------------------------------------------
-- 10. 데이터 추가, 수정 삭제하는 데이터 조작어  
   -- 10.3 테이블에 있는 데이터 삭제하기 (p.283)
--------------------------------------------- 

delete from boards
where bwriter='winter'; -- 메모리상에서만 삭제됨. rollback 가능

delete from members
where mid='winter';  -- mid를 참조하는 테이블에서 on delete cascade 로 되어있으면 해당 값을 가진 '행' 자체가 삭제됨
                     -- mid를 참조하는 테이블에서 on delete set null 로 되어있으면 mid 값이 null로 바뀜

delete from members
where mid in ('summer', 'fall');  -- mid 가 'summer'이거나 'fall'이면 삭제
