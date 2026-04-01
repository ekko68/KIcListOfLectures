create table springboard(
num number(3) primary key,
author varchar2(15),
title varchar2(50),
content varchar2(4000),
writeday date default sysdate,
readcnt number(4) default 0);
