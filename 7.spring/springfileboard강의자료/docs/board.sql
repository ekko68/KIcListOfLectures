create table springboard(
  seq number primary key,
  writer varchar2(50) not null,
  title varchar2(100) not null,
  content clob not null,
  pwd varchar2(10) not null,
  hit number(5) not null,
  regdate date not null,
  filename varchar2(100)
)

create sequence board_seq;