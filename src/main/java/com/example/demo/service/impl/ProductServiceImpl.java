package com.example.demo.service.impl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

    @Override
    public String create(Product p) {
        if (p == null || p.getName() == null || p.getName().trim().isEmpty()) {
            return "El producto no es válido";
        }

        if (productRepository.findByName(p.getName()) != null) {
            return "Ya existe un producto con ese nombre";
        }

        productRepository.save(p);
        return "Producto creado exitosamente";
    }

    @Override
    public String update(Long id, Product p) {
        Optional<Product> existing = productRepository.findById(id);

        if (existing.isEmpty()) {
            return "No existe el producto con el id " + id;
        }

        Product existingByName = productRepository.findByName(p.getName());
        if (existingByName != null && !existingByName.getId().equals(id)) {
            return "Ya existe un producto con ese nombre";
        }

        p.setId(id);
        productRepository.save(p);
        return "Producto actualizado exitosamente";
    }

    @Override
    public String delete(Long id) {
        Optional<Product> existing = productRepository.findById(id);

        if (existing.isEmpty()) {
            return "No existe un producto con el id " + id;
        }

        productRepository.deleteById(id);
        return "Producto eliminado exitosamente";
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
    @Override
    public Page<Product> getAll(org.springframework.data.domain.Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}