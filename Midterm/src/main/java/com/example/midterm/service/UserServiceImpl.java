package com.example.midterm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.midterm.dao.EmployeeJPADao;
import com.example.midterm.dao.UserJPADao;
import com.example.midterm.model.Employee;
import com.example.midterm.model.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserJPADao userDao;
	
	
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Autowired
	EmailService emailService;
	
	
	@Override
	public void save(User user) {
		String hashedPassword = bCryptEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setActive(true);
		userDao.save(user);
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(user.getEmail());
		emailMsg.setText("You are registered!");
		emailMsg.setSubject("Registration successful!");
		emailMsg.setFrom("admin@random.asia");

		try {
			emailService.sendEmail(emailMsg);
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
		
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User findById(int uid) {
		// TODO Auto-generated method stub
		return userDao.getOne(uid);
	}

}
