-- 1. Товары дороже 500€, по убыванию цены
SELECT product_name, price
FROM products
WHERE price > 500
ORDER BY price DESC;

-- 2. Заказы с суммой и именем покупателя (JOIN + GROUP BY)
SELECT o.order_id,
       c.customer_name,
       SUM(oi.quantity * oi.price_at_moment) AS total
FROM orders o
         JOIN customers c ON o.customer_id = c.customer_id
         JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY o.order_id, c.customer_name
ORDER BY total DESC;

-- 3. Товары с категориями (LEFT JOIN)
SELECT p.product_name, p.price, c.category_name
FROM products p
         LEFT JOIN categories c ON p.category_id = c.category_id;

-- 4. Обновить статус заказа
UPDATE orders
SET status = 'paid'
WHERE order_id = 1;

-- 5. Удалить товар без заказов
DELETE
FROM products
WHERE product_id = 4;