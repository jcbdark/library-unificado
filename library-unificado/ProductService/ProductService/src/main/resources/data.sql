-- Categorías
INSERT INTO category (name) VALUES ('Útiles Escolares');
INSERT INTO category (name) VALUES ('Tecnología');
INSERT INTO category (name) VALUES ('Papelería');

-- Productos (fíjate que category_id sí lo ponemos porque es FK)
INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Cuaderno A4', 'Cuaderno tamaño A4', 5.50, 100, 1, true);

INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Lápiz HB', 'Lápiz estándar HB', 1.20, 200, 1, true);

INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Laptop', 'Laptop de oficina', 1200.50, 0, 2, true);

INSERT INTO product (name, description, price, stock, category_id, active)
VALUES ('Mouse inalámbrico', 'Mouse óptico', 25.00, 0, 2, true);
