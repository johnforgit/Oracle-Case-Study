package com.oracle.controller;

import org.springframework.http.ResponseEntity;

import com.oracle.dto.VarTimeSeriesDTO;

import java.time.LocalDate;
import java.util.List;

public interface VarAnalysisController {
    ResponseEntity<?> getVaR(LocalDate reportingDate);
    ResponseEntity<List<VarTimeSeriesDTO>> getVaRTimeSeries();
}
