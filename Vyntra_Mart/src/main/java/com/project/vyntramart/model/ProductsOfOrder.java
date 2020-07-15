package com.project.vyntramart.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "vyntra_order_details")
public class ProductsOfOrder {
	
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long order_id;
	
	
	@Column
	private Long checkOutId;
	
	@Column
	private Long user_id;
	
	@Column
	private String pic1;
	
	@Column
	private String product_id;
	
	@Column
	private float rate;
//	
//	@Column
//	private int quantity;
	
	@Column
	private float amount;

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

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

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
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

	public float getAmount() {
		return amount;
	}

	public ProductsOfOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductsOfOrder [order_id=" + order_id + ", checkOutId=" + checkOutId + ", user_id=" + user_id
				+ ", pic1=" + pic1 + ", product_id=" + product_id + ", rate=" + rate 
				+ ", amount=" + amount + "]";
	}

	public ProductsOfOrder(Long order_id, Long checkOutId, Long user_id, String pic1, String product_id, float rate,
			 float amount) {
		super();
		this.order_id = order_id;
		this.checkOutId = checkOutId;
		this.user_id = user_id;
		this.pic1 = pic1;
		this.product_id = product_id;
		this.rate = rate;
		//this.quantity = quantity;
		this.amount = amount;
	}

	
	
	
	
}
