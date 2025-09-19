-- ==========================
-- Sales
-- ==========================
INSERT IGNORE INTO sales (id, customer_id, sale_date, total_amount)
VALUES (1, 1, NOW(), 2580.00);
-- ==========================
-- SaleDetails
INSERT IGNORE INTO sale_details (id, sale_id, product_id, quantity, price)
VALUES (1, 1, 1, 1, 2500.00);

INSERT IGNORE INTO sale_details (id, sale_id, product_id, quantity, price)
VALUES (2, 1, 2, 1, 80.00);