package com.example.homework3.mongodb.repository;

import com.example.homework3.mongodb.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview,String> {
}
