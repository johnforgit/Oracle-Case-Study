package com.oracle.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class NimAnalysisDTO {
    private BigDecimal netInterestMargin;

    public NimAnalysisDTO() {}

    public NimAnalysisDTO(BigDecimal netInterestMargin) {
        this.netInterestMargin = netInterestMargin;
    }
}