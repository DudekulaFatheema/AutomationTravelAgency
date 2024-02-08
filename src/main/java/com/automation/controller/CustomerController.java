package com.automation.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automation.entity.Customer;
import com.automation.service.CustomerService;
import com.automation.service.CustomerServiceImpl;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	private final org.slf4j.Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CustomerService customerService;

	// http://localhost:8090/Customer/addCustomer
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		try {
			return customerService.addCustomer(customer);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return customer;
	}

	// http://localhost:8090/Customer/delete
	@DeleteMapping("/delete/{cId}")
	public String deleteBycId(@PathVariable int cId) {
		try {
			// Assuming routeService.deleteCustomerBycId(cId) method exists to perform the
			// delete operation
			customerService.deleteCustomerBycId(cId);
			mylogs.info("Deleted = " + cId + " Data");
			return "Deleted Id = " + cId + " Data";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error deleting Id = " + cId + " Data: " + e.getMessage();
		}
	}

	// http://localhost:8090/Customer/updateCustomer
	@PutMapping("/updateCustomer/{cId}")

	public Customer updateCustomer(@PathVariable int cId, @RequestBody Customer customer) throws Exception {

		customer.setcId(cId);

		return customerService.updateCustomer(customer);

	}

	// http://localhost:8090/Customer/allCustomer
	@GetMapping("/allCustomer")
	public List<Customer> viewAllCustomer() throws Exception {
		return customerService.viewAllCustomer();
	}

	// http://localhost:8090/Customer/customerId/2
	@GetMapping("/customerId/{cId}")
	public Customer getCustomerBycId(@PathVariable int cId) {
		Customer customer = customerService.getCustomerBycId(cId);
		return (customer != null) ? customer : new Customer(); // Return an empty Booking object if not found
	}

//    public static void main(String[] args) {
//        CustomerController controller = new CustomerController();
//
//        // Example usage
//        Customer customer1 = new Customer(1, "John Doe", 1234567890);
//        controller.addCustomer(customer1);
//
//        controller.handleGetCustomer(1);
//
//        Customer updatedCustomer = new Customer(1, "Updated John Doe", 987654321);
//        controller.handleUpdateCustomer(updatedCustomer);
//
//        controller.handleGetCustomer(1);
//
//        controller.handleDeleteCustomer(1);
//    }

//
//	public void handleGetCustomer(int customerId) {
//		Customer customer = customerService.getCustomerBycId(customerId);
//		if (customer != null) {
//			System.out.println("Found Customer: " + customer);
//		} else {
//			System.out.println("Customer not found with ID: " + customerId);
//		}
//	}
}
