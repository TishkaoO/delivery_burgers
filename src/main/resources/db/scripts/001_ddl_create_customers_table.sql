CREATE TABLE IF NOT EXISTS customers(
id SERIAL PRIMARY KEY,
user_name VARCHAR not null unique,
password VARCHAR not null,
phone_number VARCHAR not null
);