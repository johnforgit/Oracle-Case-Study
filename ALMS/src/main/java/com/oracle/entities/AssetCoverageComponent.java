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
}
