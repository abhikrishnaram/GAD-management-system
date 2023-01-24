CREATE TABLE users (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    is_staff BOOLEAN      NOT NULL DEFAULT false
);

INSERT INTO users(name, email, password) VALUES ('admin', 'admin@admin.com', 'admin');
