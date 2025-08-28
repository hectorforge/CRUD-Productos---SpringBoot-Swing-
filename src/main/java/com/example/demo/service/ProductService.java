package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Product;

public interface ProductService {
	String create(Product p);
	String update(Long id, Product p);
	String delete(Long id);
	Product getById(Long id);
	List<Product> getAll();
	
    Page<Product> getAll(Pageable pageable);
}
