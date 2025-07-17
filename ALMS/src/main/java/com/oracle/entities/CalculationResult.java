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
@Table(name = "CALCULATION_RESULT")
@Data
public class CalculationResult {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calculation_id")
    private int calculationId;

    @Column(name = "calculation_type", length = 50, nullable = false)
    private String calculationType;

    @Column(name = "result_value", precision = 20, scale = 6)
    private BigDecimal resultValue;

    @Temporal(TemporalType.DATE)
    @Column(name = "reporting_date")
    private Date reportingDate;

    @Column(name = "parameters_used", columnDefinition = "TEXT")
    private String parametersUsed;

    @Column(name = "remarks", length = 255)
    private String remarks;

	public CalculationResult() {}
}
