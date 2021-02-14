##### What program it is?

this is example of program where we can rent book, similar to libray/book rental. the program use console as menu. theres couple of depedency that i use in this program : 

1. mysql connector = for the database
2. junit jupiter engine and mockito junit jupiter = for testing
3. hibernate core = mapping an object-oriented domain model to a relational database.

and other depedency that you can see in pom.xml



##### How to use

1. make mysql database and name it as "perpus" (without quote)
2. go to hibernate.propertise and change hibernate.hbm2ddl.auto to "create" (without quote)
3. the first time you run it, aplication will automaticly create table(entities) for you.
4. look at your database,  see if the table exist now
5. if it exist, now go to hibernate.propertise and change hibernate.hbm2 to "update" again



##### how to use(other way)

1. i'm include sql file named perpus.sql in same place as readme.md
2. you can import it to your mysql database

