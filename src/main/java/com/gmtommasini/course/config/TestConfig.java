/* configuration class for TEST profile*/

package com.gmtommasini.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gmtommasini.course.entities.User;
import com.gmtommasini.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	/* CommandLineRunner constains "run" 
	 * run will be executed when the applications starts */
	
	
	/* database seed for now */	
	// Dependency injection: Repository classes have access to DB. 
	// @Autowired resolves dependency and associates a UserRepository instance
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestConfig run");
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	

}
