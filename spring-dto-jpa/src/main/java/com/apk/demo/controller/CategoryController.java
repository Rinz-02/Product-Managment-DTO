package com.apk.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apk.demo.model.Category;
import com.apk.demo.request.CreateRequestCategory;
import com.apk.demo.request.UpdateRequestCategory;
import com.apk.demo.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(categoryService.findAll());
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}

	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateRequestCategory request) {

		try {
			Category created = categoryService.create(request);

			return ResponseEntity.status(HttpStatus.CREATED).body(created);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
		}

	}

	// UPDATE
	@GetMapping("/eidt")
	public ResponseEntity<?> edit(@RequestBody Long id) 
	{
		try {
			Category edit = categoryService.findById(id);
			return ResponseEntity.ok(edit);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
		}
	}

	@PutMapping("/edit")
	public ResponseEntity<?> edit(@RequestBody UpdateRequestCategory request) {
		Category edit = categoryService.update(request);
		return null;
	}

	// DELETE
	@GetMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Long id)
	{
		boolean flag = categoryService.delete(id);
		return null;
	}
		
}
