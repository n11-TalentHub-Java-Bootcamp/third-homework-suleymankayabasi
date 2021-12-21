package com.example.homework3.mongodb.service.implemantation;

import com.example.homework3.mongodb.entity.ProductReview;
import com.example.homework3.mongodb.service.ProductReviewService;
import com.example.homework3.mongodb.service.entityservice.ProductReviewEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    private ProductReviewEntityService productReviewEntityService;

    @Override
    public List<ProductReview> findAll() {
        return productReviewEntityService.findAll();
    }

    @Override
    public ProductReview findById(String id) {
        return productReviewEntityService.findById(id);
    }

    @Override
    public ProductReview save(ProductReview productReview) {
        return productReviewEntityService.save(productReview);
    }

    @Override
    public void deleteById(String id) {
        productReviewEntityService.delete(id);
    }
}
