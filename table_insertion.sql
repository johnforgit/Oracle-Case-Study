-- Insert dummy data into PRODUCT with explicit prod_id
INSERT INTO PRODUCT (prod_id, prod_type, description) VALUES
(1, 'Loan', 'Personal loan product'),
(2, 'Deposit', 'Savings account'),
(3, 'Bond', 'Corporate bond'),
(4, 'Mortgage', 'Home mortgage'),
(5, 'CD', 'Certificate of deposit'),
(6, 'Equity', 'Equity investment'),
(7, 'Derivative', 'Interest rate swap'),
(8, 'Treasury', 'Government bond'),
(9, 'CreditCard', 'Credit card product'),
(10, 'Lease', 'Equipment lease');

-- Insert dummy data into ASSET with explicit asset_id
INSERT INTO ASSET (asset_id, asset_type, asset_value, maturity_date, interest_rate, duration, book_value, is_tangible, asset_status, prod_id, is_rate_sensitive) VALUES
(1, 'Corporate Loan', 1000000, '2027-12-31', 0.0450, 3.5, 980000.00, TRUE, 'Active', 1, TRUE),
(2, 'Savings Deposit', 500000, '2025-05-01', 0.0150, 0.5, 500000.00, FALSE, 'Active', 2, FALSE),
(3, 'Corporate Bond', 2000000, '2030-06-30', 0.0350, 7.0, 1950000.00, FALSE, 'Active', 3, TRUE),
(4, 'Residential Mortgage', 1500000, '2040-10-15', 0.0375, 15.0, 1480000.00, TRUE, 'Active', 4, TRUE),
(5, 'CD', 300000, '2026-03-20', 0.0200, 1.0, 300000.00, FALSE, 'Active', 5, FALSE),
(6, 'Stock', 800000, NULL, NULL, NULL, 800000.00, FALSE, 'Active', 6, FALSE),
(7, 'IRS Swap', NULL, '2028-11-30', NULL, 5.0, NULL, FALSE, 'Active', 7, TRUE),
(8, 'Treasury Bond', 1200000, '2029-09-01', 0.0250, 6.0, 1180000.00, FALSE, 'Active', 8, TRUE),
(9, 'Credit Card Receivable', 250000, NULL, 0.18, NULL, 240000.00, FALSE, 'Active', 9, TRUE),
(10, 'Equipment Lease', 400000, '2027-07-15', 0.06, 4.0, 390000.00, TRUE, 'Active', 10, TRUE);

-- Insert dummy data into LIABILITY with explicit liability_id
INSERT INTO LIABILITY (liability_id, liability_type, liability_value, maturity_date, interest_rate, duration, is_current, is_short_term, liability_status, prod_id, is_rate_sensitive) VALUES
(1, 'Short Term Loan', 700000, '2025-12-31', 0.0350, 1.0, TRUE, TRUE, 'Active', 1, TRUE),
(2, 'Customer Deposit', 1000000, NULL, 0.0100, NULL, TRUE, FALSE, 'Active', 2, FALSE),
(3, 'Corporate Bond Issued', 1500000, '2031-08-15', 0.0400, 7.5, FALSE, FALSE, 'Active', 3, TRUE),
(4, 'Mortgage Payable', 1400000, '2040-10-15', 0.0380, 15.0, FALSE, FALSE, 'Active', 4, TRUE),
(5, 'CD Liability', 300000, '2026-03-20', 0.0220, 1.0, TRUE, TRUE, 'Active', 5, FALSE),
(6, 'Equity Financing', 900000, NULL, NULL, NULL, FALSE, FALSE, 'Active', 6, FALSE),
(7, 'IRS Swap Payable', NULL, '2028-11-30', NULL, 5.0, FALSE, FALSE, 'Active', 7, TRUE),
(8, 'Treasury Note Payable', 1100000, '2029-09-01', 0.0280, 6.0, FALSE, FALSE, 'Active', 8, TRUE),
(9, 'Credit Card Debt', 260000, NULL, 0.1850, NULL, TRUE, FALSE, 'Active', 9, TRUE),
(10, 'Lease Obligation', 380000, '2027-07-15', 0.0580, 4.0, FALSE, FALSE, 'Active', 10, TRUE);

