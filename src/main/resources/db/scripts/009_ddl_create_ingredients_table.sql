CREATE TABLE IF NOT EXISTS ingredients(
id SERIAL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
price DOUBLE PRECISION NOT NULL,
burger_id int references burgers(id),
ingredient_types_id int references ingredient_types(id)
);