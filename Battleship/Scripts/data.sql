/*Holden Davis - Team #6
CSCI 4490 - CRN 30660 - Spring 2022
data.sql - Provides example data in insertion form for the battleship server
*/

insert into users values('Holden', aes_encrypt('Davis13', 'midnightexigent'), 0, 0);
insert into users values('Kevin', aes_encrypt('Butler11', 'midnightexigent'), 1, 5);
insert into users values('Christopher', aes_encrypt('Stinson2', 'midnightexigent'), 3, 7);
insert into users values('Jerry', aes_encrypt('Williams107', 'midnightexigent'), 99, 0);
insert into users values('Austin', aes_encrypt('Gilbert4', 'midnightexigent'), 3, 56);