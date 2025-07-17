package com.oracle.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "LIABILITY")
@Data
public class Liability {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "liability_id")
    private int liabilityId;

    @Column(name = "liability_type", length = 50)
    private String liabilityType;

    @Column(name = "liability_value", precision = 20, scale = 2)
    private BigDecimal liabilityValue;

    @Column(name = "maturity_date")
    @Temporal(TemporalType.DATE)
    private Date maturityDate;

    @Column(name = "interest_rate", precision = 7, scale = 4)
    private BigDecimal interestRate;

    @Column(name = "duration", precision = 10, scale = 4)
    private BigDecimal duration;

    @Column(name = "is_current")
    private Boolean isCurrent;

    @Column(name = "is_short_term")
    private Boolean isShortTerm;

    @Column(name = "liability_status", length = 10)
    private String liabilityStatus;

    @ManyToOne
    @JoinColumn(name = "prod_id", foreignKey = @ForeignKey(name = "FK_LIABILITY_PRODUCT"))
    private Product product;

    @Column(name = "is_rate_sensitive")
    private Boolean isRateSensitive = false;

    @Column(name = "stddev", precision = 15, scale = 6)
    private BigDecimal stddev;

    @Column(name = "var_value", precision = 20, scale = 2)
    private BigDecimal varValue;
	
    
    public Liability() {}
}
