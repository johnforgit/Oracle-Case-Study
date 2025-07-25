package com.oracle.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.dto.CustomerDTO;
import com.oracle.entities.Customer;
import com.oracle.repository.CustomersRepository;
import com.oracle.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomersRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers=customerRepository.getAllCustomers();
		return customers;
	}

}