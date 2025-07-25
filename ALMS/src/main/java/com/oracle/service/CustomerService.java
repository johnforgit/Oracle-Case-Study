package com.oracle.service;

import java.util.List;
import com.oracle.entities.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
}