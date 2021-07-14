package com.gmtommasini.course.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gmtommasini.course.entities.User;
import com.gmtommasini.course.repositories.UserRepository;
import com.gmtommasini.course.services.exceptions.DatabaseException;
import com.gmtommasini.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		System.out.println("Find User by ID");

		Optional<User> user = repository.findById(id); // findById returns an Optional<>, hence the .get()
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj); // findById returns an Optional<>, hence the .get()
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public User update(Long id, User obj) {
		try {
			User entity = repository.getById(id);
			updateData(entity, obj);

			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
