package com.apk.demo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProduct 
{
	private Long id;
	private String name;
	private String price;
	private String quantity;
	private String description;
	private String status;
	
	private Long categoryId;
}
