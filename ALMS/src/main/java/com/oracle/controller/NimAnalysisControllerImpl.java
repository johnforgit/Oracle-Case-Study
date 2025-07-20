package com.oracle.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


import com.oracle.dto.NimAnalysisDTO;
import com.oracle.service.NimAnalysisService;

@RestController
@RequestMapping("api")
@EnableAspectJAutoProxy
@CrossOrigin(origins = "*")
public class NimAnalysisControllerImpl implements NimAnalysisController {

    @Autowired
    private NimAnalysisService nimAnalysisService;

    @GetMapping(value = "net-interest-margin", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> getNim(@RequestParam("startDate") LocalDate startDate,
                                    @RequestParam("endDate") LocalDate endDate) {
        try {
            BigDecimal result = nimAnalysisService.calculateNIM(startDate, endDate);
            System.out.println("Start: " + startDate + ", End: " + endDate);
            System.out.println("NIM: " + result);
            return new ResponseEntity<>(new NimAnalysisDTO(result), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to compute NIM", HttpStatus.BAD_REQUEST);
        }
    }

}
