package com.oracle.dto;



import java.math.BigDecimal;

import lombok.Data;

@Data
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

}
