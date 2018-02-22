package com.springboot.demo.springbootdemo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Serializable>{

	List<Car> findCarsByMake(String make);
}
