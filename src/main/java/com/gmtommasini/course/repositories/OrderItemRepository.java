package com.gmtommasini.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmtommasini.course.entities.OrderItem;

//JpaRepository already has annotation @Repository
//@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	//SprindDataJPA has a default implementation for JpaRepository interface

}
