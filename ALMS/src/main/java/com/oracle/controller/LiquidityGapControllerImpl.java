package com.oracle.controller;

import com.oracle.dto.LiquidityGapDTO;
import com.oracle.service.LiquidityGapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class LiquidityGapControllerImpl implements LiquidityGapController {

@Autowired
private LiquidityGapService liquidityGapService;

@GetMapping(value = "liquidity-gap", produces = "application/json")
@Override
public ResponseEntity<?> getLiquidityGapAnalysis() {
List<LiquidityGapDTO> gaps = liquidityGapService.getLiquidityGaps();
return ResponseEntity.ok(gaps);
}
}
