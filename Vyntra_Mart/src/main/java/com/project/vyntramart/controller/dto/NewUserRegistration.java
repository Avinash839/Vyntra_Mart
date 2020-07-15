package com.project.vyntramart.controller.dto;
import java.util.Set;

import com.project.vyntramart.model.*;

public class NewUserRegistration {

	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String phone_number;
	Set<Cart> cart;
	public String getPhone_number() {
		return phone_number;
	}
	public Set<Cart> getCart() {
		return cart;
	}
	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public NewUserRegistration(String firstname, String lastname, String password, String email, String phone_number,Set<Cart> cart) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
	}
	public NewUserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
