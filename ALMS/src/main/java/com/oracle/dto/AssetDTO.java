package com.oracle.dto;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AssetDTO {

	@NotNull
    @Schema(description = "Unique identifier of the asset", example = "101")
    private int assetId;

    @Schema(description = "Type of the asset", example = "Stock")
    private String assetType;

    @Schema(description = "Value of the asset", example = "500000")
    private Integer assetValue;

    @Schema(description = "Maturity date of the asset", example = "2030-12-31")
    private Date maturityDate;

    @Schema(description = "Interest rate on the asset", example = "0.0450")
    private BigDecimal interestRate;

    @Schema(description = "Duration of the asset", example = "5.1200")
    private BigDecimal duration;

    @Schema(description = "Book value of the asset", example = "490000.00")
    private BigDecimal bookValue;

    @Schema(description = "Indicates if the asset is tangible", example = "true")
    private Boolean isTangible;

    @Schema(description = "Status of the asset", example = "Active")
    private String assetStatus;

    @Schema(description = "Product ID associated with the asset", example = "2001")
    private Integer productId;

    @Schema(description = "Indicates if the asset is sensitive to interest rate changes", example = "false")
    private Boolean isRateSensitive;

    @Schema(description = "Standard deviation of asset returns", example = "0.015623")
    private BigDecimal stddev;

    @Schema(description = "Value at risk for the asset", example = "15000.00")
    private BigDecimal varValue;

    public AssetDTO() {}
    
    public AssetDTO(int assetId, String assetType, Integer assetValue, Date maturityDate, BigDecimal interestRate,
            BigDecimal duration, BigDecimal bookValue, Boolean isTangible, String assetStatus, Integer productId,
            Boolean isRateSensitive, BigDecimal stddev, BigDecimal varValue) {
		this.assetId = assetId;
		this.assetType = assetType;
		this.assetValue = assetValue;
		this.maturityDate = maturityDate;
		this.interestRate = interestRate;
		this.duration = duration;
		this.bookValue = bookValue;
		this.isTangible = isTangible;
		this.assetStatus = assetStatus;
		this.productId = productId;
		this.isRateSensitive = isRateSensitive;
		this.stddev = stddev;
		this.varValue = varValue;
    }

}
