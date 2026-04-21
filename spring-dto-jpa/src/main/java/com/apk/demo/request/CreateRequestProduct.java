package com.apk.demo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestProduct 
{
	private String name;
	private String price;
	private String description;
	private String status;
	private String quantity;
	
	private Long categoryId;
}
