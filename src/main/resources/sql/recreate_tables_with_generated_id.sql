DROP TABLE cars;
DROP TABLE people;

CREATE SEQUENCE people_id_seq START WITH 1;
CREATE SEQUENCE cars_id_seq START WITH 1;

-- create people table 
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

-- create cars table
CREATE TABLE cars (
	id bigserial not null primary key,
	vin_number varchar(255) not null,
	make varchar(255) not null,
	model varchar(255) not null,
	color varchar(255) not null,
	owner bigint not null
);
-- constrain foreigen key
ALTER TABLE cars
   ADD CONSTRAINT cars_pople_fk FOREIGN KEY (owner)
   	   REFERENCES people(id);

SELECT * FROM people;

INSERT INTO people(full_name, first_name, last_name, age, email, address, zipcode) values
('Bowen Shen', 'Bowen', 'Shen', 24, 'bshen36@gwu.edu', '5597 Seminary Rd', 22041 ),
('Ronny Chow', 'Ronny', 'Chow', 25, 'ronny@gwu.edu', '1900 S Eads St', 22202),
('April Chen', 'April', 'Chen', 21, 'april@gwu.edu', '1900 S Eads St', 22202);

SELECT * FROM cars;

INSERT INTO cars(vin_number, make, model, color, owner) values
('ABWENBSDA124387SA','Toyota','camry','black',1),
('SASD4567W8S56D31F','Honda','civic','white',1),
('A1S5D4E7F23S65DAW','Mazda','3','silver',2),
('WQEQ21A53S4E5WEQE','Ford','mustang','red',3);