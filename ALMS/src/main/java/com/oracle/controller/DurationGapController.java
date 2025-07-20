package com.oracle.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Duration Gap Resource Operation")
public interface DurationGapController {

@Operation(description = "Calculate duration gap on a specific reporting date")
@ApiResponses(value = {
@ApiResponse(description = "Successfully calculated duration gap", responseCode = "200"),
@ApiResponse(description = "Error during calculation", responseCode = "400")
})
public ResponseEntity<?> getDurationGap(LocalDate reportingDate);
}
