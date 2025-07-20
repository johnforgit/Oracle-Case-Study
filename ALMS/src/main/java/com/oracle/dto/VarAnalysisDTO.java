package com.oracle.dto;

import java.math.BigDecimal;

public class VarAnalysisDTO {
    private BigDecimal varValue;

    public VarAnalysisDTO() {}

    public VarAnalysisDTO(BigDecimal varValue) {
        this.varValue = varValue;
    }

    public BigDecimal getVarValue() {
        return varValue;
    }

    public void setVarValue(BigDecimal varValue) {
        this.varValue = varValue;
    }
    
}
