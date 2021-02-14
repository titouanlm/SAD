package com.example.demo.securitysad.service;

import com.example.demo.securitysad.model.User;

public interface UserService {
	void save(User user);
	User findByUsername(String username);
}
