package com.oracle.service;

import java.time.LocalDate;
import java.math.BigDecimal;

public interface VarAnalysisService {
    BigDecimal calculateVaR(LocalDate reportingDate);
}
