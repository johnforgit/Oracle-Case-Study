package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.entities.Liability;
import com.oracle.repository.LiabilityRepository;
@Service
public class LiabilityServiceImplementation implements LiabilityService {

	@Autowired
	private LiabilityRepository liabilityRepository;
	
	@Override
	public List<Liability> allLiabilities() {
		List<Liability> liabilities = liabilityRepository.getLiabilities();
		
		return liabilities;
	}

}
