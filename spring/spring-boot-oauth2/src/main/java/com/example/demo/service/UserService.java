package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	User create(User user);
	
	void delete(long id);
	
	List<User> findAll();
	
}
