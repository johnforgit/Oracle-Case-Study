package com.oracle.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Gap Analysis Resource Operation")
public interface GapAnalysisController {

    @Operation(description = "Calculate rate sensitivity gap (RSA - RSL)")
    @ApiResponses(value = {
        @ApiResponse(description = "Successfully calculated the gap", responseCode = "200"),
        @ApiResponse(description = "Calculation failed or returned zero", responseCode = "404")
    })
    public ResponseEntity<?> getGap();
}
