package com.project.vyntramart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.vyntramart.model.Wishlist;
@Repository
public interface WiahlistRepository extends JpaRepository<Wishlist, Long>{

}
