package com.oracle.dto;

import java.math.BigDecimal;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GapAnalysisDTO {

    @Schema(description = "Difference between rate-sensitive assets and liabilities", example = "1500000.00")
    @NotNull
    private BigDecimal gapValue;

    @Schema(description = "Gap type derived from value sign", example = "Asset-sensitive")
    @NotNull
    private String gapType;

    public GapAnalysisDTO() {}

    public GapAnalysisDTO(BigDecimal gapValue, String gapType) {
        this.gapValue = gapValue;
        this.gapType = gapType;
    }

    @Override
    public String toString() {
        return "GapAnalysisDTO [gapValue=" + gapValue + ", gapType=" + gapType + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(gapType, gapValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GapAnalysisDTO other = (GapAnalysisDTO) obj;
        return Objects.equals(gapValue, other.gapValue) && Objects.equals(gapType, other.gapType);
    }

    public BigDecimal getGapValue() {
        return gapValue;
    }

    public void setGapValue(BigDecimal gapValue) {
        this.gapValue = gapValue;
    }

    public String getGapType() {
        return gapType;
    }

    public void setGapType(String gapType) {
        this.gapType = gapType;
    }
}
