package com.assignment.carlease.carlease.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.carlease.carlease.model.Customer;
import com.assignment.carlease.carlease.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
    	System.out.println("Customer Data:" + customerRepository.findAll());
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
    	if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new InvalidParameterException("Customer name cannot be empty");
        }
        return customerRepository.save(customer);
    }
    
    public Customer updateCustomer(Long customerId, Customer customer) {
        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new InvalidParameterException("Customer name cannot be empty");
        }
        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setName(customer.getName());
            existingCustomer.setStreet(customer.getStreet());
            return customerRepository.save(existingCustomer);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCustomer(Long customerId) {
    	if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return true;
        } else {
            return false;
        }
    }

}
