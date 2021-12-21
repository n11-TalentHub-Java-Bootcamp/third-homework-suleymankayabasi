package com.example.homework3.mongodb.controller;

import com.example.homework3.mongodb.entity.ProductReview;
import com.example.homework3.mongodb.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_reviews/")
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("")
    public MappingJacksonValue findAllUserList() {

        List<ProductReview> productReviewList = productReviewService.findAll();

        MappingJacksonValue mapping = new MappingJacksonValue(productReviewList);

        return mapping;

    }

    @GetMapping("{id}")
    public MappingJacksonValue findUserById(@PathVariable String id){

        ProductReview productReview = productReviewService.findById(id);

        MappingJacksonValue mapping = new MappingJacksonValue(productReview);

        return mapping;

    }

    @PostMapping("")
    public ResponseEntity<Object> saveUser(/**@Valid*/@RequestBody ProductReview productReview){
        productReview = productReviewService.save(productReview);
        return new ResponseEntity<>(productReview, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id){
        productReviewService.deleteById(id);
    }
}
