package com.fgarzon.demomodernapi.service.impl;

import com.fgarzon.demomodernapi.entity.Product;
import com.fgarzon.demomodernapi.repository.ProductRepository;
import com.fgarzon.demomodernapi.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
