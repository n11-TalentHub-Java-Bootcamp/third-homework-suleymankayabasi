package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.dto.ProductReviewDto;

import java.util.List;

public interface IProductReviewService {

    List<ProductReviewDto> findAll();
    ProductReviewDto findById(String id);
    ProductReviewDto save(ProductReviewDto productReviewDto);
    void deleteById(String id);
}
