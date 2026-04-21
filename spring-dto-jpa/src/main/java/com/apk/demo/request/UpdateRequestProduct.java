package com.apk.demo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestProduct 
{
	private Long id;
	private String name;
	private String price;
	private String status;
	private String description;
	private String quantity;
	
	private Long categoryId;
}
