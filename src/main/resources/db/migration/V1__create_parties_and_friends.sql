CREATE TABLE parties(
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description TEXT,
location VARCHAR(255)
);

CREATE TABLE friends (
id SERIAL PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL
);