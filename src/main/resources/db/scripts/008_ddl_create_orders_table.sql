CREATE TABLE IF NOT EXISTS orders(
id SERIAL PRIMARY KEY,
name VARCHAR not null,
number_order INTEGER not null,
created_date TIMESTAMP not null,
status_order_id int not null references status_orders(id),
customer_id int not null references customers(id),
payment_id int not null references payments(id)
);