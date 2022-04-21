/*Holden Davis - Team #6
CSCI 4490 - CRN 30660 - Spring 2022
project.sql - combines all required database setup functionality into one file

****This file only ever needs to be run once - once the host machine runs it a single time, it will be ready to fully utilize the database without any modification every subsequent time****

*/

drop table users;

create table users(
    username varchar(30) not null primary key,
    password varbinary(20) not null,
    wins int(10),
    losses int(10)
);

insert into users values('Holden', aes_encrypt('Davis13', 'midnightexigent'), 0, 0);
insert into users values('Kevin', aes_encrypt('Butler11', 'midnightexigent'), 0, 0);
insert into users values('Christopher', aes_encrypt('Stinson2', 'midnightexigent'), 0, 0);
insert into users values('Jerry', aes_encrypt('Williams107', 'midnightexigent'), 0, 0);