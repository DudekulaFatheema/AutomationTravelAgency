package com.automation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.entity.Customer;
import com.automation.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	// You might want to replace this with a database or repository
	// for the actual storage and retrieval of customer data
	private List<Customer> customers = new ArrayList<>();

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerBycId(int cId) {
		
		    return customerRepo.findById(cId).orElse(null);
		}

	@Override

	public Customer updateCustomer(Customer customer) throws Exception {
		Customer existingCustomer = customerRepo.findById(customer.getcId())
				.orElseThrow(() -> new Exception("Customer not found"));
		existingCustomer.setcId(customer.getcId());
		existingCustomer.setcName(customer.getcName());
		existingCustomer.setcPhoneNo(customer.getcPhoneNo());

		return customerRepo.save(existingCustomer);

	}

	@Override
	public void deleteCustomerBycId(int cId) {
		customerRepo.deleteById(cId);

	}

	@Override
	public List<Customer> viewAllCustomer() {
		List<Customer> allCustomer = customerRepo.findAll(); // Note : same as save
		return allCustomer;
	}
}
