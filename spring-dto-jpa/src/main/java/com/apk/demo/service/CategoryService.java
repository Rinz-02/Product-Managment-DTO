package com.apk.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apk.demo.model.Category;
import com.apk.demo.request.CreateRequestCategory;
import com.apk.demo.request.UpdateRequestCategory;


public interface CategoryService 
{
	public List<Category> findAll();
	
	public Category create(CreateRequestCategory request);
	
	public Category findById(Long id);
	
	public boolean delete(Long id);

	public Category update(UpdateRequestCategory request);
}
