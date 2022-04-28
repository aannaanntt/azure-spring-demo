package com.anant.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anant.spring.boot.entity.Employee;
import com.anant.spring.boot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emprepo;
	
	public List<Employee> getAllemp(){
		return emprepo.findAll();
	}
	
	public Employee getSingle(int id) {
		return emprepo.findById(id).orElse(null);
	}
	
	public Employee saveEmp(Employee emp) {
		return emprepo.save(emp);
	}
	
	public String deleteEmp(int id) {
		emprepo.deleteById(id);
		return "deleted of Id"+" "+id;
	}
	
	public Employee updateEmp(Employee emp) {
		Employee emplo = emprepo.findById(emp.getId()).orElse(null);
		emplo.setFirst_name(emp.getFirst_name());
		emplo.setLast_name(emp.getLast_name());
		emplo.setEmail(emp.getEmail());
		return emprepo.save(emplo);
		
	}
	
	
	
	
}
