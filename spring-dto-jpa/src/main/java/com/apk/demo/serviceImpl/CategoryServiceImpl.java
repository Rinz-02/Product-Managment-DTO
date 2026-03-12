package com.apk.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apk.demo.model.Category;
import com.apk.demo.repository.CategoryRepository;
import com.apk.demo.service.CategoryService;

public class CategoryServiceImpl implements CategoryService
{

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<Category> findAll() 
	{
		return categoryRepo.findAll();
	}

	@Override
	public Category create(Category category) 
	{
		return categoryRepo.save(category);
	}

	@Override
	public Category findById(Long id) 
	{
		return categoryRepo.findById(id).get();
	}

	@Override
	public boolean delete(Long id) 
	{
		if(categoryRepo.existsById(id))
		{
			categoryRepo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

}
