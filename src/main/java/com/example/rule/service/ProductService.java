package com.example.rule.service;

import com.example.rule.entity.ProductEntity;
import com.example.rule.model.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct();

    ProductDTO EntityToDto (ProductEntity entity);

    ProductEntity findById(String id);
}
