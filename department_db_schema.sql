create database department_db;
use department_db;

create table department (
	id bigint primary key auto_increment,
    department_name varchar(150) not null unique,
    department_code varchar(50) not null
);