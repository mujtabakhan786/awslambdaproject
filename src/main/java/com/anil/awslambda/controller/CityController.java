package com.anil.awslambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.awslambda.model.City;
import com.anil.awslambda.model.Employee;
import com.anil.awslambda.service.CityService;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*")
public class CityController {

	@Autowired
	CityService service;

	@PostMapping
	public City saveCity(@RequestBody City city) {
		return service.saveCity(city);
	}
	
	@GetMapping("/{stateId}")
	public List<City> stateAgainstCity(@PathVariable String stateId) {
		System.out.println("==============" + stateId);
		List<City> id = service.getByStateId(stateId);
		return id;
		
	}
}
