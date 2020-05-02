
PASO 1. Se borra todo el script enviado de principio para el examen por el profesor, seleccionando todo y que la pantalla de la consulta quede en blanco, se borra la base de datos que el profesor tambien envió, cerrando todas las conexiones
existentes en la base de datos, ya que la base de datos creada en el script editado se llama igual, despues hay que conectar otra vez sql 

PASO 2. Se procede a abrir el script Quartino_Enzo_scriptbasededatos.

PASO 3. Una vez abierto se SELECCIONA PRIMERO la linea para crear la base de datos llamada CUENTAS y se ejecuta la consulta
	CREATE DATABASE CUENTAS

Paso 4. SELECCIONAR linea para usar la base de datos CUENTAS y ejecutar consulta
	GO
	USE CUENTAS
	GO

Paso 5. Se SELECCIONAN SOLAMENTE las tablas en el script: Cliente, Moneda, Cuenta, Movimiento, Favoritas y se
	ejecuta la consulta

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

	Create table Favoritas(
	id_favorita int not null primary key identity(1, 1),
	id_cliente int not null,
	id_cuenta int not null
	)

Paso 6. Ahora se procede a crear las llaves foraneas SELECCIONANDO los 3 alter table del script de las tablas
	Cuenta, Movimiento y Favoritas y se ejecuta la consulta


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

Paso 7. Ahora se crean las monedas usadas en el examen, SELECCIONANDO las 4 lineas de "INSERT TO" del script y
	se ejecuta la consulta

	insert into Moneda (nombre_moneda,tipo_de_cambio) values ('USD', 585);
	insert into Moneda (nombre_moneda,tipo_de_cambio) values ('EUR', 720);
	insert into Moneda (nombre_moneda,tipo_de_cambio) values ('CRC', 1);
	insert into Moneda (nombre_moneda,tipo_de_cambio) values ('YEN', 820);



***Favoritas pasó  a ser una tabla intermedia entre Cliente y Cuenta, que va a almacenar varias cuentas con el id
***respectivo del cliente que quiso agregar dicha cuenta a su lista Favorita










