package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeePojo;
import com.example.demo.service.EmpService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmpService empService;

	@PostMapping("saveEmployee")
	public ResponseEntity<String> saveEmp(@RequestBody EmployeePojo ep) {
		System.out.println(ep);
		if (empService.addEmployee(ep)) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee details not Saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@CrossOrigin("*")
	@GetMapping("getAllEmployees")
	public List<EmployeePojo> getAllEmp() {

		List<EmployeePojo> empList = new ArrayList<>();

		empList = empService.getAllEmp();

		return empList;
	}

}
