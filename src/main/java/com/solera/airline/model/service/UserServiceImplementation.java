package com.solera.airline.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.airline.model.entity.User;
import com.solera.airline.model.repository.UserRepository;

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
	public int addUser(User user) {
		int ok = 0;
		if (uRepo.findById(user.getUserId()) == null) {
			try {
				uRepo.save(user);
				ok = 1;
			} catch (Exception e) {
				e.printStackTrace();
			} 
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
