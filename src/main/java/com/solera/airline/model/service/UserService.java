package com.solera.airline.model.service;

import java.util.List;

import com.solera.airline.model.entity.User;

public interface UserService {
	
	List<User> findAllUsers();
	User findByIdUser(int userId);
	User findByNameUser(String userName);
	int addUser(User user);
	int deleteUser(int userId);
	
}
