package com.anant.spring.boot.controller;

import java.util.List;

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

import com.anant.spring.boot.entity.Employee;
import com.anant.spring.boot.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {
	@Autowired
	private EmployeeService empserv;
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return empserv.getAllemp();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getSingle(@PathVariable int id) {
		return empserv.getSingle(id);
		
	}
	@PostMapping("/saveemp")
	public Employee saveEmployee(@RequestBody Employee emp){
		return empserv.saveEmp(emp);
		
	}
	
	@DeleteMapping("/deleteemp/{id}")
	public String deleteEmp(@PathVariable int id) {
		return empserv.deleteEmp(id);
	}
	
	@PutMapping("/updateemp")
	public Employee updateEmp(@RequestBody Employee emp) {
		return empserv.updateEmp(emp);
	}
}
