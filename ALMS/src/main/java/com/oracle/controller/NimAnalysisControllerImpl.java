package com.oracle.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


import com.oracle.dto.NimAnalysisDTO;
import com.oracle.dto.NimSummaryDTO;
import com.oracle.service.NimAnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("net-interest-margin-by-year")
	@Override
	public ResponseEntity<?> getNimByYear() {
		List<Map<String,String>> retrieved=nimAnalysisService.computeNIM();
		List<NimSummaryDTO> result =new ArrayList<>();
		
//		if (retrieved == null || retrieved.isEmpty())
//		    return ResponseEntity.noContent().build();
//
//		retrieved
//		.stream()
//		.forEach((data)->{
//			result.add(new NimSummaryDTO(Integer.parseInt(data.get("year")),
//					new BigDecimal(data.get("income")),
//					new BigDecimal(data.get("expense")),
//					new BigDecimal(data.get("nim"))));
//		});
//		System.out.println("CHECK 3");
//		return new ResponseEntity<List<NimSummaryDTO>>(result, HttpStatus.OK);
		return ResponseEntity.ok(retrieved);

	}

}
