CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    user_is_staff BOOLEAN NOT NULL DEFAULT false,
    product_name VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    description TEXT,
    total_quantity INTEGER,
    quantity INTEGER,
    order_quantity INTEGER NOT NULL,
    remark TEXT,
    status VARCHAR(255) NOT NULL
);

DROP TABLE product, users, tickets;

CREATE TABLE users (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    is_staff BOOLEAN      NOT NULL DEFAULT false
);

INSERT INTO users (name, email, password, is_staff)
VALUES
    ('admin', 'admin@admin.com', 'admin', true),
    ('John Doe', 'johndoe@example.com', 'password1', false),
    ('Jane Doe', 'janedoe@example.com', 'password2', true),
    ('Bob Smith', 'bobsmith@example.com', 'password3', false),
    ('Alice Johnson', 'alicejohnson@example.com', 'password4', true),
    ('Mike Brown', 'mikebrown@example.com', 'password5', false),
    ('Sophie Wilson', 'sophiewilson@example.com', 'password6', true),
    ('Tom Green', 'tomgreen@example.com', 'password7', false),
    ('Emma Davis', 'emmadavis@example.com', 'password8', true),
    ('William Parker', 'williamparker@example.com', 'password9', false),
    ('Ella King', 'ellaking@example.com', 'password10', true);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name           VARCHAR(255) NOT NULL ,
    price          NUMERIC(10, 2) NOT NULL ,
    description    TEXT,
    total_quantity INTEGER,
    quantity       INTEGER,
);

INSERT INTO product (name, price, description, total_quantity, quantity)
VALUES
    ('Product 1', 20.00, 'A high-quality product', 10, 10),
    ('Product 2', 15.00, 'A versatile product', 20, 20),
    ('Product 3', 25.00, 'A premium product', 5, 5),
    ('Product 4', 10.00, 'An economical product', 30, 30),
    ('Product 5', 30.00, 'A top-of-the-line product', 15, 15),
    ('Product 6', 35.00, 'A cutting-edge product', 10, 10),
    ('Product 7', 40.00, 'A state-of-the-art product', 5, 5),
    ('Product 8', 45.00, 'A next-generation product', 20, 20),
    ('Product 9', 50.00, 'A revolutionary product', 25, 25),
    ('Product 10', 55.00, 'An industry-leading product', 30, 30);

CREATE TABLE ticket
(
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users,
    product_id INTEGER NOT NULL REFERENCES product,
    quantity INTEGER NOT NULL,
    remark TEXT,
    status VARCHAR(255) NOT NULL,
);

INSERT INTO ticket (user_id, product_id, quantity, remark, status)
VALUES
    (1, 1, 5, 'test remark 1', 'pending'),
    (2, 2, 3, 'test remark 2', 'completed'),
    (3, 3, 7, 'test remark 3', 'pending'),
    (4, 4, 4, 'test remark 4', 'completed'),
    (5, 5, 2, 'test remark 5', 'pending'),
    (6, 6, 1, 'test remark 6', 'completed'),
    (7, 7, 6, 'test remark 7', 'pending'),
    (8, 8, 8, 'test remark 8', 'completed'),
    (9, 9, 10, 'test remark 9', 'pending'),
    (10, 10, 2, 'test remark 10', 'completed');


SELECT AVG(price) as avg_price, name as product_name
FROM product
GROUP BY name
HAVING AVG(price) > 5;

SELECT * FROM product
ORDER BY price DESC;

SELECT users.name as user_name, product.name as product_name, ticket.quantity as order_quantity
FROM users
         JOIN ticket
              ON users.id = ticket.user_id
         JOIN product
              ON ticket.product_id = product.id;

SELECT users.name as user_name, product.name as product_name, ticket.quantity as order_quantity
FROM users
         LEFT JOIN ticket
                   ON users.id = ticket.user_id
         LEFT JOIN product
                   ON ticket.product_id = product.id;

SELECT * FROM product
WHERE price > 5 AND quantity > 0;

SELECT name, price + (price * 0.1) as new_price
FROM product;

SELECT *
FROM product
WHERE name LIKE '%product%';

SELECT to_char(created_at, 'YYYY-MM-DD') as order_date, name as product_name
FROM product;

SELECT *
FROM product
WHERE price BETWEEN 5 AND 15;

SELECT *
FROM product
WHERE name IN ('product1', 'product2', 'product3');

SELECT *
FROM product
UNION
SELECT *
FROM users;

