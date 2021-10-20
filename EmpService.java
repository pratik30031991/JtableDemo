package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeePojo;

@Service
public interface EmpService {
		
		public Boolean addEmployee(EmployeePojo ep);
		
		public List<EmployeePojo> getAllEmp();
		
		public EmployeePojo getSingleEmp(int id);
		
		public void deleteEmpById(int id);
}
