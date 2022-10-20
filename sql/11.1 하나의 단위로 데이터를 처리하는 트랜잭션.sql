---------------------------------------------
-- 11.1 하나의 단위로 데이터를 처리하는 트랜잭션 (p.291)
--------------------------------------------- 

-- 트랜잭션은 모두 성공처리하거나 모두 실패처리하는 것. (All or Nothing)
-- DML : insert, update, delete)
-- DDL : create, alter, drop
-- DQL : select
-- DCL : grant, revoke
-- !트랜잭션에 쓰임! TCL : commit, rollback, save point

create table accounts (
    ano varchar2(15) primary key,
    owner varchar2(10) not null,
    balance number not null
);

-- 트랜잭션 시작
insert into accounts values ('111-111', '홍길동', 10000);
insert into accounts values ('111-222', '감자바', 0);
commit;  -- 기존 트랜잭션 끝남
-- 트랜잭션 종료

-- 트랜잭션 시작
update accounts set balance=balance-1000 where ano = '111-111';
update accounts set balance=balance+1000 where ano = '111-222';
rollback;
-- 트랜잭션 종료


-- SAVE POINT
-- 트랜잭션 시작
insert into accounts values ('111-113', '홍길서', 10000);
insert into accounts values ('111-114', '홍길남', 0);

savepoint insertedPoint;  -- rollback 할 지점 정해주기 

update accounts set balance=balance-1000 where ano='111-113';
update accounts set balance=balance+1000 where ano='111-114';

savepoint updatePoint;  -- rollback 할 지점 정해주기 

delete from acouunts where ano='111-114';  

rollback to updatePoint;  -- updatePoint 지점까지 돌아감. 즉 삭제(delete) 전 지점으로 (insert, update까지 완료한 상태)
-- 그냥 rollback 하면 insert문 전으로 돌아감. 중간에 commit 이 없기 때문

