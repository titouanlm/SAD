package com.example.designpatterns.builder.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.designpatterns.builderwithlombok.User;

import com.example.designpatterns.builderwithoutlombok.User2;
import com.example.designpatterns.builderwithoutlombok.UserBuilder;

@RestController
@RequestMapping("/builder")
public class BuilderController {

	@GetMapping("user1")
	public String getUser1() {
		User2 user = new UserBuilder()
				.setEmail("titouan.lemao@gmail.com")
				.setName("Titouan")
				.setNationality("France")
				.setUid(1)
				.build();
		System.out.println(user.toString());
		return "created";
					
	}
	
	
	@GetMapping("userAuto")
	public String getUser2() {
		User user = User.builder()
				.email("remi@gmail.com")
				.name("Rémi")
				.nationality("Sénégale")
				.uid(2)
				.build();
		System.out.println(user.toString());
		return "created";
	}
	
}
