package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeePojo;
import com.example.demo.repository.EmpRepo;
import com.example.demo.service.EmpService;

@Service
public class empServiceImpl implements EmpService {

	@Autowired
	private EmpRepo empRepo;

	@Override
	public List<EmployeePojo> getAllEmp() {
		List<EmployeePojo> employeeList = empRepo.findAll();
		return employeeList;

	}


	@Override
	public Boolean addEmployee(EmployeePojo ep) {
		Boolean b = empRepo.save(ep) != null;

		return b;
	}

	@Override
	public EmployeePojo getSingleEmp(int id) {
		EmployeePojo ep = empRepo.findById(id);
		return ep;
	}


	@Override
	public void deleteEmpById(int id) {
		this.empRepo.deleteById(id);
		
	}

}
