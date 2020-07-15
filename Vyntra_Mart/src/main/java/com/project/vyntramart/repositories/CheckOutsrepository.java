package com.project.vyntramart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.vyntramart.model.CheckOuts;

@Repository
public interface CheckOutsrepository extends JpaRepository<CheckOuts, Long>{

}
