package com.springboot.demo.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping("addCar")
	public String addCar(@RequestParam String make,
						 @RequestParam String model,
						 @RequestParam String year){
		
		Car car = new Car();
		car.setMake(make);
		car.setModel(model);
		car.setModelYear(year);
		
		carRepository.save(car);
		
		return "Car Created";
	}
	
	@RequestMapping(path="viewCars")
	public @ResponseBody Iterable<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	@RequestMapping(path="findCarsByMake")
	public @ResponseBody Iterable<Car> finCarsByModel(@RequestParam String make) {
		return carRepository.findCarsByMake(make);
	}
	
	
	
}
