package com.nitin.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 4;
	
	static {
		users.add(new User(1,"Nitin", new Date()));
		users.add(new User(2,"Jayant", new Date()));
		users.add(new User(3,"Madhusudan", new Date()));
		users.add(new User(4,"Manish", new Date()));
		
	}
	
	//findAll() to find all the user
	public List<User> findAll(){
		return users;
	}
	
	//save user
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	//find one of the user
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	// delete one of the user by id
		public User deleteById(int id) {
			Iterator<User> iterator = users.iterator();
			while (iterator.hasNext()) {
				User user = iterator.next();
				if(user.getId()==id) {
					iterator.remove();
					return user;
				}
			}
			return null;
		}
}
