package com.oracle.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface NimAnalysisService {
    BigDecimal calculateNIM(LocalDate startDate, LocalDate endDate);
    
    List<Map<String,String>> computeNIM();
}
