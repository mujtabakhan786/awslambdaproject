package com.anil.awslambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.awslambda.model.Employee;
import com.anil.awslambda.model.State;
import com.anil.awslambda.service.StateService;

@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "*")
public class StateController {

	@Autowired
	StateService service;

	@PostMapping
	public State saveSate(@RequestBody State state) {
		return service.saveSate(state);
	}
	
	@GetMapping("/states")
	public List<State> getState() {
		return service.getState();
	}
}
