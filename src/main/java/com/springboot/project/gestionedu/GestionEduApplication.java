package com.springboot.project.gestionedu;

import com.springboot.project.gestionedu.core.dao.entities.Role;
import com.springboot.project.gestionedu.core.dao.entities.User;
import com.springboot.project.gestionedu.core.dao.repositories.RoleRepository;
import com.springboot.project.gestionedu.core.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@SpringBootApplication
public class GestionEduApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(GestionEduApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RoleRepository roleRepository, UserRepository userRepository) {
		return (args) -> {
			Role role=new Role();
			role.setName("ROLE_ADMIN");
			roleRepository.save(role);

			Role role2=new Role();
			role2.setName("ROLE_USER");
			roleRepository.save(role2);

			Set<Role> roleBoth = roleRepository.findAll().stream().collect(Collectors.toSet());
			Role roleUser = roleRepository.findByName("ROLE_USER").get();

			User user=new User();
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("123456"));
			user.setRoles(roleBoth);
			userRepository.save(user);

			User user2=new User();
			user2.setUsername("user");
			user2.setPassword(passwordEncoder.encode("123456"));
			user2.setRoles(Collections.singleton(roleUser));
			userRepository.save(user2);
		};
	}

}
