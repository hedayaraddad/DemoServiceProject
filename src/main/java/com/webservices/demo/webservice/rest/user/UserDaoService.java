package com.webservices.demo.webservice.rest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users=new ArrayList<User>();
	private static int usersCount = 5 ; 
	static {
		users.add(new User(1, "Ali", new Date()));
		users.add(new User(2, "Noi", new Date()));
		users.add(new User(3, "Roa", new Date()));
		users.add(new User(4, "Maan", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(usersCount++);
		}
		users.add(user);
		return user ;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null ;
	}

}
