-- 한줄 주석 
/*
   여러줄 주석 
*/ 

--1.DB생성  create database 생성할 db명;

create database imsi;

--2.DB삭제  drop database 삭제시킬 db명;
drop database imsi;

create database mydb;

use mydb;

--3 테이블 생성->오라클과 형식이 같다(자료형이 틀린것이 있다)
-- number,varchar2
create table sawon
( id int(5) not null, /* 사번 */
  name varchar(13) not null,/*이름 */
  dept varchar(14) not null); 

--4. 테이블의 구조를 확인 desc 테이블명 

desc sawon; 

--5.필드 추가
-- alter table 수정t add column 필드명 데이터형

alter table sawon add column addr varchar(40);

--6.필드를 삭제
--alter table 수정t drop column 삭제할 필드명
alter table sawon drop column addr; 

--7.필드를 변경
--alter table 수정t modify column 변경할 필드명 자료형
alter table sawon modify column dept varchar(30); 

--8.데이터를 입력
insert into sawon values(1,'홍길동','영업부'); 
insert into sawon values(2,'테스트','개발부');
insert into sawon values(3,'임시','관리부');
insert into sawon values(4,'임시2','총무부');
insert into sawon values(5,'테스트2','생산2부');

--9.select
select * from sawon where id=2 or dept='영업부'; 

--10.테이블의 이름을 변경=>rename table 원본t to 변경t명
rename table sawon to test; 
rename table test to sawon; 

--11.테이블의 백업
-- create table 백업t as select * from 원본t 

create table b_sawon as select * from sawon;

--12.필드 정렬-> order by 정렬할 필드명 정렬기준(asc or desc) 
select * from sawon order by id desc; 

--**13.필드명 변경**
--alter table 변경t change 기존필드명 새로운 필드명 자료형

alter table b_sawon change dept deptment varchar(20);

desc b_sawon


 



