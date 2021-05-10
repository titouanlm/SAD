package com.example.finalexam.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.finalexam.model.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {
	
	//@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select p from Product p where p.id = :id")
	Product findProductForWrite(@Param("id") int id);
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select p from Product p where p.id = :id")
	Product findProductForRead(@Param("id") int id);
	
}