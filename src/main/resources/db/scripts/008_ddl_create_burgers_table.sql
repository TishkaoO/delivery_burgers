CREATE TABLE IF NOT EXISTS burgers(
id SERIAL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
description TEXT NOT NULL,
price DOUBLE PRECISION,
is_spicy BOOLEAN DEFAULT FALSE,
order_id int references orders(id)
);