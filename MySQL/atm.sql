use exlbatch;

create table atm(
cardNo bigint(16) primary key,
accHolderName VARCHAR(45),
accNo INT,
accPin INT(4),
initialBal bigint(10) not null,
contactNo bigint(10),
address VARCHAR(45)
);

desc atm;
drop table atm;

INSERT INTO atm VALUES(43462845, 'Jahnavi', 44285675, 2021, 125000, 9012368800, 'Bidar');
INSERT INTO atm VALUES(43456345, 'Chandana', 43457675, 2023, 26500, 9012367897, 'Kalburgi');
INSERT INTO atm VALUES(56712193, 'Karthik', 43274175, 7894, 21650, 98711189, 'DVG');

Select * from atm;