package com.project.vyntramart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.vyntramart.controller.dto.NewProductAdd;
import com.project.vyntramart.controller.dto.NewUserRegistration;
import com.project.vyntramart.repositories.CheckOutsrepository;
import com.project.vyntramart.service.ProductsService;

@Controller

public class ProductController {

	@Autowired
	private ProductsService productsService;
	

	@Autowired
	CheckOutsrepository checkoutRepository;
	
	
	public ProductController(ProductsService productsService) {
		super();
		this.productsService=productsService;
	}
	@GetMapping("/admin")
	public String productregistrationForm(Model model) {
		
		model.addAttribute("products", productsService.getAllProducts());
		model.addAttribute("orders", checkoutRepository.findAll());
		
		return "admin";
	}
	
	@ModelAttribute("product")
	public NewProductAdd new_user() {
		return new NewProductAdd();
	}
	
	@PostMapping("/addproduct")
	public String registerUserAccount(@ModelAttribute("product") NewProductAdd newpro) {
		productsService.save(newpro);
		return "redirect:/admin?success";
	}
	@PostMapping("/deleteproduct{id}")
	public String delete(@PathVariable(value="id") Long id) {
		productsService.deleteProductById(id);
		return null;
		
	}
	
	@PostMapping("/deliverProduct/{id}")
	public String deliver(@PathVariable(value="id") Long id) {
		
		System.out.println("The current status of this checkout os     "+checkoutRepository.getOne(id).getStatus());
		checkoutRepository.getOne(id).setStatus("Delivered");
		System.out.println("The current status of this checkout os     "+checkoutRepository.getOne(id).getStatus());
		checkoutRepository.save(checkoutRepository.getOne(id));
		return "redirect:/admin";
		
	}
}
