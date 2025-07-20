package com.oracle.service;

import com.oracle.dto.LiquidityGapDTO;
import com.oracle.repository.MaturingCashFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class LiquidityGapServiceImpl implements LiquidityGapService {

@Autowired
private MaturingCashFlowRepository maturingCashFlowRepository;

@Override
public List<LiquidityGapDTO> getLiquidityGaps() {
List<Object[]> results = maturingCashFlowRepository.getLiquidityGapsByBucket();
List<LiquidityGapDTO> gapList = new ArrayList<>();

for (Object[] row : results) {
String label = (String) row[0];
BigDecimal inflow = (BigDecimal) row[1];
BigDecimal outflow = (BigDecimal) row[2];
gapList.add(new LiquidityGapDTO(label, inflow, outflow));
}

return gapList;
}
}
