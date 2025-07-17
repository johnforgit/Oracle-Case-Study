package com.oracle.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "MATURING_CASH_FLOW")
@Data
public class MaturingCashFlow {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flow_id")
    private int flowId;

    @ManyToOne
    @JoinColumn(name = "asset_id", foreignKey = @ForeignKey(name = "FK_MCF_ASSET"))
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "liability_id", foreignKey = @ForeignKey(name = "FK_MCF_LIABILITY"))
    private Liability liability;

    @ManyToOne
    @JoinColumn(name = "bucket_id", nullable = false, foreignKey = @ForeignKey(name = "FK_MATURING_CASH_FLOW_TIME_BUCKET"))
    private TimeBucket bucket;

    @Column(name = "amount", nullable = false, precision = 20, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "inflow_or_outflow", nullable = false)
    private FlowType inflowOrOutflow;

    public enum FlowType {
        inflow, outflow
    }
	
    public MaturingCashFlow() {}
}
