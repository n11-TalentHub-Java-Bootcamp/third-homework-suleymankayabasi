package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.dto.ProductDetailDto;
import com.example.homework3.mongodb.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id);

    ProductDetailDto findProductDetailDtoById(String id);

    Product save(Product product);

    void deleteById(String id);

    List<ProductDetailDto> findAllProductByCategoryId(String categoryId);
}
