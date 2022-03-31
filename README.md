# Battleship
## About
Semester Project of Team #6 in CSCI 4490, taught by Dr. Smith in Spring 2022 at UCA

* [CSCI 4490 Team #6 Gantt Chart](https://docs.google.com/spreadsheets/d/1rUP5cWph9T2Uh9NK1eyY8VFdHowtq0ac6O3bni1iBjY/edit?usp=sharing)
* [Team Members](https://github.com/CSCI-4490-Team-6/team-composition)

## Database
Database specification and definition is as follows (also contained within db.properties):
* Using XAMMP's MariaDB MySQL distribution running on localhost and opened on port 3306
* Using a space called *student_space*
* Using the username *student* and the password *hello*
* Using the password AES encryption key *midnightexigent*
* For this project, the database will contain a single table: *users*
* The table will consist of three columns:
* > username
* >> Datatype of varchar(30), non-null, first half of primary key
* > password
* >> Datatype of varbinary(20), non-null, second half of primary key
* >> Uses aes_encrypt() for insertion and aes_decrypt for retrieval
* > wlratio
* >> Datatype of double(3,2), non-null
