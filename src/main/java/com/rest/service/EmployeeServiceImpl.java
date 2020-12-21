package com.rest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.bean.Employee;
import com.rest.jpa.EmployeeRepository;

 
@Service
public class EmployeeServiceImpl implements EmployeeService{

 @Autowired
 private EmployeeRepository employeeRepository;

 public void setEmployeeRepository(EmployeeRepository employeeRepository) {
  this.employeeRepository = employeeRepository;
 }
 
 
 public void addEmployee(Employee employee){
	 employeeRepository.save(employee);
 }
 
 public Employee getEmployee(Long employeeId) {
	 Optional<Employee> optEmp = employeeRepository.findById(employeeId);
	 return optEmp.get();
 }

 public void updateEmployee(Employee employee) {
	 employeeRepository.save(employee);
 }

 public void deleteEmployee(Long employeeId){
	 employeeRepository.deleteById(employeeId);
 }
 
 public List<Employee> listEmployees() {
  List<Employee> employees = employeeRepository.findAll();
  return employees;
 }

 public long employeeCount() {
	 return  employeeRepository.count();
}
 
}