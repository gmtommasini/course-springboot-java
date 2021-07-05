package com.gmtommasini.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmtommasini.course.entities.User;

@RestController
@RequestMapping(value = "/users") // controller for endpoint "/users"
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Mary", "mary@amil", "123098", "12345");
		
		return ResponseEntity.ok().body(u);
	}
}
