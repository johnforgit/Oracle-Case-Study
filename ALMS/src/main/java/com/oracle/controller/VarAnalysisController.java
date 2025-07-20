package com.oracle.controller;

import org.springframework.http.ResponseEntity;
import java.time.LocalDate;

public interface VarAnalysisController {
    ResponseEntity<?> getVaR(LocalDate reportingDate);
}
