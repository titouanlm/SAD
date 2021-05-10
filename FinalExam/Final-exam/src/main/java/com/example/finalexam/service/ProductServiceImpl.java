package com.example.finalexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalexam.model.Product;
import com.example.finalexam.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	private ProductRepo repo;

	@Override
	public List<Product> findAllProducts() {
		return repo.findAll();
	}
	
}
