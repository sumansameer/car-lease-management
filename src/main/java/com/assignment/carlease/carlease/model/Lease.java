package com.assignment.carlease.carlease.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(nullable = false)
    private int mileage;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private double interestRate;

    @Column(nullable = false)
    private double nettPrice;

    @Column(nullable = false)
    private double leaseRate;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;


 // Default constructor    
    public Lease() {
        
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getNettPrice() {
		return nettPrice;
	}

	public void setNettPrice(double nettPrice) {
		this.nettPrice = nettPrice;
	}

	public double getLeaseRate() {
		return leaseRate;
	}

	public void setLeaseRate(double leaseRate) {
		this.leaseRate = leaseRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Lease(Customer customer, Car car, int mileage, int duration, double interestRate, double nettPrice, Date startDate) {
        this.customer = customer;
        this.car = car;
        this.mileage = mileage;
        this.duration = duration;
        this.interestRate = interestRate;
        this.nettPrice = nettPrice;
        this.startDate = startDate;
        // Calculate and set lease rate based on the provided formula
        this.leaseRate = calculateLeaseRate();
    }



    public double calculateLeaseRate() {
        double monthlyMileage = ((mileage / 12) * duration)	 / nettPrice;
        double monthlyInterestRate = ((interestRate / 100) * nettPrice) / 12;
        return monthlyMileage + monthlyInterestRate;
    }
}
