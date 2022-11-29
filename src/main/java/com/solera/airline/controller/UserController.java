package com.solera.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public User getUserById(@PathVariable int id) {
		return uService.findByIdUser(id);
	}
	
	@GetMapping("/name/{name}")
	public User getUserByName(@PathVariable String name) {
		return uService.findByNameUser(name);
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return uService.addUser(user) == 1 ? "ok" : "error";
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteUser(@PathVariable int id) {
		if(uService.findByIdUser(id) == null) {
			return "The user does not exist";
		}
		return uService.deleteUser(id) == 1 ? "ok" : "error";
	}
	
	
}
