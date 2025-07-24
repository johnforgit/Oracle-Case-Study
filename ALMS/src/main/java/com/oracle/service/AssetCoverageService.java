package com.oracle.service;

import com.oracle.dto.AssetCoverageRatioDTO;
import com.oracle.dto.AssetDTO;

import java.time.LocalDate;
import java.util.List;

public interface AssetCoverageService {
    AssetCoverageRatioDTO calculateCoverageRatio(LocalDate reportingDate);
    List<AssetDTO> allAssets();
}
