package com.solera.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solera.airline.model.entity.User;
import com.solera.airline.model.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService uService;
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return uService.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@RequestParam int id) {
		return uService.findByIdUser(id);
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return uService.addUser(user) == 1 ? "ok" : "error";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@RequestParam int id) {
		return uService.deleteUser(id) == 1 ? "ok" : "error";
	}
	
	
}
