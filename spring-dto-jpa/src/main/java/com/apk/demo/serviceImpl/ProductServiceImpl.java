package com.apk.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apk.demo.model.Product;
import com.apk.demo.repository.ProductRepository;
import com.apk.demo.service.ProductService;

public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product findById(Long id) {
		return productRepo.findById(id).get();
	}

	@Override
	public boolean delete(Long id) 
	{
		
		if(productRepo.existsById(id))
		{
			productRepo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

}
