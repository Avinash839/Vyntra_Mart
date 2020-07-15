package com.project.vyntramart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.vyntramart.controller.dto.NewProductAdd;
import com.project.vyntramart.repositories.CheckOutsrepository;
import com.project.vyntramart.service.ProductsService;
import com.project.vyntramart.service.UserService;

@Controller
public class MainController {
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@Autowired
	ProductsService productsService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", productsService.getAllProducts());
		return "index";
	}
	

}


