package com.assignment.carlease.carlease.service;

import java.util.Date;
import java.util.List;

import com.assignment.carlease.carlease.model.Car;
import com.assignment.carlease.carlease.model.Customer;
import com.assignment.carlease.carlease.model.Lease;

public interface LeaseService {
	double calculateLeaseRate(int mileage, int duration, double interestRate, double nettPrice);

	boolean deleteLease(Long id);

	List<Lease> getAllLeases();

	Lease getLeaseById(Long id);

	Lease addLease(Customer customer, Car car, int mileage, int duration, double interestRate, double nettPrice,
			Date startDate);

	Lease updateLease(Long id, Customer customer, Car car, int mileage, int duration, double interestRate,
			double nettPrice, Date startDate);
	
	
}
