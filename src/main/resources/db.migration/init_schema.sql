CREATE TABLE IF NOT EXISTS users (
     id SERIAL PRIMARY KEY,
     email VARCHAR(255) not null,
     name VARCHAR(255) not null,
     password VARCHAR(255) not null,
     role integer not null
);