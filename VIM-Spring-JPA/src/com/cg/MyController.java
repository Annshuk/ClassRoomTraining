package com.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.dao.CarDAO;
import com.cg.dto.CarDTO;

@Controller
public class MyController {

	@Autowired
	private CarDAO carDAO;

	@RequestMapping("/viewCars")
	String viewAllCars(ModelMap map){
		List<CarDTO> cars = carDAO.findAll();
		
		map.addAttribute("carList",cars);
		System.out.println(cars);
		return "carList";
	}
	
	@RequestMapping("/addCar")
	String addNewCar(ModelMap map,
					@RequestParam(value = "make") String make,
					@RequestParam(value = "model") String model,
					@RequestParam(value = "modelYear") String year){
				
		CarDTO car = new CarDTO();
		car.setMake(make);
		car.setModel(model);
		car.setModelYear(year);
		
		carDAO.create(car);
		
		List<CarDTO> cars = carDAO.findAll();
		cars = carDAO.findAll();
		map.addAttribute("carList",cars);
		System.out.println(cars);
		return "carList";
	}
	
	@RequestMapping("/carForm")
	String carForm(ModelMap map){
		return "carForm";
	}
	
}
