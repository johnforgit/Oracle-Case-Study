package com.oracle.dto;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.Data;

@Data
public class AssetCoverageRatioDTO {

    private BigDecimal bvta;
    private BigDecimal ia;
    private BigDecimal cl;
    private BigDecimal totalDebt;
    private BigDecimal assetCoverageRatio;

    public AssetCoverageRatioDTO() {}

    public AssetCoverageRatioDTO(BigDecimal bvta, BigDecimal ia, BigDecimal cl, BigDecimal totalDebt) {
        this.bvta = bvta;
        this.ia = ia;
        this.cl = cl;
        this.totalDebt = totalDebt;
        if (totalDebt != null && totalDebt.compareTo(BigDecimal.ZERO) > 0) {
            this.assetCoverageRatio = (bvta.subtract(ia).subtract(cl)).divide(totalDebt, 4, BigDecimal.ROUND_HALF_UP);
        } else {
            this.assetCoverageRatio = BigDecimal.ZERO;
        }
    }

}
