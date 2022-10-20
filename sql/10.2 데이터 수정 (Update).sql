---------------------------------------------
-- 10. 데이터를 추가, 수정, 삭제하는 데이터 조작어(DML)
   -- 10.2 테이블에 있는 데이터 수정하기 (p.277)
--------------------------------------------- 

-- 데이터 일부분만 수정하기
-- 대부분 update 는 where조건에 맞는 값만 수정
  -- mid가 'winter'인 멤버의 memail, mage, mtel 값 변경
update members set memail='ice@mycompany.com', mage=mage+1, mtel='010-321-4321'
where mid='winter';

-- 조건없이 한꺼번에 모두 수정하는 경우 (거의 안씀, 참고만)
  -- 테이블에 새로운 컬럼을 추가하고 싶은데 해당 컬럼을 not null로 만들고 싶은데
  -- 이미 만들어진 테이블에 컬럼을 새로운 추가하는 것이기 때문에 값이 있을 수가 없다.
  -- 따라서 우선은 null 제약조건으로 컬럼을 추가한 후
  -- 해당 컬럼에 대해 값을 모두 일괄적으로 넣어주고 해당 컬럼의 제약조건을 not null로 변경한다.
  
  
-- 서브쿼리를 사용하여 데이터 수정하기
update boards set bwriter = (select mid from members where memail='ice@mycompany.com')
where bwriter = 'winter';