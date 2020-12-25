package com.rest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.bean.Employee;
import com.rest.exception.ResourceNotFoundException;
import com.rest.jpa.EmployeeRepository;

 
@Service
public class EmployeeServiceImpl implements EmployeeService{

 @Autowired
 private EmployeeRepository employeeRepository;
 
 @Override
 public Employee addEmployee(Employee employee){
	 return employeeRepository.save(employee);
 }
 
 @Override
 public Employee getEmployee(Long employeeId) {
	 Optional<Employee> optEmp = employeeRepository.findById(employeeId);
	 if(!optEmp.isPresent())
		 throw new ResourceNotFoundException("Employee Not Found with Id :"+employeeId, employeeId);
	 return optEmp.get();
 }
 
 @Override
 public void updateEmployee(Employee employee) {
	 employeeRepository.save(employee);
 }
 
 @Override
 public void deleteEmployee(Long employeeId){
	 employeeRepository.deleteById(employeeId);
 }
 
 @Override
 public List<Employee> listEmployees() {
  List<Employee> employees = employeeRepository.findAll();
  return employees;
 }
 
 @Override
 public long employeeCount() {
	 return  employeeRepository.count();
}
 
}