create table Student(id int primary key,name varchar(50),passport_id int);
create table Passport(id int primary key,number varchar(50));


insert into Passport(id,number)
values(40001,'E123456');
insert into Passport(id,number)
values(40002,'N123457');
insert into Passport(id,number)
values(40003,'L123890');

insert into Student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into Student(id,name,passport_id)
values(20002,'Adam',40002);
insert into Student(id,name,passport_id)
values(20003,'Jane',40003);