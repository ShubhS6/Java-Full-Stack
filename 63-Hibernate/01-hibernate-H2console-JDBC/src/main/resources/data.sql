create table person(id int not null,
name varchar(70),
location varchar(70),
birth_date timestamp,
primary key(id)
);

insert into person(id,name,location,birth_date) values(10001,'Ranga','Hyderabad','2025-01-17 12:30:00');
insert into person(id,name,location,birth_date) values(10002,'Adam','New York','2025-01-17 12:30:00');
insert into person(id,name,location,birth_date) values(10003,'John','London','2025-01-17 12:30:00');