package com.apk.demo.mapper;

import com.apk.demo.model.Category;
import com.apk.demo.request.CreateRequestCategory;
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
	
	public static Category toEntity(CreateRequestCategory request)
	{	 
		return Category.builder()
				.name(request.getName())
				.description(request.getDescription())
				.build();
	}
	
	//update
	public static void updateEntity(UpdateRequestCategory request,Category existing)
	{
		 existing.setName(request.getName());
		 existing.setDescription(request.getDescription());
	}
	

	
}