-- Insert dummy data into TIME_BUCKET with explicit bucket_id
INSERT INTO TIME_BUCKET (bucket_id, label, start_date, end_date) VALUES
(1, 'Q1 2025', '2025-01-01', '2025-03-31'),
(2, 'Q2 2025', '2025-04-01', '2025-06-30'),
(3, 'Q3 2025', '2025-07-01', '2025-09-30'),
(4, 'Q4 2025', '2025-10-01', '2025-12-31'),
(5, 'Q1 2026', '2026-01-01', '2026-03-31'),
(6, 'Q2 2026', '2026-04-01', '2026-06-30'),
(7, 'Q3 2026', '2026-07-01', '2026-09-30'),
(8, 'Q4 2026', '2026-10-01', '2026-12-31'),
(9, 'Q1 2027', '2027-01-01', '2027-03-31'),
(10, 'Q2 2027', '2027-04-01', '2027-06-30');

-- Insert dummy data into INTEREST_INCOME_EXPENSE with explicit id
INSERT INTO INTEREST_INCOME_EXPENSE (id, asset_id, liability_id, entry_type, period, amount) VALUES
(1, 1, NULL, 'income', '2025-03-31', 11250.00),
(2, NULL, 1, 'expense', '2025-03-31', 6125.00),
(3, 3, NULL, 'income', '2025-06-30', 17500.00),
(4, NULL, 3, 'expense', '2025-06-30', 15000.00),
(5, 4, NULL, 'income', '2025-09-30', 14062.50),
(6, NULL, 4, 'expense', '2025-09-30', 13320.00),
(7, 6, NULL, 'income', '2025-12-31', 0.00),
(8, NULL, 6, 'expense', '2025-12-31', 0.00),
(9, 10, NULL, 'income', '2025-12-31', 24000.00),
(10, NULL, 10, 'expense', '2025-12-31', 22040.00);

-- Insert dummy data into MATURING_CASH_FLOW with explicit flow_id
INSERT INTO MATURING_CASH_FLOW (flow_id, asset_id, liability_id, bucket_id, amount, inflow_or_outflow) VALUES
(1, 1, NULL, 1, 100000.00, 'inflow'),
(2, NULL, 1, 1, 70000.00, 'outflow'),
(3, 3, NULL, 4, 200000.00, 'inflow'),
(4, NULL, 3, 4, 150000.00, 'outflow'),
(5, 4, NULL, 10, 150000.00, 'inflow'),
(6, NULL, 4, 10, 140000.00, 'outflow'),
(7, 6, NULL, 3, 80000.00, 'inflow'),
(8, NULL, 6, 3, 90000.00, 'outflow'),
(9, 10, NULL, 2, 40000.00, 'inflow'),
(10, NULL, 10, 2, 38000.00, 'outflow');

-- Insert dummy data into DURATION_METRIC with explicit duration_id
INSERT INTO DURATION_METRIC (duration_id, asset_id, liability_id, reporting_date, duration_value) VALUES
(1, 1, NULL, '2025-06-30', 3.5),
(2, NULL, 1, '2025-06-30', 1.0),
(3, 3, NULL, '2025-06-30', 7.0),
(4, NULL, 3, '2025-06-30', 7.5),
(5, 4, NULL, '2025-06-30', 15.0),
(6, NULL, 4, '2025-06-30', 15.0),
(7, 6, NULL, '2025-06-30', NULL),
(8, NULL, 6, '2025-06-30', NULL),
(9, 10, NULL, '2025-06-30', 4.0),
(10, NULL, 10, '2025-06-30', 4.0);

