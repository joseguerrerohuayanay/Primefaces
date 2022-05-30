--mysql: script

CREATE TABLE cliente(

	id Int not null auto_increment,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	dni char(8) not null,
	primari key(id)

);

CREATE TABLE empleado(

	id Int not null auto_increment,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	dni char(8) not null,
	primari key(id)

);