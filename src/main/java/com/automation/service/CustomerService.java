package com.automation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.automation.entity.Customer;
@Service
public interface CustomerService {

	
	   // Create
    public Customer addCustomer(Customer customer);
    
    // Read
    public Customer getCustomerBycId(int cId);
    
    // Update
    public  Customer updateCustomer(Customer customer) throws Exception;
    
    // Delete
    public void deleteCustomerBycId(int cId);

	public List<Customer> viewAllCustomer();
}

