package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.entities.Liability;
import com.oracle.service.LiabilityService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins="*")
public class LiabilityControllerImpl implements LiabilityController{

	@Autowired
	private LiabilityService liabilityService;
	
	@Override
	@GetMapping("liability")
	public ResponseEntity<?> getLiabilities() {
		List<Liability> retrieve = liabilityService.allLiabilities();
		
		if(retrieve==null)
			return new ResponseEntity<String>("Error in endpoint",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<List<Liability>>(retrieve,HttpStatus.OK);
	}

}
