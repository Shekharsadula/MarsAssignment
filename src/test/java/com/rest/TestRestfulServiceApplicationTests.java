package com.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.rest.bean.Employee;
import com.rest.controller.EmployeeRestController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestRestfulServiceApplicationTests {
	
	@LocalServerPort
	private int portNumber;

 	@Autowired
	private EmployeeRestController employeeRestController;

 	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void contextLoads() throws Exception {
		assertThat(employeeRestController).isNotNull();
	}
	 
	   @Test
	   public void addEmployeeTest() throws JSONException  {
		   Employee emp=new Employee();
		   emp.setId(1l);
		   emp.setFirstname("rest");
		   emp.setLastname("rest");
		   ResponseEntity<Employee> response =restTemplate.postForEntity("http://localhost:" + portNumber + "/rest/addemployee",emp, Employee.class);
			
		   Assertions.assertEquals(200,response.getStatusCodeValue());
		   Assertions.assertEquals(Employee.class,response.getBody().getClass());
		   Assertions.assertEquals(emp.getId(),response.getBody().getId());
		   Assertions.assertEquals(emp.getFirstname(),response.getBody().getFirstname());
		   Assertions.assertEquals(emp.getLastname(),response.getBody().getLastname());
	   }
	   @Test
		public void totalCountTest()   {
		    ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:" + portNumber + "/rest/countemployees",String.class);
			Assertions.assertEquals(200, response.getStatusCodeValue());
		}
		@Test
		public void listEmployeesTest() throws JSONException {
			ResponseEntity<Object> response=restTemplate.getForEntity("http://localhost:" + portNumber + "/rest/listemployees",Object.class);
			
			Assertions.assertEquals(200,response.getStatusCodeValue());
			@SuppressWarnings("unchecked")
			List<Employee> list=(List<Employee>)response.getBody();
			Assertions.assertEquals(1,list.size());
		}
		@Test
		public void updateEmployeeTest() {
			ResponseEntity<Employee> response =restTemplate.getForEntity("http://localhost:" + portNumber + "/rest/getemployee/1",Employee.class);
			Employee emp=response.getBody();
			emp.setFirstname("sanjay");
			emp.setLastname("sanjay");
			   restTemplate.put("http://localhost:" + portNumber + "/rest/updateemployee/"+emp.getId(),emp);
			   ResponseEntity<Employee> responseupdate =restTemplate.getForEntity("http://localhost:" + portNumber + "/rest/getemployee/1",Employee.class);
			   Assertions.assertEquals(200, restTemplate.getForEntity("http://localhost:" + portNumber + "/rest/getemployee/"+emp.getId(),Employee.class).getStatusCodeValue());
			   Assertions.assertEquals("sanjay", responseupdate.getBody().getFirstname());
			   Assertions.assertEquals("sanjay", responseupdate.getBody().getLastname());
		}
		
		@Test
		public void getEmployeeTest() {
			
			  Employee emp=new Employee();
			  emp.setId(2l); 
			  emp.setFirstname("sam");
			  emp.setLastname("sam");
			  //To Add new Employeee
			  ResponseEntity<Employee> response=restTemplate.postForEntity("http://localhost:" + portNumber +"/rest/addemployee",emp, Employee.class);
			  //To get Employee test
			Assertions.assertEquals(200, restTemplate.getForEntity("http://localhost:" + portNumber + "/rest/getemployee/"+response.getBody().getId(),Employee.class).getStatusCodeValue());
		}
		@Test
		public void deleteEmployeeTest() {
			
			  Employee emp=new Employee(); 
			  emp.setId(3l); 
			  emp.setFirstname("sandy");
			  emp.setLastname("sandy"); 
			  
			  ResponseEntity<Employee> response=restTemplate.postForEntity("http://localhost:" + portNumber +"/rest/addemployee",emp, Employee.class); 
			  
			  restTemplate.delete("http://localhost:" + portNumber +"/rest/deleteemployee/"+response.getBody().getId());
		       
		       Assertions.assertEquals(404, restTemplate.getForEntity("http://localhost:" + portNumber + "/rest/getemployee/"+response.getBody().getId(),Employee.class).getStatusCodeValue());
		}
		
}
