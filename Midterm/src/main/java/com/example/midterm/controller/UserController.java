package com.example.midterm.controller;

import java.security.Principal;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.midterm.model.Role;
import com.example.midterm.model.User;
import com.example.midterm.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(path = "/home")
	public ModelAndView userDashboard(Principal principal) {
		ModelAndView mv = new ModelAndView("home.jsp");
		User u = userService.findByUsername(principal.getName());
		mv.addObject("user", u);

		if(u.getRole().getName().equalsIgnoreCase("ROLE_ADMIN")){
			System.out.println("I'm an Admin !");
		}
		if(u.getRole().getName().equalsIgnoreCase("ROLE_USER")){
			System.out.println("I'm a  User !");
		}
		
		return mv;
	}
	
	
	@RequestMapping(path = "/myInfos")
	public ModelAndView employeeInfos(Principal principal) {
		ModelAndView mv = new ModelAndView("userInfo.jsp");
		User u = userService.findByUsername(principal.getName());
		mv.addObject("employee", u.getEmp());
		
		return mv;
	}
	
	
	@RequestMapping(path = "/login")
	public String login() {
		return "login.jsp";
	}	
	
	
	@RequestMapping(path = "/logout-success")
	public String logout() {
		return "logout.jsp";
	}
}