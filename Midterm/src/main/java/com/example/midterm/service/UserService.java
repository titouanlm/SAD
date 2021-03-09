package com.example.midterm.service;


import com.example.midterm.model.User;

public interface UserService {
	void save(User user);
	User findByUsername(String username);
	void delete(User user);
	User findById(int uid);
}
