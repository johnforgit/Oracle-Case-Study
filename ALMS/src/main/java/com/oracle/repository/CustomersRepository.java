package com.oracle.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oracle.entities.Asset;
import com.oracle.entities.Customer;

public interface CustomersRepository  extends CrudRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer c")
    List<Customer> getAllCustomers();
	
}