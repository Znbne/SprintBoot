package com.javatpoint.springboothelloworldexample.user;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController

public class UserResource {

	@Autowired
	private UserDaoService service;
	//retrieveAllUsers
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user ==null)
			throw new UserNotFoundException("id-"+id);
		
		EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        return resource.add(link.withRel("all-users"));
       
		// return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void DeleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user ==null)
			throw new UserNotFoundException("id-"+id);
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> retrieveUser(@Valid @RequestBody User user) {
		
		User savedUser = service.save(user);
		//	http://localhost:8081/users/4
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
