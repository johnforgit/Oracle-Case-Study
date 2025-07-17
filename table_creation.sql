CREATE DATABASE ALM;
USE ALM;

-- 1. Product Table (Create first to satisfy FK in ASSET and LIABILITY)
CREATE TABLE PRODUCT (
    prod_id INT AUTO_INCREMENT PRIMARY KEY, 
    prod_type VARCHAR(20) NOT NULL,
    description VARCHAR(30)
);

-- 2. Asset Table
CREATE TABLE ASSET (
    asset_id INT AUTO_INCREMENT PRIMARY KEY,
    asset_type VARCHAR(50),             -- increased size for flexibility
    asset_value INT,
    maturity_date DATE,
    interest_rate DECIMAL(7,4),
    duration DECIMAL(10,4),
    book_value DECIMAL(20,2),
    is_tangible BOOLEAN,
    asset_status VARCHAR(10),
    prod_id INT,
    is_rate_sensitive BOOLEAN DEFAULT FALSE,
    CONSTRAINT FK_ASSET_PRODUCT FOREIGN KEY (prod_id) REFERENCES PRODUCT(prod_id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- 3. Liability Table
CREATE TABLE LIABILITY (
    liability_id INT AUTO_INCREMENT PRIMARY KEY,
    liability_type VARCHAR(50),
    liability_value DECIMAL(20,2),
    maturity_date DATE,
    interest_rate DECIMAL(7,4),
    duration DECIMAL(10,4),
    is_current BOOLEAN,
    is_short_term BOOLEAN,
    liability_status VARCHAR(10),
    prod_id INT,
    is_rate_sensitive BOOLEAN DEFAULT FALSE,
    CONSTRAINT FK_LIABILITY_PRODUCT FOREIGN KEY (prod_id) REFERENCES PRODUCT(prod_id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- 4. Interest Income/Expense Table
-- 4. Interest Income/Expense Table (Updated)
CREATE TABLE INTEREST_INCOME_EXPENSE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    asset_id INT NULL,
    liability_id INT NULL,
    entry_type ENUM('income', 'expense') NOT NULL,
    period DATE NOT NULL,
    amount DECIMAL(20,2) NOT NULL,
    -- One of asset_id or liability_id must be NOT NULL (enforce via application or triggers)
    CONSTRAINT FK_IIE_ASSET FOREIGN KEY (asset_id) REFERENCES ASSET(asset_id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT FK_IIE_LIABILITY FOREIGN KEY (liability_id) REFERENCES LIABILITY(liability_id) ON DELETE SET NULL ON UPDATE CASCADE,
    INDEX idx_asset_id (asset_id),
    INDEX idx_liability_id (liability_id)
);

-- 6. Maturing Cash Flow Table (Updated)
CREATE TABLE MATURING_CASH_FLOW (
    flow_id INT AUTO_INCREMENT PRIMARY KEY,
    asset_id INT NULL,
    liability_id INT NULL,
    bucket_id INT NOT NULL,
    amount DECIMAL(20,2) NOT NULL,
    inflow_or_outflow ENUM('inflow', 'outflow') NOT NULL,
    -- One of asset_id or liability_id must be NOT NULL (enforce via application or triggers)
    CONSTRAINT FK_MCF_ASSET FOREIGN KEY (asset_id) REFERENCES ASSET(asset_id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT FK_MCF_LIABILITY FOREIGN KEY (liability_id) REFERENCES LIABILITY(liability_id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT FK_MATURING_CASH_FLOW_TIME_BUCKET FOREIGN KEY (bucket_id) REFERENCES TIME_BUCKET(bucket_id) ON DELETE CASCADE ON UPDATE CASCADE,
    INDEX idx_asset_id (asset_id),
    INDEX idx_liability_id (liability_id)
);


-- 5. Time Bucket Table
CREATE TABLE TIME_BUCKET (
    bucket_id INT AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(20) NOT NULL UNIQUE,
    start_date DATE,
    end_date DATE
);

-- 6. Maturing Cash Flow Table

-- 7. Duration Metric Table
CREATE TABLE DURATION_METRIC (
    duration_id INT AUTO_INCREMENT PRIMARY KEY,
    asset_id INT NULL,
    liability_id INT NULL,
    reporting_date DATE NOT NULL,
    duration_value DECIMAL(10,4),
    CONSTRAINT FK_DURATION_ASSET FOREIGN KEY (asset_id) REFERENCES ASSET(asset_id) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT FK_DURATION_LIABILITY FOREIGN KEY (liability_id) REFERENCES LIABILITY(liability_id) ON DELETE SET NULL ON UPDATE CASCADE,
    -- Consider application-level check to ensure one of asset_id or liability_id is not null
    INDEX idx_asset_id (asset_id),
    INDEX idx_liability_id (liability_id)
);

-- 8. Risk/Market Data Table (VaR)
CREATE TABLE RISK_MARKET_DATA (
    risk_id INT AUTO_INCREMENT PRIMARY KEY,
    reporting_date DATE NOT NULL,
    stddev DECIMAL(15,6),
    z_factor DECIMAL(6,4),
    time_horizon INT, -- days
    portfolio_value DECIMAL(20,2),
    var_value DECIMAL(20,2)
);

-- 9. Asset Coverage Component Table
CREATE TABLE ASSET_COVERAGE_COMPONENT (
    comp_id INT AUTO_INCREMENT PRIMARY KEY,
    bvta DECIMAL(20,2),
    ia DECIMAL(20,2),
    cl DECIMAL(20,2),
    stdo DECIMAL(20,2),
    total_debt DECIMAL(20,2),
    reporting_date DATE
);

-- 10. Calculation Result Table
CREATE TABLE CALCULATION_RESULT (
    calculation_id INT AUTO_INCREMENT PRIMARY KEY,
    calculation_type VARCHAR(50) NOT NULL, -- e.g., 'Gap', 'NIM', 'Duration'
    result_value DECIMAL(20,6),
    reporting_date DATE,
    parameters_used TEXT,
    remarks VARCHAR(255)
);

-- Show all tables after creation
SHOW TABLES;
