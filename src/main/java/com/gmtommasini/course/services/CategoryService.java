package com.gmtommasini.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmtommasini.course.entities.Category;
import com.gmtommasini.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		return repository.findById(id).get(); //findById returns an Optional<>, hence the .get()
	}

}
