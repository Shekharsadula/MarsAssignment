package com.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bean.Employee;
import com.rest.service.EmployeeService;

import io.swagger.models.Response;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Add Employee
	@PostMapping("/rest/addemployee")
	public void addEmployee(Employee employee) {
		employeeService.addEmployee(employee);
		System.out.println("Employee Added Successfully");
	}

//search employee by employee id 
	@GetMapping("/rest/getemployee/{employeeId}")
	public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

//Update employee by employee id
	@PutMapping("/rest/updateemployee/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
		}
	}

	// Delete employee by employee id
	@DeleteMapping("/rest/deleteemployee/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		System.out.println("Employee Deleted Successfully");
	}

	// Count Employees
	@GetMapping("/rest/countemployees")
	public long countEmployees() {
		return employeeService.employeeCount();
	}
 

	//List all Employees
	@GetMapping("/rest/listemployees")
	public List<Employee> listEmployees() {
		List<Employee> employees = employeeService.listEmployees();
		return employees;
	}
}