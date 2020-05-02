CREATE DATABASE CUENTAS
GO
USE CUENTAS
GO

  Create table Cliente(
  id_cliente int not null primary key identity(1, 1),
  identificacion varchar(20) not null,
  nombre_completo varchar(100),
  nombre_usuario varchar(20),
  clave varchar(10)
  )
  Create table Moneda(
  id_moneda int not null primary key identity(1, 1),
  nombre_moneda varchar(20) not null,
  tipo_de_cambio int not null 
  )

Create table Cuenta(
id_cuenta int not null primary key identity(1, 1),
numero_cuenta varchar(20) not null,
saldo int not null,
id_cliente int not null,
id_moneda int not null
)

Create table Movimiento(
id_movimiento int not null primary key identity(1, 1),
tipo_de_transferencia varchar(20) not null,
monto int,
fecha date not null,
id_moneda int not null,
id_cuenta int not null
)

Create table Favoritas(
id_favorita int not null primary key identity(1, 1),
id_cliente int not null,
id_cuenta int not null
)
Alter table Cuenta
ADD 
	FOREIGN KEY (id_cliente) references Cliente(id_cliente),
	FOREIGN KEY(id_moneda) references Moneda (id_moneda)

Alter table Movimiento
ADD 
	FOREIGN KEY(id_moneda) references Moneda(id_moneda), 
	FOREIGN KEY (id_cuenta) references Cuenta(id_cuenta)

Alter table Favoritas
ADD 
	FOREIGN KEY (id_cuenta) references Cuenta(id_cuenta),
	FOREIGN KEY (id_cliente) references Cliente(id_cliente)

	

insert into Moneda (nombre_moneda,tipo_de_cambio) values ('USD', 585);
insert into Moneda (nombre_moneda,tipo_de_cambio) values ('EUR', 720);
insert into Moneda (nombre_moneda,tipo_de_cambio) values ('CRC', 1);
insert into Moneda (nombre_moneda,tipo_de_cambio) values ('YEN', 820);