-- Insert dummy data into RISK_MARKET_DATA with explicit risk_id
INSERT INTO RISK_MARKET_DATA (risk_id, reporting_date, stddev, z_factor, time_horizon, portfolio_value, var_value) VALUES
(1, '2025-06-30', 0.025000, 1.6450, 10, 10000000.00, 412500.00),
(2, '2025-07-31', 0.023000, 1.6450, 10, 10050000.00, 380000.00),
(3, '2025-08-31', 0.022000, 1.6450, 10, 10100000.00, 365000.00),
(4, '2025-09-30', 0.021500, 1.6450, 10, 10150000.00, 350000.00),
(5, '2025-10-31', 0.020800, 1.6450, 10, 10200000.00, 335000.00),
(6, '2025-11-30', 0.020500, 1.6450, 10, 10250000.00, 330000.00),
(7, '2025-12-31', 0.020000, 1.6450, 10, 10300000.00, 320000.00),
(8, '2026-01-31', 0.019800, 1.6450, 10, 10350000.00, 315000.00),
(9, '2026-02-28', 0.019500, 1.6450, 10, 10400000.00, 310000.00),
(10, '2026-03-31', 0.019200, 1.6450, 10, 10450000.00, 305000.00);

-- Insert dummy data into ASSET_COVERAGE_COMPONENT with explicit comp_id
INSERT INTO ASSET_COVERAGE_COMPONENT (comp_id, bvta, ia, cl, stdo, total_debt, reporting_date) VALUES
(1, 20000000.00, 3000000.00, 1000000.00, 500000.00, 15000000.00, '2025-06-30'),
(2, 20500000.00, 3100000.00, 1050000.00, 510000.00, 15500000.00, '2025-07-31'),
(3, 21000000.00, 3200000.00, 1100000.00, 520000.00, 16000000.00, '2025-08-31'),
(4, 21500000.00, 3300000.00, 1150000.00, 530000.00, 16500000.00, '2025-09-30'),
(5, 22000000.00, 3400000.00, 1200000.00, 540000.00, 17000000.00, '2025-10-31'),
(6, 22500000.00, 3500000.00, 1250000.00, 550000.00, 17500000.00, '2025-11-30'),
(7, 23000000.00, 3600000.00, 1300000.00, 560000.00, 18000000.00, '2025-12-31'),
(8, 23500000.00, 3700000.00, 1350000.00, 570000.00, 18500000.00, '2026-01-31'),
(9, 24000000.00, 3800000.00, 1400000.00, 580000.00, 19000000.00, '2026-02-28'),
(10, 24500000.00, 3900000.00, 1450000.00, 590000.00, 19500000.00, '2026-03-31');

INSERT INTO CALCULATION_RESULT (calculation_type, result_value, reporting_date, parameters_used, remarks) VALUES
('Gap', 2500000.123456, '2025-06-30', 'bucket=Q2 2025', 'Positive gap observed'),
('NIM', 1.875000, '2025-06-30', 'period=Q2 2025', 'Net Interest Margin'),
('Duration', 5.1234, '2025-06-30', 'asset_id=1', 'Duration for asset 1'),
('Duration', 3.9876, '2025-06-30', 'liability_id=1', 'Duration for liability 1'),
('Gap', -1500000.000000, '2025-07-31', 'bucket=Q3 2025', 'Negative gap observed'),
('NIM', 1.900000, '2025-07-31', 'period=Q3 2025', 'Improved NIM'),
('Duration', 6.0000, '2025-07-31', 'asset_id=3', 'Duration for asset 3'),
('Duration', 4.2500, '2025-07-31', 'liability_id=3', 'Duration for liability 3'),
('Gap', 500000.000000, '2025-08-31', 'bucket=Q4 2025', 'Positive gap observed'),
('NIM', 1.850000, '2025-08-31', 'period=Q4 2025', 'NIM stabilized');
