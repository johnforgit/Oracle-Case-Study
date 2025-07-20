package com.oracle.service;

import com.oracle.dto.AssetCoverageRatioDTO;

import java.time.LocalDate;

public interface AssetCoverageService {
    AssetCoverageRatioDTO calculateCoverageRatio(LocalDate reportingDate);
}
