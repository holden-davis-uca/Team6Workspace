/*Holden Davis - Team #6
CSCI 4490 - CRN 30660 - Spring 2022
define.sql - creates the tables for the battleship server
*/

create table users(
    username varchar(30) not null primary key,
    password varbinary(20) not null,
    wins int(10),
    losses int(10)
);