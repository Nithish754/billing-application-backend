INSERT INTO fertilizers (
    name,
    unit,
    price,
    quantity,
    total_stock,
    new_stock_added,
    manufacture_date,
    expiry_date
)
VALUES
('Urea', 'KG', 260.00, 45, 100, 0, '2024-01-15', '2026-01-14'),
('DAP Fertilizer', 'KG', 1350.75, 50, 100, 0, '2024-02-10', '2026-02-09'),
('MOP Fertilizer', 'KG', 1100.00, 50, 100, 0, '2024-03-01', '2026-02-28'),
('NPK 19-19-19', 'KG', 1450.50, 50, 100, 0, '2024-02-20', '2026-02-19'),
('SSP Fertilizer', 'KG', 450.00, 50, 100, 0, '2024-01-05', '2026-01-04'),
('Ammonium Sulphate', 'KG', 520.00, 50, 100, 0, '2024-01-25', '2026-01-24'),
('Calcium Nitrate', 'KG', 980.00, 50, 100, 0, '2024-03-10', '2026-03-09'),
('Potash Fertilizer', 'KG', 1650.00, 50, 100, 0, '2024-02-05', '2026-02-04'),
('Zinc Sulphate', 'KG', 1250.00, 50, 100, 0, '2024-03-15', '2026-03-14');




INSERT INTO pesticides
(expiry_date, id, manufacture_date, new_stock_added, price, quantity, total_stock, name, unit)
VALUES
('2026-01-04', 1, '2024-01-05', 0, 780, 1, 100, 'Cypermethrin', 'LITRE'),
('2026-02-11', 2, '2024-02-12', 0, 560.5, 1, 100, 'Acephate', 'KG'),
('2026-03-17', 3, '2024-03-18', 0, 920, 500, 100, 'Imidacloprid', 'ML');



INSERT INTO seeds
(expiry_date, id, manufacture_date, new_stock_added, price, quantity, total_stock, name, unit)
VALUES
('2025-12-31', 1, '2024-01-20', 0, 550, 1, 100, 'Cotton Seed', 'PACKET'),
('2025-11-30', 2, '2024-02-01', 0, 480, 10, 100, 'Paddy Seed', 'KG'),
('2025-12-15', 3, '2024-02-25', 0, 620, 5, 100, 'Maize Seed', 'KG');

