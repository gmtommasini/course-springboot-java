package com.gmtommasini.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmtommasini.course.entities.Product;

//JpaRepository already has annotation @Repository
//@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	//SprindDataJPA has a default implementation for JpaRepository interface

}
