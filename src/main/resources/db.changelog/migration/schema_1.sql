CREATE SCHEMA IF NOT EXISTS public;
create table public.Persons (
           name varchar(50) not Null,
           surname varchar(100) not Null,
           age int check (age > 0 and age < 150),
           phone_number int not Null,
           city_of_living varchar(50) not Null,
           PRIMARY KEY (name, surname, age)
);
-- rollback drop table hw_netology.CUSTUMERS;