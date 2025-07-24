package com.oracle.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AvgActiveAssetByYearDTO {
	
    @NotNull
    private Integer maturityYear;
    
    private BigDecimal cumulativeAverage;
    
    public AvgActiveAssetByYearDTO() {}
    public AvgActiveAssetByYearDTO(Integer year, BigDecimal avg) {
    	this.maturityYear=year;
    	this.cumulativeAverage=avg;
    }

    
}
