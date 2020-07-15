package com.project.vyntramart.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "vyntra_products", uniqueConstraints = @UniqueConstraint(columnNames = "product_code"))
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long product_id;
	
	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	
	
	
	@Column
	private String product_code;
	
	@Column
	private String brand_name;
	
	@Column
	private String category;
	
	@Column
	private float price;
	
	@Column
	private float discount;
	
	@Column
	private String colour;
	
	
	@Column 
	private String ideal;
	
	@Column
	private String supplier;
	
	@Column
	private String pic1;
	
	@Column
	private String pic2;

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getIdeal() {
		return ideal;
	}

	public void setIdeal(String ideal) {
		this.ideal = ideal;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public Products(String product_code, String brand_name, String category, float price, float discount, String colour,
		 String ideal, String supplier, String pic1, String pic2) {
		super();
		this.product_code = product_code;
		this.brand_name = brand_name;
		this.category = category;
		this.price = price;
		this.discount = discount;
		this.colour = colour;
		
		this.ideal = ideal;
		this.supplier = supplier;
		this.pic1 = pic1;
		this.pic2 = pic2;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
