package com.oracle.controller;

import com.oracle.dto.VarAnalysisDTO;
import com.oracle.service.VarAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("api")
public class VarAnalysisControllerImpl implements VarAnalysisController {

    @Autowired
    private VarAnalysisService varService;

    @GetMapping(value = "value-at-risk", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VarAnalysisDTO> getVaR(
            @RequestParam("reportingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reportingDate) {

        BigDecimal var = varService.calculateVaR(reportingDate);
        return ResponseEntity.ok(new VarAnalysisDTO(var));
    }
}
