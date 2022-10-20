---------------------------------------------
-- 13.4 Sequence (시퀀스)  (p.348)
--------------------------------------------- 

drop table boards;
create table boards (
    bno number primary key,
    btitle varchar(100) not null,
    bcontent clob not null
);

-- Sequence 생성
create sequence seq_boards_bno;

select seq_boards_bno.nextval from dual; -- 계속 1씩 증가함
select seq_boards_bno.currval from dual; -- 현재 seq_boards_bno 번호

insert into boards values (seq_boards_bno.nextval, '제목', '내용');
select * from boards;
-- sequence는 다시 같은 값이 나오면 안될때 사용

create sequence seq_test1;