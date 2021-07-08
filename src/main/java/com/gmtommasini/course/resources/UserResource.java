package com.gmtommasini.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gmtommasini.course.entities.User;
import com.gmtommasini.course.services.UserService;

@RestController
@RequestMapping(value = "/users") // controller for endpoint "/users"
public class UserResource {
	
	/* //OLD for test
	 * @GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Mary", "mary@amil", "123098", "12345");		
		return ResponseEntity.ok().body(u);
	}*/
	
	@Autowired
	private UserService service;	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
//		List<User> list = service.findAll();
//		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> insert( @RequestBody User obj){ //@RequestBody indicates that User is in the message body
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{x}").buildAndExpand(obj.getName()).toUri(); //test
		return ResponseEntity.created(uri).body(obj);
		/*"created() returns code 201 */
	}

	
}
