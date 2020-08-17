package com.ags.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ags.entities.User;
import com.ags.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "988224834","123456");
		User usuario2 = new User(null, "Maria Antonia", "maria@gmail.com", "988224834","123456");
	
		userRepository.saveAll(Arrays.asList(usuario1, usuario2));
	}
	
	
}