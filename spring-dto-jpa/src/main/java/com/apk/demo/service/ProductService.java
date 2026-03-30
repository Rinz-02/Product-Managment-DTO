package com.apk.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apk.demo.model.Product;

@Service
public interface ProductService 
{
	public List<Product> findAll();
	
	public Product save(Product product);
	
	public Product findById(Long id);
	
	public boolean delete(Long id);
	
}
