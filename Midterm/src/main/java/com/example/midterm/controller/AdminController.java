package com.example.midterm.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.midterm.dao.EmployeeJPADao;
import com.example.midterm.model.Employee;
import com.example.midterm.model.Level;
import com.example.midterm.model.User;
import com.example.midterm.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
		
	@Autowired
	EmployeeJPADao jpaDao;
	
	@RequestMapping(path = "/createUser", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "createUser.jsp";
	}
	
	@RequestMapping(path = "/createUser", method=RequestMethod.POST)
	public String createUser( @ModelAttribute("user") User user,
			BindingResult bindingResult) {
		user.getEmp().setId(user.getId());
		user.getEmp().setBirthday(LocalDate.now());
		user.getEmp().setUser(user);
		
		userService.save(user);
		
		return "createUser.jsp";
		
	}
	
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView("employees.jsp");	
		List<Employee> employees = jpaDao.findAll();
		mv.addObject("employees" , employees);
		return mv;
	}
	
	
	@RequestMapping(path = "/deleteUser", method=RequestMethod.GET)
	public String deleteUser(Model model) {
		return "deleteUser.jsp";
	}
	
	
	@RequestMapping(path = "/deleteUserById/{uid}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable("uid") int uid) {
		User u = userService.findById(uid);		
		
		if(u == null) {
			return "error";
		}
		
		userService.delete(u);
		
		return "deleted";
	}

}
