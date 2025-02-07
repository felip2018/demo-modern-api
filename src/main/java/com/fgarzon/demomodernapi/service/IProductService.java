package com.fgarzon.demomodernapi.service;

import com.fgarzon.demomodernapi.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProductsByCategory(String category);
}
