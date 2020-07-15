package com.project.vyntramart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name= "vyntra_check_out_details")
public class CheckOuts {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long checkOutId;
	
	@Column
	private Long user_id;
	
	@Column
	private String pic1;
	
	@Column
	private Long product_id;
	
	@Column
	private float rate;
	
	@Column
	private String status;
	
	@Column
	private String shipping_address;
	
//	@Column
//	private float amount;
	
	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ElementCollection
    @CollectionTable(name = "vyntra_order_details", joinColumns = @JoinColumn(name = "checkOutId"))
    @Column(name = "product_id")
	Set<Long> order=new HashSet<>();

	public Long getCheckOutId() {
		return checkOutId;
	}

	public void setCheckOutId(Long checkOutId) {
		this.checkOutId = checkOutId;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long long1) {
		this.product_id = long1;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public float getAmount() {
//		return amount;
//	}
//
//	public void setAmount(float amount) {
//		this.amount = amount;
//	}

	public Set<Long> getOrder() {
		return order;
	}

	public void setOrder(Set<Long> order) {
		this.order = order;
	}

	

	
	public CheckOuts(Long user_id, String pic1, Long product_id, float rate, String status, String shipping_address,
			Set<Long> order) {
		super();
		this.user_id = user_id;
		this.pic1 = pic1;
		this.product_id = product_id;
		this.rate = rate;
		this.status = status;
		this.shipping_address = shipping_address;
		this.order = order;
	}

	public CheckOuts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}
