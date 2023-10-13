package com.anil.awslambda.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.awslambda.model.Employee;
import com.anil.awslambda.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		log.info("saveEmployee called");
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/active/{empId}")
	public String activeInactive(@PathVariable String empId, @RequestBody Employee employee) {
		log.info("updateEmployee called");
		System.out.println("isactive called");
		Employee activeInactive = employeeService.activeInactive(empId, employee);
		return "Successfully Updated";
	}

//	public static boolean validateDateFormat(String format,String date) {
//		if (format == null || format.length() == 0 || format.isEmpty() || format.trim().isEmpty() || format.equals("")
//				|| format.trim().equals("") || format.equalsIgnoreCase("null")) {
//			return false;
//		} 
//		if (date == null || date.length() == 0 || date.isEmpty() || date.trim().isEmpty() || date.equals("")
//				|| date.trim().equals("") || date.equalsIgnoreCase("null")) {
//			return false;
//		}
//		Date pdate = null;
//		DateFormat sdf = new SimpleDateFormat(format);
//        sdf.setLenient(false);
//        try {
//        	pdate=sdf.parse(date);
//        	
//        	if(date.equals(sdf.format(pdate))) {
//        		return true;
//        	}else {
//        		return false;
//        	}
//        } catch (ParseException e) {
//            return false;
//        }
//	}

//	@PostMapping
//	public Employee saveEmployee(@RequestBody Employee employee) {
//		log.info("saveEmployee called");
//		
//		return employeeService.saveEmployee(employee);
//	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		log.info("updateEmployee called");
		System.out.println("updateEmployee called");
		return employeeService.updateEmployee(employee);
	}

	@GetMapping("/{empId}")
	public Employee getEmployeeById(@PathVariable String empId) {
		log.info("getEmployeeById called");
		System.out.println("==============" + empId);
		return employeeService.getEmployeeById(empId);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		log.info("getEmployees called");
		return employeeService.getEmployees();
	}

	@DeleteMapping("/{empId}")
	public String deleteEmployeeById(@PathVariable String empId) {
		log.info("deleteEmployeeById called");
		return employeeService.deleteEmployeeById(empId);
	}

}
