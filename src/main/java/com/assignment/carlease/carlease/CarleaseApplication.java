package com.assignment.carlease.carlease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = "com.assignment.carlease.carlease")
@EntityScan(basePackages = "com.assignment.carlease.carlease.model")
public class CarleaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarleaseApplication.class, args);
	}

}
