package com.project.vyntramart.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vyntra_order_details")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long order_id;
	
	@Column
	private String user_id;
	
	@Column
	private Long checkOutId;
	
	public Long getCheckOutId() {
		return checkOutId;
	}

	public void setCheckOutId(Long checkOutId) {
		this.checkOutId = checkOutId;
	}

	@Column
	private String amount;
	public Orders() {
	
	}
	
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "products_of_order", joinColumns = @JoinColumn(name = "order_id", insertable = false, updatable = false))
	private Set<ProductsOfOrder> products_of_order = new HashSet<>();
	
	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Set<ProductsOfOrder> getProducts_of_order() {
		return products_of_order;
	}

	public void setProducts_of_order(Set<ProductsOfOrder> products_of_order) {
		this.products_of_order = products_of_order;
	}

	public Orders(String user_id, Long checkOutId, String amount, Set<ProductsOfOrder> products_of_order) {
		super();
		this.user_id = user_id;
		this.checkOutId = checkOutId;
		this.amount = amount;
		this.products_of_order = products_of_order;
	}

	

	

	
	
	
	
	
}
