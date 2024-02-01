CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT,
    type_access TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description VARCHAR(50),
    quantity INTEGER,
    price NUMERIC(10,2),
    bar_code VARCHAR(100),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    name TEXT,
    address TEXT
);

CREATE TABLE sale (
    id SERIAL PRIMARY KEY,
    seller_id INTEGER,
    location_id INTEGER,
    discount NUMERIC(10,2),
    total NUMERIC(10,2),
    payment_method TEXT,
    money_received numeric(10, 2),
    change numeric(10, 2),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    FOREIGN KEY (seller_id) REFERENCES users(id),
    FOREIGN KEY (location_id) REFERENCES location(id)
);

CREATE TABLE sale_item(
    id SERIAL PRIMARY KEY,
    product_id INTEGER,
    quantity INTEGER,
    discount NUMERIC(10,2),
    total NUMERIC(10,2),
    sale_id INTEGER,

    FOREIGN KEY (sale_id) REFERENCES sale(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);