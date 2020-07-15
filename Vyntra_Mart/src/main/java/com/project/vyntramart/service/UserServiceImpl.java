package com.project.vyntramart.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.vyntramart.model.Cart;
import com.project.vyntramart.model.Products;
import com.project.vyntramart.model.Role;
import com.project.vyntramart.model.User;
import com.project.vyntramart.repositories.UserRepository;

import javassist.expr.NewArray;

import com.project.vyntramart.controller.dto.*;;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	private UserRepository userRepository;
	
	public  UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}
	
	@Override
	public User save(NewUserRegistration newuser) {
		User user= new User(newuser.getFirstname(),newuser.getLastname(),newuser.getEmail(),
				passwordEncoder.encode(newuser.getPassword()),newuser.getPhone_number(),Arrays.asList(new Role("USER")),new HashSet<>(),new HashSet<>());
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid Username or password");
		}
		
		 return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		
		
	}

	@Override
	public void addToCart(Long product,String Username) {
//		Cart c=new Cart(product);
//		System.out.println("For the person           "+userRepository.findByEmail(Username).getFirstname());
//		userRepository.findByEmail(Username).getCart().add(c);
	}

	
}
