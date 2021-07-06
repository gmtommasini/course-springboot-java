package com.gmtommasini.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmtommasini.course.entities.Category;

//JpaRepository already has annotation @Repository
//@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	//SprindDataJPA has a default implementation for JpaRepository interface

}
