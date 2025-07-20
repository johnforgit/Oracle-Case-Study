package com.oracle.dto;



import java.math.BigDecimal;

public class LiquidityGapDTO {
    private String bucketLabel;
    private BigDecimal inflow;
    private BigDecimal outflow;
    private BigDecimal gap;

    public LiquidityGapDTO(String bucketLabel, BigDecimal inflow, BigDecimal outflow) {
        this.bucketLabel = bucketLabel;
        this.inflow = inflow;
        this.outflow = outflow;
        this.gap = inflow.subtract(outflow);
    }

    public String getBucketLabel() {
        return bucketLabel;
    }

    public BigDecimal getInflow() {
        return inflow;
    }

    public BigDecimal getOutflow() {
        return outflow;
    }

    public BigDecimal getGap() {
        return gap;
    }

    // Optional: toString(), equals(), hashCode()
}
