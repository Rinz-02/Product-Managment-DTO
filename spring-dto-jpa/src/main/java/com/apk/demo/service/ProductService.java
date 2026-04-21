package com.apk.demo.service;

import java.util.List;


import com.apk.demo.model.Product;
import com.apk.demo.request.CreateRequestProduct;
import com.apk.demo.request.UpdateRequestProduct;
import com.apk.demo.response.ResponseProduct;

public interface ProductService 
{
	public List<ResponseProduct> findAll();
	
	public ResponseProduct save(CreateRequestProduct product);
	
	public ResponseProduct findById(Long id);
	
	public ResponseProduct update(UpdateRequestProduct product);
	
	public boolean delete(Long id);
	
}
