package com.assignment.carlease.carlease.service;

import java.util.List;

import com.assignment.carlease.carlease.model.Car;

public interface CarService {

	List<Car> getAllCars();
	Car getCarById(Long id);
	Car saveCar(Car car);
    boolean deleteCar(Long id);
	Car updateCar(Long id, Car car);

}
