package com.apk.demo.response;

import com.apk.demo.request.CreateRequestCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCategory 
{
	private Long id;
	private String name;
	private String description;
}
