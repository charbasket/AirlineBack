package com.solera.airline.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.airline.model.user.entity.User;
import com.solera.airline.model.user.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository uRepo;
	
	@Override
	public List<User> findAllUsers() {
		return uRepo.findAll();
	}

	@Override
	public User findByIdUser(int userId) {
		return uRepo.findById(userId).orElse(null);
	}

	@Override
	public User findByNameUser(String userName) {
		return uRepo.findUserByName(userName);
	}
	
	@Override
	public int addUser(User user) {
		int ok = 0;
			try {
				uRepo.save(user);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return ok;
	}

	@Override
	public int deleteUser(int userId) {
		int ok = 0;
		if (uRepo.findById(userId) != null) {
			try {
				uRepo.deleteById(userId);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return ok;
	}



}
