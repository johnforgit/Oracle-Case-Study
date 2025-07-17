package com.oracle.entities;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "INTEREST_INCOME_EXPENSE")
@Data
public class InterestIncomeExpense {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "asset_id", foreignKey = @ForeignKey(name = "FK_IIE_ASSET"))
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "liability_id", foreignKey = @ForeignKey(name = "FK_IIE_LIABILITY"))
    private Liability liability;

    @Column(name = "entry_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EntryType entryType;

    @Column(name = "period", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date period;

    @Column(name = "amount", precision = 20, scale = 2, nullable = false)
    private BigDecimal amount;

    public enum EntryType {
        income, expense
    }
	
    public InterestIncomeExpense() {}
}
