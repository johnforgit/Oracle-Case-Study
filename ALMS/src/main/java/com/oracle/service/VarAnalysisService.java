package com.oracle.service;

import java.time.LocalDate;
import java.util.List;

import com.oracle.dto.VarTimeSeriesDTO;

import java.math.BigDecimal;

public interface VarAnalysisService {
    BigDecimal calculateVaR(LocalDate reportingDate);
    List<VarTimeSeriesDTO> getVarTimeSeries();
}
