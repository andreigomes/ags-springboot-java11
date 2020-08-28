package com.ags.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ags.entities.Category;
import com.ags.entities.Order;
import com.ags.entities.OrderItem;
import com.ags.entities.Product;
import com.ags.entities.User;
import com.ags.entities.enums.OrderStatus;
import com.ags.repositories.CategoryRepository;
import com.ags.repositories.OrderItemRepository;
import com.ags.repositories.OrderRepository;
import com.ags.repositories.ProductRepository;
import com.ags.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Category categoria1 = new Category(null, "Eletrônicos diversos");
		Category categoria2 = new Category(null, "Televisores");
		Category categoria3 = new Category(null, "Computadores");
		categoryRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));

		Product produto1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,
				"");
		Product produto2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product produto3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product produto4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product produto5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99,
				"");
		productRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

		produto1.getCategories().add(categoria2);
		produto2.getCategories().add(categoria1);
		produto2.getCategories().add(categoria3);
		produto3.getCategories().add(categoria3);
		produto4.getCategories().add(categoria3);
		produto5.getCategories().add(categoria2);
		productRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

		User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "988224834", "123456");
		User usuario2 = new User(null, "Maria Antonia", "maria@gmail.com", "988224834", "123456");
		userRepository.saveAll(Arrays.asList(usuario1, usuario2));

		Order order1 = new Order(null, Instant.parse("2020-08-17T22:45:20Z"), OrderStatus.PAID, usuario1);
		Order order2 = new Order(null, Instant.parse("2020-08-16T22:45:20Z"), OrderStatus.WAITING_PAYMENT, usuario2);
		Order order3 = new Order(null, Instant.parse("2020-08-15T22:45:20Z"), OrderStatus.WAITING_PAYMENT, usuario1);
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));

		OrderItem orderItem1 = new OrderItem(order1, produto1, 2, produto1.getPrice()); 
		OrderItem orderItem2 = new OrderItem(order1, produto3, 1, produto3.getPrice()); 
		OrderItem orderItem3 = new OrderItem(order2, produto3, 2, produto3.getPrice()); 
		OrderItem orderItem4 = new OrderItem(order3, produto5, 2, produto5.getPrice());
		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
		
	}

}
