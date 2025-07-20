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
@Table(name = "ASSET_COVERAGE_COMPONENT")
@Data
public class AssetCoverageComponent {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private int compId;

    @Column(name = "bvta", precision = 20, scale = 2)
    private BigDecimal bvta;

    @Column(name = "ia", precision = 20, scale = 2)
    private BigDecimal ia;

    @Column(name = "cl", precision = 20, scale = 2)
    private BigDecimal cl;

    @Column(name = "stdo", precision = 20, scale = 2)
    private BigDecimal stdo;

    @Column(name = "total_debt", precision = 20, scale = 2)
    private BigDecimal totalDebt;

    @Temporal(TemporalType.DATE)
    @Column(name = "reporting_date")
    private Date reportingDate;
	
    public AssetCoverageComponent() {}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public BigDecimal getBvta() {
		return bvta;
	}

	public void setBvta(BigDecimal bvta) {
		this.bvta = bvta;
	}

	public BigDecimal getIa() {
		return ia;
	}

	public void setIa(BigDecimal ia) {
		this.ia = ia;
	}

	public BigDecimal getCl() {
		return cl;
	}

	public void setCl(BigDecimal cl) {
		this.cl = cl;
	}

	public BigDecimal getStdo() {
		return stdo;
	}

	public void setStdo(BigDecimal stdo) {
		this.stdo = stdo;
	}

	public BigDecimal getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(BigDecimal totalDebt) {
		this.totalDebt = totalDebt;
	}

	public Date getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(Date reportingDate) {
		this.reportingDate = reportingDate;
	}
    
}
