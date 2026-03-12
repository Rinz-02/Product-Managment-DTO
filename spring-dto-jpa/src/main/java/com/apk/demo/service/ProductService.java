package com.apk.demo.service;

import java.util.List;

import com.apk.demo.model.Product;

public interface ProductService 
{
	public List<Product> findAll();
	
	public Product save(Product product);
	
	public Product findById(Long id);
	
	public boolean delete(Long id);
	
}
