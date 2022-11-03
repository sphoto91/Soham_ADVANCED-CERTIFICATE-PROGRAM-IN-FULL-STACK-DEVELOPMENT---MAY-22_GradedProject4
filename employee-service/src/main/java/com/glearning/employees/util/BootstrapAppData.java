package com.glearning.employees.util;

import com.glearning.employees.model.Role;
import com.glearning.employees.model.User;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.glearning.employees.model.Employee;
import com.glearning.employees.repository.EmployeeRepository;
import com.glearning.employees.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {
	private EmployeeRepository employeeRepository;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployees(ApplicationReadyEvent event) {
		Employee rajdeep = new Employee();
		rajdeep.setName("Rajdeep");
		rajdeep.setEmail("rajdeep@abc.com");
		this.employeeRepository.save(rajdeep);
		
		Employee avik = new Employee();
		avik.setName("Aik");
		avik.setEmail("avik@abc.com");
		this.employeeRepository.save(avik);
		
		
		User abhijit = new User();
		abhijit.setUsername("abhijit");
		abhijit.setPassword(this.passwordEncoder.encode("abcd1234"));
		abhijit.setEmailAddress("abhijit@abc.com");
		
		Role santoshRole =  new Role();
		santoshRole.setRoleName("USER");
				
		Role abhijitRole =  new Role();
		abhijitRole.setRoleName("ADMIN");
				
		abhijitRole.setUser(abhijit);		
		abhijit.addRole(abhijitRole);
		
		User santosh = new User();
		santosh.setUsername("santosh");
		santosh.setPassword(this.passwordEncoder.encode("abcd1234"));
		santosh.setEmailAddress("santosh@abc.com");
		santoshRole.setUser(santosh);
		santosh.addRole(santoshRole);
		
		this.userRepository.save(abhijit);
		this.userRepository.save(santosh);
	}

}
