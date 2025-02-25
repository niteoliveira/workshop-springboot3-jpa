package com.leoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leoweb.course.entities.User;
import com.leoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "João", "joao@gmail.com", "999999999", "12345");
        User user2 = new User(null, "Maria", "maria@gmail.com", "888888888", "54321");
		
        userRepository.saveAll(Arrays.asList(user1,user2));
	}

}
