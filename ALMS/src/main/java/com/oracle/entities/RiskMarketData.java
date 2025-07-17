package com.oracle.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "RISK_MARKET_DATA")
@Data
public class RiskMarketData {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "risk_id")
    private int riskId;

    @Column(name = "reporting_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reportingDate;

    @Column(name = "stddev", precision = 15, scale = 6)
    private BigDecimal stddev;

    @Column(name = "z_factor", precision = 6, scale = 4)
    private BigDecimal zFactor;

    @Column(name = "time_horizon")
    private Integer timeHorizon;

    @Column(name = "portfolio_value", precision = 20, scale = 2)
    private BigDecimal portfolioValue;

    @Column(name = "var_value", precision = 20, scale = 2)
    private BigDecimal varValue;
	
    public RiskMarketData() {}
}
