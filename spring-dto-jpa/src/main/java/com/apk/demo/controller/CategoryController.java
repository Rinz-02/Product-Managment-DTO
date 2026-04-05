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

import com.apk.demo.model.Category;
import com.apk.demo.request.CreateRequestCategory;
import com.apk.demo.request.UpdateRequestCategory;
import com.apk.demo.service.CategoryService;
 


@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController 
{
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		try 
		{
			return ResponseEntity.ok(categoryService.findAll());
		} catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}

	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateRequestCategory request) {

		try 
		{
			System.out.print(request.getName());
			System.out.print(request.getDescription());
			
			Category created = categoryService.create(request);
			

			return ResponseEntity.status(HttpStatus.CREATED).body(created);
		} catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
		}

	}

	// UPDATE
	@GetMapping("/edit/{id}")
	public ResponseEntity<?> edit(@PathVariable Long id) 
	{
		try 
		{
			Category edit = categoryService.findById(id);
			return ResponseEntity.ok(edit);
		} catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}
	}

	@PutMapping("/edit")
	public ResponseEntity<?> edit(@RequestBody UpdateRequestCategory request) {
		try 
		{
			Category edit = categoryService.update(request);
			return ResponseEntity.ok(edit);
		}catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		try 
		{
			boolean flag = categoryService.delete(id);
			return null;
		}catch (RuntimeException e) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}
	}
		
}
