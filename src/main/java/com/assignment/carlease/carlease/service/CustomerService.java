package com.assignment.carlease.carlease.service;

import java.util.List;

import com.assignment.carlease.carlease.model.Customer;

public interface CustomerService {
	 	List<Customer> getAllCustomers();
	    Customer getCustomerById(Long id);
	    Customer saveCustomer(Customer customer);
	    boolean deleteCustomer(Long id);
		Customer updateCustomer(Long id, Customer customer);
		
}
