CREATE TABLE IF NOT EXISTS users (
     id serial PRIMARY KEY,
     email VARCHAR(255),
     name VARCHAR(255),
     password VARCHAR(255),
     role VARCHAR(255)
);

INSERT INTO users(id, email, name, password, role)
VALUES ((select coalesce(max(id)+1, 1) from users), 'james19@example.com', 'James Smith', 'james123', 'USER');

INSERT INTO users(id, email, name, password, role)
VALUES ((select coalesce(max(id)+1, 1) from users), 'luis.seidel@example.com', 'Luis Seidel', 'teste123', 'USER');