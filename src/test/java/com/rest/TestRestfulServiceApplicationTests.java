package com.rest;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.bean.Employee;
import com.rest.jpa.EmployeeRepository;
import com.rest.service.EmployeeService;

@SpringBootTest
@RunWith(SpringRunner.class)
class TestRestfulServiceApplicationTests {

	@MockBean
	private EmployeeRepository employeeRepository;

	   @Test
	   public void testEmployeewhileadding() {
		   Employee emp=new Employee();
		   emp.setId(1l);
		   emp.setFirstname("test");
		   emp.setLastname("name");
	      when(employeeRepository.save(emp)).thenReturn(emp);
	   }
	 

	   
	   
	   
}
