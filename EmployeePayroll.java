 UC1--mysql> create database payrollService;
Query OK, 1 row affected (0.03 sec)

mysql> show database;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'database' at line 1
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| addressbook        |
| information_schema |
| mysql              |
| payrollservice     |
| performance_schema |
| sakila             |
| sys                |
| world              |
+--------------------+
8 rows in set (0.01 sec)
UC2

mysql> use payrollservice;
Database changed
mysql>  create table Employee_payroll(
    ->  id int auto_increment primary key,
    -> name varchar (160) not null,
    -> salray double not null,
    -> start_date date not null
    -> );
Query OK, 0 rows affected (0.08 sec)

mysql> desc Employee_payroll;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int          | NO   | PRI | NULL    | auto_increment |
| name       | varchar(160) | NO   |     | NULL    |                |
| salray     | double       | NO   |     | NULL    |                |
| start_date | date         | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql>
 UC3
mysql> insert into Employee_payroll(name,salray,start_date)values
    -> ("bill","400000","2016-08-15"),
    -> ("chali","54200","2018-09-14"),
    -> ("Elon","124500","2020-12-30");
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0
    
UC4

mysql> select * from Employee_payroll;
+----+-------+--------+------------+
| id | name  | salray | start_date |
+----+-------+--------+------------+
|  1 | bill  | 400000 | 2016-08-15 |
|  2 | bill  | 400000 | 2016-08-15 |
|  3 | bill  | 400000 | 2016-08-15 |
|  4 | chali |  54200 | 2018-09-14 |
|  5 | Elon  | 124500 | 2020-12-30 |
+----+-------+--------+------------+
5 rows in set (0.00 sec)
UC5

mysql> select * from Employee_payroll;
+----+-------+--------+------------+
| id | name  | salray | start_date |
+----+-------+--------+------------+
|  1 | bill  | 400000 | 2016-08-15 |
|  2 | bill  | 400000 | 2016-08-15 |
|  3 | bill  | 400000 | 2016-08-15 |
|  4 | chali |  54200 | 2018-09-14 |
|  5 | Elon  | 124500 | 2020-12-30 |
+----+-------+--------+------------+
5 rows in set (0.00 sec)

mysql> select salary from Employee_payroll where name ="bill";
ERROR 1054 (42S22): Unknown column 'salary' in 'field list'
mysql> select salray from Employee_payroll where name ="bill";
+--------+
| salray |
+--------+
| 400000 |
| 400000 |
| 400000 |
+--------+

