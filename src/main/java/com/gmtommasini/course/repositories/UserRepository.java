package com.gmtommasini.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmtommasini.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//SprindDataJPA has a default implementation for JpaRepository interface

}
