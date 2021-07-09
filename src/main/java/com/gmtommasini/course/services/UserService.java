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
		System.out.println("Find User by ID");
		User user  = repository.findById(id).get(); //findById returns an Optional<>, hence the .get() 
		return user; 
	}
	
	public User insert(User obj) {
		return repository.save(obj); //findById returns an Optional<>, hence the .get()
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone() );
		
	}

}
