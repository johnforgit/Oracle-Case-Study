package com.oracle.service;

import com.oracle.dto.AssetCoverageRatioDTO;
import com.oracle.entities.AssetCoverageComponent;
import com.oracle.repository.AssetCoverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AssetCoverageServiceImpl implements AssetCoverageService {

    @Autowired
    private AssetCoverageRepository assetCoverageRepository;

    @Override
    public AssetCoverageRatioDTO calculateCoverageRatio(LocalDate reportingDate) {
        AssetCoverageComponent acc = assetCoverageRepository.findByReportingDate(reportingDate);
        if (acc == null) return null;

        return new AssetCoverageRatioDTO(
            acc.getBvta(),
            acc.getIa(),
            acc.getCl(),
            acc.getTotalDebt()
        );
    }
}
