package com.oracle.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.dto.CustomerDTO;
import com.oracle.entities.Customer;
import com.oracle.service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    private CustomerService customerService;

    @Override
    @GetMapping("/customer-data")
	public ResponseEntity<?> getCustomerData() {
		
    	List<Customer> retrieve= customerService.getAllCustomers();
    	
    	if(retrieve ==null)
    		return ResponseEntity.ok("Empty Customers Table");
    	
    	List<CustomerDTO> result=new ArrayList<>();
    	
    	retrieve
    	.stream()
    	.forEach((d)->{
    		CustomerDTO o=new CustomerDTO();
    		o.setAddress(d.getAddress());
    		o.setCustomerId(d.getCustomerId());
    		o.setDateOfBirth(d.getDateOfBirth());
    		o.setEmail(d.getEmail());
    		o.setName(d.getName());
    		o.setPhone(d.getPhone());
    		o.setRiskProfile(d.getRiskProfile());
    		result.add(o);
    	});
    	
    	return ResponseEntity.ok(result);
    	
    	
	}

    
    
}