package com.assignment.carlease.carlease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.carlease.carlease.model.Car;
import com.assignment.carlease.carlease.model.Customer;
import com.assignment.carlease.carlease.model.Lease;
import com.assignment.carlease.carlease.repository.LeaseRepository;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class LeaseServiceImpl implements LeaseService {

    @Autowired
    private LeaseRepository leaseRepository;
    

    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }

    public Lease getLeaseById(Long leaseId) {
        return leaseRepository.findById(leaseId).orElse(null);
    }

    public Lease addLease(Customer customer, Car car, int mileage, int duration, double interestRate, double nettPrice, Date startDate) {
        validateLeaseInputs(customer, car, mileage, duration, interestRate, nettPrice, startDate);
        Lease lease = new Lease(customer, car, mileage, duration, interestRate, nettPrice, startDate);
        return leaseRepository.save(lease);
    }

    public Lease updateLease(Long leaseId, Customer customer, Car car, int mileage, int duration, double interestRate, double nettPrice, Date startDate) {
        validateLeaseInputs(customer, car, mileage, duration, interestRate, nettPrice, startDate);
        Lease existingLease = leaseRepository.findById(leaseId).orElseThrow(() -> new EntityNotFoundException("Lease not found"));
        existingLease.setCustomer(customer);
        existingLease.setCar(car);
        existingLease.setMileage(mileage);
        existingLease.setDuration(duration);
        existingLease.setInterestRate(interestRate);
        existingLease.setNettPrice(nettPrice);
        existingLease.setStartDate(startDate);
        existingLease.setLeaseRate(existingLease.calculateLeaseRate());
        return leaseRepository.save(existingLease);
    }

    public boolean deleteLease(Long leaseId) {
        if (leaseRepository.existsById(leaseId)) {
            leaseRepository.deleteById(leaseId);
            return true;
        } else {
            return false;
        }
    }

    private void validateLeaseInputs(Customer customer, Car car, int mileage, int duration, double interestRate, double nettPrice, Date startDate) {
        if (customer == null || car == null || mileage <= 0 || duration <= 0 || interestRate <= 0 || nettPrice <= 0 || startDate == null) {
            throw new IllegalArgumentException("Invalid input parameters for lease");
        }
    }

	@Override
	public double calculateLeaseRate(int mileage, int duration, double interestRate, double nettPrice) {
		double monthlyMileageCost = ((mileage / 12) * duration)	 / nettPrice;
        double interestCost = ((interestRate / 100) * nettPrice) / 12;
        return monthlyMileageCost + interestCost;
	}


	
}
