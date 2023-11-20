package com.assignment.carlease.carlease.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.carlease.carlease.model.Car;
import com.assignment.carlease.carlease.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
    private CarRepository carRepository;
	
	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		 return carRepository.findById(id).orElse(null);
	}

	@Override
	public Car saveCar(Car car) {
		if (car.getMake() == null || car.getMake().isEmpty()) {
            throw new InvalidParameterException("Car make cannot be empty");
        }
        return carRepository.save(car);
	}
	
	public Car updateCar(Long carId, Car car) {
        if (car.getMake() == null || car.getMake().isEmpty()) {
            throw new InvalidParameterException("Car make cannot be empty");
        }
        Car existingCar = carRepository.findById(carId).orElse(null);
        if (existingCar != null) {
            existingCar.setMake(car.getMake());
            existingCar.setModel(car.getModel());
            return carRepository.save(existingCar);
        } else {
            return null;
        }
    }

	@Override
	public boolean deleteCar(Long carId) {
        // Delete car if exists
        if (carRepository.existsById(carId)) {
            carRepository.deleteById(carId);
            return true;
        } else {
            return false;
        }
    }

	

}