SELECT *
FROM product
WHERE id = (SELECT product_id FROM ticket WHERE user_id = 1);

SELECT *
FROM product
WHERE price > ALL (SELECT price FROM product WHERE quantity < 5);


User Table:

    id: This is the primary key of the table, unique identifier of each user in the table.
    name: The name of the user, this is not null and assumed to be a string of maximum length 255 characters.
    email: The email of the user, this is not null and assumed to be a string of maximum length 255 characters. It is also unique, meaning no two users can have the same email.
    password: The password of the user, this is not null and assumed to be a string of maximum length 255 characters.
    is_staff: The status of the user as staff, assumed to be a boolean value (either true or false). It is not null and has a default value of false.

Product Table:

    id: This is the primary key of the table, unique identifier of each product in the table.
    name: The name of the product, this is not null and assumed to be a string of maximum length 255 characters.
    price: The price of the product, this is not null and assumed to be a numeric value with maximum 10 digits and 2 decimal places.
    description: A brief description of the product, assumed to be a text field.
    total_quantity: Total quantity of the product available, assumed to be an integer.
    quantity: Current quantity of the product available, assumed to be an integer.

Ticket Table:

    id: This is the primary key of the table, unique identifier of each ticket in the table.
    user_id: The foreign key referencing the user table, the user who made the purchase. Assumed to be an integer and not null.
    product_id: The foreign key referencing the product table, the product that was purchased. Assumed to be an integer and not null.
    quantity: The quantity of the product purchased, assumed to be an integer and not null.
    remark: Additional remarks about the purchase, assumed to be a text field.
    status: The status of the purchase, assumed to be a string of maximum length 255 characters and not null.


Functional dependencies in the 1NF table "orders":

    id -> user_name, user_email, user_password, user_is_staff, product_name, price, description, total_quantity, quantity, order_quantity, remark, status
    user_name -> user_email, user_password, user_is_staff
    product_name -> price, description, total_quantity, quantity

Note: These functional dependencies are based on the assumption that each attribute in the table is unique and determines the value of other attributes in the table

To form the tables in 2NF, we need to decompose the 1NF table into multiple tables to remove partial functional dependencies.

Here are the steps to form the 2NF tables:

    Create a table named "user" to store user information. The table will have the following attributes:
        id (Primary Key)
        name
        email
        password
        is_staff

    Create a table named "product" to store product information. The table will have the following attributes:
        id (Primary Key)
        name
        price
        description
        total_quantity
        quantity

    Create a table named "ticket" to store order information. The table will have the following attributes:
        id (Primary Key)
        user_id (Foreign Key referencing the "user" table)
        product_id (Foreign Key referencing the "product" table)
        quantity
        remark
        status

This decomposition helps to ensure that each table contains only non-redundant data and eliminates partial functional dependencies. In this way, we have formed tables that are in 2NF.


        The tables in 2NF can further be normalized to 3NF by removing transitive dependencies. Transitive dependencies occur when there is a non-key attribute that depends on another non-key attribute.

For the orders table, we have the following functional dependencies:

    id -> (user_name, user_email, user_password, user_is_staff, product_name, price, description, total_quantity, quantity, order_quantity, remark, status)
    user_name, user_email -> (user_password, user_is_staff)
    product_name, price, description, total_quantity -> (quantity)

The functional dependency between user_name, user_email and user_password, user_is_staff is a transitive dependency. So we can separate the user information into a separate table.

CREATE TABLE users (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
is_staff BOOLEAN NOT NULL DEFAULT false
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        user_id INTEGER NOT NULL REFERENCES users,
                        product_name VARCHAR(255) NOT NULL,
                        price NUMERIC(10, 2) NOT NULL,
                        description TEXT,
                        total_quantity INTEGER,
                        quantity INTEGER,
                        order_quantity INTEGER NOT NULL,
                        remark TEXT,
                        status VARCHAR(255) NOT NULL
);

The functional dependency between product_name, price, description, total_quantity and quantity is also a transitive dependency. So we can separate the product information into a separate table.

CREATE TABLE product (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL ,
price NUMERIC(10, 2) NOT NULL ,
description TEXT,
total_quantity INTEGER,
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        user_id INTEGER NOT NULL REFERENCES users,
                        product_id INTEGER NOT NULL REFERENCES product,
                        order_quantity INTEGER NOT NULL,
                        remark TEXT,
                        status VARCHAR(255) NOT NULL
);

The above tables are in 3NF as all the non-key attributes depend only on the primary key, and there are no transitive dependencies.
