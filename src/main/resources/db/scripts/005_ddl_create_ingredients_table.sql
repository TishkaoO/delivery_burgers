CREATE TABLE IF NOT EXISTS ingredients(
ingredient_id SERIAL PRIMARY KEY,
name VARCHAR(30) NOT NULL,
price DOUBLE PRECISION NOT NULL,
fk_burger_id int references burgers(burger_id),
fk_ingredient_type_id int references ingredients_type(ingredient_type_id)
);