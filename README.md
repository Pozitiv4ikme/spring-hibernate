# Stored programs

#### Based on the previous work (back-end with [`Spring Boot + Hibernate`](https://github.com/Pozitiv4ikme/spring-hibernate/tree/lab5)), a number of software structures (triggers, procedures, functions, cursors) should be written for the existing database. For stored procedures, ensure that they are called using backend controllers.

### Task 1
#### Add one additional arbitrary table to the database and link it to another existing table with a `1:M relationship`. However, to ensure value integrity, use triggers instead of a physical foreign key.

### Task 2
#### Stored procedures:
 - Provide parameterized insertion of new values into an arbitrary table.
 - To ensure the implementation of the `M:M connection` between 2 tables, i.e. to insert into the linking table the corresponding tape according to the real-existing values (eg surname, name) in these main tables.
 - Create a package that inserts 10 tapes into an arbitrary DB table in the format <Noname+№>, for example: Noname5, 
   Noname6, Noname7, etc.
 - Write a custom function that will search for `Max, Min, Sum or Avg` for a column of an arbitrary table in the database. Write a procedure that will call this function in `SELECT`.
   - Using a cursor, ensure the dynamic creation of 2 tables with names containing a time stamp, the structure of the tables is identical to any structure of a DB table. Then randomly copy tapes from the parent table to one or the other additional table. Re-starting the procedure again creates new similar tables, in which the data from the parent table will be randomly spread again.
   - Using a cursor, ensure dynamic creation of tables with names+timestamp taken from a column from an arbitrary DB table, with a random number of columns (from 1 to 9). Column names and type are arbitrary.
   - Using a cursor, ensure dynamic creation of databases with names taken from a column from an arbitrary table of the current database, with a random number of tables for each database (from 1 to 9). The structure of the tables is arbitrary. The names of the tables correspond to the name of the database with a serial number from 1 to 9.

### Task 3
#### Write 3 arbitrary triggers for the tables of the current database, as an example you can take the following:
 - The value of a certain column cannot end with two zeros
 - Prohibit any modification of the data in the table
 - Prohibit removal of tapes from the table
 - Ensure a minimum cardinality of 6 tapes for a certain DB table
 - Ensure the cardinality (min=2, max=6) of tapes for a certain database table
 - Create a log table in which to keep logs with a time stamp when data is deleted for a certain table
 - Create a log table in which to keep logs with a time stamp when data is modified for the table
 - For a specific column, provide the input format: 2 arbitrary letters, except M and R + '-' + 3 numbers + '-' + 2 
   numbers
 - For a specific column, provide the input format: 1 letter: A, M or Z + 5 numbers + 2 random letters
 - Only the following names are allowed for a given column: 'Svitlana', 'Petro', 'Olha', 'Taras'.
 - For a specific column, provide the input format:
   the first letter in the value must match the first letter of the value of the adjacent field in the string