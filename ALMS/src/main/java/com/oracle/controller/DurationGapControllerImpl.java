package com.oracle.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oracle.dto.DurationGapDTO;
import com.oracle.service.DurationGapService;

@RestController
@RequestMapping("api")
@EnableAspectJAutoProxy
@CrossOrigin(origins = "*")
public class DurationGapControllerImpl implements DurationGapController {

@Autowired
private DurationGapService durationGapService;

@GetMapping("duration-gap")
@Override
public ResponseEntity<?> getDurationGap(@RequestParam("reportingDate") LocalDate reportingDate) {
try {
BigDecimal gap = durationGapService.calculateDurationGap(reportingDate);
DurationGapDTO dto = new DurationGapDTO(gap);
return new ResponseEntity<>(dto, HttpStatus.OK);
} catch (Exception e) {
return new ResponseEntity<>("Error calculating duration gap", HttpStatus.BAD_REQUEST);
}
}
}
