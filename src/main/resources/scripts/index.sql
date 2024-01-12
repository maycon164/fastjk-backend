SELECT * FROM users;

insert into users(name, email, type_access) values
('Maycon Huanca', 'mayconfelipe164@gmail.com', 'ADMIN')

select * from product;
file:/C:/Users/maycon/Documents/PROJETOS/fastjk-backend/src/main/resources/db/migration/V1__tables.sql


INSERT INTO product (name, description, quantity, price, bar_code)
VALUES
  ('Product1', 'Description1', 10, 19.99, 'ABC123'),
  ('Product2', 'Description2', 15, 29.99, 'XYZ456'),
  ('Product3', 'Description3', 20, 39.99, '123XYZ');


 INSERT INTO location (name, address)
VALUES ('Location1', '123 Main St, Cityville');

select * from sale

INSERT INTO sale (seller_id, location_id, discount, total, payment_method)
VALUES (1, 1, 0.10, 100.00, 'MONEY');

select * from sale_item;

INSERT INTO sale_item (product_id, quantity, discount, total, sale_id)
VALUES (2, 5, 0.05, 90.00, 3);
