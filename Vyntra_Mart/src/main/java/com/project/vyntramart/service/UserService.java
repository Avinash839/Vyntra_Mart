package com.project.vyntramart.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.vyntramart.model.Products;
import com.project.vyntramart.model.User;
import com.project.vyntramart.controller.dto.*;

public interface UserService extends UserDetailsService{
	User save(NewUserRegistration newuser);
	 void addToCart(Long product_id ,String username );
}
