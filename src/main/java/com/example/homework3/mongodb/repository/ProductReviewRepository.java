package com.example.homework3.mongodb.repository;

import com.example.homework3.mongodb.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductReviewRepository extends MongoRepository<ProductReview,String> {
}
