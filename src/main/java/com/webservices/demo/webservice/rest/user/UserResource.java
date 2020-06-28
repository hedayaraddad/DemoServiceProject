package com.webservices.demo.webservice.rest.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	public UserDaoService service ;
	
	@GetMapping("/users")
	public List<User> retrieveAll(){
		return service.findAll() ;
	}
	
	@GetMapping("/users/{id}")
	public User retrieveOne(@PathVariable int id ) {
		User user =service.findOne(id);
		if(user == null) {
			throw new  UserNotFoundException("id_"+id);
		}
		return user ;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return service.save(user);
	}

}
