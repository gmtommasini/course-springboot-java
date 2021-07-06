package com.gmtommasini.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmtommasini.course.entities.Order;
import com.gmtommasini.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders") // controller for endpoint "/users"
public class OrderResource {
	
	/* //OLD for test
	 * @GetMapping
	public ResponseEntity<Order> findAll(){
		Order u = new Order(1L, "Mary", "mary@amil", "123098", "12345");		
		return ResponseEntity.ok().body(u);
	}*/
	
	@Autowired
	private OrderService service;	
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
//		List<Order> list = service.findAll();
//		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
