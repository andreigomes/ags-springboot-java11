package com.ags.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ags.entities.Order;
import com.ags.entities.User;
import com.ags.repositories.OrderRepository;
import com.ags.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "988224834","123456");
		User usuario2 = new User(null, "Maria Antonia", "maria@gmail.com", "988224834","123456");
	
		Order order1 = new Order(null, Instant.parse("2020-08-17T22:45:20Z"), usuario1);
		Order order2 = new Order(null, Instant.parse("2020-08-16T22:45:20Z"), usuario2);
		Order order3 = new Order(null, Instant.parse("2020-08-15T22:45:20Z"), usuario1);
		
		userRepository.saveAll(Arrays.asList(usuario1, usuario2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
	}
	
	
}
