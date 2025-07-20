package com.oracle.dto;

import java.math.BigDecimal;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class DurationGapDTO {

    @Schema(description = "Computed duration gap", example = "1.3476")
    @NotNull
    private BigDecimal durationGap;

    public DurationGapDTO() {
    }

    public DurationGapDTO(BigDecimal durationGap) {
        this.durationGap = durationGap;
    }

    public BigDecimal getDurationGap() {
        return durationGap;
    }

    public void setDurationGap(BigDecimal durationGap) {
        this.durationGap = durationGap;
    }

    @Override
    public String toString() {
        return "DurationGapDTO [durationGap=" + durationGap + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationGap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DurationGapDTO other = (DurationGapDTO) obj;
        return Objects.equals(durationGap, other.durationGap);
    }
}
