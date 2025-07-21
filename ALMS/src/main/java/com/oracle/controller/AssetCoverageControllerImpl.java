package com.oracle.controller;

import com.oracle.dto.AssetCoverageRatioDTO;
import com.oracle.service.AssetCoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class AssetCoverageControllerImpl implements AssetCoverageController {

    @Autowired
    private AssetCoverageService assetCoverageService;

    @GetMapping("asset-coverage")
    @Override
    public ResponseEntity<?> getCoverageRatio(@RequestParam("reportingDate") LocalDate reportingDate) {
        AssetCoverageRatioDTO result = assetCoverageService.calculateCoverageRatio(reportingDate);
        if (result == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }
}
