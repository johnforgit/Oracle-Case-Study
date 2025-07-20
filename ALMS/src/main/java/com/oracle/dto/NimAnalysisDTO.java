package com.oracle.dto;

import java.math.BigDecimal;

public class NimAnalysisDTO {
    private BigDecimal netInterestMargin;

    public NimAnalysisDTO() {}

    public NimAnalysisDTO(BigDecimal netInterestMargin) {
        this.netInterestMargin = netInterestMargin;
    }

    public BigDecimal getNetInterestMargin() {
        return netInterestMargin;
    }

    public void setNetInterestMargin(BigDecimal netInterestMargin) {
        this.netInterestMargin = netInterestMargin;
    }
}