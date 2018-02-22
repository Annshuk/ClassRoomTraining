package com.springboot.demo.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("api/vi/")
	public String sayHello(){
		return "Hello World";
	}
}
