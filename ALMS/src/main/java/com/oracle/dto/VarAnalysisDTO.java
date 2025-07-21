package com.oracle.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class VarAnalysisDTO {
    private BigDecimal varValue;

    public VarAnalysisDTO() {}

    public VarAnalysisDTO(BigDecimal varValue) {
        this.varValue = varValue;
    }
    
}
