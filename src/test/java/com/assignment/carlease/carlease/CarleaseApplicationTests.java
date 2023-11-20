package com.assignment.carlease.carlease;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarleaseApplicationTests {

	@Test
	void contextLoads() {

        LeaseService leaseService = new LeaseService();
        double calculatedLeaseRate	 = leaseService.calculateLeaseRate(45000, 60, 4.5, 63000);
        assertEquals(239.76, calculatedLeaseRate, 0.1);
	}
	
	public class LeaseService {

	    public double calculateLeaseRate(int mileage, int duration, double interestRate, double nettPrice) {
	    	double monthlyMileageCost = ((mileage / 12) * duration)	 / nettPrice;
	        double interestCost = ((interestRate / 100) * nettPrice) / 12;
	        return monthlyMileageCost + interestCost;
	        
	    }
	}

}
