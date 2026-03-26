CREATE TABLE customers
(
    customer_id   SERIAL PRIMARY KEY,
    customer_name VARCHAR(100)        NOT NULL,
    email         VARCHAR(100) UNIQUE NOT NULL,
    phone         VARCHAR(20),
    created_at    TIMESTAMP DEFAULT NOW()
);

CREATE TABLE categories
(
    category_id   SERIAL PRIMARY KEY,
    category_name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE products
(
    product_id   SERIAL PRIMARY KEY,
    product_name VARCHAR(150)   NOT NULL,
    price        NUMERIC(10, 2) NOT NULL CHECK (price >= 0),
    stock_qty    INTEGER        NOT NULL CHECK (stock_qty >= 0),
    category_id  INTEGER REFERENCES categories (category_id)
);

CREATE TABLE orders
(
    order_id    SERIAL PRIMARY KEY,
    customer_id INTEGER     NOT NULL REFERENCES customers (customer_id),
    order_date  TIMESTAMP   NOT NULL DEFAULT NOW(),
    status      VARCHAR(20) NOT NULL DEFAULT 'new'
);

CREATE TABLE order_items
(
    order_id        INTEGER        NOT NULL REFERENCES orders (order_id),
    product_id      INTEGER        NOT NULL REFERENCES products (product_id),
    quantity        INTEGER        NOT NULL CHECK (quantity > 0),
    price_at_moment NUMERIC(10, 2) NOT NULL CHECK (price_at_moment >= 0),
    PRIMARY KEY (order_id, product_id)
);