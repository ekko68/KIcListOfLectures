create table phone(
  productnum number primary key,
  model varchar2(20) not null,
  company varchar2(10) not null,
  price number(10) not null,
  color varchar2(10) not null,
  image varchar2(15) not null
);