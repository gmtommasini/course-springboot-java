package com.gmtommasini.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmtommasini.course.entities.Order;

//JpaRepository already has annotation @Repository
//@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	//SprindDataJPA has a default implementation for JpaRepository interface

}
