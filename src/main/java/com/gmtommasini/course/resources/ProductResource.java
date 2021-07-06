package com.gmtommasini.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmtommasini.course.entities.Product;
import com.gmtommasini.course.services.ProductService;

@RestController
@RequestMapping(value = "/products") // controller for endpoint "/users"
public class ProductResource {
	
	/* //OLD for test
	 * @GetMapping
	public ResponseEntity<Product> findAll(){
		Product u = new Product(1L, "Mary", "mary@amil", "123098", "12345");		
		return ResponseEntity.ok().body(u);
	}*/
	
	@Autowired
	private ProductService service;	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
//		List<Product> list = service.findAll();
//		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
