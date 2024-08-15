create schema employee;

-- enter the context of this schema by double clicking on it!

CREATE TABLE `companies` (
  `name` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`name`),
  KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

select * from companies;

insert into companies(name,email,password) values ('Microsoft', 'admin@microsoft.com', 'password');
insert into companies(name,email,password) values ('Intel', 'admin@intel.com', 'shhhhh');
insert into companies(name,email,password) values ('Google', 'admin@google.com', '1234');

select * from companies;

insert into companies(name,email,password) values ('Google2', 'admin@google.com', '1234');

select * from companies;

delete from companies where name = 'Google2';

select * from companies;




