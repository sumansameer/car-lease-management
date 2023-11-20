package com.assignment.carlease.carlease.startup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.assignment.carlease.carlease.model.Car;
import com.assignment.carlease.carlease.model.Customer;
import com.assignment.carlease.carlease.model.User;
import com.assignment.carlease.carlease.repository.CarRepository;
import com.assignment.carlease.carlease.repository.CustomerRepository;
import com.assignment.carlease.carlease.repository.UserRepository;

@Component
public class ApplicationStartupRunner implements CommandLineRunner	{

	 @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private CarRepository carRepository;
	    
	    @Autowired
	    private UserRepository userRepository;
	    
	    @Autowired
	    public PasswordEncoder passwordEncoder;

	    
	    String password = "";
	@Override
	public void run(String... args) throws Exception {
		System.out.println("ApplicationStartupRunner executed on application startup");
		
		 password = passwordEncoder.encode("password");
		 List<Car> cars = generateCars();
	     List<Customer> customers = generateCustomers();
	     List<User> users = generateUsers(password);
	    
	        
	     for (Car car : cars) {
	    	 carRepository.save(car);
	     }

	     for (Customer customer : customers) {
	    	 customerRepository.save(customer);
	     }
	     
	     for (User user : users) {
	    	 userRepository.save(user);
	     }
		
	}
	
	public static List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Toyota", "Camry", "Standard", 4, 120.5, 25000.0, 22000.0));
        cars.add(new Car("Honda", "Accord", "Sport", 4, 130.2, 28000.0, 25000.0));
        cars.add(new Car("Ford", "Fusion", "EcoBoost", 4, 110.8, 26000.0, 23000.0));

        return cars;
    }

    public static List<Customer> generateCustomers() {
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("John Doe", "123 Main St", "Apt 45", "12345", "Cityville", "john@example.com", "555-1234"));
        customers.add(new Customer("Jane Doe", "456 Oak St", "Unit 12", "67890", "Townsville", "jane@example.com", "555-5678"));
        customers.add(new Customer("Bob Smith", "789 Pine St", "Suite 9", "54321", "Villagetown", "bob@example.com", "555-9876"));

        return customers;
    }
    
    public static List<User> generateUsers(String password) {
        List<User> users = new ArrayList<>();

        users.add(new User("user", password));
        users.add(new User("broker",password));
        users.add(new User("employee", password));

        return users;
    }

}
