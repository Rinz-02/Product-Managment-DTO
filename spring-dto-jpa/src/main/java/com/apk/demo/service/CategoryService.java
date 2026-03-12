package com.apk.demo.service;

import java.util.List;

import com.apk.demo.model.Category;

public interface CategoryService 
{
	public List<Category> findAll();
	
	public Category create(Category category);
	
	public Category findById(Long id);
	
	public boolean delete(Long id);
}
