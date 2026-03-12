package com.apk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apk.demo.model.Product;

public interface productRepository extends JpaRepository<Product,Long>
{

}
