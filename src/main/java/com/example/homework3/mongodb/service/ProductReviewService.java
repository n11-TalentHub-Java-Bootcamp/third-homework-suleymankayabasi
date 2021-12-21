package com.example.homework3.mongodb.service;

import com.example.homework3.mongodb.entity.ProductReview;

import java.util.List;

public interface ProductReviewService {

    List<ProductReview> findAll();

    ProductReview findById(String id);

    ProductReview save(ProductReview productReview);

    void deleteById(String id);
}
