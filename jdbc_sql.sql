create database core_java_jdbc;
use core_java_jdbc;
create table employee
(
	emp_id int primary key auto_increment,
    first_name varchar (50) not null,
    last_name varchar (50) not null,
    email varchar(60) unique not null,
    gender varchar(10),
    created_at datetime default now(),
    updated_at datetime on update now() default null
);

insert into employee (first_name, last_name, email, gender)
values 
("Abdul Gani","Memon","memon12@gmail.com","Male"),
("Satish","Sharma","satishsh123@gmail.com","Male"),
("Rohini","Yadav","rohiniyadav3@gmail.com","Female");

select * from employee;

update employee
set email = "abdulgani12@gmail.com"
where emp_id = 1;

select * from employee;