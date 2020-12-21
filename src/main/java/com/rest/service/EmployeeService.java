package com.rest.service;

import java.util.List;

import com.rest.bean.Employee;

public interface EmployeeService {
	
 public void addEmployee(Employee employee);
	
 public Employee getEmployee(Long employeeId);

 public void updateEmployee(Employee employee);

 public void deleteEmployee(Long employeeId);
 
 public List<Employee> listEmployees();
 
 public long employeeCount();
 
}