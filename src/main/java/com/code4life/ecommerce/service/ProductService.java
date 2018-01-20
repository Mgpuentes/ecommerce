package com.code4life.ecommerce.service;

import com.code4life.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getAllProducts();
}
