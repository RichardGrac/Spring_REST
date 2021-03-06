-- -- # 1.- Habilitar Federated en Linux:
-- --   #     Agregar linea 'federated' en la Sección "[mysqld]"
-- --   #     nano /etc/mysql/mysql.conf.d/mysqld.cnf
-- -- https://stackoverflow.com/questions/5210309/how-can-i-enable-federated-engine-in-mysql-after-installation?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
-- --
-- -- # 2.- En Server Host agregar Usuario Remoto y darle permisos:
-- -- # CREATE USER 'richardgrac'@'192.168.15.137' IDENTIFIED BY 'Super2017.';
-- -- # GRANT ALL ON proyecto_seguridad.* TO 'richardgrac'@'192.168.15.137';
-- -- # DROP USER 'richardgrac'@'192.168.15.137'; # Para borrar
--
-- -- # 3.- Crear tabla en Host
-- create table employee(
--   id int not null 	primary key,
-- 	email varchar(255) not null,
-- 	name varchar(255) not null,
-- 	lastname varchar(255) not null,
-- 	mobile varchar(255) not null
-- )
-- ENGINE=MyISAM DEFAULT CHARSET=latin1;
--
-- -- # 4.- Generar Tablas Federadas en Clientes
-- -- # En Linux:
-- -- # create table P_Datos_Generales(
-- -- #   id int not null 	primary key,
-- -- # 	name varchar(255) not null,
-- -- # 	lastname varchar(255) not null
-- -- # )ENGINE=FEDERATED DEFAULT CHARSET=latin1
-- -- # CONNECTION='mysql://richardgrac:Super2017.@192.168.15.141:3306/proyecto_seguridad/employee';
--
-- -- # Local:
-- create table P_Datos_Contacto(
--   id int not null 	primary key,
-- 	email varchar(255) not null,
-- 	mobile varchar(255) not null
-- )ENGINE=FEDERATED DEFAULT CHARSET=latin1
-- CONNECTION='mysql://root:admin@localhost:3306/proyecto_seguridad/employee';
--
