CREATE TABLE IF NOT EXISTS burgers(
burger_id SERIAL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
description TEXT NOT NULL,
price DOUBLE PRECISION,
is_spicy BOOLEAN DEFAULT FALSE,
fk_order_id int references orders(order_id)
);