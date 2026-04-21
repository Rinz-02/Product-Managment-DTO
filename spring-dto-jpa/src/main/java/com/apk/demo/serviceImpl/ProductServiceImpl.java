package com.apk.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apk.demo.mapper.CategoryMapper;
import com.apk.demo.mapper.ProductMapper;
import com.apk.demo.model.Category;
import com.apk.demo.model.Product;
import com.apk.demo.repository.CategoryRepository;
import com.apk.demo.repository.ProductRepository;
import com.apk.demo.request.CreateRequestProduct;
import com.apk.demo.request.UpdateRequestProduct;
import com.apk.demo.response.ResponseProduct;
import com.apk.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<ResponseProduct> findAll() 
	{
		List<Product> products =  productRepo.findAll();
		return products.stream()
				.map((product) -> {return ProductMapper.toResponse(product);})
				.collect(Collectors.toList());	 
	}

	@Override
	public ResponseProduct save(CreateRequestProduct product) 
	{
		return ProductMapper.toResponse(productRepo.save(ProductMapper.toEntity(product)));
	}

	@Override
	public ResponseProduct findById(Long id) 
	{
		return ProductMapper.toResponse(productRepo.findById(id).get());
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

	@Override
	public ResponseProduct update(UpdateRequestProduct request) 
	{
		Product existing = productRepo.findById(request.getId())
				.orElseThrow(() -> new RuntimeException("Product Not Found"));
		
		if(request.getName() != null) existing.setName(request.getName());
		if(request.getPrice() != null) existing.setPrice(request.getPrice());
		if(request.getQuantity() != null) existing.setQuantity(request.getQuantity());
		if(request.getStatus() != null) existing.setStatus(request.getStatus());
		
		if(request.getCategoryId() != null) 
		{
			Category category = categoryRepo.findById(request.getCategoryId())
					.orElseThrow(() -> new RuntimeException("ProductNotFound"));
			existing.setCategory(category);
		}
 		 productRepo.save(existing);
 		 
 		 return ProductMapper.toResponse(existing);
	}

}
