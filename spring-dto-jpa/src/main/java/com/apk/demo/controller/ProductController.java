package com.apk.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apk.demo.model.Product;
import com.apk.demo.request.CreateRequestProduct;
import com.apk.demo.request.UpdateRequestProduct;
import com.apk.demo.response.ResponseProduct;
import com.apk.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("http://localhost:5173")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	//FindAll
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll()
	{
		try
		{
			return ResponseEntity.ok(productService.findAll());
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Message", e.getMessage()));
		}
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateRequestProduct request)
	{
		try 
		{
			ResponseProduct created = productService.save(request);
			return ResponseEntity.status(HttpStatus.CREATED).body(created);
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Message", e.getMessage()));
		}
	}
	
	//Update
	@GetMapping("/edit/{id}")
	public ResponseEntity<?> edit(@PathVariable Long id)
	{
		try 
		{
			ResponseProduct edit = productService.findById(id);
			return ResponseEntity.ok(edit);
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Message", e.getMessage()));
		}
	}
	
	//Update
	@PutMapping("/edit")
	public ResponseEntity<?> edit(@RequestBody UpdateRequestProduct request)
	{
		try
		{
			ResponseProduct edit = productService.update(request);
			return ResponseEntity.status(HttpStatus.OK).body(edit);
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Message", e.getMessage()));
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		try 
		{
			boolean flag = productService.delete(id);
			return null;
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Message", e.getMessage()));
		}
	} 
	
	
	
}
