CREATE TABLE IF NOT EXISTS roles (
    id serial PRIMARY KEY,
    name varchar(255) not null
);

CREATE TABLE IF NOT EXISTS users (
     id SERIAL PRIMARY KEY,
     email VARCHAR(255) not null,
     name VARCHAR(255) not null,
     password VARCHAR(255) not null
);

CREATE TABLE IF NOT EXISTS users_roles (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id),
    role_id INTEGER NOT NULL REFERENCES roles(id)
);

INSERT INTO roles VALUES ('USER'), ('ADMIN');

INSERT INTO users VALUES
 ('james19@example.com', 'James Smith', 'james123'),
 ('luis.seidel@example.com', 'Luis Seidel', 'teste123');

INSERT INTO users_roles VALUES
((select u.id from users u where u.email = 'james19@example.com'), 'USER'),
((select u.id from users u where u.email = 'luis.seidel@example.com'), 'ADMIN');