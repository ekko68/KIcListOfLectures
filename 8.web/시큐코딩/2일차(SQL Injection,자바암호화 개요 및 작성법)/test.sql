create table test(id int,name varchar(10),passwd varchar(10));

select * from test;

insert into test(id,name,passwd) values(1,'test','123456');
insert into test(id,name,passwd) values(2,'kkk','pass');
insert into test(id,name,passwd) values(3,'imsi','testkim');

select * from test;

commit;
