package com.oracle.dto;

import java.util.Date;
import lombok.Data;

@Data
public class CustomerDTO {
    private int customerId;
    private String name;
    private Date dateOfBirth;
    private String email;
    private String phone;
    private String address;
    private String riskProfile;
    
    public CustomerDTO() {};
}