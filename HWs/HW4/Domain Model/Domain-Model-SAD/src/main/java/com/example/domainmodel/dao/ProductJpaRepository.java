package com.example.domainmodel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domainmodel.model.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer>{

}
