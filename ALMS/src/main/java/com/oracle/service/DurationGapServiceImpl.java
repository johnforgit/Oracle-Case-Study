package com.oracle.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.repository.AssetRepository;
import com.oracle.repository.DurationMetricRepository;
import com.oracle.repository.LiabilityRepository;

@Service
public class DurationGapServiceImpl implements DurationGapService {

@Autowired
private DurationMetricRepository durationRepo;

@Autowired
private AssetRepository assetRepo;

@Autowired
private LiabilityRepository liabilityRepo;

@Override
public BigDecimal calculateDurationGap(LocalDate reportingDate) {
BigDecimal durAssets = durationRepo.getTotalAssetDuration(reportingDate);
BigDecimal durLiabilities = durationRepo.getTotalLiabilityDuration(reportingDate);
BigDecimal totalAssets = assetRepo.getTotalAssetValue();
BigDecimal totalLiabilities = liabilityRepo.getTotalLiabilityValue();

if (totalAssets == null || totalAssets.compareTo(BigDecimal.ZERO) == 0) {
return BigDecimal.ZERO;
}

BigDecimal weightedLiability = durLiabilities.multiply(totalLiabilities).divide(totalAssets, 6, BigDecimal.ROUND_HALF_UP);
return durAssets.subtract(weightedLiability);
}
}
