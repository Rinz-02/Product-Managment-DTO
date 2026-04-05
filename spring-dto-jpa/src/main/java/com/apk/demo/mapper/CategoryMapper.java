package com.apk.demo.mapper;

import com.apk.demo.model.Category;
import com.apk.demo.request.CreateRequestCategory;
import com.apk.demo.request.CreateRequestProduct;
import com.apk.demo.request.UpdateRequestCategory;
import com.apk.demo.response.ResponseCategory;

public class CategoryMapper 
{
	public static ResponseCategory toResponse(Category category)
	{
		return ResponseCategory.builder()
				.id(category.getId())
				.name(category.getName())
				.description(category.getDescription())
				.build();
				
	}
	
	public static Category toEntity(CreateRequestCategory product)
	{	 
		return Category.builder()
				.name(product.getName())
				.description(product.getDescription())
				.build();
	}
	
		
}
