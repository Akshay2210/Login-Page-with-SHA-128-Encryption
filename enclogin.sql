#enclogin.sql
create database emp2;
use emp2;
create table employee (id int(20),name varchar(100),password varchar(100));
insert into employee values (1,"admin",sha1("admin12345"));
select * from employee;
