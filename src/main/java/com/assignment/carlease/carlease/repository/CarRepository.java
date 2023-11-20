package com.assignment.carlease.carlease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.carlease.carlease.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
