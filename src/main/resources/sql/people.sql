CREATE TABLE people (
id bigserial not null primary key,
full_name varchar(40) not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
age integer not null,
email varchar(50),
address varchar(150),
zipcode integer
);

SELECT * FROM people;

INSERT INTO people(id, full_name, first_name, last_name, age, email, address, zipcode) values
(1, 'Bowen Shen', 'Bowen', 'Shen', 24, 'bshen36@gwu.edu', '5597 Seminary Rd', 22041 ),
(2, 'Ronny Chow', 'Ronny', 'Chow', 25, 'ronny@gwu.edu', '1900 S Eads St', 22202),
(3, 'April Chen', 'April', 'Chen', 21, 'april@gwu.edu', '1900 S Eads St', 22202);