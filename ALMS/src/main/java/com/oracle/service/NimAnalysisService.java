package com.oracle.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface NimAnalysisService {
    BigDecimal calculateNIM(LocalDate startDate, LocalDate endDate);
}
