package com.example.AthenticatedBackend;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.AthenticatedBackend.Models.ApplicationUser;
import com.example.AthenticatedBackend.Models.Role;
import com.example.AthenticatedBackend.repository.RoleRepository;
import com.example.AthenticatedBackend.repository.UserRepository;

@SpringBootApplication
public class AthenticatedBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthenticatedBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userrepository, PasswordEncoder passwordEncoder){
		return args ->{

				if(roleRepository.findByAuthority("ADMIN").isPresent())return;
				Role adminRole = roleRepository.save(new Role("ADMIN"));
				roleRepository.save(new Role("USER"));

				Set<Role> roles = new HashSet<>();
				roles.add(adminRole);

				ApplicationUser admin  = new ApplicationUser(1,"admin", passwordEncoder.encode("password"), roles);
				userrepository.save(admin);
		};
	}

}
