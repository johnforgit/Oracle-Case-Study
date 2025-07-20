package com.oracle.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
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
    private LocalDate reportingDate;

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

	public int getRiskId() {
		return riskId;
	}

	public void setRiskId(int riskId) {
		this.riskId = riskId;
	}

	public LocalDate getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(LocalDate reportingDate) {
		this.reportingDate = reportingDate;
	}

	public BigDecimal getStddev() {
		return stddev;
	}

	public void setStddev(BigDecimal stddev) {
		this.stddev = stddev;
	}

	public BigDecimal getzFactor() {
		return zFactor;
	}

	public void setzFactor(BigDecimal zFactor) {
		this.zFactor = zFactor;
	}

	public Integer getTimeHorizon() {
		return timeHorizon;
	}

	public void setTimeHorizon(Integer timeHorizon) {
		this.timeHorizon = timeHorizon;
	}

	public BigDecimal getPortfolioValue() {
		return portfolioValue;
	}

	public void setPortfolioValue(BigDecimal portfolioValue) {
		this.portfolioValue = portfolioValue;
	}

	public BigDecimal getVarValue() {
		return varValue;
	}

	public void setVarValue(BigDecimal varValue) {
		this.varValue = varValue;
	}
    
}
