package com.project.vyntramart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.vyntramart.service.ProductsService;
import com.project.vyntramart.service.UserService;
import com.project.vyntramart.controller.dto.*;

@Controller
@RequestMapping("/registration")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService=userService;
	}
	
	
	@ModelAttribute("user")
	public NewUserRegistration new_user() {
		return new NewUserRegistration();
	}
	
	
	
	@GetMapping
	public String registrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") NewUserRegistration newUserRegistration) {
		
		
		userService.save(newUserRegistration);
		
		
		return "redirect:/registration?success";
	}
	
	
	
	
	
}
