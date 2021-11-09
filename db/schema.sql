CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT,
    created TIMESTAMP
);

CREATE TABLE candidates (
    id SERIAL PRIMARY KEY,
    cityId int references cities(id),
    name TEXT,
    created timestamp
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name text,
    email text UNIQUE,
    password text
);

CREATE TABLE cities(
    id SERIAL PRIMARY KEY,
    name text
);