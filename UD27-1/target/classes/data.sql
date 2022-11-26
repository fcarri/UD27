drop table if exists suministra;
drop table if exists piezas;
drop table if exists proveedores;

create table piezas(codigo int not null auto_increment, nombre varchar(100),
primary key (codigo));

create table proveedores(id int not null auto_increment, nombre varchar(100),
primary key(id));

create table suministra(codigopieza int not null auto_increment, id_proveedor int not null,
precio int, 
foreign key(codigopieza) references piezas(codigo)
on delete cascade on update cascade,
foreign key(id_proveedor) references proveedores(id)
on delete cascade on update cascade); 

create table usuario  (username varchar(50), password varchar(200), role varchar(50),
	primary key(username));

insert into piezas (nombre) values ('pieza1');    
insert into proveedores (nombre) values ('pr1');
insert into suministra (id_proveedor, precio) values (1, 10);

INSERT INTO Usuario (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');