package com.oracle.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VarTimeSeriesDTO {
	private LocalDate reportingDate;
	private BigDecimal portfolioValue;
	private BigDecimal valueAtRisk;
	public LocalDate getReportingDate() {
		return reportingDate;
	}
	public BigDecimal getPortfolioValue() {
		return portfolioValue;
	}
	public BigDecimal getValueAtRisk() {
		return valueAtRisk;
	}
	public VarTimeSeriesDTO(LocalDate reportingDate, BigDecimal portfolioValue, BigDecimal valueAtRisk) {
		this.reportingDate = reportingDate;
		this.portfolioValue = portfolioValue;
		this.valueAtRisk = valueAtRisk;
	}
	public VarTimeSeriesDTO() {}
}
