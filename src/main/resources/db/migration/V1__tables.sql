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
    price NUMERIC(5,2),
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
    product_id INTEGER,
    seller_id INTEGER,
    location_id INTEGER,
    quantity INTEGER,
    discount NUMERIC(5,2),
    total NUMERIC(5,2),
    payment_method TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);