create database ecomerceDB;
use ecomerceDB;

create table product(
        id int auto_increment primary key ,
        name varchar(255) not null
);

create table product_details(
       id int auto_increment primary key ,
       product_id int not null ,
       name varchar(255) not null ,
       expiration_date date not null,
       manufacturer varchar(255) not null ,
       price double not null ,
       available boolean not null default false,
       foreign key (product_id) references product(id)
);

INSERT INTO ecomerceDB.product (id, name) VALUES (1, 'milk');
INSERT INTO ecomerceDB.product (id, name) VALUES (2, 'fish');
INSERT INTO ecomerceDB.product (id, name) VALUES (3, 'cheese');
INSERT INTO ecomerceDB.product (id, name) VALUES (4, 'chocolate');

INSERT INTO ecomerceDB.product_details (id, product_id, name, expiration_date, manufacturer, price, available) VALUES (1, 1, 'milk', '2024-02-08', 'dina farms', 30, 1);
INSERT INTO ecomerceDB.product_details (id, product_id, name, expiration_date, manufacturer, price, available) VALUES (2, 2, 'fish', '2024-02-15', 'abu elsayed', 100, 1);
INSERT INTO ecomerceDB.product_details (id, product_id, name, expiration_date, manufacturer, price, available) VALUES (3, 3, 'cheese', '2024-06-11', 'dina farms', 50, 1);
INSERT INTO ecomerceDB.product_details (id, product_id, name, expiration_date, manufacturer, price, available) VALUES (4, 4, 'chocolate ', '2024-02-29', 'cadbury', 60, 0);

