CREATE TABLE IF NOT EXISTS payments(
id SERIAL PRIMARY KEY,
paymentAmount INTEGER not null,
card_id int not null references cards(id),
customer_id int not null references customers(id)
);