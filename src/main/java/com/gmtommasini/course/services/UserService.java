package com.gmtommasini.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmtommasini.course.entities.User;
import com.gmtommasini.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id).get(); //findById returns an Optional<>, hence the .get()
	}
	
	public User insert(User obj) {
		return repository.save(obj); //findById returns an Optional<>, hence the .get()
	}
	

}
