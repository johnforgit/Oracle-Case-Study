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

}
