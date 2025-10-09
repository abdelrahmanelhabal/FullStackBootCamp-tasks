CREATE DATABASE IF NOT EXISTS user_information;
USE user_information;

DROP TABLE IF EXISTS User_inf;

CREATE TABLE User_inf (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    birth_date DATE,
    city VARCHAR(100) NOT NULL
);
