package com.oracle.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.repository.AssetRepository;
import com.oracle.repository.LiabilityRepository;

@Service
public class GapAnalysisServiceImpl implements GapAnalysisService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private LiabilityRepository liabilityRepository;

    @Override
    public BigDecimal calculateGap() {
        BigDecimal rsa = assetRepository.getTotalRateSensitiveAssets();
        BigDecimal rsl = liabilityRepository.getTotalRateSensitiveLiabilities();
        return rsa.subtract(rsl);
    }
}
