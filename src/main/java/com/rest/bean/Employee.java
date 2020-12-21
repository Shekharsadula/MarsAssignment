package com.rest.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long id;
 
 @Column(name="FIRST_NAME")
 private String firstname;
 
 @Column(name="LAST_NAME")
 private String lastname;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}
 
 
}