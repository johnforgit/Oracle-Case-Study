package com.oracle.dto;

import java.math.BigDecimal;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DurationGapDTO {

    @Schema(description = "Computed duration gap", example = "1.3476")
    @NotNull
    private BigDecimal durationGap;

    public DurationGapDTO() {
    }

    public DurationGapDTO(BigDecimal durationGap) {
        this.durationGap = durationGap;
    }

}
