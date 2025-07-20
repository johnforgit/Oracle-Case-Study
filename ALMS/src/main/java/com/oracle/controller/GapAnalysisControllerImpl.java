package com.oracle.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oracle.service.GapAnalysisService;

@RestController
@RequestMapping("api")
@EnableAspectJAutoProxy
@CrossOrigin(origins = "*")
public class GapAnalysisControllerImpl implements GapAnalysisController {

    @Autowired
    private GapAnalysisService gapAnalysisService;

    @Override
    @GetMapping("gap-analysis")
    public ResponseEntity<?> getGap() {
        BigDecimal gap = gapAnalysisService.calculateGap();
        if (gap != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("gapValue", gap);
            response.put("gapType", gap.signum() > 0 ? "Asset-sensitive" : gap.signum() < 0 ? "Liability-sensitive" : "Neutral");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>("Unable to calculate gap", HttpStatus.NOT_FOUND);
    }
}
