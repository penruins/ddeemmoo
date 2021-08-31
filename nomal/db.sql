create database db_user;

create table t_people(
    id bigint not null,
    name varchar(30),
    age int,
    primary key (id)
);