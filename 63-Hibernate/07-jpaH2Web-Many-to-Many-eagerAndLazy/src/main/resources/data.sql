create table Student(id int primary key,name varchar(50),passport_id int);
create table Passport(id int primary key,number varchar(50));
create table Course(id int primary key,name varchar(50));
create table Review(id int primary key,rating int,description varchar(50),course_id int);
create table STUDENT_COURSE(student_id int,course_id int);

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

insert into Course(id, name)
values(10001,'JPA in 50 Steps');
insert into Course(id, name)
values(10002,'Spring in 50 Steps');
insert into Course(id, name)
values(10003,'Spring Boot in 100 Steps');


insert into Review(id,rating,description,course_id)
values(50001,'5', 'Great Course',10001);
insert into Review(id,rating,description,course_id)
values(50002,'4', 'Wonderful Course',10001);
insert into Review(id,rating,description,course_id)
values(50003,'5', 'Awesome Course',10003);


insert into STUDENT_COURSE(student_id,course_id)
values(20001,10001);
insert into STUDENT_COURSE(student_id,course_id)
values(20002,10001);
insert into STUDENT_COURSE(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);


















