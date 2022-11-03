package com.glearning.employees.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstname;
	private String lastname;
	private String email;
	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setLastName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(String string) {
		// TODO Auto-generated method stub
		
	}

}
