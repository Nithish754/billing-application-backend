-- =========================
-- FERTILIZERS
-- =========================
INSERT INTO fertilizers (
    id,
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
(1, 'Urea', 'KG', 260.00, 45, 100, 0, '2024-01-15', '2026-01-14'),
(2, 'DAP Fertilizer', 'KG', 1350.75, 50, 100, 0, '2024-02-10', '2026-02-09'),
(3, 'MOP Fertilizer', 'KG', 1100.00, 50, 100, 0, '2024-03-01', '2026-02-28'),
(4, 'NPK 19-19-19', 'KG', 1450.50, 50, 100, 0, '2024-02-20', '2026-02-19'),
(5, 'SSP Fertilizer', 'KG', 450.00, 50, 100, 0, '2024-01-05', '2026-01-04'),
(6, 'Ammonium Sulphate', 'KG', 520.00, 50, 100, 0, '2024-01-25', '2026-01-24'),
(7, 'Calcium Nitrate', 'KG', 980.00, 50, 100, 0, '2024-03-10', '2026-03-09'),
(8, 'Potash Fertilizer', 'KG', 1650.00, 50, 100, 0, '2024-02-05', '2026-02-04'),
(9, 'Zinc Sulphate', 'KG', 1250.00, 50, 100, 0, '2024-03-15', '2026-03-14')
ON CONFLICT (id) DO NOTHING;

-- =========================
-- PESTICIDES
-- =========================
INSERT INTO pesticides (
    id,
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
(1, 'Cypermethrin', 'LITRE', 780.00, 1, 100, 0, '2024-01-05', '2026-01-04'),
(2, 'Acephate', 'KG', 560.50, 1, 100, 0, '2024-02-12', '2026-02-11'),
(3, 'Imidacloprid', 'ML', 920.00, 500, 100, 0, '2024-03-18', '2026-03-17')
ON CONFLICT (id) DO NOTHING;

-- =========================
-- SEEDS
-- =========================
INSERT INTO seeds (
    id,
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
(1, 'Cotton Seed', 'PACKET', 550.00, 1, 100, 0, '2024-01-20', '2025-12-31'),
(2, 'Paddy Seed', 'KG', 480.00, 10, 100, 0, '2024-02-01', '2025-11-30'),
(3, 'Maize Seed', 'KG', 620.00, 5, 100, 0, '2024-02-25', '2025-12-15')
ON CONFLICT (id) DO NOTHING;
