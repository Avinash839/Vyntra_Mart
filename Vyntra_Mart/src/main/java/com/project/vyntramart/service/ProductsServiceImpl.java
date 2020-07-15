package com.project.vyntramart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vyntramart.controller.dto.NewProductAdd;
import com.project.vyntramart.model.Products;
import com.project.vyntramart.repositories.ProductRepository;

@Service

public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductRepository productRepository;
	
	public  ProductsServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository=productRepository;
	}
	
	
	@Override
	public Products save(NewProductAdd newproduct) {
		Products pro= new Products(newproduct.getProduct_code(),newproduct.getBrand_name(),newproduct.getCategory(),
				newproduct.getPrice(),newproduct.getDiscount(),newproduct.getColour(),newproduct.getIdeal()
				,newproduct.getSupplier(),newproduct.getPic1(),newproduct.getPic2());
		return productRepository.save(pro);
	}

	
	@Override
	public List<Products> getAllProducts() {
		return productRepository.findAll();
	}

	

	@Override
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
		
	}


	@Override
	public Products getProductById(Long id) {
		return productRepository.getOne(id);
	
	}
	
	

}
