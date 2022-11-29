package com.solera.airline.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solera.airline.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserByName(String name);
}
