DROP DATABASE IF EXISTS  Vehicles_System_db;

CREATE DATABASE Vehicles_System_db;

USE Vehicles_System_db;

CREATE TABLE Vehicles(
    id INT(15) PRIMARY KEY AUTO_INCREMENT,
    brand VARCHAR(30),
    type VARCHAR(30)
);

