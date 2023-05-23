CREATE TABLE IF NOT EXISTS burger(
id SERIAL PRIMARY KEY,
name VARCHAR not null unique,
description VARCHAR not null,
price VARCHAR not null,
dish_id int references orders(id)
);