package com.project.vyntramart.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.project.vyntramart.model.*;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String phone_number;
	
	
	public String getPhone_number() {	
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_roles",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
			)
	private Collection<Role> roles;
	
	
	@ElementCollection
    @CollectionTable(name = "vyntra_cart", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "product_id")
	Set<Long> cart=new HashSet<>();
	
	@ElementCollection
    @CollectionTable(name = "vyntra_wishlist", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "product_id")
	Set<Long> wishlist=new HashSet<>();
	
	
	
	public Set<Long> getWishlist() {
		return wishlist;
	}
	public void setWishlist(Set<Long> wishlist) {
		this.wishlist = wishlist;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Long> getCart() {
		return cart;
	}
	public void setCart(Set<Long> cart) {
		this.cart = cart;
	}
	public User(String firstname, String lastname, String email, String password, String phone_number,
			Collection<Role> roles,Set<Long> cart,Set<Long> wishlist) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
		this.roles = roles;
		this.wishlist = wishlist;
		this.cart = cart;
	}
	public User() {
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
