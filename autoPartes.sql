CREATE DATABASE productos;
USE productos;
CREATE TABLE USUARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);
INSERT INTO USUARIO (id, username, password) 
VALUES 
('1','Alisson', 'Ali123');
INSERT INTO USUARIO (username, password) 
VALUES 
('2''Cristian', 'Cris123');
INSERT INTO USUARIO (username, password) 
VALUES 
('3''Melani', 'Mela123');
CREATE TABLE PRODUCTO (
    codigo_producto VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad INT NOT NULL,
    marca VARCHAR(50)
);
INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, marca)
VALUES ('CP001', 'Bateria', 'Encargado de generar electricidad al automovil ', 100 , 1, 'Ecuador');
INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, marca)
VALUES ('CP002', 'Bomba de agua', 'Encargado de que no se recaliente el motor', 40, 2, 'GM');
INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, marca)
VALUES ('CP003', 'Termostato', 'Encargado de enfriar el motor', 20, 1, 'GM');
INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, marca)
VALUES ('CP004', 'Disco de embrage', 'Encargado del funcionamiento de las marchas', 100, 1, 'Valeo');
INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, marca)
VALUES ('CP005', 'Sensor de oxigeno', 'Encargado de controlar la emicion de gases', 75, 1, 'GM');
INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, marca)
VALUES ('CP006', 'Bomba de combustible', 'Encargado de enviar combustible al motor', 40, 1, 'GM');
INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, marca)
VALUES ('CP007','Radiador', 'Encargado de la circulacion de agua en el motor',70 , 1, 'GM');
