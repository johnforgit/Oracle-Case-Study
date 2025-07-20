package com.oracle.dto;

import java.math.BigDecimal;
import java.util.Objects;

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

    public BigDecimal getBvta() {
        return bvta;
    }

    public void setBvta(BigDecimal bvta) {
        this.bvta = bvta;
    }

    public BigDecimal getIa() {
        return ia;
    }

    public void setIa(BigDecimal ia) {
        this.ia = ia;
    }

    public BigDecimal getCl() {
        return cl;
    }

    public void setCl(BigDecimal cl) {
        this.cl = cl;
    }

    public BigDecimal getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(BigDecimal totalDebt) {
        this.totalDebt = totalDebt;
    }

    public BigDecimal getAssetCoverageRatio() {
        return assetCoverageRatio;
    }

    public void setAssetCoverageRatio(BigDecimal assetCoverageRatio) {
        this.assetCoverageRatio = assetCoverageRatio;
    }

    @Override
    public String toString() {
        return "AssetCoverageRatioDTO{" +
                "bvta=" + bvta +
                ", ia=" + ia +
                ", cl=" + cl +
                ", totalDebt=" + totalDebt +
                ", assetCoverageRatio=" + assetCoverageRatio +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(bvta, ia, cl, totalDebt, assetCoverageRatio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AssetCoverageRatioDTO that = (AssetCoverageRatioDTO) obj;
        return Objects.equals(bvta, that.bvta) &&
               Objects.equals(ia, that.ia) &&
               Objects.equals(cl, that.cl) &&
               Objects.equals(totalDebt, that.totalDebt) &&
               Objects.equals(assetCoverageRatio, that.assetCoverageRatio);
    }
}
