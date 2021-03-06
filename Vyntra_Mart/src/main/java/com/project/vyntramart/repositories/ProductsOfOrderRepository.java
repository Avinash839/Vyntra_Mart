package com.project.vyntramart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.vyntramart.model.ProductsOfOrder;

@Repository
public interface ProductsOfOrderRepository extends JpaRepository<ProductsOfOrder, Long>{

}
