create database employee_db;
use employee_db;

create table employees (
	id bigint primary key auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(150) not null unique,
    department_code varchar(50) not null
);