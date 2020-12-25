package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bean.Employee;
import com.rest.exception.ResourceNotFoundException;
import com.rest.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/getemployee/{employeeId}")
	public ResponseEntity <Employee> getEmployee(@PathVariable(name = "employeeId") Long employeeId) throws ResourceNotFoundException{
		Employee emp= employeeService.getEmployee(employeeId);
		 return ResponseEntity.ok().body(emp);
	}

	@PutMapping("/updateemployee/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
		} 
	}

	@DeleteMapping("/deleteemployee/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		Employee emp= employeeService.getEmployee(employeeId);
		if(emp!=null) {
			employeeService.deleteEmployee(employeeId);
		}
 	}

	@GetMapping("/countemployees")
	public long countEmployees() {
		return employeeService.employeeCount();
	}
 

	@GetMapping("/listemployees")
	public List<Employee> listEmployees() {
		List<Employee> employees = employeeService.listEmployees();
		return employees;
	}
}