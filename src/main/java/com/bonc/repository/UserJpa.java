package com.bonc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bonc.entity.User;

public interface UserJpa extends JpaRepository<User, String> {
	public User findByUsername(String username);
}
