package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.database.Roles;
import com.example.demo.database.Users;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;

@SpringBootApplication
public class WoroMedia1Application {

	public static void main(String[] args) {
		SpringApplication.run(WoroMedia1Application.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepo roleRepository, UserRepo userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByname("ADMIN").isPresent()) return;
			Roles adminRole = roleRepository.save(new Roles("ADMIN"));
			roleRepository.save(new Roles("USER"));

			Set<Roles> roles = new HashSet<>();
			roles.add(adminRole);

			Users admin = new Users((long)1, "admin", passwordEncode.encode("password"),"jagadabi@gmail.com", roles);

			userRepository.save(admin);
		};
	}

}
