package com.project.vyntramart.service;
import com.project.vyntramart.controller.dto.*;
import com.project.vyntramart.model.Products;
import java.util.*;
public interface ProductsService {
	
	List<Products> getAllProducts();
	Products getProductById(Long id);
	void deleteProductById(Long id);
	Products save(NewProductAdd newproduct);
	
}
