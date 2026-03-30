INSERT INTO customers (customer_name, email, phone)
VALUES ('Иван Иванов', 'ivan@example.com', '+49111111111'),
       ('Мария Петрова', 'maria@example.com', '+49222222222'),
       ('Петр Сидоров', 'petr@example.com', '+49333333333');

INSERT INTO categories (category_name)
VALUES ('Смартфоны'),
       ('Ноутбуки'),
       ('Аксессуары');

INSERT INTO products (product_name, price, stock_qty, category_id)
VALUES ('iPhone 15', 1200.00, 10, 1),
       ('Samsung S24', 1000.00, 8, 1),
       ('MacBook Air', 1500.00, 5, 2),
       ('Чехол iPhone', 20.00, 100, 3);

INSERT INTO orders (customer_id, status)
VALUES (1, 'new'),
       (1, 'paid'),
       (2, 'new'),
       (3, 'cancelled');

INSERT INTO order_items (order_id, product_id, quantity, price_at_moment)
VALUES (1, 1, 1, 1200.00),
       (1, 4, 2, 20.00),
       (2, 3, 1, 1500.00),
       (3, 2, 1, 1000.00);