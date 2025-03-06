package com.leoweb.course.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leoweb.course.entities.Order;
import com.leoweb.course.entities.User;
import com.leoweb.course.repositories.OrderRepository;
import com.leoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "João", "joao@gmail.com", "999999999", "12345");
		User u2 = new User(null, "Maria", "maria@gmail.com", "888888888", "54321");
		
		saveIfNotExists(u1);
	    saveIfNotExists(u2);
	    
		
	
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	private void saveIfNotExists(User user) {
	    if (user.getId() != null && userRepository.findById(user.getId()).isEmpty()) {
	        userRepository.save(user);
	    }
	    // Se o ID for nulo, significa que é um novo usuário, então salva direto
	    else if (user.getId() == null) {
	        userRepository.save(user);
	    }
	}


}
