package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Value("${env.name}")
	private String envName;

	@GetMapping("/hello")
	public String hello() {
		return "Hello world!! " + envName;
	}
}
