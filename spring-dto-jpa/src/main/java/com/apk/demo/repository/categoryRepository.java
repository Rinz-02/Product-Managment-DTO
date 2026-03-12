package com.apk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apk.demo.model.Category;

public interface categoryRepository extends JpaRepository<Category,Long>{

}
