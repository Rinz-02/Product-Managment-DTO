package com.apk.demo.mapper;

import com.apk.demo.model.Category;
import com.apk.demo.model.Product;
import com.apk.demo.request.CreateRequestProduct;
import com.apk.demo.response.ResponseProduct;

public class ProductMapper 
{
	public static ResponseProduct toResponse(Product product)
	{
		return ResponseProduct.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.quantity(product.getQuantity())
				.description(product.getDescription())
				.status(product.getStatus())
				.categoryId(product.getCategory().getId())
				.build();
	}
	
	//
	public static Product toEntity(CreateRequestProduct request)
	{
		Category category = new Category();
		category.setId(request.getCategoryId());
		
		Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setQuantity(request.getQuantity());
		product.setStatus(request.getStatus());
		product.setCategory(category);
		
		return product;
		
	}
}
