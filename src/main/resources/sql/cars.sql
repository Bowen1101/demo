CREATE TABLE cars (
	id bigserial not null primary key,
	vin_number varchar(255) not null,
	make varchar(255) not null,
	model varchar(255) not null,
	color varchar(255) not null,
	owner bigint not null
);

ALTER TABLE cars
   ADD CONSTRAINT cars_pople_fk FOREIGN KEY (owner)
   	   REFERENCES people(id);
	   
-- SELECT * FROM cars;

-- INSERT INTO cars(id, vin_number, make, model, color, owner) values
-- (1,'ABWENBSDA124387SA','Toyota','camry','black',1),
-- (2,'SASD4567W8S56D31F','Honda','civic','white',1),
-- (3,'A1S5D4E7F23S65DAW','Mazda','3','silver',2),
-- (4,'WQEQ21A53S4E5WEQE','Ford','mustang','red',3);