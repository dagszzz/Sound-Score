package com.instrument;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.instrument.domain.User;
import com.instrument.domain.security.Role;
import com.instrument.domain.security.UserRole;
import com.instrument.service.UserService;
import com.instrument.utility.SecurityUtility;

@SpringBootApplication
public class InstrumentApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(InstrumentApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("dags");
		user1.setLastName("dags");
		user1.setUsername("d");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("rcfd8110@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}
}