mysql>  select * from Employee_payroll where start_date between cast("2018-01-01" as date) and date (NOW());
+----+-------+--------+------------+
| id | name  | salray | start_date |
+----+-------+--------+------------+
|  4 | chali |  54200 | 2018-09-14 |
|  5 | Elon  | 124500 | 2020-12-30 |
+----+-------+--------+------------+
2 rows in set (0.00 sec)
UC6
mysql>  alter table Employee_payroll add GENDER char not null after name;
Query OK, 0 rows affected (0.10 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select * from Employee_payroll;
+----+-------+--------+--------+------------+
| id | name  | GENDER | salray | start_date |
+----+-------+--------+--------+------------+
|  1 | bill  |        | 400000 | 2016-08-15 |
|  2 | bill  |        | 400000 | 2016-08-15 |
|  3 | bill  |        | 400000 | 2016-08-15 |
|  4 | chali |        |  54200 | 2018-09-14 |
|  5 | Elon  |        | 124500 | 2020-12-30 |
+----+-------+--------+--------+------------+
5 rows in set (0.00 sec)

mysql> update Employee_payroll set GENDER = 'M' where name = "Bill" or name = "Elon";
Query OK, 4 rows affected (0.01 sec)
Rows matched: 4  Changed: 4  Warnings: 0

mysql> select * from Employee_payroll;
+----+-------+--------+--------+------------+
| id | name  | GENDER | salray | start_date |
+----+-------+--------+--------+------------+
|  1 | bill  | M      | 400000 | 2016-08-15 |
|  2 | bill  | M      | 400000 | 2016-08-15 |
|  3 | bill  | M      | 400000 | 2016-08-15 |
|  4 | chali |        |  54200 | 2018-09-14 |
|  5 | Elon  | M      | 124500 | 2020-12-30 |
+----+-------+--------+--------+------------+
5 rows in set (0.00 sec)

mysql> update Employee_payroll set GENDER = 'M' where id = 2;
Query OK, 0 rows affected (0.00 sec)
Rows matched: 1  Changed: 0  Warnings: 0

mysql> select * from Employee_payroll;
+----+-------+--------+--------+------------+
| id | name  | GENDER | salray | start_date |
+----+-------+--------+--------+------------+
|  1 | bill  | M      | 400000 | 2016-08-15 |
|  2 | bill  | M      | 400000 | 2016-08-15 |
|  3 | bill  | M      | 400000 | 2016-08-15 |
|  4 | chali |        |  54200 | 2018-09-14 |
|  5 | Elon  | M      | 124500 | 2020-12-30 |
+----+-------+--------+--------+------------+
5 rows in set (0.00 sec)

UC7



mysql> insert into Employee_payroll(name,GENDER,salary,start_date)values
    ->  ("Smital","F","25614.00","2018-10-12"),
    -> ("Nandini","F","451200.00","2021-12-30");
ERROR 1054 (42S22): Unknown column 'salary' in 'field list'
mysql> insert into Employee_payroll(name,GENDER,salray,start_date)values
    ->  ("Smital","F","25614.00","2018-10-12"),
    -> ("Nandini","F","451200.00","2021-12-30");
Query OK, 2 rows affected (0.01 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql>  select * from Employee_payroll;
+----+---------+--------+--------+------------+
| id | name    | GENDER | salray | start_date |
+----+---------+--------+--------+------------+
|  1 | bill    | M      | 400000 | 2016-08-15 |
|  2 | bill    | M      | 400000 | 2016-08-15 |
|  3 | bill    | M      | 400000 | 2016-08-15 |
|  4 | chali   |        |  54200 | 2018-09-14 |
|  5 | Elon    | M      | 124500 | 2020-12-30 |
|  6 | Smital  | F      |  25614 | 2018-10-12 |
|  7 | Nandini | F      | 451200 | 2021-12-30 |
+----+---------+--------+--------+------------+
7 rows in set (0.00 sec)

mysql> select sum(salary) from Employee_payroll where GENDER = 'M' group by GENDER;
ERROR 1054 (42S22): Unknown column 'salary' in 'field list'
mysql> select sum(salray) from Employee_payroll where GENDER = 'M' group by GENDER;
+-------------+
| sum(salray) |
+-------------+
|     1324500 |
+-------------+
1 row in set (0.00 sec)

mysql> select sum(salary) from Employee_payroll where GENDER = 'F' group by GENDER;
ERROR 1054 (42S22): Unknown column 'salary' in 'field list'
mysql> select sum(salray) from Employee_payroll where GENDER = 'F' group by GENDER;
+-------------+
| sum(salray) |
+-------------+
|      476814 |
+-------------+
1 row in set (0.00 sec)

mysql>  select avg(salray) from Employee_payroll where GENDER = 'M' group by GENDER;
+-------------+
| avg(salray) |
+-------------+
|      331125 |
+-------------+
1 row in set (0.00 sec)

mysql> select avg(salray) from Employee_payroll where GENDER = 'F' group by GENDER;
+-------------+
| avg(salray) |
+-------------+
|      238407 |
+-------------+
1 row in set (0.00 sec)

mysql> select avg(salray) from Employee_payroll where GENDER = 'F' group by GENDER;
+-------------+
| avg(salray) |
+-------------+
|      238407 |
+-------------+
1 row in set (0.00 sec)

mysql> select min(salray) from Employee_payroll;
+-------------+
| min(salray) |
+-------------+
|       25614 |
+-------------+
1 row in set (0.00 sec)

mysql> select name,GENDER,max(salray) from Employee_payroll group by GENDER;
+--------+--------+-------------+
| name   | GENDER | max(salray) |
+--------+--------+-------------+
| bill   | M      |      400000 |
| chali  |        |       54200 |
| Smital | F      |      451200 |
+--------+--------+-------------+
3 rows in set (0.00 sec)

mysql> select name,GENDER,min(salray) from Employee_payroll group by GENDER;
+--------+--------+-------------+
| name   | GENDER | min(salray) |
+--------+--------+-------------+
| bill   | M      |      124500 |
| chali  |        |       54200 |
| Smital | F      |       25614 |
+--------+--------+-------------+
3 rows in set (0.00 sec)

mysql> select count(salray) from Employee_payroll where GENDER = 'M' group by GENDER;
+---------------+
| count(salray) |
+---------------+
|             4 |
+---------------+
1 row in set (0.00 sec)

mysql> select count(salray) from Employee_payroll where GENDER = 'F' group by GENDER;
+---------------+
| count(salray) |
+---------------+
|             2 |
+---------------+
1 row in set (0.00 sec)

mysql>
