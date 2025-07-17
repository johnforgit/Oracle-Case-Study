package com.oracle.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Table(name = "DURATION_METRIC")
@Data
public class DurationMetric {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duration_id")
    private int durationId;

    @ManyToOne
    @JoinColumn(name = "asset_id", foreignKey = @ForeignKey(name = "FK_DURATION_ASSET"))
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "liability_id", foreignKey = @ForeignKey(name = "FK_DURATION_LIABILITY"))
    private Liability liability;

    @Column(name = "reporting_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reportingDate;

    @Column(name = "duration_value", precision = 10, scale = 4)
    private BigDecimal durationValue;
	
    public DurationMetric() {}
}
